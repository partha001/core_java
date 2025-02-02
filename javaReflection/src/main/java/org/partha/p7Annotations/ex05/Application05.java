package org.partha.p7Annotations.ex05;

import org.partha.p7Annotations.ex05.customAnnotations.Annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;


/**
 * programDescription: this example is to demonstrate how to use class-field annotation
 */
public class Application05 {


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SqlQueryBuilder sqlQueryBuilder = new SqlQueryBuilder(Arrays.asList("1","2","3"),
                10,
                "movies",
                Arrays.asList("Id","Name"));
        String sqlQuery = execute(sqlQueryBuilder);
        System.out.println(sqlQuery);

    }

    private static <T> T execute(Object instance) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = instance.getClass();
        Map<String, Method> operationToMethod = getOperationToMethod(clazz);

        Map<String, Field> inputToField = getInputField(clazz);

        Method finalResultMethod = findFinalResultMethod(clazz);
        return (T) executeWithDepedencies(instance, finalResultMethod, operationToMethod, inputToField); //this method will recursively traverse
        // our graph of operations starting with the finalResultMethod. ones complete this will give us the final result
        // which will return to the caller
    }

    private static Object executeWithDepedencies(Object instance,
                                                 Method currentMehthod,
                                                 Map<String, Method> operationToMethod,
                                                 Map<String, Field> inputToField )
            throws InvocationTargetException, IllegalAccessException {
        List<Object> parameterValues = new ArrayList<>(currentMehthod.getParameterCount());

        for(Parameter parameter: currentMehthod.getParameters()){
            Object value = null;
            if(parameter.isAnnotationPresent(Annotations.DependsOn.class)){
                String dependencyOperationName = parameter.getAnnotation(Annotations.DependsOn.class).value();
                Method dependencyMethod = operationToMethod.get(dependencyOperationName);
                value = executeWithDepedencies(instance, dependencyMethod, operationToMethod, inputToField); //note that here the recursive call is happening
            }
            else if(parameter.isAnnotationPresent(Annotations.Input.class)) {
                String inputName = parameter.getAnnotation(Annotations.Input.class).value();
                Field inputField = inputToField.get(inputName);
                inputField.setAccessible(true); //since the field can be private as well
                value = inputField.get(instance); //also note that in this case we dont need any recursion. since the current parameter is taken from a field and doesnt come from another method-call operation
            }
            parameterValues.add(value);;
        }
        return currentMehthod.invoke(instance, parameterValues.toArray());
    }


    private static Map<String, Method> getOperationToMethod(Class<?> clazz){
        Map<String,Method> operationNameToMethod = new HashMap<>();

        for(Method method: clazz.getDeclaredMethods()){
            if(!method.isAnnotationPresent(Annotations.Operation.class)){
                continue;
            }
            Annotations.Operation operation = method.getAnnotation(Annotations.Operation.class);
            operationNameToMethod.put(operation.value(), method);
        }
        return operationNameToMethod;
    }



    private static Method findFinalResultMethod(Class<?> clazz){
        for(Method method: clazz.getDeclaredMethods()){
            if(method.isAnnotationPresent(Annotations.FinalResult.class)){
                return method;
            }
        }
        throw new RuntimeException("no method found with finalResult annotation");
    }

    private static Map<String, Field> getInputField(Class<?> clazz){
        Map<String, Field> inputToField = new HashMap<>();
        for(Field field: clazz.getDeclaredFields()){
            if(!field.isAnnotationPresent(Annotations.Input.class)){
                continue;
            }
            Annotations.Input input = field.getAnnotation(Annotations.Input.class);
            inputToField.put(input.value(), field);
        }
        return inputToField;
    }


}

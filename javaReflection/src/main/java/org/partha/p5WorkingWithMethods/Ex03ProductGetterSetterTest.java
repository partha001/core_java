package org.partha.p5WorkingWithMethods;

import org.partha.p5WorkingWithMethods.dto3.ClothingProduct;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Ex03ProductGetterSetterTest {

    public static void main(String[] args) {
        testGetters(ClothingProduct.class);
        testSetter(ClothingProduct.class);
    }

    //setter test method
    public static void testSetter(Class<?> dataClass){
        //Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);

        for(Field field:fields){
            String setterName = "set" + capitalizeFirstLetter(field.getName());

            Method setterMethod = null;
            try{
                setterMethod = dataClass.getMethod(setterName,field.getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(String.format("setter : %s not found",setterName));
            }

            //now verifying if the return type of the method is void or not
            if(!setterMethod.getReturnType().equals(void.class)){
                throw new IllegalStateException(String.format("setter : %s has to return void",setterName));
            }
        }
    }


    //this is a recursive method
    private static List<Field> getAllFields(Class<?> clazz){

        /**if class is not null and its not Object.class since Object is the parent class of all classes which we will not consider
         * we are only interested any parent class which is not null and not Object.class
         * note: this is also the breaking condition for our recursion **/
        if(clazz==null || clazz.equals(Object.class)){
            return Collections.emptyList();
        }
        Field[] currentClassFields = clazz.getDeclaredFields(); //getting current class fields

        //below we are making the recursive call
        List<Field> inheritedFields = getAllFields(clazz.getSuperclass()); //getting parent class fields using recursion

        //finally combining the two get all field
        List<Field> allFields = new ArrayList();
        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);
        return allFields;
    }

    //this is the helper method
    private static Map<String, Method> mapMethodName(Class<?> dataClass){
        Method[] allMethods = dataClass.getMethods();
        Map<String,Method> nameToMethod = new HashMap<>();
        for(Method method: allMethods){
            nameToMethod.put(method.getName(), method);
        }
        return nameToMethod;
    }


    //getter test method
    public static void testGetters(Class<?> dataClass){
        //Field[] fields = dataClass.getDeclaredFields();
        List<Field> fields = getAllFields(dataClass);
        Map<String,Method> methodNameToMethod = mapMethodName(dataClass);

        for(Field field: fields){
            String getterName = "get" + capitalizeFirstLetter(field.getName());

            //throwing exception if getter is not declared. however in a real testing we can do any task here
            if(!methodNameToMethod.containsKey(getterName)){
                throw new IllegalStateException(String.format("Field : %s doesnt have a getter method defined", field.getName()));
            }

            //now retrieving the method object
            Method getter = methodNameToMethod.get(getterName);

            //now validating other features the getter method to ensure it complies with the norms of a getter
            //validation1: validating the return type of the getter mathches with that of the attribute type
            if(!getter.getReturnType().equals(field.getType())){
                throw new IllegalStateException(String.format("getter method : %s() has return type %s but expected %s",
                        getter.getName(),
                        getter.getReturnType().getTypeName(),
                        field.getType().getTypeName()));
            }
            
            //validation2: validating that the getter should not take any input argument
            if(getter.getParameterCount()>0){
                throw new IllegalStateException(String.format("Getter : %s has %d arguments", getterName));
            }
        }
    }

    private static String capitalizeFirstLetter(String fieldName) {
        return fieldName.substring(0,1).toUpperCase().concat(fieldName.substring(1));
    }
}

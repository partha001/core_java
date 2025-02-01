package org.partha.p7Annotations.ex04;

import org.partha.p7Annotations.ex04.customAnnotations.Annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class ApplicationParamAnnotation {


//        public static void main(String[] args) {
//
//        BestGamesFinder bestGamesFinder = new BestGamesFinder();
//
//        Set<String> allGames = bestGamesFinder.getAllGames();
//
//        Map<String, Float> gameToRating = bestGamesFinder.getGameToRating(allGames);
//        Map<String, Float> gameToPrice = bestGamesFinder.getGameToPrice(allGames);
//
//        SortedMap<Double, String> scoreToGame = bestGamesFinder.scoreGames(gameToPrice, gameToRating);
//
//        List<String> bestGamesInDescendingOrder = bestGamesFinder.getTopGames(scoreToGame);
//
//        System.out.println(bestGamesInDescendingOrder);
//
//    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        BestGamesFinder bestGamesFinder = new BestGamesFinder();
        List<String> bestGamesInDescendingOrder = execute(bestGamesFinder);
        System.out.println(bestGamesInDescendingOrder);
    }

    private static <T> T execute(Object instance) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = instance.getClass();
        Map<String, Method> operationToMethod = getOperationToMethod(clazz);
        Method finalResultMethod = findFinalResultMethod(clazz);
        return (T) executeWithDepedencies(instance, finalResultMethod, operationToMethod); //this method will recursively traverse
        // our graph of operations starting with the finalResultMethod. ones complete this will give us the final result
        // which will return to the caller
    }

    private static Object executeWithDepedencies(Object instance, Method currentMehthod, Map<String, Method> operationToMethod) throws InvocationTargetException, IllegalAccessException {
        List<Object> parameterValues = new ArrayList<>(currentMehthod.getParameterCount());

        for(Parameter parameter: currentMehthod.getParameters()){
            Object value = null;
            if(parameter.isAnnotationPresent(Annotations.DependsOn.class)){
                String dependencyOperationName = parameter.getAnnotation(Annotations.DependsOn.class).value();
                Method dependencyMethod = operationToMethod.get(dependencyOperationName);
                value = executeWithDepedencies(instance, dependencyMethod, operationToMethod); //note that here the recursive call is happening
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
        throw new RuntimeException("no method foiund with finalResult annotation");
    }


}

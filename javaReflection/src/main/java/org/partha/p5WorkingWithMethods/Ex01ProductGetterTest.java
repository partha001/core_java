package org.partha.p5WorkingWithMethods;

import org.partha.p5WorkingWithMethods.dto1.Product;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Ex01ProductGetterTest {

    public static void main(String[] args) {
        testGetters(Product.class);
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




    //now writing our test method
    public static void testGetters(Class<?> dataClass){
        Field[] fields = dataClass.getDeclaredFields();
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

package org.partha.p3WorkingWithFields;


import org.partha.p3WorkingWithFields.dto.Address;

import java.lang.reflect.Field;

/**
 * here we will make use of the knowledge of accessing attributes
 * and write our own custom serializer
 */
public class Program4WritingCustomJsonSerializer1 {

    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("main street", (short)1);
        String json = objectToJson(address);
        System.out.println(json);

    }

    public static String objectToJson(Object instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{"); //appending the first curly brace
        for(int i=0;i< fields.length;i++){
            Field field = fields[i];

            //first: setting it true to read private attribute values
            field.setAccessible(true);

            //second: ignoring synthetic fields
            if(field.isSynthetic())
                continue;

            //appending field name
            stringBuilder.append(formatStringValues(field.getName()));
            //appending colon
            stringBuilder.append(":");

            //now appending value
            if(field.getType().isPrimitive()){
                stringBuilder.append(formatPrimitiveValue(field,instance));
            }else if(field.getType().equals(String.class)){
                stringBuilder.append(formatStringValues(field.get(instance).toString()));
            }


            //adding comma if its not the last attribute
            if(i!=fields.length-1){
                stringBuilder.append(",");
            }

        }

        stringBuilder.append("}");
        return stringBuilder.toString();

    }




    //helperMethod1 : this method will process other primitive type values
    private static String formatPrimitiveValue(Field field, Object parentInstance) throws IllegalAccessException {
        if(field.getType().equals(boolean.class) //case1: handling these types
        || field.getType().equals(int.class)
        || field.getType().equals(long.class)
        || field.getType().equals(short.class)) {
            return field.get(parentInstance).toString();
        } else if(field.getType().equals(double.class) || field.getType().equals(float.class)) { //case2: if there are more trailing decimal numbers then trimmimng it to 2 decimal numbers after decimal
            return String.format("%.02f", field.get(parentInstance));
        }
        throw new RuntimeException(String.format("Type : %s is unsupported", field.getType().getName()));
    }

    //helperMethod2 : this method will process string values
    private static String formatStringValues(String value){
        return String.format("\"%s\"",value);
    }
}

package org.partha.p3WorkingWithFields;


import org.partha.p3WorkingWithFields.dto.Actor;
import org.partha.p3WorkingWithFields.dto.Movie;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * this program enhances our json serialize to serialize array attributes
 * present in an object
 */
public class Program6WritingCustomJsonSerializer4 {

    public static void main(String[] args) throws IllegalAccessException {


        Actor actor1 = new Actor("Elijah Wood", new String[]{"Lord of the rings","The good Son"});
        String json = objectToJson(actor1, 0);
        System.out.println(json);

        Movie movie = new Movie("Lord of the rings",8.8f, new String[]{"Action","Adventure","Drama"});
        json = objectToJson(movie, 0);
        System.out.println(json);
    }

    public static String objectToJson(Object instance,int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(indent(indentSize));
        stringBuilder.append("{"); //appending the first curly brace
        stringBuilder.append("\n");
        for(int i=0;i< fields.length;i++){
            Field field = fields[i];

            //first: setting it true to read private attribute values
            field.setAccessible(true);

            //second: ignoring synthetic fields
            if(field.isSynthetic())
                continue;

            stringBuilder.append(indent(indentSize+1));
            //appending field name
            stringBuilder.append(formatStringValues(field.getName()));
            //appending colon
            stringBuilder.append(":");

            //now appending value
            if(field.getType().isPrimitive()){
                stringBuilder.append(formatPrimitiveValue(field.get(instance),field.getType()));
            }else if(field.getType().equals(String.class)){
                stringBuilder.append(formatStringValues(field.get(instance).toString()));
            }else if (field.getType().isArray()){
                stringBuilder.append(arrayToJson(field.get(instance)));
            }
            else {
                stringBuilder.append(objectToJson(field.get(instance),indentSize+1));
            }


            //adding comma if its not the last attribute
            if(i!=fields.length-1){
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");

        }

        stringBuilder.append(indent(indentSize));
        stringBuilder.append("}");
        return stringBuilder.toString();

    }

    private static String arrayToJson(Object arrayInstance) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        int arrayLength = Array.getLength(arrayInstance);
        Class<?> componentType = arrayInstance.getClass().getComponentType();
        stringBuilder.append("[");
        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayInstance, i);
            if (componentType.isPrimitive()) {
                stringBuilder.append(formatPrimitiveValue(element, componentType));
            } else if (componentType.equals(String.class)) {
                stringBuilder.append(formatStringValues(element.toString()));
            }

            if (i != arrayLength - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String indent(int indentSize){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<indentSize;i++){
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();
    }

    

    //helperMethod1 : this method will process other primitive type values
    private static String formatPrimitiveValue(Object instance, Class<?> type) throws IllegalAccessException {
        if(type.equals(boolean.class) //case1: handling these types
        || type.equals(int.class)
        || type.equals(long.class)
        || type.equals(short.class)) {
            return instance.toString();
        } else if(type.equals(double.class) || type.equals(float.class)) { //case2: if there are more trailing decimal numbers then trimmimng it to 2 decimal numbers after decimal
            return String.format("%.02f", instance);
        }
        throw new RuntimeException(String.format("Type : %s is unsupported", type.getName()));
    }

    //helperMethod2 : this method will process string values
    private static String formatStringValues(String value){
        return String.format("\"%s\"",value);
    }
}

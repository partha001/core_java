package org.partha.p3WorkingWithFields;


public class Program06WorkingWithArrays1 {

    public static void main(String[] args) {
        int[]  oneDimensionalArray = {1,2};
        inspectArrayObject(oneDimensionalArray);

        //now lets inspect with 2 dimensional array;
        //while working with 2 dimensional array we need to keep in mind
        //that they ara array of other arrays
        double[][] twoDimensionalArray = {{1,2}, {3,4}};
        inspectArrayObject(twoDimensionalArray);

    }

    public static void inspectArrayObject(Object arrayObject){
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("is array : %s", clazz.isArray()));

        //now getting the component type
        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This i an array of type : %s", arrayComponentType.getTypeName()));
    }
}

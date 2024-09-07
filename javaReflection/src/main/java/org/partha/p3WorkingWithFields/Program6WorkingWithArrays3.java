package org.partha.p3WorkingWithFields;

import java.lang.reflect.Array;

/*
this program builds on top of the previous program.
where if an arrayObject contains nested array then it will furthur
print the nested array elements
 */
public class Program6WorkingWithArrays3 {

    public static void main(String[] args) {
        int[]  oneDimensionalArray = {1,2};
        //inspectArrayObject(oneDimensionalArray);
        inspectArrayValues(oneDimensionalArray);

        System.out.println();

        //now lets inspect with 2 dimensional array;
        //while working with 2 dimensional array we need to keep in mind
        //that they ara array of other arrays
        double[][] twoDimensionalArray = {{1,2}, {3,4}};
        inspectArrayValues(twoDimensionalArray);

    }

    public static void inspectArrayObject(Object arrayObject){
        Class<?> clazz = arrayObject.getClass();
        System.out.println(String.format("is array : %s", clazz.isArray()));

        //now getting the component type
        Class<?> arrayComponentType = clazz.getComponentType();
        System.out.println(String.format("This i an array of type : %s", arrayComponentType.getTypeName()));
    }

    public static void inspectArrayValues(Object arrayObject){
        int arrayLength = Array.getLength(arrayObject);
        System.out.print("[");
        for(int i=0;i<arrayLength;i++){
            Object element = Array.get(arrayObject,i);

            if(element.getClass().isArray()){
                inspectArrayValues(element);
            }else{
                System.out.print(element);
            }
            if(i!=arrayLength-1)
                System.out.print(" ,");
        }
        System.out.print("]");
    }
}

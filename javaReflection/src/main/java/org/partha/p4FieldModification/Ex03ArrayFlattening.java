package org.partha.p4FieldModification;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex03ArrayFlattening {

    public static void main(String[] args) {
        Object result = concat(int.class, 1, 2, 3, new int[]{4, 5, 6}, 7);
        if(result.getClass().isArray()){
            int arrayLength = Array.getLength(result);
            IntStream.range(0,arrayLength).forEach(i -> {
                System.out.print(Array.get(result,i) + " ");
            });
        }


    }

    public static <T> T concat(Class<?> type, Object... arguments) {
        if (arguments.length == 0) {
            return null;
        }

        List<Object> elements = new ArrayList<>();
        for (Object argument : arguments) {
            if (argument.getClass().isArray()) {
                int length = Array.getLength(argument);

                for (int i = 0; i < length; i++) {
                    elements.add(Array.get(argument, i));
                }
            } else {
                elements.add(argument);
            }
        }

        Object flattenedArray = Array.newInstance(type, elements.size());

        for (int i = 0; i < elements.size(); i++) {
            Array.set(flattenedArray, i, elements.get(i));
        }

        return (T) flattenedArray;
    }
}

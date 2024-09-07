package org.partha.p3WorkingWithFields;

import org.partha.p3WorkingWithFields.dto.Address;
import org.partha.p3WorkingWithFields.dto.PersonV2;

import java.lang.reflect.Field;

/**
 * this is another example program on reading field attributes
 * of an object using java reflection.
 *
 * goal: An estimate in bytes of the amount of memory the object takes in the JVM.
 */
public class Program5ObjectSizeCalculation {

    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;

    public static void main(String[] args) throws IllegalAccessException {
        Address address = new Address("main street", (short)1);
        System.out.println("size of the object is:"+sizeOfObject(address));

        //note the program is not considering nested objects
        //PersonV2 person = new PersonV2("john", true, 29, 100.555f,address);

    }


    public static long sizeOfObject(Object object) throws IllegalAccessException {
        long size = HEADER_SIZE + REFERENCE_SIZE;

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getType().isPrimitive()) {
                size += sizeOfPrimitiveType(field.getType());
            } else {
                size += sizeOfString((String) field.get(object));
            }
        }
        return size;
    }


    /*************** Helper methods ********************************/
    private static  long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }

    private static long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }

}

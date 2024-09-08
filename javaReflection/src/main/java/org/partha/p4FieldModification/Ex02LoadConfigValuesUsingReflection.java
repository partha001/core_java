package org.partha.p4FieldModification;

import org.partha.p4FieldModification.dto2.GameConfig;
import org.partha.p4FieldModification.dto2.UserInterfaceConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

/**
 * this program shows how we are reading a property/configuration file
 * and then dynamically populating the attributes of a class using reflection
 *
 * it is also to be noted that for user-interface:
 * 1. the attibute footerText='null' is null since we havent mentioned it in our configuration file
 * 2. on the flip side configuration file contains a entry called titleText for which there is not attribute present in
 *      the class file so it shows Property name: titleText is unsupported
 */
public class Ex02LoadConfigValuesUsingReflection {

    private static final String GAME_CONFIG_PATH = "folder2/game-properties.cfg";
    private static final String USER_INTERFACE_PATH = "folder2/user-interface.cfg";



    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        GameConfig gameConfig = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
        System.out.println(gameConfig);

        UserInterfaceConfig userInterfaceConfig = createConfigObject(UserInterfaceConfig.class, USER_INTERFACE_PATH);
        System.out.println(userInterfaceConfig);
    }

    public static <T> T createConfigObject(Class<T> clazz, String filePath) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T configInstance = (T) constructor.newInstance();

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = contextClassLoader.getResourceAsStream(filePath);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        String line;
        while ((line = reader.readLine()) != null){

            String[] nameValuePair = line.split("=");
            String propertyName = nameValuePair[0];
            String propertyValue = nameValuePair[1];

            Field field;
            try {
                field = clazz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                System.out.println(String.format("Property name: %s is unsupported", propertyName));
                continue;
            }
            field.setAccessible(true);
            Object parsedValue;
            if(field.getType().isArray()){
                parsedValue = parseArray(field.getType().getComponentType(), propertyValue);
            }else{
                parsedValue = parseValue(field.getType(), propertyValue);
            }
            field.set(configInstance, parsedValue);
        }
        return configInstance;
    }

    private static Object parseArray(Class<?> arrayElementType, String value){
        String[] elementValues = value.split(",");
        Object arrayObject = Array.newInstance(arrayElementType, elementValues.length);
        for(int i=0;i< elementValues.length;i++){
            Array.set(arrayObject, i, parseValue(arrayElementType,elementValues[i]));
        }
        return arrayObject;
    }

    //right now this method supports the below types however this can be easily enhanced
    private static Object parseValue(Class<?> type, String value) {
        if (type.equals(int.class)) {
            return Integer.parseInt(value);
        } else if (type.equals(short.class)) {
            return Short.parseShort(value);
        } else if (type.equals(long.class)) {
            return Long.parseLong(value);
        } else if (type.equals(double.class)) {
            return Double.parseDouble(value);
        } else if (type.equals(float.class)) {
            return Float.parseFloat(value);
        } else if (type.equals(String.class)) {
            return value;
        }
        throw new RuntimeException(String.format("Type : %s unsupported", type.getTypeName()));
    }
}

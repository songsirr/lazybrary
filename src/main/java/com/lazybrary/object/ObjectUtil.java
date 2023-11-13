package com.lazybrary.object;

import java.lang.reflect.Field;
import java.util.Objects;

public class ObjectUtil {

    public static boolean hasNullField(Object o) {
        for (Field f : o.getClass().getDeclaredFields()){
            f.setAccessible(true);
            try {
                if (f.get(o) == null){
                    return true;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static boolean isNullObject(Object o){
        for (Field f : o.getClass().getDeclaredFields()){
            f.setAccessible(true);
            try {
                if (f.get(o) != null){
                    return false;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    public static void removeEmptyStringFields(Object o){
        Objects.requireNonNull(o);
        for (Field f : o.getClass().getDeclaredFields()){
            f.setAccessible(true);
            try {
                if (f.getType().equals(String.class)){
                    if (f.get(o).equals("")){
                        f.set(o, null);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

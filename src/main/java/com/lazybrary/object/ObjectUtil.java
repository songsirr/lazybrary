package com.lazybrary.object;

import java.lang.reflect.Field;
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
}

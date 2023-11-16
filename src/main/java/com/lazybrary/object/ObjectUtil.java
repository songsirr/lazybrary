package com.lazybrary.object;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ObjectUtil {

    public static boolean hasNullField(Object o) {
        return Arrays.stream(o.getClass().getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .anyMatch(field -> {
                    try {
                        return field.get(o) == null;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
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
                    Object value = f.get(o);
                    if (value != null && value.equals("")) {
                        f.set(o, null);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void removeNullField(Object o) {
        Objects.requireNonNull(o);

        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                Object value = f.get(o);
                if (value == null) {
                    f.set(o, getDefaultForType(f.getType()));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static Object getDefaultForType(Class<?> type) {
        if (type.equals(String.class)) {
            return "";
        } else if (Number.class.isAssignableFrom(type)) {
            try {
                return ((Class<? extends Number>) type).getConstructor(String.class).newInstance("-1");
            } catch (Exception e) {
                throw new RuntimeException("Error creating default value for type: " + type, e);
            }
        } else if (type.equals(Boolean.class)) {
            return false;
        } else if (type.equals(List.class)) {
            return Collections.emptyList();
        } else if (type.equals(Map.class)) {
            return Collections.emptyMap();
        } else if (type.equals(Set.class)) {
            return Collections.emptySet();
        } else {
            try {
                return type.getConstructor().newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
                throw new RuntimeException("Error creating default value for type: " + type, e);
            }
        }
    }
}

package com.lazybrary.collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CollectionUtil {

    // prevent create instance
    private CollectionUtil() {}

    /**
     * find object by key from list
     * may be need override equals() method of key type if object have special key
     * <pre>{@code
     *     Foo f = (Foo)CollectionUtil.findBy(list, "id", 3);
     * }</pre>
     * @param list list with object
     * @param key the key (variable) name that you want to find
     * @param val the value of the key that you want to find
     * @return single object that having key of value. it may be null
     * @throws NoSuchFieldException can not find the field
     * @throws IllegalAccessException can not access the field
     */
    public static <T> T findBy(List<T> list, String key, Object val) throws NoSuchFieldException, IllegalAccessException {
        for (T t : list){
            Field f = t.getClass().getDeclaredField(key);
            f.setAccessible(true);
            if (f.get(t).equals(val)){
                return t;
            }
        }

        return null;
    }

    /**
     * convert List to Map
     * <pre>{@code
     *     Map<Object, Foo> = CollectionUtil.listToMap(list, "id");
     * }</pre>
     * @param list with object
     * @param key of object
     * @return Map
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static <T> Map<Object, T> listToMap(List<T> list, String key) throws NoSuchFieldException, IllegalAccessException {
        Map<Object, T> map = new HashMap<>();
        for (T t : list){
            Field f = t.getClass().getDeclaredField(key);
            f.setAccessible(true);
            map.put(f.get(t), t);
        }

        return map;
    }

    public static <T> List<T> subList(List<T> list, int from, int to) {
        if (list.size() > from) {
            return list.subList(from, Math.min(to, list.size()));
        } else {
            return new ArrayList<>();
        }
    }

    public static <T> List<T> listPagination(List<T> list, int offset, int limit) {
        int size = list.size();
        int fromIndex = offset * limit;
        int toIndex = Math.min(fromIndex + limit, size);
        return subList(list, fromIndex, toIndex);
    }
}

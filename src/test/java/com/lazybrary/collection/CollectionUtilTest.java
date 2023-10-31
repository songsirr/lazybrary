package com.lazybrary.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilTest {

    private static List<Foo> list;

    @BeforeAll
    static void initList(){
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list.add(new Foo(i));
        }
    }

    @Test
    void findBy_primitive() throws Exception {
        Foo f = (Foo)CollectionUtil.findBy(list, "id", 3);
        Assertions.assertEquals(f.getStr(), "3");
    }

    @Test
    void findBy_refer() throws Exception {
        Foo f = (Foo)CollectionUtil.findBy(list, "str", "3");
        Assertions.assertEquals(f.getId(), 3);
    }

    @Test
    void listToMap() throws Exception {
        Map<Object, Foo> map = CollectionUtil.listToMap(list, "id");
        Assertions.assertEquals(map.get(3).getStr(), "3");
    }

    static class Foo {
        private int id;
        private String str;

        public Foo(int id) {
            this.id = id;
            this.str = String.valueOf(id);
        }

        public int getId() {
            return id;
        }

        public String getStr() {
            return str;
        }
    }
}
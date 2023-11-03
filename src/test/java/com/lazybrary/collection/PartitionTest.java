package com.lazybrary.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PartitionTest {

    private List<Integer> list = new ArrayList<>();

    @BeforeEach
    void initList(){
        for (int i = 0; i < 3000; i++){
            list.add(i);
        }
    }

    @Test
    void partition(){
        Partition<Integer> p = new Partition<Integer>(list, 500);
        Assertions.assertEquals(p.size(), 6);
        Assertions.assertEquals(p.get(1).get(0), 500);
    }
}

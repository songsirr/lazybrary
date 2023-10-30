package com.lazybrary.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoUtilTest {

    @Test
    void getDistance() {
        double dist = GeoUtil.getDistance(37.537167,126.969533, 37.5368941, 126.9704532);
        Assertions.assertEquals(86.62574113037515, dist);
    }
}
package com.lazybrary.unit.units;

public interface Convertible <T extends Enum<T>> {
    double convertTo(T toUnit, double value);
}

package com.lazybrary.unit.units;

import com.lazybrary.unit.exception.NotSupportedTypeException;

public enum FileSize {

    BIT("bit", "b", 1),
    BYTE("byte", "B", BIT.value * 8),
    KILOBYTE("kilobyte", "KB", BYTE.value * 1024),
    MEGABYTE("megabyte", "MB", KILOBYTE.value * 1024),
    GIGABYTE("gigabyte", "GB", MEGABYTE.value * 1024),
    TERABYTE("terabyte", "TB", GIGABYTE.value * 1024),
    PETABYTE("petabyte", "PB", TERABYTE.value * 1024),
    EXABYTE("exabyte", "EB", PETABYTE.value * 1024),
    ZETTABYTE("zettabyte", "ZB", EXABYTE.value * 1024),
    YOTTABYTE("yottabyte", "YB", ZETTABYTE.value * 1024);

    private final String lowerCase;

    private final String symbol;

    private final double value;

    FileSize(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    public static FileSize of(String unit){
        // try to find by Unit name or Symbol
        for (FileSize l : values()){
            if (l.lowerCase.equalsIgnoreCase(unit) || l.symbol.equalsIgnoreCase(unit)){
                return l;
            }
        }

        throw new NotSupportedTypeException(FileSize.class, unit);
    }

    public double convertTo(FileSize toUnit, double value) {
        return value * this.value / toUnit.value;
    }
}

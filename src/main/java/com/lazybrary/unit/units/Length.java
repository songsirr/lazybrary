package com.lazybrary.unit.units;

import com.lazybrary.unit.exception.UnitConverterException;

public enum Length {

    // SI
    MILLIMETER("millimeter", "mm", 1),
    CENTIMETER("centimeter", "cm", MILLIMETER.value * 10),
    METER("meter", "m", CENTIMETER.value * 100),
    KILOMETER("kilometer", "km", METER.value * 1000),

    // English unit or imperial/US units
    INCH("inch", "in", MILLIMETER.value * 25.4),
    FOOT("foot", "ft", INCH.value * 12),
    YARD("yard", "yd", FOOT.value * 3),
    MILE("mile", "mi", YARD.value * 1760);


    private final String lowerCase;

    private final String symbol;

    private final double value;

    Length(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    public static Length of(String unit){
        // try to find by Unit name or Symbol
        for (Length l : values()){
            if (l.lowerCase.equalsIgnoreCase(unit) || l.symbol.equalsIgnoreCase(unit)){
                return l;
            }
        }

        throw new UnitConverterException("Unsupported length unit of: " + unit);
    }

    public double convertTo(Length toUnit, double value) {
        return value * this.value / toUnit.value;
    }
}

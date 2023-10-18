package com.lazybrary.unit.units;

import com.lazybrary.unit.exception.NotSupportedTypeException;

public enum Weight {

    // SI
    MILLIGRAM("milligram", "mg", 1),
    GRAM("gram", "g", MILLIGRAM.value * 1000),
    KILOGRAM("kilogram", "kg", GRAM.value * 1000),
    TONNE("tonne", "t", KILOGRAM.value * 1000), // AKA metric ton

    // English unit or imperial/US units
    OUNCE("ounce", "oz", MILLIGRAM.value * 28349.5),
    POUND("pound", "lbs", OUNCE.value * 16),
    TON("ton", "tn", POUND.value * 2000); // AKA short ton

    private final String lowerCase;

    private final String symbol;

    private final double value;

    Weight(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    public static Weight of(String unit){
        // try to find by Unit name or Symbol
        for (Weight l : values()){
            if (l.lowerCase.equalsIgnoreCase(unit) || l.symbol.equalsIgnoreCase(unit)){
                return l;
            }
        }

        throw new NotSupportedTypeException(Weight.class, unit);
    }

    public double convertTo(Weight toUnit, double value) {
        return value * this.value / toUnit.value;
    }
}

package com.lazybrary.unit.units;

import com.lazybrary.unit.exception.NotSupportedTypeException;

public enum Time implements Convertible<Time> {

    NANOSECOND("nanosecond", "ns", 1),
    MICROSECOND("microsecond", "μs", NANOSECOND.value * 1000),
    MILLISECOND("millisecond", "ms", MICROSECOND.value * 1000),
    SECOND("second", "s", MILLISECOND.value * 1000),
    MINUTE("minute", "m", SECOND.value * 60),
    HOUR("hour", "h", MINUTE.value * 60),
    DAY("day", "d", HOUR.value * 24),
    WEEK("week", "w", DAY.value * 7);

    private final String lowerCase;

    private final String symbol;

    private final double value;

    Time(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    public static Time of(String unit){
        // try to find by Unit name or Symbol
        for (Time t : values()){
            if (t.lowerCase.equalsIgnoreCase(unit) || t.symbol.equalsIgnoreCase(unit)){
                return t;
            }
        }

        throw new NotSupportedTypeException(Length.class, unit);
    }

    @Override
    public double convertTo(Time toUnit, double value) {
        return value * this.value / toUnit.value;
    }
}

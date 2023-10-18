package com.lazybrary.unit;

import com.lazybrary.unit.exception.NotSupportedUnitException;
import com.lazybrary.unit.exception.UnitConverterException;
import com.lazybrary.unit.units.Length;
import com.lazybrary.unit.units.Weight;

import java.util.Objects;

public class UnitConverter {

    private double value;

    private Enum<?> fromUnit;

    private Enum<?> toUnit;

    private UnitConverter(Enum<?> fromUnit, double value) {
        this.fromUnit = fromUnit;
        this.value = value;
    }

    public static UnitConverter from(Enum<?> unit, double value) {
        Objects.requireNonNull(unit, "unit of method from");
        return new UnitConverter(unit, value);
    }

    public UnitConverter to(Enum<?> unit) {
        Objects.requireNonNull(unit, "unit of method to");
        this.toUnit = unit;
        return this;
    }

    public double convert(){
        if (fromUnit.getClass() != toUnit.getClass()){
            throw new UnitConverterException("Units are not of the same type.");
        }

        if (fromUnit instanceof Length){
            return ((Length) fromUnit).convertTo((Length) toUnit, value);
        } else if (fromUnit instanceof Weight) {
            return ((Weight) fromUnit).convertTo((Weight) toUnit, value);
//        } else if (fromUnit instanceof Temperature) {
//            return ((Temperature) fromUnit).convertTo((Temperature) toUnit, value);
        }
        else {
            throw new NotSupportedUnitException("Not supported unit.");
        }
    }
}

package com.lazybrary.unit;

import com.lazybrary.unit.exception.NotSupportedUnitException;
import com.lazybrary.unit.exception.UnitConverterException;
import com.lazybrary.unit.units.*;

import java.util.Objects;

public class UnitConverter {

    private final double value;

    private final Enum<?> fromUnit;

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

    @SuppressWarnings("unchecked")
    public double convert(){
        validateUnits();

        if (fromUnit instanceof Convertible){
            return ((Convertible)fromUnit).convertTo(toUnit, value);
        } else {
            throw new NotSupportedUnitException("Not supported unit.");
        }
    }

    private void validateUnits() {
        if (fromUnit.getClass() != toUnit.getClass()) {
            throw new UnitConverterException("Units are not of the same type.");
        }
    }
}

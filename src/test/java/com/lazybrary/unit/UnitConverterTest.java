package com.lazybrary.unit;

import com.lazybrary.unit.exception.NotSupportedTypeException;
import com.lazybrary.unit.exception.NotSupportedUnitException;
import com.lazybrary.unit.exception.UnitConverterException;
import com.lazybrary.unit.units.Length;
import com.lazybrary.unit.units.Weight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UnitConverterTest {

    @Test
    void lengthTest_correct(){
        double convertedInch = UnitConverter.from(Length.CENTIMETER, 2.54).to(Length.INCH).convert();
        Assertions.assertEquals(convertedInch, 1);
    }

    @Test
    void lengthTest_wrong(){
        double convertedInch = UnitConverter.from(Length.CENTIMETER, 2.55).to(Length.INCH).convert();
        Assertions.assertNotEquals(convertedInch, 1);
    }

    @Test
    void weightTest_correct(){
        double convertedTonne = UnitConverter.from(Weight.KILOGRAM, 1000).to(Weight.TONNE).convert();
        Assertions.assertEquals(convertedTonne, 1);
    }

    @Test
    void weightTest_wrong(){
        double convertedTonne = UnitConverter.from(Weight.KILOGRAM, 1000.1).to(Weight.TONNE).convert();
        Assertions.assertNotEquals(convertedTonne, 1);
    }

    @Test
    void throw_when_not_supported_type(){
        assertThatThrownBy(() -> {
            UnitConverter.from(Length.of("micro"), 2.54).to(Length.INCH).convert();
        }).isInstanceOf(NotSupportedTypeException.class)
                .hasMessageContaining("Not supported")
                .hasMessageContaining("type");
    }

    @Test
    void throw_when_not_supported_unit(){
        WrongEnum wrongEnum = WrongEnum.WRONG;
        assertThatThrownBy(() -> {
            UnitConverter.from(wrongEnum, 2.54).to(wrongEnum).convert();
        }).isInstanceOf(NotSupportedUnitException.class)
                .hasMessageContaining("Not supported")
                .hasMessageContaining("unit");
    }

    @Test
    void throw_when_different_unit(){
        WrongEnum wrongEnum = WrongEnum.WRONG;
        assertThatThrownBy(() -> {
            UnitConverter.from(Length.CENTIMETER, 2.54).to(wrongEnum).convert();
        }).isInstanceOf(UnitConverterException.class)
                .hasMessage("Units are not of the same type.");
    }

    private enum WrongEnum{
        WRONG
    }
}
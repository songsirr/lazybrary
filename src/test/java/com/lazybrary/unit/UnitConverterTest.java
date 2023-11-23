package com.lazybrary.unit;

import com.lazybrary.unit.exception.NotSupportedTypeException;
import com.lazybrary.unit.exception.NotSupportedUnitException;
import com.lazybrary.unit.exception.UnitConverterException;
import com.lazybrary.unit.units.*;
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
    void lengthTest_chaining(){
        double convertedValue = UnitConverter.from(Length.MILLIMETER, 10).to(Length.CENTIMETER).to(Length.METER).convert();
        Assertions.assertEquals(convertedValue, 0.01);
    }

    @Test
    void lengthTest_chaining2(){
        double convertedValue = UnitConverter.from(Length.CENTIMETER, 100).to(Length.METER).to(Length.KILOMETER).to(Length.CENTIMETER).convert();
        Assertions.assertEquals(convertedValue, 100);
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
    void fileSizeTest_correct(){
        double convertedSize = UnitConverter.from(FileSize.GIGABYTE, 1).to(FileSize.TERABYTE).convert();
        Assertions.assertEquals(1/1024f, convertedSize);
    }

    @Test
    void fileSizeTest_wrong(){
        double convertedSize = UnitConverter.from(FileSize.MEGABYTE, 1).to(FileSize.KILOBYTE).convert();
        Assertions.assertNotEquals(1023, convertedSize);
    }

    @Test
    void TimeTest_correct(){
        double convertedTime = UnitConverter.from(Time.MINUTE, 3).to(Time.SECOND).convert();
        Assertions.assertEquals(180, convertedTime);
    }

    @Test
    void TimeTest_wrong(){
        double convertedTime = UnitConverter.from(Time.MINUTE, 3).to(Time.SECOND).convert();
        Assertions.assertNotEquals(120, convertedTime);
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

    @Test
    void TempConvert(){
        double baseCel = 36.5; // f: 97.7, k: 309.65
        double baseFah = 97.7; // c: 36.5, k: 309.65

        Assertions.assertEquals(UnitConverter.from(Temperature.CELSIUS, baseCel).to(Temperature.FAHRENHEIT).convert(), 97.7);
        Assertions.assertEquals(UnitConverter.from(Temperature.CELSIUS, baseCel).to(Temperature.KELVIN).convert(), 309.65);
        Assertions.assertEquals(UnitConverter.from(Temperature.CELSIUS, baseCel).to(Temperature.CELSIUS).convert(), 36.5);
        Assertions.assertEquals(UnitConverter.from(Temperature.FAHRENHEIT, baseFah).to(Temperature.CELSIUS).convert(), 36.5);
        Assertions.assertEquals(UnitConverter.from(Temperature.FAHRENHEIT, baseFah).to(Temperature.KELVIN).convert(), 309.65);
    }

    private enum WrongEnum{
        WRONG
    }
}
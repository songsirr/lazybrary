package com.lazybrary.unit;

import com.lazybrary.unit.units.Length;
import com.lazybrary.unit.units.Weight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitConverterTest {

    @Test
    void lengthTest(){
        double convertedInch = UnitConverter.from(Length.CENTIMETER, 2.54).to(Length.INCH).convert();
        Assertions.assertEquals(convertedInch, 1);
    }

    @Test
    void weightTest(){
        double convertedTonne = UnitConverter.from(Weight.KILOGRAM, 1000).to(Weight.TONNE).convert();
        Assertions.assertEquals(convertedTonne, 1);
    }
}
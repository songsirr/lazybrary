package com.lazybrary.unit.units;

public enum Temperature implements Convertible {
    CELSIUS("celsius", "c", 0),
    FAHRENHEIT("fahrenheit", "f", 32),
    KELVIN("kelvin", "k", 273.15);

    private final String lowerCase;

    private final String symbol;

    private final double value;

    Temperature(String lowerCase, String symbol, double value) {
        this.lowerCase = lowerCase;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public double convertTo(Enum toUnit, double value) {
        if (this.equals(CELSIUS)){
            switch (toUnit.name()) {
                case "FAHRENHEIT":
                    return (value * 9/5) + 32;
                case "KELVIN":
                    return value + 273.15;
                default:
                    return value;
            }
        } else if (this.equals(FAHRENHEIT)) {
            switch (toUnit.name()) {
                case "CELSIUS":
                    return (value - 32) * 5/9;
                case "KELVIN":
                    return (value - 32) * 5/9 + 273.15;
                default:
                    return value;
            }
        } else { // from kelvin
            switch (toUnit.name()) {
                case "CELSIUS":
                    return value - 273.15;
                case "FAHRENHEIT":
                    return (value - 273.15) * 9/5 + 32;
                default:
                    return value;
            }
        }
    }
}

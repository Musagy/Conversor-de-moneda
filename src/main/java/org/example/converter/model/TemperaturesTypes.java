package org.example.converter.model;

public enum TemperaturesTypes {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin");

    private final String value;

    TemperaturesTypes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

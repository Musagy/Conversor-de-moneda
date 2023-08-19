package org.example.converter.model;

public enum LengthTypes {
    FEET("Pie(s)"),
    INCHES("Pulgada(s)"),
    CENTIMETERS("Centímetro(s)"),
    METERS("Metro(s)");

    private final String value;

    LengthTypes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

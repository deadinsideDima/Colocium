package org.example.converters;

public class FahrenheitConverter implements BaseTempConverter {
    @Override
    public double convert(double degreesCelsius) {
        return degreesCelsius * 1.8 + 32;
    }
}

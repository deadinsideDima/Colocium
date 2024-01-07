package org.example.converters;

public class KelvinConverter implements BaseTempConverter {
    @Override
    public double convert(double degreesCelsius) {
        return 273.15 + degreesCelsius;
    }
}

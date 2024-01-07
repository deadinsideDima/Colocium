package org.example;

import org.example.converters.BaseTempConverter;
import org.example.creators.ConverterCreator;
import org.example.creators.FahrenheitCreator;
import org.example.creators.KelvinCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Application {

    private BaseTempConverter converter;
    private final ArrayList<String> fahrenheitCountries = new ArrayList<>(Arrays.asList("BS", "US", "BZ", "KY", "PW"));

    private String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public void configure() {
        ConverterCreator creator;
        if (fahrenheitCountries.contains(getCountry())) {
            creator = new FahrenheitCreator();
        }
        else {
            creator = new KelvinCreator();
        }

        converter = creator.createConverter();
    }

    public double getTemperature(double celsius) {
        return converter.convert(celsius);
    }
}

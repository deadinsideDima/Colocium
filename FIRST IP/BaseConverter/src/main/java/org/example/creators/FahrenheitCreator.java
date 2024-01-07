package org.example.creators;

import org.example.converters.BaseTempConverter;
import org.example.converters.FahrenheitConverter;

public class FahrenheitCreator extends ConverterCreator {
    public BaseTempConverter createConverter() {
        return new FahrenheitConverter();
    }
}

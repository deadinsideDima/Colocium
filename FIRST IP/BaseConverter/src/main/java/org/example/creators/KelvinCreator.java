package org.example.creators;

import org.example.converters.BaseTempConverter;
import org.example.converters.KelvinConverter;

public class KelvinCreator extends ConverterCreator {
    public BaseTempConverter createConverter() {
        return new KelvinConverter();
    }
}

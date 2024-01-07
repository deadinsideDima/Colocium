package org.example.converters;

import org.example.converters.FahrenheitConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FahrenheitConverterTest {
    private FahrenheitConverter converter;

    @Before
    public void config() {
        converter = new FahrenheitConverter();
    }

    @Test
    public void zeroTest() {
        assertEquals(converter.convert(0), 32.0, 0.0);
    }

    @Test
    public void simpleTest() {
        assertEquals(converter.convert(12.5), 54.5, 0.0);
    }

    @Test
    public void negativeCelsiusTest() {
        assertEquals(converter.convert(-12.5), 9.5, 0.0);
    }

    @Test
    public void allNegativeTest() {
        assertEquals(converter.convert(-22.7), -8.86, 0.0);
    }
}

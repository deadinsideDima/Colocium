package org.example.converters;

import org.example.converters.KelvinConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KelvinConverterTest {
    private KelvinConverter converter;

    @Before
    public void config() {
        converter = new KelvinConverter();
    }

    @Test
    public void zeroTest() {
        assertEquals(273.15, converter.convert(0), 0.0);
    }

    @Test
    public void simpleTest() {
        assertEquals(285.65, converter.convert(12.5), 0.0);
    }

    @Test
    public void negativeCelsiusTest() {
        assertEquals(260.65, converter.convert(-12.5), 0.0);
    }

    @Test
    public void allNegativeTest() {
        assertEquals(250.45, converter.convert(-22.7), 0.0);
    }
}

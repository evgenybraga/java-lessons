package com.utilities;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibraga on 14/12/2015.
 */
public class ConverterTest extends TestCase {

    @Test
    public void testToString() throws Exception {
        assertEquals("-6843", Converter.toString(-6843));
        assertEquals("-1", Converter.toString(-1));
        assertEquals("0", Converter.toString(-0));
        assertEquals("0", Converter.toString(0));
        assertEquals("1", Converter.toString(1));
        assertEquals("9871", Converter.toString(9871));
    }

}
package com.utilities;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ibraga on 14/12/2015.
 */
public class ConverterTest extends TestCase {

    @Test
    public void testToStringInteger() throws Exception {
        assertEquals("-6843", Converter.toString(-6843));
        assertEquals("-1", Converter.toString(-1));
        assertEquals("0", Converter.toString(-0));
        assertEquals("0", Converter.toString(0));
        assertEquals("1", Converter.toString(1));
        assertEquals("9871", Converter.toString(9871));
    }

    @Test
    public void testParseInt() throws Exception {
        assertEquals(1, Converter.parseInt("1"));
        assertEquals(1, Converter.parseInt("+1"));
        assertEquals(-1, Converter.parseInt("-1"));
        assertEquals(-98256, Converter.parseInt("-98256"));
        assertEquals(98256, Converter.parseInt("98256"));
        assertEquals(-98256, Converter.parseInt("-000098256"));
        assertEquals(98256, Converter.parseInt("+000098256"));
        assertEquals(-98256000, Converter.parseInt("-98256000"));
        assertEquals(98256000, Converter.parseInt("98256000"));
        assertEquals(0, Converter.parseInt("-000000"));
        assertEquals(0, Converter.parseInt("+000000"));
        //assertEquals("Given value = [sdf] contains non digit characters", Converter.parseInt("sdf"));
    }

    public void testToStringDouble() throws Exception {
        assertEquals("0.0", Converter.toString(-0.0));
        assertEquals("0.0", Converter.toString(0.0));
        assertEquals("-0.1", Converter.toString(-0.1d));
        assertEquals("-0.4560000000000000", Converter.toString(-0.456d));
        assertEquals("0.1", Converter.toString(0.1d));
        assertEquals("0.4560000000000000", Converter.toString(0.456d));
        assertEquals("1.0", Converter.toString(1.0d));
        assertEquals("-1.0", Converter.toString(-1.0d));
        assertEquals("123.0", Converter.toString(123.0d));
        assertEquals("-123.0", Converter.toString(-123.0d));
        assertEquals("-123.45600000000000", Converter.toString(-123.456d));
        assertEquals("123.45600000000000", Converter.toString(123.456d));
    }

    public void testParseDouble() throws Exception {
        assertEquals(0.0, Converter.parseDouble("-0.0"), 0);
        assertEquals(0.0, Converter.parseDouble("0.0"), 0);
        assertEquals(-123.0, Converter.parseDouble("-123.0"), 0);
        assertEquals(-0.123, Converter.parseDouble("-0.123"), 0);
        assertEquals(-123.456, Converter.parseDouble("-123.456"), 0);
        assertEquals(123.0, Converter.parseDouble("123.0"), 0);
        assertEquals(0.123, Converter.parseDouble("0.123"), 0);
        assertEquals(123.456, Converter.parseDouble("123.456"), 0);
        assertEquals(0.123456789, Converter.parseDouble("0.123456789"), 0);
    }
}
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

    public void testToString1() throws Exception {

    }

    public void testParseDouble() throws Exception {

    }
}
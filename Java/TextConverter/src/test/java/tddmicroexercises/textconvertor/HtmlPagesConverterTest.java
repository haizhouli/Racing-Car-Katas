package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class HtmlPagesConverterTest {

    private PageReaderStub reader;

    @Before
    public void setup()
    {
        reader = new PageReaderStub();
    }

    @Test
    public void testPageConverter() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter("foo");
        converter.setReader(reader);
        reader.writeLine("first&second");
        assertEquals(converter.getHtmlPage(0),"first&amp;second<br />");
    }

    @Test
    public void testPageBreak() throws IOException {
        HtmlPagesConverter converter = new HtmlPagesConverter("foo");
        converter.setReader(reader);
        reader.writeLine("first&second");
        reader.writeLine("PAGE_BREAK");
        assertEquals(converter.getHtmlPage(0),"first&amp;second<br />");
    }
}

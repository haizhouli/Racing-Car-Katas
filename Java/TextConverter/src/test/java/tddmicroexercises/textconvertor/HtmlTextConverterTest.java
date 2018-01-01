package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HtmlTextConverterTest {

    private TextReaderStub reader;

    @Before
    public void setup()
    {
        reader = new TextReaderStub();
    }

    @Test
    public void textConverterTest() throws IOException{
        HtmlTextConverter textConverter = new HtmlTextConverter();
        textConverter.setReader(reader);
        reader.writeLine("first&second");
        assertEquals(textConverter.convertToHtml(),"first&amp;second<br />");
    }
}

package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lenovo on 2017/12/17.
 */
public class TextReaderImpl implements ITextReader {

    private BufferedReader reader;

    public TextReaderImpl(java.lang.String fullFilenameWithPath) throws FileNotFoundException
    {
         reader = new BufferedReader(new FileReader(fullFilenameWithPath));
    }

    @Override
    public java.lang.String readLine() throws IOException{
        return reader.readLine();
    }
}

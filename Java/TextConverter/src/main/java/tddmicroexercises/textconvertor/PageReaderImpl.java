package tddmicroexercises.textconvertor;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class PageReaderImpl implements IPageReader {

    private BufferedReader reader;

    public boolean init(String fileName) throws FileNotFoundException
    {
        if(StringUtils.isNotBlank(fileName)) {
            reader = new BufferedReader(new FileReader(fileName));
            return true;
        }
        return false;
    }

    @Override
    public java.lang.String readLine() throws IOException{
        return reader.readLine();
    }

    @Override
    public void skip(long num) throws IOException
    {
        reader.skip(num);
    }

    @Override
    public void close() throws IOException
    {
        reader.close();
    }
}

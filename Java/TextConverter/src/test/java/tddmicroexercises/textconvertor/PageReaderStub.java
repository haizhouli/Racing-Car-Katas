package tddmicroexercises.textconvertor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haizhou on 2017/12/17.
 */
public class PageReaderStub implements IPageReader{

    List<String> mockFileSource = new ArrayList<>();
    int count = 0;

    @Override
    public boolean init(String fileName) throws FileNotFoundException {
        count = 0;
        return true;
    }

    @Override
    public void skip(long num) throws IOException {

    }

    @Override
    public void close() throws IOException {
        return;
    }

    @Override
    public String readLine() throws IOException {
        if(count >= mockFileSource.size())
            return null;
        return mockFileSource.get(count++);
    }

    public void writeLine(String input)
    {
        mockFileSource.add(input);
    }
}

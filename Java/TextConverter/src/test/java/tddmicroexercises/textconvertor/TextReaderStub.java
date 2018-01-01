package tddmicroexercises.textconvertor;

import java.io.IOException;
import java.util.*;

/**
 * Created by lenovo on 2017/12/17.
 */
public class TextReaderStub implements ITextReader {

    Queue<String> mockFileSource = new LinkedList<>();

    public void writeLine(String input)
    {
        mockFileSource.add(input);
    }

    @Override
    public String readLine() throws IOException {
        return mockFileSource.poll();
    }
}

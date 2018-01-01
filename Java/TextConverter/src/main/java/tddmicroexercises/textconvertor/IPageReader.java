package tddmicroexercises.textconvertor;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Haizhou on 2017/12/17.
 */
public interface IPageReader extends ITextReader {

    boolean init(String fileName) throws FileNotFoundException;
    void skip(long num) throws IOException;
    void close() throws IOException;
}

package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlPagesConverter {

    private IPageReader reader;
    private List<Integer> breaks = new ArrayList<Integer>();
    private String fileName;

    public void setReader(IPageReader reader)
    {
        this.reader = reader;
    }

    public IPageReader getReader()
    {
        return this.reader;
    }

    public HtmlPagesConverter(String fileName)
    {
        this.fileName = fileName;
    }

    private boolean initReader() throws IOException
    {
        return reader.init(fileName);
    }

    private void cumulateBreaks() throws IOException
    {
        initReader();
        this.breaks.add(0);
        int cumulativeCharCount = 0;
        String line = reader.readLine();
        while (line != null)
        {
            cumulativeCharCount += line.length() + 1; // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                int page_break_position = cumulativeCharCount;
                breaks.add(page_break_position);
            }
            line = reader.readLine();
        }
    }

    public String getHtmlPage(int page) throws IOException {
        cumulateBreaks();
        initReader();
        reader.skip(breaks.get(page));
        StringBuffer htmlPage = new StringBuffer();
        String line = reader.readLine();
        while (line != null)
        {
            if (line.contains("PAGE_BREAK")) {
                break;
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line));
            htmlPage.append("<br />");
            
            line = reader.readLine();
        }
        reader.close();
        return htmlPage.toString();
    }
}

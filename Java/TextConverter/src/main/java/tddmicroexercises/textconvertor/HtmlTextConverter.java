package tddmicroexercises.textconvertor;

import java.io.IOException;

public class HtmlTextConverter
{

	ITextReader reader;

	public void setReader(ITextReader reader)
	{
		this.reader = reader;
	}

	public ITextReader getReader()
	{
		return this.reader;
	}

    //Literally this method should be rewritten as PagesConverter shows but functionality will
	//change. Current implementation doesn't ignore page_breaks.
	public String convertToHtml() throws IOException{

	    String line = reader.readLine();
		String html = "";
		while (line != null)
		{
			html += StringEscapeUtils.escapeHtml(line);
			html += "<br />";
			line = reader.readLine();
		}
		return html;

    }
}

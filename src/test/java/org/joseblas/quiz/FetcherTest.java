package org.joseblas.quiz;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptException;

/**
 * Created by josetaboada on 27/06/2015.
 */
public class FetcherTest {

    @Test
    public void testParseData() throws Exception {
        String data = "<html>\n" +
                "<head>\n" +
                "\t<title>Question</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Who is Football Radar's favourite football team</h2><h3>Find the answer here: http://www.footballradar.com/quiz/answer/{4 + 6 + 6}</h3>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        String tagValue = Utils.parse(data, "\\{([^}]*)\\}");
        Assert.assertEquals("Equals", "4 + 6 + 6", tagValue);

    }

    @Test
    public void sumFromString() throws ScriptException {
        Assert.assertEquals("Equals", "16", Utils.eval("10 + 5 + 1"));
    }


}

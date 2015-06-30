package org.joseblas.quiz;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by josetaboada on 27/06/2015.
 */
public class Fetcher {
    private static Log log = LogFactory.getLog(Fetcher.class);

    private static String target = "http://www.footballradar.com/quiz/answer/";
    private static String source = "http://www.footballradar.com/quiz/";
    public final static String pattern = "\\{([^}]*)\\}";


    public static String getResponse(String URL) throws IOException {
        return getContent(target+URL);
    }

    public static String fetchDataAndParse(String pattern) throws IOException {
        return Utils.parse(getContent(source),pattern);
    }

    private static String getContent(String URL) throws IOException {
        return Request.Get(URL).execute().returnContent().asString(Charset.defaultCharset());
    }


}

package org.joseblas.quiz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by josetaboada on 27/06/2015.
 */
public class Utils {

    private static Log log = LogFactory.getLog(Utils.class);

    private static ScriptEngine engine;

    public static String eval(String input) throws ScriptException {
        init();
        return ((Number) engine.eval(input)).toString();
    }


    public static String parse(String content, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        if (m.find()) {
            // get the matching group
            String codeGroup = m.group(1);

            // print the group
            log.debug("tag: " + codeGroup);
            return codeGroup;
        }
        return null;
    }

    public static void init() {
        if (engine == null)
            engine = new ScriptEngineManager().getEngineByName("JavaScript");
    }

}

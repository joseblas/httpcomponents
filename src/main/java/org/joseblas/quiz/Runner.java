package org.joseblas.quiz;

/**
 * Created by josetaboada on 27/06/2015.
 */
public class Runner {
    public static void main(String...args) throws Exception{

        Utils.init();
        long init= System.currentTimeMillis();
        String parse = Fetcher.fetchDataAndParse(Fetcher.pattern);
        System.out.println("   total fetching original webpage and parsing the math operation  "+ (System.currentTimeMillis() - init) + "ms");
        String processed = Utils.eval(parse);
        System.out.println("   total evaluating the operation "+ (System.currentTimeMillis() - init)+ "ms");
        String response = Fetcher.getResponse(processed);
        System.out.println("   total getting the best team ever!  "+ (System.currentTimeMillis() - init)+ "ms");
        System.out.println("Result "+ response);
        System.out.println("I thought it was a 11-side :) ");
    }


}

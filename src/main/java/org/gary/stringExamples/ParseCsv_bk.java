package org.gary.stringExamples;

import java.util.ArrayList;

public class ParseCsv_bk {

    private static void verifySeparatorQuote(String separator, String quote) {
        if(separator.length() != 1 || quote.length() != 1) {
            throw new RuntimeException("The value for separator or quote must be single character");
        }

        if(separator.equalsIgnoreCase(quote)) {
            throw new RuntimeException("The values for separator and quote cannot be the same");
        }
    }

    public static ArrayList<ArrayList<String>> parseCsv(
            String csv,
            String separator,
            String quote
    ) {

        verifySeparatorQuote(separator, quote);

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> element =  new ArrayList<String>();

        if (csv == null || csv.isEmpty()) {
            String tmp = "";
            element.add(tmp);
            result.add(element);
            return result;
        }

        final char LINE_FEEDER = '\n';

        String tmp = "";
        int numQuotes = 0;
        for(int i = 0; i < csv.length(); i++){
            String currentStr = csv.substring(i,i + 1);
            if(currentStr.charAt(0) != separator.charAt(0) && currentStr.charAt(0) != quote.charAt(0)
                    && currentStr.charAt(0) != LINE_FEEDER) {
                tmp += currentStr;
                if(i == csv.length() -1) {
                    element.add(tmp);
                    result.add(element);
                }
            } else if(currentStr.charAt(0) == separator.charAt(0)) {
                if(numQuotes % 2 == 0) {
                    element.add(tmp);
                    tmp = "";
                } else {
                    tmp += separator.charAt(0);
                }
            } else if (currentStr.charAt(0) == LINE_FEEDER) {
                if(numQuotes % 2 == 0) {
                    element.add(tmp);
                    result.add(element);
                    element = new ArrayList<String>();
                    tmp = "";
                } else {
                    tmp += LINE_FEEDER;
                }

            } else if (currentStr.charAt(0) == quote.charAt(0)
                    && csv.substring(i+1,i + 2).charAt(0) != LINE_FEEDER && csv.substring(i+1,i + 2).charAt(0) != separator.charAt(0)) {
                numQuotes++;
                if(numQuotes != 1 && numQuotes % 2 == 1) {
                    tmp += quote.charAt(0);
                }
            } else if (currentStr.charAt(0) == quote.charAt(0)) {
                numQuotes = 0;
            }

        }

        if(numQuotes % 2 != 0) {
            throw new RuntimeException("Error: unclosed quoted fields found");
        }

        return result;
    }
}

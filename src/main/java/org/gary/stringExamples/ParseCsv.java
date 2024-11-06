package org.gary.stringExamples;

import java.util.ArrayList;
import java.util.Arrays;

public class ParseCsv {

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
        int totalLength = csv.length();
        for(int i = 0; i < totalLength; i++){
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
                    && (i + 1 != totalLength) && csv.substring(i+1,i + 2).charAt(0) != LINE_FEEDER
                    && csv.substring(i+1,i + 2).charAt(0) != separator.charAt(0)) {
                numQuotes++;
                if(numQuotes != 1 && numQuotes % 2 == 1) {
                    tmp += quote.charAt(0);
                }
            } else if (currentStr.charAt(0) == quote.charAt(0)) {
                numQuotes++;
                if (numQuotes != 1 && numQuotes % 2 == 1) {
                    tmp += quote.charAt(0);
                } else if(numQuotes != 1){
                    numQuotes = 0;
                    if(i + 1 == totalLength) {
                        element.add(tmp);
                        result.add(element);
                    }
                }
            }
        }

        if(numQuotes % 2 != 0) {
            throw new RuntimeException("Error: unclosed quoted fields found");
        }

        return result;
    }

    public static void main(String args[]) {
//        ArrayList<ArrayList<String>>  result5 =
//                ParseCsv.parseCsv("one, ',,,,,..two,,,,,\n,,,,,,', three\n4, , 6", ",", "'");
//        System.out.println(result5);
//        ArrayList<ArrayList<String>>  result5 =
//                ParseCsv.parseCsv("1,2,3\n4,'this ''is''\n a test',6", ",", "'");
//        System.out.println(result5);
        ArrayList<ArrayList<String>>  result4 =
                ParseCsv.parseCsv("\\a \\\\string\\\\ using \\\\ as the quote\\.\\multi\nline\\. \n1.2.\\3.4\\", ".", "\\");
        System.out.println(result4);
//        ArrayList<ArrayList<String>>  result =
//                ParseCsv.parseCsv("1,2,3\n4,5,6", ",", "\"");
//        System.out.println(result);

//        ArrayList<ArrayList<String>>  result1 =
//                ParseCsv.parseCsv("1,\"two was here\",3\n4,5,6", ",", "\"");
//        System.out.println(result1);

//        ArrayList<ArrayList<String>>  result2 =
//                ParseCsv.parseCsv("1\t2\t3\n4\t5\t6", "\t", "\"");
//        System.out.println(result2);

//        ArrayList<ArrayList<String>>  result3 =
//                ParseCsv.parseCsv("one,\"two wraps\nonto \"\"two\"\" lines\",three\n4,,6", ",", "\"");
//        System.out.println(result3);




        /**
         * one,"two wraps
         * onto ""two"" lines",three
         * 4,,6
         */
    }

    public static <T> ArrayList<T> AL(T ...a) {
        return new ArrayList<T>(Arrays.asList(a));
    }
}
/**
 * separtor: \, $
 */
/**
 * alternative separators:
 * expected: <[[1, 2, 3	three], [4, 5, 6]]> but was: <[[1, 2, 3, three], [4, 5, 6]]>
 *
 * quote: \ $
 * expected: <[[a \string\ using \ as the quote, multi
 * line, ], [1, 2, 3.4]]> but was: <[[a \string\ using \ as the quote, \multi
 * line, ]]>
 *
 * expected: <[[a $string$ using $ as the quote, multi
 * line, ], [1.2, 3, 4]]> but was: <[[a $string$ using $ as the quote, $multi
 * line, ], [$1, 2, 3, 4]]>
 *
 * "a $string$ using $ as the quote, multi\nline,. \n"
 *
 * should handle separators in quoted fields
 * expected: <[[1, two, too, 3], [4, 5, 6]]> but was: <[[1, two,  too, 3], [4, 5, 6]]>
 *
 *
 * should handle multiple separators in multiline quoted fields
 * expected: <[[one, ,,,,,..two,,,,,
 * ,,,,,,, three], [4, , 6]]> but was: <[[one, , , , , , ..two, , , , ,
 * , , , , , , , three], [4, , 6]]>
 */

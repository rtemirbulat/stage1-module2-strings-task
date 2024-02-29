package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimiters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> resultList = new ArrayList<>();
        List<String> tempArr = new ArrayList<>();
        String temp = source;
        for (String d: delimiters) {
            StringTokenizer st1 = new StringTokenizer(temp, d);
            while (st1.hasMoreTokens()){
                tempArr.add(st1.nextToken());
            }
            temp = String.join(", ",tempArr);
            tempArr.clear();
        }
        resultList.add(temp);

        return  resultList;
    }
}

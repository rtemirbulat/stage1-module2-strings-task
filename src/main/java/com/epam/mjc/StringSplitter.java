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
        String[] temp3;
        tempArr.add(source);
        int cnt = 0;
        for (String d : delimiters) {
            tempArr.add(tempArr.get(cnt).replaceAll(d, " "));
            cnt++;
        }
        temp3 = tempArr.get(tempArr.size() - 1).split(" ");
        resultList.addAll(Arrays.asList(temp3));
        resultList.removeAll(Arrays.asList("", null));
        return resultList;
    }
}

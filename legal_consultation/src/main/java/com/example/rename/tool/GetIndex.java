package com.example.rename.tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetIndex {
    public static int getIndexOf (String data, String str, int num) {
        Pattern pattern = Pattern.compile( str );
        Matcher findMatcher = pattern.matcher( data );

        int indexNum = 0;
        while ( findMatcher.find() ) {
            indexNum++;
            if( indexNum == num ){
                break;
            }
        }
        return findMatcher.start();
    }

}

package com.gfar.java.basis.collection.array;

import java.util.Arrays;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {

        String[] strs={"dog","cat","cow"};
        List<String> listB= Arrays.asList(strs);


        char[] chars = new char[16];
        chars[0] = 'h';
        chars[1] = 'e';
        chars[2] = 'l';
        chars[3] = 'l';
        chars[4] = 'o';

        List<char[]> charList = Arrays.asList(chars);
        System.out.println(charList.get(0).toString());
        System.out.println(new String(chars));
    }
}

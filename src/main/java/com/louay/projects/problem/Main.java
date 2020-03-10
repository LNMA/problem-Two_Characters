package com.louay.projects.problem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("please input your word: ");
        StringBuffer word = new StringBuffer(input.next());
        StringBuffer trimWord = null;

        boolean isRight = false;
        Integer max = Integer.MIN_VALUE;
        char char1;
        char char2;
        for (int i = 1; i < word.length(); i++) {
            char1 = word.charAt(i - 1);
            char2 = word.charAt(i);
            trimWord = buildTrimWord(word,char1,char2);
            isRight = checkTrimWord(isRight, trimWord, char1, char2);
            max = findMaxLength(isRight, trimWord, max);
        }

        if (max<0){
            max = 0;
        }

        System.out.println(max);
    }


    public static StringBuffer buildTrimWord(StringBuffer word, char char1, char char2) {
        StringBuffer trimWord = new StringBuffer();
        for (int j = 0; j < word.length(); j++) {
            if ((word.charAt(j) == char1) || (word.charAt(j) == char2)) {
                trimWord.append(word.charAt(j));
            }
        }
        return trimWord;
    }

    public static boolean checkTrimWord(boolean isRight, StringBuffer trimWord, char char1, char char2){
        for (int j = 0; j < trimWord.length(); j++) {
            if (j == 0) {
                continue;
            } else {
                if (trimWord.charAt(j - 1) == char1 && trimWord.charAt(j) == char2) {
                    isRight = true;
                } else if (trimWord.charAt(j - 1) == char2 && trimWord.charAt(j) == char1) {
                    isRight = true;
                } else {
                    isRight = false;
                    break;
                }
            }
        }
        return isRight;
    }

    public static int findMaxLength(boolean isRight, StringBuffer trimWord, Integer max) {
        if (isRight) {
            if (trimWord.length() > max) {
                max = trimWord.length();
            }
        }
        System.out.println(trimWord);
        return max;
    }
}

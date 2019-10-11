package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(number -> number*3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(number -> number+96)
                             .map(number -> Character.toString((char)number.intValue()))
                             .collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(number -> number+96)
                .map(number -> {
                    int quotient = (number-96)/27;
                    int remaining = (number-96)-(quotient*26);
                    if (remaining == 27){
                        remaining -=26;
                        quotient ++;
                    }

                    System.out.println("Quotient: "+ quotient + " Remaining: "+remaining+ "Number: "+ number +"\n");
                    if (quotient == 0)
                        return Character.toString((char)number.intValue());
                    else
                        return Character.toString((char)(quotient+96)) + (char) (remaining+96);
                })
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        Collections.reverse(array);
        return array;
    }

    public List<Integer> sortFromSmall() {
        Collections.sort(array);
        return array;
    }
}

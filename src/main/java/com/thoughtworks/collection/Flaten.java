package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> finalList = new ArrayList<>();
        for (Integer[] currentArray: array) {
            Arrays.stream(currentArray).forEach(finalList::add);
        }
        return finalList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> finalList = new ArrayList<>();
        for (Integer[] currentArray: array) {
            Arrays.stream(currentArray).forEach(finalList::add);
        }
        return finalList.stream().distinct().collect(Collectors.toList());
    }
}

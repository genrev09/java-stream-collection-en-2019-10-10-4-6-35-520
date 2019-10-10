package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int minNum = Math.min(left,right);
        int maxNum = Math.max(left,right);
        List<Integer> finalList = Arrays.stream(IntStream.rangeClosed(minNum,maxNum).toArray()).boxed().collect(Collectors.toList());
        if (left > right)
            Collections.reverse(finalList);

        return finalList;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int minNum = Math.min(left,right);
        int maxNum = Math.max(left,right);
        List<Integer> finalList = Arrays.stream(IntStream.rangeClosed(minNum,maxNum).toArray()).boxed().collect(Collectors.toList());
        if (left > right)
            Collections.reverse(finalList);

        return finalList.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(number -> number%2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        return Arrays.stream(firstArray).boxed().filter(
                number -> Arrays.stream(secondArray).boxed().collect(Collectors.toList()).contains(number))
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> finalArray = new ArrayList<>();
        finalArray.addAll(Arrays.asList(firstArray));

        List<Integer> uncommonList = Arrays.stream(secondArray).filter(number -> !finalArray.contains(number)).collect(Collectors.toList());
        finalArray.addAll(uncommonList);

        return finalArray;

    }
}

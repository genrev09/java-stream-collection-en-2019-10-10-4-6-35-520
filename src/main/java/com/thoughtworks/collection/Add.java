package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int minNum = Math.min(leftBorder,rightBorder);
        int maxNum = Math.max(leftBorder,rightBorder);

        IntStream range = IntStream.rangeClosed(minNum,maxNum);
        return range.filter(number -> number%2 == 0)
                    .reduce((a,b) -> a+b).getAsInt();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int minNum = Math.min(leftBorder,rightBorder);
        int maxNum = Math.max(leftBorder,rightBorder);


        int total = 0;
        int[] range = IntStream.rangeClosed(minNum,maxNum).toArray();
        for (int number: range) {
            if(number%2 != 0)
                total+= number;
        }
        return total;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(number -> (number*3)+2).reduce((a,b) -> a+b).get();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
       List<Integer> totals = new ArrayList<>();

        for (int number: arrayList) {
            if(number % 2 == 0)
            {
                totals.add(number);
            }
            else {
                totals.add( (number * 3) +2);
            }
        }
        return totals;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {


        return arrayList.stream()
                .filter(num -> (num % 2 != 0))
                .map(number -> ((number * 3)+5))
                .reduce((a,b) -> a+b).get();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> filteredNumber = arrayList.stream()
                                                    .filter(number -> number%2 == 0)
                                                    .collect(Collectors.toList());

        return new Double(filteredNumber.stream().reduce((a,b) -> a+b).get()/filteredNumber.size());
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        List<Integer> finalList = arrayList.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
        return finalList.stream().reduce((a,b) -> a+b).get()/finalList.size();

    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> filteredNumber = arrayList.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
        return filteredNumber.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> finalList = new ArrayList<>();
        List<Integer> evenList = arrayList.stream().filter(number -> number%2 == 0).collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(number -> number%2 != 0).collect(Collectors.toList());

        Collections.sort(evenList);
        Collections.reverse(oddList);

        finalList.addAll(evenList);
        finalList.addAll(oddList);


        return finalList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> finalList = new ArrayList<>();
        List<Integer> numberList =  arrayList.stream().map((num) -> num*3).collect(Collectors.toList());
        for (int number: numberList) {
            int nextIndex = numberList.indexOf(number)+1;
            if (nextIndex < numberList.size())
                finalList.add(number + numberList.get(nextIndex));
        }
        return finalList;
    }
}

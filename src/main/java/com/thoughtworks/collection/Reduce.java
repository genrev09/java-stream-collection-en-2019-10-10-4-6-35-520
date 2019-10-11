package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return  arrayList.stream().reduce((a,b) -> a > b ? a : b).get();
    }

    public double getMinimum() {
        return  arrayList.stream().reduce((a,b) -> a < b ? a : b).get();
    }

    public double getAverage() {
        return arrayList.stream().reduce((a,b) -> a + b).get()/ (double) arrayList.size();
    }

    public double getOrderedMedian() {
        double medianNumber;
        DoubleStream sortedNumber = arrayList.stream().mapToDouble(Integer::doubleValue).sorted();

        if (arrayList.size()%2 == 0)
            return sortedNumber.skip(arrayList.size()/2 - 1).limit(2).average().getAsDouble();
        else
            return sortedNumber.skip(arrayList.size()/2).findFirst().getAsDouble();
    }

    public int getFirstEven() {
        return arrayList.stream().filter(number -> number%2 == 0)
                                 .reduce((a,b) -> a).get();
    }

    public int getIndexOfFirstEven() {
        int firstEven = arrayList.stream().filter(number -> number%2 == 0)
                                      .reduce((a,b) -> a).get();
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return Arrays.equals(this.arrayList.toArray(),arrayList.toArray());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        return arrayList.stream().filter(number -> number%2 != 0)
                                 .reduce((a,b) -> b).get();
    }

    public int getIndexOfLastOdd() {
        int lastOdd = arrayList.stream().filter(number -> number%2 != 0)
                                        .reduce((a,b) -> b).get();
        return arrayList.indexOf(lastOdd);
    }
}

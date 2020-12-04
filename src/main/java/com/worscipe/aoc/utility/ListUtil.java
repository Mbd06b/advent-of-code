package com.worscipe.aoc.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.worscipe.aoc.one.Password;

public class ListUtil {

    // Generic function to convert List of
    // String to List of Integer
    public static <T, U> List<U> convertStringListToTypeList(List<T> listOfString, Function<T, U> function) {
        return listOfString.stream().map(function).collect(Collectors.toList());
    }   
}
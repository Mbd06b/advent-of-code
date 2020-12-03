package com.worscipe.aoc.utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {

                // Generic function to convert List of 
        // String to List of Integer 
        public static <T, U> List<U> convertStringListToIntList(List<T> listOfString, Function<T, U> function) { 
            return listOfString.stream() 
                .map(function) 
                .collect(Collectors.toList()); 
        } 
    
}
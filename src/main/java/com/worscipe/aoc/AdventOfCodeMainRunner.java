
package com.worscipe.aoc;

import java.util.ArrayList;
import java.util.List;

import com.worscipe.aoc.utility.FileResourcesUtil;
import com.worscipe.aoc.utility.ListUtil;

public class AdventOfCodeMainRunner {

    public static void main(String... argvs) {
        String a = "Che";
        System.out.println("Hello World " + a + "!");


        //Day 1
        List<String> strList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        try{
            strList = FileResourcesUtil.getLines("12-1-2020/day1Input.txt");
        }catch(Exception e){
            System.out.print(e);
        }

        if(!strList.isEmpty()){
          numList = ListUtil.convertStringListToIntList(strList, Integer::parseInt);
        
          outerloop:
          for(int i = 0; i < numList.size(); i++ ){
                for(int j = 0; j < numList.size(); j++) {
                    if( i == j ) {
                        break;
                    }else {
                        if( numList.get(i) + numList.get(j) == 2020){
                            Integer product = numList.get(i) * numList.get(j);
                            System.out.println("Solution is product of two entries that total to 2020: " + numList.get(i) +" * " + numList.get(j) +" = " + product);
                            break outerloop;
                        }
                    }
                }
            }

            outerloop:
            for(int i = 0; i < numList.size(); i++ ){
                for(int j = 0; j < numList.size(); j++) {
                    for(int k = 0; k < numList.size(); k++){
                        if( i == j || i == k || k == j ) {
                            break;
                        }else {
                            if( numList.get(i) + numList.get(j) + numList.get(k) == 2020){
                                Integer product = numList.get(i) * numList.get(j) * numList.get(k);
                                System.out.println("Solution is product of three entries that total to 2020: " + numList.get(i) +" * " + numList.get(j) + " * " + numList.get(k) + " = " + product);
                                break outerloop;
                            }
                        }
                    }
                }
            }
        }

        

    }
}

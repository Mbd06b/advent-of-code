
package com.worscipe.aoc;

import java.util.ArrayList;
import java.util.List;

import com.worscipe.aoc.one.Password;
import com.worscipe.aoc.utility.FileResourcesUtil;
import com.worscipe.aoc.utility.ListUtil;

public class AdventOfCodeMainRunner {

    public static void main(String... argvs) {
  
        //Day 1
        List<String> strList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        try{
            strList = FileResourcesUtil.getLines("12-1-2020/day1Input.txt");
        }catch(Exception e){
            System.out.print(e);
        }

        if(!strList.isEmpty()){
          numList = ListUtil.convertStringListToTypeList(strList, Integer::parseInt);
        
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

        //DAY 2 
        List<String> inputList = new ArrayList<>();
        List<Password> passwordList = new ArrayList<>();  
        try{
            inputList = FileResourcesUtil.getLines("12-2-2020/day2Input.txt");
        }catch(Exception e){
            System.out.print(e);
        }

        passwordList = ListUtil.convertStringListToTypeList(inputList, Password::parsePassword);
        Integer occuranceCount = 0;
        Integer positionValidCount = 0;
        if(!inputList.isEmpty()){
            for(Password password : passwordList){
               if(password.isOccuranceValid()){
                   occuranceCount = occuranceCount + 1; 
               }
               if(password.isPositionValid()){
                   positionValidCount = positionValidCount + 1;
               }
            }
        System.out.println("Number of valid character occurance passwords: " + occuranceCount.toString());
        System.out.println("Number of valid character position passwords: " + positionValidCount.toString());

        }

    }
}

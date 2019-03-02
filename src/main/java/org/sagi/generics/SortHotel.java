package org.sagi.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SortHotel {


    // Complete the best_hotels function below.
    static void best_hotels() {
        System.out.println("Please insert inputs");
        Scanner scanner = new Scanner(System.in);
        int numberOfHotels = Integer.valueOf(scanner.nextLine());

        String lineInput;
        Map<Integer, List<Integer>> hotelsMap = new HashMap(numberOfHotels);
        for (int i = 0; i < numberOfHotels; i++) {
            lineInput = scanner.nextLine();
            String[] siltedData = lineInput.split(" ");
            Integer key = Integer.valueOf(siltedData[0]);
            Integer score = Integer.valueOf(siltedData[1]);
            List<Integer> scoreList;
            if (hotelsMap.keySet().contains(key)) {
                scoreList = hotelsMap.get(key);
            } else {
                scoreList = new ArrayList();
                hotelsMap.put(key, scoreList);
            }
            scoreList.add(score);
        }

        Set<Map.Entry<Integer, List<Integer>>> entries = hotelsMap.entrySet();
        List<Map.Entry<Integer, List<Integer>>> entriesList = new ArrayList<>(entries);


        Collections.sort(entriesList, (elm1, elm2) -> {
            int returnValue;
            List<Integer> elm1Values = elm1.getValue();
            List<Integer> elm2Values = elm2.getValue();

            Double elm1Average = elm1Values.stream().mapToDouble((p) -> p).average().orElse(Double.NaN);
            Double elm2Average = elm2Values.stream().mapToDouble((p) -> p).average().orElse(Double.NaN);

            if (elm1Average == elm2Average) {
                returnValue = elm1.getKey().compareTo(elm2.getKey());
            } else {
                returnValue =  elm1Average.compareTo(elm2Average);
            }
            return returnValue*-1;
        });

       // Collections.reverse(entriesList);
        for ( Map.Entry<Integer, List<Integer>> integerListEntry : entriesList){
            System.out.println(integerListEntry.getKey());
        }

    }

    public static void main(String[] args) {

        best_hotels();

    }
}




package org.sagi.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ssefer at 2/24/2019
 */
public class GenericMethodDemo {

    public <T> List<T> convertToList (T[] values){
        return Arrays.stream(values).collect(Collectors.toList());
    }

    public <T, G> List<G> mapFromArrayList (T[] values, Function<T,G> funcF ){

        return Arrays.stream(values).map(funcF).collect(Collectors.toList());
    }

    Function<Integer, String> function1 = t -> ("Number is: " + t);

    public static void main(String[] args){
        GenericMethodDemo gd = new GenericMethodDemo();
        Integer[] inputs = {1,2,3,4,5};
        //Function<Integer, String> function1 = t -> ("Number is: " + t);
        List<String> result = gd.mapFromArrayList(inputs, gd.function1);
        System.out.println(result.toString());

        int[] intArray = new int[] {1,2,3,4,5,6,7,8,9};
        List<Integer> integers = Arrays.stream(intArray).filter(v -> v % 2 == 0).boxed().collect(Collectors.toList());

    }

    class HotelAsd{

        List<Integer> aa;
        int id;

        HotelAsd(){
            aa = new ArrayList<>();
        }

        void addScore(int a){
            aa.add(a);
        }

    }
}

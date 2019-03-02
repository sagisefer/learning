package org.sagi.generics.functions;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ssefer at 2/24/2019
 */
public class GenericMethods {

    //get list of numbers and return List of Strings
    public static <T extends Number> List<String> convertToListOfString(List<T> values) {
        return values.stream().map(value -> value.toString()).collect(Collectors.toList());
    }

    //Get list of number from type T, sort it and return List of number from type V.
    public static <T extends Number, V extends Number> List<V> sortAndCust(List<T> inputs){
        return inputs.stream().sorted().map(value -> (V)value).collect(Collectors.toList());
    }

    //convert from list of something to list of something else
    public static <T, G> List<G> fromListSomthingToListSomething(List<T> inputList, Function<T,G> myMapper){
        return inputList.stream().map(value -> myMapper.apply(value)).collect(Collectors.toList());
    }

}

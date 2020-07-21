package ru.commands.javamm.temp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 2, 1, 1, 1, 1, 4, 5));
        //List<Integer> list1 = list.stream().distinct().map(x -> x + 10).sorted().peek(System.out::println).collect(Collectors.toList());
/*        int[] ints = Stream.builder().add("1").add("2").add("3").build()
                .mapToInt((s) -> Integer.parseInt((String) s))
                .peek(System.out::println).toArray();*/
        Integer integer = list.stream().filter(x -> x == 10).findFirst().orElse(-1);
        System.out.println(integer);
        boolean b = list.stream().noneMatch(x -> x == 10);
        System.out.println(b);
        boolean b1 = list.stream().allMatch(x -> x > 0);
        System.out.println(b1);
        boolean b2 = list.stream().allMatch(x -> x > 0);
        System.out.println(b2);
        OptionalDouble average = IntStream.of(6, 2, 1, 1, 1, 1, 4, 5).average();
        System.out.println(average.getAsDouble());

    }
    public Integer findExactValue(List<Integer> list, int exactValue) {
        return list.stream().distinct().filter(x -> x == exactValue).findAny().orElse(-1);
    }
}

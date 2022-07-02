package com.pfi.main;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("uno");
        lista.add("dos");
        lista.add("tres");

        Long count = lista.stream().collect(Collectors.counting());
        Double avg = lista.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(avg);

        List<Integer> listInt = new ArrayList<>();
        listInt.add(4);
        listInt.add(8);
        listInt.add(3);

        Optional<Integer> max = listInt.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        Optional<Integer> min = listInt.stream().collect(Collectors.minBy(Comparator.naturalOrder()));

        System.out.println(max.get() + " " + min.get());

        IntSummaryStatistics statistics = listInt.stream()
                .collect(Collectors.summarizingInt(x -> x));
        long suma = statistics.getSum();

        System.out.println(suma);
        Integer sum = listInt.stream()
                .collect(Collectors.summingInt(x->x));

        System.out.println(sum);

        LinkedList<Integer> ll = listInt.stream().collect(Collectors.toCollection(LinkedList::new));

        ll.forEach(System.out::println);

        String join = listInt.stream().map(x -> ""+x).collect(Collectors.joining("-"));
        System.out.println(join);
    }
}

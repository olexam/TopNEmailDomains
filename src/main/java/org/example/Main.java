package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static final int MAX_SIZE = 10;
    public static final String AMPERSAND = "@";

    public static void main(String[] args) {
        final Comparator<Map.Entry<String, Long>> entryValueComparator = (e1, e2) -> Long.compare(e2.getValue(), e1.getValue());

        new BufferedReader(new InputStreamReader(System.in)).lines()
                .filter(s1 -> s1.contains(AMPERSAND))
                .map(String::strip)
                .map(email -> email.substring(email.lastIndexOf(AMPERSAND) + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(entryValueComparator.thenComparing(Map.Entry.comparingByKey()))
                .limit(MAX_SIZE)
                .forEach(x -> System.out.printf("%s %d%n", x.getKey(), x.getValue()));
    }
}

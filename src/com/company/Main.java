package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var name = "John Ronald Reuel Tolkien";

        var result = buildName(name);
        System.out.println(result);

    }

    public static String buildName(String name) {
        List<String> listOfNames = Arrays.asList(String.valueOf(name.split(" ")));
        var lastName = prepareAndGetLastName(listOfNames);
        var allOthersNames = prepareAndGetAllOthersNames(listOfNames);
        return createSignature(lastName, allOthersNames);
    }

    private static String prepareAndGetLastName(List<String> listOfNames) {
        return listOfNames.get(listOfNames.size() - 1).toUpperCase();
    }

    private static List<String> prepareAndGetAllOthersNames(List<String> listOfNames) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < listOfNames.size() - 1; i++) {
            names.add(listOfNames.get(i).substring(0, 1).toUpperCase());
        }
        return names;
    }

    private static String createSignature(String lastName, List<String> allOthersNames) {

        String othersNames = allOthersNames.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(". "));

        return lastName + ", " + othersNames + ".";
    }
}


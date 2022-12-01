package com.adventofcode.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Advent of Code - Day 1");
	    Main main = new Main();
        List<String> input = new ArrayList<>();
        try {
            input = main.loadDataFromFile("/input1.txt");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println("Most caloric Elf: " + main.findMostCaloricElf(main.processData(input)));
        System.out.println("Three most caloric elves: " + main.findMostThreeCaloricElf(main.processData(input)));
    }

    private List<String> loadDataFromFile(String fileName) throws IOException, URISyntaxException {
        Stream<String> input = Files.lines(Path.of(this.getClass().getResource(fileName).toURI()));
        Iterator<String> it = input.iterator();
        List<String> data = new ArrayList<>();
        while (it.hasNext()) {
            data.add(it.next());
        }
        return data;
    }

    private List<Elf> processData(List<String> data) {
        List<Elf> elves = new ArrayList<>();
        int totalCalories = 0;
        for (String singleLoadOfCalories : data) {
            if (!singleLoadOfCalories.isEmpty()) {
                totalCalories += Integer.valueOf(singleLoadOfCalories);
            } else {
                elves.add(new Elf(totalCalories));
                totalCalories = 0;
            }
        }
        return elves;
    }

    private Elf findMostCaloricElf(List<Elf> elves) {
        elves.sort(Comparator.comparingInt(Elf::getTotalCalories));
        return elves.get(elves.size()-1);
    }

    private int findMostThreeCaloricElf(List<Elf> elves) {
        elves.sort(Comparator.comparingInt(Elf::getTotalCalories));
        return elves.get(elves.size()-1).getTotalCalories()
                + elves.get(elves.size()-2).getTotalCalories()
                + elves.get(elves.size()-3).getTotalCalories();
    }


}

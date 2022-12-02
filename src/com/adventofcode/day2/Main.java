package com.adventofcode.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Advent of Code - Day 2");
        Main main = new Main();
        List<String> input = new ArrayList<>();
        try {
            input = main.loadDataFromFile("/input2.txt");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        List<String> mappedFristValues = input.stream().map(element -> element
                .replace("A ", "ROCK ")
                .replace("B ", "PAPER ")
                .replace("C ", "SCISSORS ")
                .replace("X", "ROCK")
                .replace("Y", "PAPER")
                .replace("Z", "SCISSORS"))
                .collect(Collectors.toList());

        List<String> mappedSecondValues = input.stream().map(element -> element
                .replace("A ", "ROCK ")
                .replace("B ", "PAPER ")
                .replace("C ", "SCISSORS ")
                .replace("X", "LOSE")
                .replace("Y", "DRAW")
                .replace("Z", "WIN"))
                .collect(Collectors.toList());

        System.out.println("Sum first strategy: " + main.sumUp(main.mappingFirstStrategy(mappedFristValues)));
        System.out.println("Sum second strategy: " + main.sumUp(main.mappingSecondStrategy(mappedSecondValues)));
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

    private int sumUp(List<String> rounds) {
        int sum = 0;
        for (String round : rounds) {
            sum += Integer.valueOf(round);
        }
        return sum;
    }

    private List<String> mappingFirstStrategy(List<String> rounds) {
        return rounds.stream().map(element -> element
                .replace("ROCK SCISSORS", "3")
                .replace("SCISSORS PAPER", "2")
                .replace("PAPER ROCK", "1")
                .replace("ROCK ROCK", "4")
                .replace("PAPER PAPER", "5")
                .replace("SCISSORS SCISSORS", "6")
                .replace("SCISSORS ROCK", "7")
                .replace("ROCK PAPER", "8")
                .replace("PAPER SCISSORS", "9"))
                .collect(Collectors.toList());

    }

    private List<String> mappingSecondStrategy(List<String> rounds) {
        return rounds.stream().map(element -> element
                .replace("ROCK LOSE", "3")
                .replace("ROCK DRAW", "4")
                .replace("ROCK WIN", "8")
                .replace("PAPER LOSE", "1")
                .replace("PAPER DRAW", "5")
                .replace("PAPER WIN", "9")
                .replace("SCISSORS LOSE", "2")
                .replace("SCISSORS DRAW", "6")
                .replace("SCISSORS WIN", "7"))
                .collect(Collectors.toList());
    }
}



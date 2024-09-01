package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        int MAX_FREQUENCY = 20;

        HashMap<String, Integer> frequency = new HashMap<>();

        // Extracting valid words and updating frequency
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.matches("^[a-zA-Z]+$")) {
                        String lowerCaseWord = word.toLowerCase();
                        frequency.put(lowerCaseWord, frequency.getOrDefault(lowerCaseWord, 0) + 1);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Finding top 20 most frequent words
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (String word : frequency.keySet()) {
            Integer count = frequency.get(word);
            heap.offer(new Pair(word, count));
            if (heap.size() > MAX_FREQUENCY) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            Pair pair = heap.poll();
            String word = pair.getWord();
            int currentFrequency = frequency.get(word);
            System.out.println("Word: " + word + " Frequency: " + currentFrequency);
        }
    }
}


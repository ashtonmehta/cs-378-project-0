package org.example;

public class Pair implements Comparable<Pair> {
    private String word;
    private int freq;

    public Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }

    public int getFrequency() {
        return freq;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.freq, o.freq);
    }
}

package com.fridge;

import java.util.Arrays;

public class Permutations {
    private Object[] source;
    private int variationLength;

    public Permutations(Object[] source, int variationLength) {
        this.source = source;
        this.variationLength = variationLength;
    }

    public Object[][] getVariations() {
        int srcLength = source.length;
        int permutations = (int) Math.pow(srcLength, variationLength);

        Object[][] table = new Object[permutations][variationLength];

        for (int i = 0; i < variationLength; i++) {
            int t2 = (int) Math.pow(srcLength, i);
            for (int p1 = 0; p1 < permutations;) {
                for (int al = 0; al < srcLength; al++) {
                    for (int p2 = 0; p2 < t2; p2++) {
                        table[p1][i] = source[al];
                        p1++;
                    }
                }
            }
        }

        return table;
    }

    public static void main(String[] args) {
        Permutations gen = new Permutations(new Integer[]{0, 1}, 4);
        Object[][] variations = gen.getVariations();

        for (Object[] s : variations) {
            System.out.println(Arrays.toString(s));
        }
    }
}
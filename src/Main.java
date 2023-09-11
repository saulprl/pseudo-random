import algorithms.ConstantMultiplier;
import algorithms.Linear;
import algorithms.MiddleSquare;

import java.util.ArrayList;

public class Main {
    public static void middleSquare(int seed, int digits, int n) {
        System.out.println("i\t\t\t|xᵢ\t\t\t\t|rᵢ\t\t");

        for (int i = 1; i <= n; i++) {
            long squaredSeed = (long) seed * seed;
            String squaredSeedStr = String.valueOf(squaredSeed);
            int startIndex = (squaredSeedStr.length() - digits) / 2;
            int endIndex = startIndex + digits;

            int nextSeed = Integer.parseInt(squaredSeedStr.substring(startIndex, endIndex));
            double randomNumber = (double) nextSeed / Math.pow(10, digits);

            seed = nextSeed;

            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }
    }

    public static ArrayList<Float> middleProduct(int X_0, int X_1) {
        int digits = String.valueOf(X_0).length();
        if (String.valueOf(X_1).length() != digits) {
            return null;
        }

        int n = 100;
        ArrayList<Integer> seeds = new ArrayList<>() {{
            add(X_0);
            add(X_1);
        }};
        ArrayList<Float> randomNumbers = new ArrayList<>();

        System.out.println("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t");
        for (int i = 1; i <= n; i++) {
            int product = seeds.get(i - 1) * seeds.get(i);
            String productStr = String.valueOf(product);
            int startIndex = (productStr.length() - digits) / 2;
            int endIndex = startIndex + digits;

            int nextSeed = Integer.parseInt(productStr.substring(startIndex, endIndex));
            float randomNumber = (float) nextSeed / (float) Math.pow(10, digits);

            seeds.add(nextSeed);
            randomNumbers.add(randomNumber);

            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, nextSeed, randomNumber);
        }

        return randomNumbers;
    }

    public static void constantMultiplier(int seed, int multiplier, int digits, int n) {
        System.out.println("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t");

        for (int i = 1; i <= n; i++) {
            long multipliedSeed = (long) seed * multiplier;
            String multipliedSeedStr = String.valueOf(multipliedSeed);
            int startIndex = (multipliedSeedStr.length() - digits) / 2;
            int endIndex = startIndex + digits;

            int nextSeed = Integer.parseInt(multipliedSeedStr.substring(startIndex, endIndex));
            double randomNumber = (double) nextSeed / Math.pow(10, digits);

            seed = nextSeed;

            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }
    }

    public static void linear(int seed, int g, int k, int c) {
        int multiplier = 1 + 4 * k;
        int modulus = (int) Math.pow(2, g);

        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= modulus; i++) {
            int nextSeed = (multiplier * seed + c) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }
    }

    public static void linear(int seed, int a, int m, int c, int n) {
        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= n; i++) {
            int nextSeed = (a * seed + c) % m;
            double randomNumber = (double) nextSeed / (m - 1);

            seed = nextSeed;
            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }
    }

    public static ArrayList<Double> multiplicativeConditioned(int seed, int g, int k) {
        int modulus = (int) Math.pow(2, g);
        int multiplier = 3 + 8 * k;
        int period = modulus / 4;

        ArrayList<Double> randomNumbers = new ArrayList<>();

        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= period; i++) {
            int nextSeed = (multiplier * seed) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            randomNumbers.add(randomNumber);
            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }

        return randomNumbers;
    }

    public static ArrayList<Double> multiplicative(int seed, int modulus, int multiplier) {
        int period = modulus / 4;

        ArrayList<Double> randomNumbers = new ArrayList<>();

        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= period; i++) {
            int nextSeed = (multiplier * seed) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            randomNumbers.add(randomNumber);
            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }

        return randomNumbers;
    }

    public static ArrayList<Double> additive(ArrayList<Integer> secuence, int modulus, int n) {
        ArrayList<Double> randomNumbers = new ArrayList<>();
        ArrayList<Integer> sec = new ArrayList<>(secuence);

        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= n; i++) {
            int index = i - 1 + secuence.size();
            int first = sec.get(index - 1);
            int second = sec.get(index - secuence.size());
            int nextSeed = (first + second) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            randomNumbers.add(randomNumber);
            sec.add(nextSeed);
            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, nextSeed, randomNumber);
        }

        return randomNumbers;
    }

    public static void main(String[] args) {
        ArrayList<Float> result = middleProduct(5015, 5734);

        if (result == null) {
            System.out.println("Result is null");
            System.exit(1);
        }
    }
}
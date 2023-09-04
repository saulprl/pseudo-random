import algorithms.ConstantMultiplier;
import algorithms.Linear;
import algorithms.MiddleSquare;

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
        int multiplier = 1 + (4 * k);
        int modulus = (int) Math.pow(2, g);

        System.out.printf("i\t\t\t|xᵢ\t\t\t|rᵢ\t\t\n");
        for (int i = 1; i <= modulus; i++) {
            int nextSeed = (multiplier * seed + c) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            System.out.printf("%d\t\t\t|%d\t\t\t|%f\n", i, seed, randomNumber);
        }
    }

    public static void main(String[] args) {
        System.out.println("Middle Square");
        middleSquare(1234, 4, 10);
        System.out.println("Constant Multiplier");
        constantMultiplier(1234, 8121, 4, 10);
        System.out.println("Linear");
        linear(6, 3, 3, 7);
    }
}
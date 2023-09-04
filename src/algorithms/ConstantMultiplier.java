package algorithms;

public class ConstantMultiplier extends Algorithm {
    private final int multiplier;
    private final int digits;
    private final int n;
    private int seed;

    public ConstantMultiplier(int seed, int multiplier, int digits, int n) {
        this.seed = seed;
        this.multiplier = multiplier;
        this.digits = digits;
        this.n = n;
    }

    @Override
    public void generate() {
        for (int i = 0; i < n; i++) {
            long multipliedSeed = (long) seed * multiplier;
            String multipliedSeedStr = String.valueOf(multipliedSeed);
            int startIndex = (multipliedSeedStr.length() - digits) / 2;
            int endIndex = startIndex + digits;

            int nextSeed = Integer.parseInt(multipliedSeedStr.substring(startIndex, endIndex));
            double randomNumber = (double) nextSeed / Math.pow(10, digits);

            seed = nextSeed;

            System.out.printf("Multiplied seed: %d\n", multipliedSeed);
            System.out.printf("Next seed: %d\n", seed);
            System.out.printf("Random number: %f\n", randomNumber);
        }
    }
}

package algorithms;

public class MiddleSquare extends Algorithm {
    private int seed;
    private final int digits;
    private final int n;

    public MiddleSquare(int seed, int digits, int n) {
        this.seed = seed;
        this.digits = digits;
        this.n = n;
    }

    @Override
    public void generate() {
        for (int i = 0; i < n; i++) {
            long squaredSeed = (long) seed * seed;
            String squaredSeedStr = String.valueOf(squaredSeed);
            int startIndex = (squaredSeedStr.length() - digits) / 2;
            int endIndex = startIndex + digits;

            int nextSeed = Integer.parseInt(squaredSeedStr.substring(startIndex, endIndex));
            double randomNumber = (double) nextSeed / Math.pow(10, digits);

            seed = nextSeed;

            System.out.printf("Squared seed: %d\n", squaredSeed);
            System.out.printf("Next seed: %d\n", seed);
            System.out.printf("Random number: %f\n", randomNumber);
        }
    }
}

package algorithms;

public class Linear extends Algorithm {
    private int seed;
    private final int multiplier;
    private final int increment;
    private final int modulus;
    private final int n;

//    public Linear(int seed, int multiplier, int increment, int modulus, int n) {
//        this.seed = seed;
//        this.multiplier = multiplier;
//        this.increment = increment;
//        this.modulus = modulus;
//        this.n = n;
//    }

    public Linear(int seed, int g, int k, int c, int n) {
        this.seed = seed;
        this.multiplier = 1 + (4 * k);
        this.modulus = (int) Math.pow(2, g);
        this.increment = c;
        this.n = n;
    }

    @Override
    public void generate() {
        System.out.printf("i\t\t\txᵢ\t\t\trᵢ\n");
        for (int i = 1; i <= n; i++) {
            int nextSeed = (multiplier * seed + increment) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            System.out.printf("%d\t\t\t%d\t\t\t%f\n", i, seed, randomNumber);
        }
    }

    public void generateConditioned(int seed, int increment, int multiplier, int modulus, int n) {
        System.out.printf("i\t\t\txᵢ\t\t\trᵢ\n");
        for (int i = 1; i <= n; i++) {
            int nextSeed = (multiplier * seed + increment) % modulus;
            double randomNumber = (double) nextSeed / (modulus - 1);

            seed = nextSeed;

            System.out.printf("%d\t\t\t%d\t\t\t%f\n", i, seed, randomNumber);
        }
    }
}

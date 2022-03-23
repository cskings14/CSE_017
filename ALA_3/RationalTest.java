




import java.util.Random;
public class RationalTest {
    

    public static void main(String[] args) {
        Number[] numbers = new Number[10];
        Random rand = new Random();
        numbers[0] = rand.nextInt(100);
        numbers[1] = rand.nextInt(100);
        numbers[2] = rand.nextLong();
        numbers[3] = rand.nextLong();
        numbers[4] = rand.nextFloat();
        numbers[5] = rand.nextFloat();
        numbers[6] = rand.nextDouble();
        numbers[7] = rand.nextDouble();
        numbers[8] = new Rational(rand.nextInt(10), rand.nextInt(10) + 1);
        numbers[9] = new Rational(rand.nextInt(10), rand.nextInt(10) + 1);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + "\t" + numbers[i].intValue() + "\t" + numbers[i].doubleValue());

        }

        Rational[] fractions = new Rational[8];
        for (int i = 0; i < fractions.length; i++) {
            fractions[i] = new Rational(rand.nextInt(10), rand.nextInt(10) + 1);

        }

        for (int i = 0; i < fractions.length; i++) {
            System.out.println(fractions[i]);


        }

        Rational ss = fractions[0].add(fractions[1]);
        Rational dd = fractions[2].sub(fractions[3]);
        Rational ff = fractions[4].mult(fractions[5]);
        Rational gg = fractions[6].div(fractions[7]);

        System.out.println("ss is the sum of " + fractions[0] + "and" + fractions[1]);
        System.out.println("dd is the difference of " + fractions[2] + "and" + fractions[3]);
        System.out.println("ff is the product of " + fractions[4] + "and" + fractions[5]);
        System.out.println("gg is the quotient of " + fractions[6] + "and" + fractions[7]);

        java.util.Arrays.sort(fractions);
        for (Rational fraction : fractions) {
            System.out.println(fraction);

        }

        










    }


}

public class Rational extends Number implements Comparable<Rational>, Cloneable {
    

    private int numerator;
    private int denominator;

    public Rational() {
        numerator = 0;
        denominator = 1;

    }
    
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String toString() {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return "" + numerator;
        }
        if (numerator == denominator) {
            return "1";
        }
        if (denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        return numerator + "/" + denominator;


    }

    public Rational add (Rational other) {
        int d = this.denominator * other.denominator;
        int n = this.numerator * other.denominator + other.numerator * this.denominator;
        Rational q = new Rational(n, d);
        q.reduce();
        return q;
    }

    private void reduce() {
        int g = gcd();
        numerator /= g;
        denominator /= g;
    }
    private int gcd(){
        int g = 1;
        for (int i = 2; i < numerator || i < denominator; i++){
            if (numerator % i == 0 && denominator % i == 0){
                g = i;
            }
        }
        return g;
    }

    public int intValue(){
        return numerator / denominator;
    }

    public float floatValue(){
        return (float) numerator / denominator;
    }

    public double doubleValue(){
        return (double) numerator / denominator;
    }

    public long longValue(){
        return (long) numerator / denominator;
    }

    public int compareTo(Rational other) {
        if (this.numerator * other.denominator > other.numerator * this.denominator){
            return 1;
        }
        if (this.numerator * other.denominator < other.numerator * this.denominator){
            return -1;
        }
        return 0;
    }

    public Object clone() {
        return new Rational(numerator, denominator);
    }












}

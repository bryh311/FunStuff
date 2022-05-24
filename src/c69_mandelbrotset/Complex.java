package c69_mandelbrotset;

/**
 * A class that handles enough parts of complex numbers to perform calculations relating to the mandelbrot set
 */
public class Complex extends Object{
    private double r;
    private double i;

    /**
     *
     * @param r The real number in a complex number
     * @param i The imaginary number in a complex number
     */
    public Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public String toString() {
        String op = this.i < 0 ? "" : "+";
        return this.r + op + this.i + "i";
    }

    public static Complex square(Complex a) {
        double real = (a.r * a.r) - (a.i * a.i);
        double imaginary = (a.r * a.i) + (a.i * a.r);
        return new Complex(real, imaginary);
    }

    public static Complex mult(Complex a, Complex b) {
        double real = (a.r * b.r) - (a.i * b.i);
        double imaginary = (a.r * b.i) + (a.i * b.r);
        return new Complex(real, imaginary);
    }

    public static Complex subtract(Complex a, Complex b) {
        double real = a.r - b.r;
        double imaginary  = a.i - b.i;
        return new Complex(real, imaginary);
    }

    public static Complex add(Complex a, Complex b) {
        Complex temp = new Complex(0,0);
        temp.r = a.r + b.r;
        temp.i = a.i + b.i;
        return temp;
    }

    public static double abs(Complex a) {
        return Math.hypot(a.r,a.i);
    }
}

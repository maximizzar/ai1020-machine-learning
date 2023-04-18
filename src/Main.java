package week16;
public class Main {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new double[] { 1., 1., 1. }));
    }
    public double sumOfSquares(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * x[i];
        }
        return sum;
    }
}
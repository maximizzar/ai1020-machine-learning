import java.util.Arrays;

public class Week16 {
    private Integer task = 1;
    public void test() {
        printHeading();
        System.out.println(sumOfSquares(new double[] {}));
        System.out.println(sumOfSquares(new double[] { 1., 1., 1. }));
        System.out.println(sumOfSquares(new double[] { 1., 2., 3. }));
        System.out.println(sumOfSquares(new double[] { -3.0, -3.0 }));
        System.out.println(sumOfSquares(new double[] { 1., 2., 3. }));

        printHeading();
        System.out.println(sumOfColOne(new double[][] {}));
        System.out.println(sumOfColOne(new double[][] { { 1., 1., 1. }, { 2., 2., 2. }, { 3., 3., 3. } }));
        System.out.println(sumOfColOne(new double[][] { { 1., 2. }, { 1., 2. }, { 1., 2. } }));
        System.out.println(sumOfColOne(new double[][] { { -3.0, 1.0, 2.0, 3.0 } }));
        System.out.println(sumOfColOne(new double[][] { { 1., 2. }, { 1., 0. } }));
        System.out.println(sumOfColOne(new double[][] { { -5., 0. }, { -1., 1. }, { -2., 2. } }));

        printHeading();
        System.out.println(sumOfRow2(new double[][] {}));
        System.out.println(sumOfRow2(new double[][] { { 1., 1., 1. }, { 2., 2., 2. }, { 3., 3., 3. } }));

        printHeading();
        System.out.println(sumOfMatrix(new double[][] {}));
        System.out.println(sumOfMatrix(new double[][] { { 1., 1., 1. }, { 2., 2., 2. }, { 3., 3., 3. } }));

        printHeading();

        printHeading();

        printHeading();

        printHeading();
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] {}, new double[] { 1.0, 0.0 })));
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 1. }, { 2., 2. }, { 3., 3. } }, new double[] { 1.0, 0.0 })));
    }
    public double sumOfSquares(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value * value;
        }
        return sum;
    }
    public double sumOfColOne(double[][] array2d) {
        if(array2d.length < 1) return 0.0;
        double sumOfColumOne = 0;

        for (double[] array : array2d) {
            sumOfColumOne += array[1];
        }
        return sumOfColumOne;
    }
    public double sumOfRow2(double[][] array2d) {
        if(array2d.length < 1) return 0.0;
        double sumOfRow2 = 0.0;

        for (double value : array2d[1]) {
            sumOfRow2 += value;

        }
        return sumOfRow2;
    }
    public double sumOfMatrix(double[][] array2d) {
        if (array2d.length < 1) return 0.0;
        double sumOfMatrix = 0.0;

        for (double[] array : array2d) {
            for (double value : array) {
                sumOfMatrix += value;
            }
        }
        return sumOfMatrix;
    }
    public double[][] modelExample(double[][] array2d){
        double[][] modelExample = new double[array2d.length][1];
        for (int index = 0; index < array2d.length; index++) {
            array2d[index][0] = 1;
        }
        return array2d;
    }

    public double[][] linearClassifier(double[][] array2dX, double[] array2dW) {
        return array2dX;
    }

    /*
        extracted functions
     */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

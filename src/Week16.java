import java.util.Arrays;

public class Week16 {
    private Integer task = 1;
    public double sumOfSquares(double[] array) {
        double sum = 0.0;
        for (double value : array)
            sum += value * value;
        return sum;
    }
    public double sumOfColOne(double[][] array2d) {
        if(array2d.length < 1) return 0.0;
        double sumOfColumOne = 0.0;

        for (double[] array : array2d)
            sumOfColumOne += array[1];
        return sumOfColumOne;
    }
    public double sumOfRow2(double[][] array2d) {
        if(array2d.length <= 1) return 0.0;
        if(array2d[1].length < 1) return 0.0;
        double sumOfRow2 = 0.0;

        for (double value : array2d[1])
            sumOfRow2 += value;
        return sumOfRow2;
    }
    public double sumOfMatrix(double[][] array2d) {
        if (array2d.length < 1) return 0.0;
        double sumOfMatrix = 0.0;

        for (double[] array : array2d) {
            for (double value : array)
                sumOfMatrix += value;
        }
        return sumOfMatrix;
    }
    public double[][] firstInSubarray(double[][] array2d){
        double[][] firstInSubarray = new double[array2d.length][1];

        for (int index = 0; index < array2d.length; index++)
            firstInSubarray[index][0] = array2d[index][0];
        return firstInSubarray;
    }
    public double[][] sumOfSubarray(double[][] array2d) {
        double[][] sumOfSubarray = new double[array2d.length][1];

        for (int array2dIndex = 0; array2dIndex < array2d.length; array2dIndex++) {
            for (double value : array2d[array2dIndex])
                sumOfSubarray[array2dIndex][0] += value;
        }
        return sumOfSubarray;
    }
    public double[][] sumOfRow(double[][] array2d) {
        double[][] sumOfRow = new double[1][array2d[0].length];

        for (double[] array : array2d) {
            for (int rowIndex = 0; rowIndex < array2d[0].length; rowIndex++)
                sumOfRow[0][rowIndex] += array[rowIndex];
        }
        return sumOfRow;
    }
    public double[][] linearClassifier(double[][] array2dX, double[] array2dW) {
        if (array2dX.length < 1) return array2dX;
        double[][] linearClassifier = new double[array2dX.length][1];

        for (int colum = 0; colum < array2dX.length; colum++) {
            for (int row = 0; row < array2dX[0].length; row++)
                linearClassifier[colum][0] += array2dX[colum][row] * array2dW[row];
        }
        return linearClassifier;
    }
    public void test() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    /*
        extracted functions
    */

    private void test8() {
        printHeading();
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] {}, new double[] { 1.0, 0.0 })));
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 1. }, { 2., 2. }, { 3., 3. } }, new double[] { 1.0, 0.0 })));
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 2. }, { 1., 2. }, { 1., 2. } }, new double[] { 1.0, 0.0 })));
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { -3.0, 1.0 } }, new double[] { 1.0, 0.0 })));
        System.out.println(Arrays.deepToString(linearClassifier(new double[][] { { 1., 2. }, { 1., 0. } }, new double[] { 1.0, 1.0 })));
    }
    private void test7() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{{1.0}},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}},
                new double[][]{{-5., 0.}, {-1., 1.}, {-2., 2.}})) {
            System.out.println(Arrays.deepToString(sumOfRow(doubles)));
        }
    }
    private void test6() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}})) {
            System.out.println(Arrays.deepToString(sumOfSubarray(doubles)));
        }
    }
    private void test5() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}},
                new double[][]{{-5., 0.}, {-1., 1.}, {-2., 2.}})) {
            System.out.println(Arrays.deepToString(firstInSubarray(doubles)));
        }
    }
    private void test4() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}})) {
            System.out.println(sumOfMatrix(doubles));
        }
    }
    private void test3() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}})) {
            System.out.println(sumOfRow2(doubles));
        }
    }
    private void test2() {
        printHeading();
        for (double[][] doubles : Arrays.asList(
                new double[][]{},
                new double[][]{{1., 1., 1.}, {2., 2., 2.}, {3., 3., 3.}},
                new double[][]{{1., 2.}, {1., 2.}, {1., 2.}},
                new double[][]{{-3.0, 1.0, 2.0, 3.0}},
                new double[][]{{1., 2.}, {1., 0.}},
                new double[][]{{-5., 0.}, {-1., 1.}, {-2., 2.}})) {
            System.out.println(sumOfColOne(doubles));
        }
    }
    private void test1() {
        printHeading();
        for (double[] doubles : Arrays.asList(
                new double[]{},
                new double[]{1., 1., 1.},
                new double[]{1., 2., 3.},
                new double[]{-3.0, -3.0},
                new double[]{1., 2., 3.})) {
            System.out.println(sumOfSquares(doubles));
        }
    }
    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

public class Week18 {
    private Integer task = 1;

    public double[] matMul1(double[][] matrix, double[] vector) { //task 1
        if (matrix[0].length != vector.length) return null;
        double[] resultVector = new double[matrix.length];

        for (int colum = 0; colum < matrix.length; colum++) {
            for (int row = 0; row < matrix[colum].length; row++)
                resultVector[colum] += vector[row] * matrix[colum][row];
        }
        return resultVector;
    }
    public double[][] matMul(double[][] matrix, double[][] vector)  { //task 2
        if (matrix[0].length != vector.length) return null;

        int matrixSubLength = matrix[0].length;
        int vectorSubLength = vector[0].length;
        double[][] resultVector = new double[matrix.length][vectorSubLength];

        for (int colum = 0; colum < matrix.length; colum++) {
            for (int row = 0; row < vectorSubLength; row++) {
                resultVector[colum][row] = 0;
                for (int k = 0; k < matrixSubLength; k++)
                    resultVector[colum][row] += matrix[colum][k] * vector[k][row];
            }
        }
        return resultVector;
    }
    public double[] toOneHot(int position, int length) { //task 3
        double[] array = new double[length];
        array[position] = 1.0;
        return array;
    }
    public double[] sm(double[] array) { //task 4
        double[] sm = new double[array.length];
        double temp = 0;

        for (int i = 0; i < array.length; i++) {
            for (double v : array) {
                temp += Math.exp(v);
            }
            sm[i] = Math.exp(array[i]) / temp;
            temp = 0;
        }
        return sm;
    }

    public void test() {
        test1();
        test2();
        test3();
        test4();

    }

    /*
        extracted functions
    */

    private void test4() {
        printHeading();
        double[] T1 = new double[] { 10., 10. };
        System.out.println(java.util.Arrays.toString(sm(T1)));
        double[] T2 = new double[] { -10., -10. };
        System.out.println(java.util.Arrays.toString(sm(T2)));
    }
    private void test3() {
        printHeading();
        System.out.println(java.util.Arrays.toString(toOneHot(1, 2)));
        System.out.println(java.util.Arrays.toString(toOneHot(0, 2)));
        System.out.println(java.util.Arrays.toString(toOneHot(3, 4)));
    }
    private void test2() {
        printHeading();
        double[][] W1 = new double[][] { { 1., 1. }, { 1., 1. } };
        System.out.println(java.util.Arrays.deepToString(matMul(new double[][] { { 2., 2. } }, W1)));
        double[][] W2 = new double[][] { { 1., 1. }, { 1., 1. } };
        System.out.println(java.util.Arrays.deepToString(matMul(new double[][] { { 2., 2., 2. } }, W2)));
    }
    private void test1() {
        printHeading();
        double[][] w1_1 = new double[][] { { 1., 1. }, { 1., 1. } };
        System.out.println(java.util.Arrays.toString(matMul1(w1_1, new double[] { 2., 2. })));
        double[][] w1_2 = new double[][] { { 1., 1. }, { 1., 1. } };
        System.out.println(java.util.Arrays.toString(matMul1(w1_2, new double[] { 2., 2., 2. })));
        double[][] w1_3 = new double[][] { { -1., 0. }, { -1., 0. } };
        System.out.println(java.util.Arrays.toString(matMul1(w1_3, new double[] { 2., 2. })));
        double[][] w1_4 = new double[][] { { -1., 0. }, { -1., 1. } };
        System.out.println(java.util.Arrays.toString(matMul1(w1_4, new double[] { 2., 2. })));
        double[][] w1_5 = new double[][] { { -1., 0. }, { -1., 1. }, { 1., 0. } };
        System.out.println(java.util.Arrays.toString(matMul1(w1_5, new double[] { 2., 2. })));
    }
    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

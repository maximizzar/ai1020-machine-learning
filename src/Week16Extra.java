import java.util.Arrays;

public class Week16Extra {
    private Integer task = 1;

    public double[] matrixSumProd(double[][] matrix) {
        double[] matrixSumProd = new double[matrix.length];

        for (int colum = 0; colum < matrix.length; colum++) {
            for (int row = 0; row < matrix[0].length; row++) {
                matrix[colum][0] *= matrix[colum][row];
            }
        }
        return matrix[0];
    }

    public void test() {
        printHeading();
        System.out.println(Arrays.toString(matrixSumProd(new double[][]{{0, 1, -2}, {3, -4, 5}, {-6, 7, -8}, {9, -10, 11}})));
        System.out.println(Arrays.toString(matrixSumProd(new double[][]{{0, -1, 2}, {-3, 4, -5}, {6, -7, 8}, {-9, 10, -11}})));
        System.out.println(Arrays.toString(matrixSumProd(new double[][]{{-2, -1, 0}, {-1, 0, 1}, {0, 1, 2}})));
        System.out.println(Arrays.toString(matrixSumProd(new double[][]{{-9, -4, -6}, {-1, -5, -3}, {-7, -2, -9}, {-8, -3, -4}})));
        System.out.println(Arrays.toString(matrixSumProd(new double[][]{{9, 4, 6}, {1, 5, 3}, {7, 2, 9}, {8, 3, 4}})));
    }

    /*
        extracted functions
     */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

public class Week16Extra {
    private Integer task = 1;

    public double matrixSumProd(double[][] matrix) {
        double matrixProd = 1;
        double matrixProdSum = 0;

        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                matrixProd *= aDouble;
            }
            matrixProdSum += matrixProd;
        }

        return matrixProdSum;
    }

    public void test() {
        printHeading();
        System.out.println(matrixSumProd(new double[][]{
                {0, 1, -2},
                {3, -4, 5},
                {-6, 7, -8},
                {9, -10, 11}})); // 1160
        System.out.println(matrixSumProd(new double[][]{{0, -1, 2}, {-3, 4, -5}, {6, -7, 8}, {-9, 10, -11}}));
        System.out.println(matrixSumProd(new double[][]{{-2, -1, 0}, {-1, 0, 1}, {0, 1, 2}}));
        System.out.println(matrixSumProd(new double[][]{{-9, -4, -6}, {-1, -5, -3}, {-7, -2, -9}, {-8, -3, -4}}));
        System.out.println(matrixSumProd(new double[][]{{9, 4, 6}, {1, 5, 3}, {7, 2, 9}, {8, 3, 4}}));
    }

    /*
        extracted functions
     */

    private void printHeading() {
        System.out.println("\n<> test task+: " + this.task++);
    }
}

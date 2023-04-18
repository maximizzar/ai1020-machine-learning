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
        //System.out.println(sumOfColOne(new double[][] {}));
        System.out.println(sumOfColOne(new double[][] { { 1., 1., 1. }, { 2., 2., 2. }, { 3., 3., 3. } }));
        System.out.println(sumOfColOne(new double[][] { { 1., 2. }, { 1., 2. }, { 1., 2. } }));
        System.out.println(sumOfColOne(new double[][] { { -3.0, 1.0, 2.0, 3.0 } }));

    }

    public double sumOfSquares(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value * value;
        }
        return sum;
    }

    public double sumOfColOne(double[][] array2d) {
        //if(array2d.length > 1 && array2d[0].length > 1) return 0.0;

        double sumOfColumOne = 0;
        return 1;
    }

    /*
        extracted functions
     */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

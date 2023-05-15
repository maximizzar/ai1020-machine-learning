public class Week20 {
    private Integer task = 1;

    public double[] gradf1(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
        return array;
    }
    public double[] gradf2(double[] ignoredX) {
        return new double[] {5,2};
    }
    public double[] gradf(double[] array) {
        java.util.Arrays.setAll(array, i -> Math.pow(array[i], 3) * 3);
        return array;
    }
    public void test() {
        printHeading();
        double[] ret = gradf1(new double[] { 0., 0. });
        System.out.printf("%.02f %.02f\n", ret[0], ret[1]);

        printHeading();
        double[] ret2 = gradf2(new double[] { 5., 2. });
        System.out.printf("%.02f %.02f\n", ret2[0], ret2[1]);

        printHeading();
        double[] ret3 = gradf(new double[] { 0., 0., 0. });
        System.out.printf("%.02f %.02f %.02f\n", ret3[0], ret3[1], ret3[2]);
    }

    /*
        extracted functions
    */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

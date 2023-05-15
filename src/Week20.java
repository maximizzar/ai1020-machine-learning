public class Week20 {
    private Integer task = 1;

    public double[] gradf(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 2 * array[i];
        }
        return array;
    }
    public void test() {
        printHeading();
        double[] ret = gradf(new double[] { 0., 0. });
        System.out.printf("%.02f %.02f\n", ret[0], ret[1]);
    }

    /*
        extracted functions
    */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

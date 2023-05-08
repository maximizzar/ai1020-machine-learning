public class Week19 {
    private Integer task = 1;
    public double cosinusSteigung(double x, double eps) {
        return 2*x + eps;
    }
    public void test() {
        printHeading();
        System.out.printf("%.04f\n", cosinusSteigung(0, 1));
        System.out.printf("%.04f\n", cosinusSteigung(0, 0.5));
        System.out.printf("%.04f\n", cosinusSteigung(0, 0.1));
    }

    /*
        extracted functions
    */
    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

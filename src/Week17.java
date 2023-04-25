public class Week17 {
    private Integer task = 1;

    public double[] f(double[] ignoredX) { // task 1
        double[] f = new double[3];
        f[0] = 1.0;
        return f;
    }
    public double[] f2(double[] array) { //task 2
        double[] f = new double[3];
        if(array[0] < 0) {
            f[0] = 1.0;
            return f;
        }
        f[1] = 1.0;
        return f;
    }
    public double[] fVecVec(double[] ignoredX) { // task 3
        return new double[] { 1., 0. };
    }
    double[][] f(double[][] x) {
        double[][] f = new double[x.length][];

        for (int index = 0; index < x.length; index++) {
            f[index] = fVecVec(x[index]);
        }

        return f;
    }
    public double classAccuracy(double[][] Y, double[][] T) { //task 4
        double accurate = 0, classAccuracy = 0;

        for (int colum = 0; colum < Y.length; colum++) {
            for (int row = 0; row < Y[colum].length; row++) {

                if(T[colum][row] == 1.0 && Y[colum][row] >= 0.5) accurate++;
            }
            classAccuracy += accurate / T[colum].length;
            accurate = 0;
        }
        return classAccuracy;
    }
    public void test() {
        printHeading();
        printArray(f(new double[] { 0.0, 1.0 }));
        printArray(f(new double[] { 0.0, 0.0 }));
        printArray(f(new double[] { 2.0, 0.0 }));
        printArray(f(new double[] { 2.0, 2.0 }));

        printHeading();
        printArray(f2(new double[] { -1.0, 1.0 }));
        printArray(f2(new double[] { -10.0, 0.0 }));
        printArray(f2(new double[] { 2.0, 0.0 }));
        printArray(f2(new double[] { 10.0, 20.0 }));

        printHeading();
        print2DArray(f(new double[][] { { -1.0 } }));
        print2DArray(f(new double[][] { { -10.0 }, { 0.0 } }));
        print2DArray(f(new double[][] { { -1.0 }, { 1.0 }, { 1.0 } }));

        printHeading();
        double[][] T1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
        System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0., 0.6 }, { 0., 0.9, 0.1 } }, T1));
        double[][] T2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
        System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1, 0. }, { 0.4, 0., 0.6, 0. }, { 0., 0.9, 0.1, 0. } }, T2));
    }

    /*
        extracted functions
    */

    void printArray(double[] x) {
        if (x.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + ",");
        }
        System.out.println(x[x.length - 1] + "]");
    }
    void print2DArray(double[][] array2D) {
        System.out.print("[");
        for (double[] array : array2D) {
            if (array.length == 0) {
                System.out.print("[]");
                continue;
            }
            System.out.print("[");
            for (int j = 0; j < array.length - 1; j++) System.out.print(array[j] + ",");
            System.out.print(array[array.length - 1] + "]");
        }
        System.out.println("]");
    }
    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

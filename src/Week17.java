public class Week17 {
    private Integer task = 1;

    public double[] f(double[] ignoredX) {
        double[] f = new double[3];
        f[0] = 1.0;
        return f;
    }
    public double[] f2(double[] array) {
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
    public double classAccuracy(double[][] array, double[][] target) { //task 4
        int numCorrect = 0, numTotal = 0, rowLength = array.length;

        for (int row = 0; row < rowLength; row++) {
            int maxIndex = 0;
            double maxValue = array[row][0];

            for (int colum = 1; colum < array[row].length; colum++) {
                if (array[row][colum] > maxValue) {
                    maxIndex = colum;
                    maxValue = array[row][colum];
                }
            }
            if (target[row][maxIndex] == 1.0) numCorrect++;
            numTotal++;
        }
        return (double) numCorrect / numTotal;
    }
    public double classError(double[][] array, double[][] target) { //task 5
        int numErrors = 0,
                numExamples = array.length, numClasses = array[0].length;

        for (int row = 0; row < numExamples; row++) {
            int trueClass = 0, predClass = 0;
            double trueMax = 0, predMax = 0;

            for (int colum = 0; colum < numClasses; colum++) {
                if (target[row][colum] > trueMax) {
                    trueMax = target[row][colum];
                    trueClass = colum;
                }
                if (array[row][colum] > predMax) {
                    predMax = array[row][colum];
                    predClass = colum;
                }
            }
            if (predClass != trueClass) numErrors++;
        }
        return (double) numErrors / numExamples;
    }
    public double crossEntropy(double[][] array, double[][] traget) {  //task 6
        int lengthRows = array.length, lengthCols = array[0].length;
        double res = 0;

        for (int row = 0; row < lengthRows; row++) {
            for (int colum = 0; colum < lengthCols; colum++)
                res += traget[row][colum] * Math.log(array[row][colum]);
        }
        return (-res/(double)lengthRows);
    }
    public double mse(double[][] array, double[][] target) { //task 7
        int rowLength = array.length, columLength = array[0].length;
        double diff, sum = 0, temp = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int colum = 0; colum < columLength; colum++) {
                diff = array[row][colum] - target[row][colum];
                temp += diff * diff;
            }
            sum += temp;
            temp = 0;
        }
        return sum / rowLength;
    }
    public double rmse(double[][] array, double[][] target) { //task 8
        int rowLength = array.length, columLength = array[0].length;
        double diff, sum = 0, temp = 0;
        
        for (int row = 0; row < rowLength; row++) {
            for (int colum = 0; colum < columLength; colum++) {
                diff = array[row][colum] - target[row][colum];
                temp += diff * diff;
            }
            sum += Math.sqrt(temp);
            temp = 0;
        }
        return sum / rowLength;
    }

    public void test() {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }

    /*
        extracted functions
    */

    private void task8() {
        printHeading();
        double[][] T4_1 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
        System.out.println(rmse(new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T4_1));
        double[][] T4_2 = new double[][] { { 1., 0.5, 0. }, { 2., 0., 0. }, { 0., 0., 0.5 } };
        System.out.println(rmse(new double[][] { { 1., 0.5, 0. }, { 0., 0., 0. }, { 0., 0., 0.5 } }, T4_2));
        double[][] T4_5 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
        System.out.println(rmse(new double[][] { { 7., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T4_5));
    }
    private void task7() {
        printHeading();
        double[][] T3_1 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
        System.out.println(mse(new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T3_1));
        double[][] T3_2 = new double[][] { { 1., 1., 0.5, 0. }, { 1., 1., 1., 1. }, { 1., 0., 0., 0.5 } };
        System.out.println(mse(new double[][] { { 1., 1., 0.5, 0. }, { 1., 1., 1., 1. }, { 1., 0., 0., 0.5 } }, T3_2));
        double[][] T3_5 = new double[][] { { 1., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } };
        System.out.println(mse(new double[][] { { 7., 0.5, 0. }, { 1., 1., 1. }, { 0., 0., 0.5 } }, T3_5));
    }
    private void task6() {
        printHeading();
        double[][] T2_1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
        System.out.println(crossEntropy(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0.1, 0.5 }, { 0.1, 0.8, 0.1 } }, T2_1));
        double[][] T2_2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
        System.out.println(crossEntropy(new double[][] { { 1., 0.01, 0.01, 0.01 }, { 0.01, 0.01, 1., 0.01 }, { 0.01, 1., 0.01, 0.01 } }, T2_2));
        double[][] T2_3 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
        System.out.println(crossEntropy(new double[][] { { 0.4, 0.5, 0.05, 0.05 }, { 0.1, 0.3, 0.4, 0.2 }, { 0.05, 0.45, 0.4, 0.1 } }, T2_3));
    }
    private void task5() {
        printHeading();
        double[][] T1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
        System.out.println(classError(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0., 0.6 }, { 0., 0.9, 0.1 } }, T1));
        double[][] T2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
        System.out.println(classError(new double[][] { { 0.5, 0.4, 0.1, 0. }, { 0.4, 0., 0.6, 0. }, { 0., 0.9, 0.1, 0. } }, T2));
    }
    private void task4() {
        printHeading();
        double[][] T1_1 = new double[][] { { 1., 0., 0. }, { 0., 0., 1. }, { 0., 1., 0. } };
        System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1 }, { 0.4, 0., 0.6 }, { 0., 0.9, 0.1 } }, T1_1));
        double[][] T1_2 = new double[][] { { 1., 0., 0., 0. }, { 0., 0., 1., 0. }, { 0., 1., 0., 0. } };
        System.out.println(classAccuracy(new double[][] { { 0.5, 0.4, 0.1, 0. }, { 0.4, 0., 0.6, 0. }, { 0., 0.9, 0.1, 0. } }, T1_2));
    }
    private void task3() {
        printHeading();
        print2DArray(f(new double[][] { { -1.0 } }));
        print2DArray(f(new double[][] { { -10.0 }, { 0.0 } }));
        print2DArray(f(new double[][] { { -1.0 }, { 1.0 }, { 1.0 } }));
    }
    private void task2() {
        printHeading();
        printArray(f2(new double[] { -1.0, 1.0 }));
        printArray(f2(new double[] { -10.0, 0.0 }));
        printArray(f2(new double[] { 2.0, 0.0 }));
        printArray(f2(new double[] { 10.0, 20.0 }));
    }
    private void task1() {
        printHeading();
        printArray(f(new double[] { 0.0, 1.0 }));
        printArray(f(new double[] { 0.0, 0.0 }));
        printArray(f(new double[] { 2.0, 0.0 }));
        printArray(f(new double[] { 2.0, 2.0 }));
    }
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
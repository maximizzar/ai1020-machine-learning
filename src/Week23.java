import java.util.Arrays;

public class Week23 {
    private Integer task = 1;

    public double[] relu(double[] a) { //Task 1
        for (int i = 0; i < a.length; i++) {
            if(a[i] < 0.0) a[i] = 0.0;
        }
        return a;
    }
    public double[][] ReLU(double[][] X) { //Task 2
        for (int i = 0; i < X.length; i++) {
            for(int j = 0; j < X[i].length; j++) {
                if(X[i][j]< 0.0) X[i][j] = 0.0;
            }
        }
        return X;
    }
    public double[][] sigmoid(double[][] A)  {
        double[][] sigmoid = new double[A.length][A[0].length] ;

        for (int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                sigmoid[i][j] = 1 / (1 +  Math.exp(-A[i][j]));
            }
        }
        return sigmoid ;
    }
    public double[][] sm(double[][] array) { //Task 4
        double[][] sm = new double[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            double temp = 0;

            for (int j = 0; j < array[i].length; j++) {
                for (double v : array[i]) {
                    temp += Math.exp(v);
                }
                sm[i][j] = Math.exp(array[i][j]) / temp;
                temp = 0;
            }
        }
        return sm;
    }
    public double[] affin(double [][] W, double[] b, double[] x) {
        double[] ans = new double[b.length];

        for (int i = 0; i < 2; i++) {
            ans[i] = W[i][0] * x[0] + W[i][1] * x[1]; // Vektor W * Vektor X
            ans[i] = ans[i] + b[i]; // Ergebnisvektor + b
        }
        return ans;
    }

    public void test() {
        printHeading();
        double[] a1 = new double[] { -1, -2, -10, 100 };
        System.out.println(java.util.Arrays.toString(relu(a1)));
        double[] a2 = new double[] { 1.0, 2.0, 3.0, 0.0 };
        System.out.println(java.util.Arrays.toString(relu(a2)));
        double[] a3 = new double[] {};
        System.out.println(java.util.Arrays.toString(relu(a3)));

        printHeading();
        double[][] ret = ReLU(new double[][] { { -1.0, -1.0 } });
        System.out.println(Arrays.deepToString(ret));

        printHeading();
        double[][] A1 = new double[][] {{ -1, -2}, {-10, 100} };
        System.out.println(java.util.Arrays.deepToString(sigmoid(A1)));
        double[][] A2 = new double[][] {{ 11, -2}, {-20, 100} };
        System.out.println(java.util.Arrays.deepToString(sigmoid(A2)));
        double[][] A3 = new double[][] {{ -1, -2} };
        System.out.println(java.util.Arrays.deepToString(sigmoid(A3)));

        printHeading();
        double[][] T1 = new double[][] { {10., 10.} };
        System.out.println(java.util.Arrays.deepToString(sm(T1)));
        double[][] T2 = new double[][] { {10., 10.}, {1., 0.} };
        System.out.println(java.util.Arrays.deepToString(sm(T2)));

        printHeading();
        double [][] W1 ={{1., 0.},{1., 1.}} ;
        double [] b1 = {0., 1} ;
        double[] x1 = {5., 5.} ;
        double []y1 = affin(W1,b1,x1) ;
        System.out.println((int)y1[0] + " " + (int)y1[1]) ;
        double [][] W2 ={{1., 1.},{0., 1.}} ;
        double [] b2 = {0., -1} ;
        double[] x2 = {5., 5.} ;
        double []y2 = affin(W2,b2,x2) ;
        System.out.println((int)y2[0] + " " + (int)y2[1]) ;
    }


    /*
        extracted functions
    */

    private void printHeading() {
        System.out.println("\n<> test task: " + this.task++);
    }
}

package org.example;

import java.util.Scanner;

public class Main {
    public static int getFactorial(int num) {
        int out = 1;
        for (int i = 1; i <= num; i++) {
            out *= i;
        }
        return out;
    }

    public static double getModule(double[][] matrix) {
        double out = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i - 1; j++) {
                out += Math.abs(matrix[i][j]);
            }
        }
        return out;
    }

    public static void toMatrix(double[][] matrix) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
    }

    public static void result(double a, double b, double c) {
        double d = b * 2 - (4 * a * c);
        double x1, x2;
        if (d > 0) {
            x1 = (b * (-1) + Math.sqrt(d)) / a * 2;
            x2 = (b * (-1) - Math.sqrt(d)) / a * 2;
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
        } else if (d == 0) {
            x1 = b * (-1) / 2 * a;
            System.out.println("x = " + x1);
        } else System.out.println("There are no roots for the equation with your data");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] dm, t, l;
        double a, b, c, d, k, m;
        int ax, bx, cx;
        dm = new double[4][4];
        t = new double[5][5];
        l = new double[6][6];
        System.out.println("1. Analyze\n2. Calculate");
        ax = in.nextInt();
        switch (ax) {
            case 2 -> {
                System.out.println("Welcome to the arithmetic expression calculator\n(a/b)!x^2 + 2(c/d)!x + (k/m)! = 0");
                System.out.println("Enter the matrix d:");
                toMatrix(dm);
                System.out.println("Enter the matrix t:");
                toMatrix(t);
                System.out.println("Enter the matrix l:");
                toMatrix(l);
                a = (double) getFactorial(dm.length - 1);
                b = getModule(dm);
                c = (double) getFactorial(t.length - 1);
                d = getModule(t);
                k = (double) getFactorial(l.length - 1);
                m = getModule(l);
                ax = getFactorial((int) (a / b));
                bx = getFactorial((int) (c / d));
                cx = getFactorial((int) (k / m));
                result((double) ax, (double) bx, (double) cx);
            }
            case 1 -> Analyzer.analyze();
        }
    }
}
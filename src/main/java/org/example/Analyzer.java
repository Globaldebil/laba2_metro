package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Analyzer {
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static void analyze(){
        StringBuilder str = new StringBuilder();
        String[] operator = new String[] {"import", " int ", "double ", "System.out.println", ";", " + ", " - ", " = ", " / ","length",
                "Math.sqrt","Math.abs","++"," += "," *= ","for","System.in","public","static","void","return","toMatrix","result",
                "getFactorial","getModule","main","String","<",">","<=","class","nextDouble", "package"};

        String[] operand = new String[] {"Welcome to the arithmetic expression calculator\\n(a/b)!x^2 + 2(c/d)!x + (k/m)! = 0",
                "Enter the matrix d:", "Enter the matrix t:", "Enter the matrix l:",
                " dm ", " t ", " l "," a ",
                " b "," c "," d "," k "," m "," ax "," bx ","in"," matrix "," cx "," out "," x1 "," x2 ",
                "There are no roots for the equation with your data","getModule",
                " i "," j "," x1 = "," x2 = "," x = ","java.util.Scanner","org.example", "Main"};
        File file = new File("D:\\Programming\\Java\\laba2_metro\\src\\main\\java\\org\\example\\Main.java");
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()){
                str.append(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("=============Operands==================");
        for (String s : operand) System.out.println(s + " => " + count(str.toString(), s));
        System.out.println("==============Operators=================");
        for (String s : operator) System.out.println(s + " => " + count(str.toString(), s));
    }
}

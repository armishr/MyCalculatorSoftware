package main_pckg;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

// Steps in a calculator 1.Read Data 2.Separate Data to integer and operators 3.Do stack ops
//Right now assuming input has no mathematical evaluating errors
public class Main {

    final static char operators[] = {'/', '*', '+', '-'};
    final static char numberList[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    static Scanner scanner;


    public static Integer charToInt(char c) {

        for (int i = 0; i < numberList.length; i++) {
            if (numberList[i] == c) {
                return ((i + 1) % 10);
            }
        }

        return -1;


    }


    public static String readExpression() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static Integer stringConv(ArrayList<Character> numb) {
        int result = 0;

        for (int i = 0; i < numb.size(); i++) {
            result += charToInt(numb.get(numb.size() - i - 1)) * (int) (pow(10, i));

        }

        return result;

    }


    public static ArrayList<Integer> getInter(String expr) {
        ArrayList<Integer> numArr = new ArrayList<>();
        ArrayList<Integer> opArr = new ArrayList<>();

        ArrayList<Character> a1 = new ArrayList<>();//acts as container to get the number

        ArrayList<Integer> resultArr = new ArrayList<>();


        for (int i = 0; i < expr.length(); i++) {
            boolean isOp = false;

            //checking if operator
            for (int opI = 0; opI < operators.length; opI++) {
                if (expr.charAt(i) == operators[opI]) {
                    opArr.add(opI + 1);
                    numArr.add(stringConv(a1)); //stringCon is a method which will convert string to int
                    a1.clear();
                    isOp = true;
                    break;

                }


            }
            //adding digits
            if (!isOp) {
                a1.add(expr.charAt(i));
            }

        }
        System.out.println(a1);
        numArr.add(stringConv(a1));
        a1.clear();

        resultArr.add(opArr.size() + 1); //index when number array will start
        resultArr.addAll(opArr);
        resultArr.addAll(numArr);


        return resultArr;


    }

    //calculating final number

    //Version 1.0 :Doesnt apply bodmas rule; just does calculation from left to right
    public static Integer calc(ArrayList<Integer>intExpr){
        int finalAns=0;
        int numbIndBig=intExpr.get(0);


        return finalAns;
    }
    /* main app*/
    public static void calculatorApp() {
        String expression = readExpression();
        //if want to exit
        if (expression.equals("exit")) {
            System.out.println("Program closing");
            System.exit(0);
        }

        //converting user data to string

        ArrayList<Integer> intermediateArray = getInter(expression);
        /*
        generating the arraylist for calculation;will have operator and number stack in same arraylist ;will have 3 main things :
            1.Index of the array when number list begins from
            2.The operator list
            3.The number list
            */

        Integer result=calc(intermediateArray);
        //simply gives final result using the arraylist

        System.out.println(intermediateArray);

    }


    public static void main(String[] args) {

        System.out.println("Welcome to the calculator program.Enter your expressions...");

        while (true) {
            calculatorApp();
        }

    }
}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //prompt to get x and y variables:
        System.out.println("Create a cartesian grid");

        System.out.println("Enter the value for x");
        System.out.print("x = ");
        int x = scnr.nextInt();

        System.out.println("Enter the value for y");
        System.out.print("y = ");
        int y = scnr.nextInt();

        //using the variables to make a CartesianGrid object and print it

        CartesianGrid matrix = new CartesianGrid(x, y);
        String[][] multiArray = matrix.gridMaker();
        matrix.gridPrinter(multiArray);
    }
}

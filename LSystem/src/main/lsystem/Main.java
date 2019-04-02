package lsystem;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String axiom = "0";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        StringCreator lsys = new StringCreator(axiom, productionRules);

        System.out.print("String representation for binary tree for i iterations.\n i: ");
        int i = Integer.valueOf(scanner.nextLine());

        System.out.println(lsys);

        for (int j = 1; j <= i; j++) {
            System.out.println("Iteration "+ j +": \t"+lsys.iterator(j));
        }
    }
}

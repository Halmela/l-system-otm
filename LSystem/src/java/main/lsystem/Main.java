package lsystem;

import lsystem.ui.Screen;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

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
        }*/

        /*HashMap<String, String[]> allRules = new HashMap<>();

        String[] z = new String[3];
        z[0] = "1[0]0";
        z[1] = "forward";
        z[2] = "end";
        String[] o = new String[2];
        o[0] = "11";
        o[1] = "forward";
        allRules.put("0", z);
        allRules.put("1", o);

        int height = 1000;
        int width = 1000;
        double angle = 60;

        Vector vec = new Vector(width / 2, height, Math.toRadians(angle), 0);

        Overlord overi = new Overlord("0", allRules, 2, vec);*/
        Screen naytto = new Screen();


    }
}

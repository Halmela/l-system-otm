package com.mycompany.lsystem;


import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String axiom = "0";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        LSystem lsys = new LSystem(axiom, productionRules);

        System.out.println(lsys);
    }
}

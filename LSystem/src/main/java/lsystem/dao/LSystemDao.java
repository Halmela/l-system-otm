package lsystem.dao;

import lsystem.domain.LSystem;
import lsystem.domain.Vector;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;


public class LSystemDao {
    private String file;
    private ArrayList<LSystem> lSystems;
    private Scanner scanner;

    public LSystemDao(String file) throws Exception {
        this.lSystems = new ArrayList();
        this.file = file;
        try {
            System.out.println("olen dao");
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()){
                lSystems.add(parse(scanner.nextLine()));
            }
            System.out.println("dd" + lSystems.toString());
        } catch (Exception e) {
            System.out.println("dao-virhe: " + e.getMessage() + "");
            //FileWriter writer = new FileWriter(new File(file));
            //writer.close();
        }
    }


    public LSystem parse(String line){
        String[] parts = line.split(";");

        String axiom = parts[0];
        int iterations = Integer.parseInt(parts[1]);
        Vector vec = new Vector(Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Math.toRadians(Double.parseDouble(parts[4])), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));

        HashMap<String, String[]> ruleset = new HashMap<>();
        for (String s : parts[7].split(":")) {
            String[] pr = s.split(",");
            
            String ax = pr[0];
            String[] rules = new String[pr.length - 1];

            for (int i = 1; i < pr.length; i++) {
                rules[i - 1] = pr[i];
            }
            ruleset.put(ax, rules);
        }

        return new LSystem(axiom, ruleset, vec, iterations);
    }


    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (LSystem lsys : lSystems) {
                writer.write(lsys.getAxiom() + ";" +
                             lsys.getIterations() + ";" + 
                             lsys.getStartVec().getStartX() + ";" +
                             lsys.getStartVec().getStartY() + ";" +
                             lsys.getStartVec().getAngle() + ";" +
                             lsys.getStartVec().getLength() + ";" +
                             lsys.getStartVec().getWidth() + ";" +
                             rulesToString(lsys.getRuleset()) + "\n");
            }
        }
    }


    public ArrayList<LSystem> getLSystems() {
        return this.lSystems;
    }


    public String rulesToString(HashMap<String, String[]> ruleset) {
        StringBuilder string = new StringBuilder();

        for (String s : ruleset.keySet()) {
            string.append(s + ",");
            
            for (String a : ruleset.get(s)) {
                string.append(a + ",");
            }

            string.replace(string.length() - 1, string.length(), ":");
        }
        
        string.delete(string.length() - 1, string.length());
        return string.toString();
    }

}

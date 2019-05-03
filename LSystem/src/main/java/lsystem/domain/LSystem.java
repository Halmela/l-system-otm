package lsystem.domain;

import lsystem.domain.Vector;

import java.util.HashMap;

public class LSystem {
    private String axiom;
    private HashMap<String,String[]> ruleset;
    private Vector startVec;
    private int iterations;

    public LSystem(String axiom, HashMap<String, String[]> ruleset, Vector startVec, int iterations) {
        this.axiom = axiom;
        this.ruleset = ruleset;
        this.startVec = startVec;
        this.iterations = iterations;
    }


    public String getAxiom() {
        return this.axiom; 
    }

    public HashMap<String, String[]> getRuleset() {
        return this.ruleset;
    }

    public Vector getStartVec() {
        return this.startVec;
    }

    public int getIterations() {
        return this.iterations;
    }

    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Axiom: " + axiom + "\n");
        string.append("Ruleset:\n");
        for (String s : ruleset.keySet()) {
            string.append("  " + s + "\n");
            for (String a : ruleset.get(s)) {
                string.append("\t" + a + "\n");
            }
        }
        string.append("Starting vector:\n  " + startVec + "\n");
        string.append("Iterations: " + iterations);

        return string.toString();
    }

}

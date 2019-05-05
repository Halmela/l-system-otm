package lsystem.domain;

import lsystem.domain.Vector;

import java.util.HashMap;
import java.util.Objects;

/**
 * LSystems store information in most compact form
 * Created in interface or loaded from file
 * Transferred to Overlord
 */

public class LSystem {
    private String axiom;
    private HashMap<String,String[]> ruleset;
    private Vector startVec;
    private int iterations;

    public LSystem(String axiom, int iterations, Vector startVec, HashMap<String, String[]> ruleset) {
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
            String[] rules = ruleset.get(s);
            string.append("  " + s + " -> " + rules[0] + "\n");
            for (int i = 1; i < rules.length; i++) {
                string.append("\t   " + rules[i] + "\n");
            }
        }
        string.append("Starting vector:\n  " + startVec + "\n");
        string.append("Iterations: " + iterations);

        return string.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LSystem lSystem = (LSystem) o;
        return iterations == lSystem.iterations &&
                axiom.equals(lSystem.axiom) &&
                ruleset.equals(lSystem.ruleset) &&
                startVec.equals(lSystem.startVec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(axiom, ruleset, startVec, iterations);
    }

    public void setAxiom(String axiom) {
        this.axiom = axiom;
    }

    public void setRuleset(HashMap<String, String[]> ruleset) {
        this.ruleset = ruleset;
    }


    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}

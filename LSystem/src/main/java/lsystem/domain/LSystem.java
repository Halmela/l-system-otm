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
}

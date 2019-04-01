package com.mycompany.lsystem;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class LSystemTest {
    LSystem ls;

    @Before
    public void setUp() {
        String axiom = "0";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        LSystem ls = new LSystem(axiom, productionRules);
    }

    @Test
    public void alphabetIsExtractedCorrectly() {
        List<String> expected = new ArrayList<>(Arrays.asList("1", "[", "0", "]"));
        assertEquals(ls.getAlphabet(), expected);
    }

}
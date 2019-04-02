package lsystem;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class StringCreatorTest {

    StringCreator lsys;

    @Before
    public void setUp() {
        String axiom = "0";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        lsys = new StringCreator(axiom, productionRules);
    }


    @Test
    public void LSystemIsConstructedCorrectly() {
        List<String> expected = new ArrayList<>(Arrays.asList("1", "[", "0", "]"));
        assertEquals(lsys.getAlphabet(), expected);
    }


    @Test
    public void rulesAreAppliedCorrectly() {
        assertEquals(lsys.ruleApplier(lsys.getAxiom()), "1[0]0");
    }


    @Test
    public void iteratorWorksCorrectly() {
        String string = lsys.iterator(2);
        assertEquals(string, "11[1[0]0]1[0]0");
    }

    @Test
    public void anotherIteratorTest() {
        String axiom = "F";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("F", "F+F-F-F+F");
        StringCreator ls = new StringCreator(axiom, productionRules);

        assertEquals(ls.iterator(2), "F+F-F-F+F+F+F-F-F+F-F+F-F-F+F-F+F-F-F+F+F+F-F-F+F");
    }

}
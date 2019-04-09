package lsystem;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ImageLogicTest {
    StringCreator lsys;
    ImageLogic iL;

    @Before
    public void setUp() {
        String axiom = "0";
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        lsys = new StringCreator(axiom, productionRules);
        iL = new ImageLogic(lsys);
    }

    @Test
    public void rulesAreExtractedCorrectly() {
        HashMap<String, String> testi = new HashMap<>();
        testi.put("1", "forward");
        testi.put("[", "push left");
        testi.put("0","forward end");
        testi.put("]", "pop right");
        assertEquals(testi, iL.getDrawingRules());
    }

}
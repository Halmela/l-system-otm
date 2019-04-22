package lsystem;

import lsystem.ui.Screen;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class OverlordTest {
    Overlord overlord;

    @Before
    public void setUp() {
        HashMap<String, String[]> allRules = new HashMap<>();

        String[] z = new String[3];
        z[0] = "1[0]0";
        z[1] = "forward";
        z[2] = "end";
        String[] o = new String[2];
        o[0] = "11";
        o[1] = "forward";
        String[] f = new String[3];
        f[0] = "[";
        f[1] = "push";
        f[2] = "left";
        String[] d = new String[3];
        d[0] = "]";
        d[1] = "pop";
        d[2] = "right";
        allRules.put("0", z);
        allRules.put("1", o);
        allRules.put("[", f);
        allRules.put("]", d);


        int height = 1000;
        int width = 1000;
        double angle = 60;

        Vector vec = new Vector(width / 2, height, Math.toRadians(angle), 0, 0);

        overlord = new Overlord("0", allRules, 3, vec);
    }

    @Test
    public void productionRulesAreExtractedCorrectly() {
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");
        productionRules.put("[", "[");
        productionRules.put("]", "]");

        assertEquals(overlord.extractProductionRules(overlord.getAllRules()), productionRules);
    }




}
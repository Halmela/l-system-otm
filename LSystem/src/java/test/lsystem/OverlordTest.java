package lsystem;

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
        allRules.put("0", z);
        allRules.put("1", o);

        overlord = new Overlord("0", allRules, 60);
    }

    @Test
    public void productionRulesAreExtractedCorrectly() {
        HashMap<String, String> productionRules = new HashMap<>();
        productionRules.put("0", "1[0]0");
        productionRules.put("1", "11");

        assertEquals(overlord.extractProductionRules(overlord.getAllRules()), productionRules);
    }




}
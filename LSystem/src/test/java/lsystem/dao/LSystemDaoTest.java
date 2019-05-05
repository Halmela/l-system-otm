package lsystem.dao;

import lsystem.domain.LSystem;
import lsystem.domain.Vector;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

import static org.junit.Assert.*;

public class LSystemDaoTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    File userFile;;
    HashMap<String, String[]> ruleset;
    LSystem binaryTreeSys;
    String binaryTreeStr;
    LSystemDao daoTester;

    @Before
    public void setUp() throws Exception {
        binaryTreeStr = "0;3;500;1000;45;0;0;0,1[0]0,forward,end:1,11,forward:[,[,push,left:],],pop,right";

        ruleset = new HashMap<>();

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
        ruleset.put("0", z);
        ruleset.put("1", o);
        ruleset.put("[", f);
        ruleset.put("]", d);

        binaryTreeSys = new LSystem("0", 3, new Vector(500, 1000, Math.toRadians(45), 0, 0), ruleset);

        userFile = testFolder.newFile("user_test.txt");

        try {
            FileWriter writer = new FileWriter(new File(userFile.getAbsolutePath()));
            writer.write(binaryTreeStr);

        } catch (Exception e) {
            System.out.println("paskaa:" + e.getMessage());
        }


        daoTester = new LSystemDao(userFile.getAbsolutePath());

    }


    @Test
    public void parse() {
        LSystem act = daoTester.parse(binaryTreeStr);
        assertEquals(binaryTreeSys.toString(), act.toString());
    }


    @Test
    public void rulesToString() {
        String rules = daoTester.rulesToString(ruleset);
        String[] parts = binaryTreeStr.split(";");
        String exp = parts[7];
        assertEquals(exp, rules);
    }



    @After
    public void tearDown() {
        userFile.delete();
    }
}
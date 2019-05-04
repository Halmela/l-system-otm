package lsystem.ui;

import lsystem.domain.Overlord;
import lsystem.domain.Vector;
import lsystem.domain.LSystem;
import lsystem.dao.LSystemDao;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class CLI {
    private Scanner scanner;
    private int height;
    private int width;
    private double angle;
    private Vector start;

    public CLI(Scanner scan) {
        this.scanner = scan;
        this.height = 1000;
        this.width = 1000;
        this.angle = 45;
    }


	/**
	 * Handles user input 
	 */

    public Overlord command() {
        System.out.println("Tervetuloa Puutuottimeen\n");
		
		while(true) {
            
            System.out.println("Anna komento:\n\t1: tee binääripuu\n\t2: tee muu puu\n\t3: muuta näytön kokoa\n\t4: lataa tiedostosta");
        	String cmd = scanner.nextLine();

        	if (cmd.equals("1")) {
			  	System.out.println("Iteraatioiden määrä:");
			  	int i = Integer.parseInt(scanner.nextLine());
				return binaryTree(i);
        	} else if (cmd.equals("2")) {
        	    System.out.println("Aksiooma:");
        	    String axiom = scanner.nextLine();

        	    System.out.println("Kulma asteina:");
        	    double a = Double.parseDouble(scanner.nextLine());

        	    System.out.println("Iteraatioiden määrä:");
        	    int i = Integer.parseInt(scanner.nextLine());

        	    Vector vec = new Vector(width / 2, height, Math.toRadians(a), 0, 0);
                LSystem lSystem =  new LSystem(axiom, newRules(), vec, i);

        	    return new Overlord(lSystem);
        	} else if (cmd.equals("3")) {
                System.out.println("Korkeus:");
                this.height = Integer.parseInt(scanner.nextLine());
                System.out.println(this.height);
                System.out.println("Leveys:");
                this.width = Integer.parseInt(scanner.nextLine());
                System.out.println(this.width);
                
                continue;
            } else if(cmd.equals("4")) {
                try {
                    LSystemDao dao = new LSystemDao("conf.txt");
                    ArrayList<LSystem> lSystems = dao.getLSystems();

                    System.out.println("Valitse l-systeemi kirjoittamalla id:\n");
                    for (int i = 0; i < lSystems.size() ; i++) {
                        System.out.println("id: " + i + "\n" + lSystems.get(i));
                    }

                    int id = 0;

                    while(true) {
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            if (id < 0 || id >= lSystems.size()) {
                                System.out.println("Yritä uudelleen");
                                continue;
                            }
                            break;
                        } catch (Exception e){
                            System.out.println("Yritä uudelleen");
                        }
                    }

                    return new Overlord(lSystems.get(id));
                } catch (Exception e) {
                    System.out.println("virhe tilanne: " + e.getMessage());
                }
            } else {
                System.out.println("Yritä uudelleen");
            }
		}
	
    }


	/**
	 * Asks user for new rules 
	 */

    public HashMap<String, String[]> newRules() {
        System.out.println("Kirjoita yksi merkki kerrallaan. Tyhjä rivi lopettaa");

        HashMap<String, String[]> rules = new HashMap<>();

        while (true) {
            System.out.print("Merkki: ");
            String s = scanner.nextLine();
            if (s.equals("")) {
                break;
            } else if (rules.keySet().contains(s)) {
                System.out.println("Merkki löytyy jo");
            } else {                
                rules.put(s, rulesToCharacter());
            }
        }
        return rules;
    }


	public String[] rulesToCharacter() {
		String[] arr = new String[2];
        System.out.print("Tuotantosääntö: ");
	  	arr[0] = scanner.nextLine();

		System.out.println("Piirtosäännöt:\n\t Sallittuja sääntöjä 'forward', 'end', 'pop', 'push', 'left', 'right', 'none'");
        int i = 1;
        while (true) {
        String t = scanner.nextLine();
        if (t.equals("")) {
            break;
        } else {
            if (i > 1) {
                arr = arrayExpander(arr);
            }

            arr[i] = t;
            i ++;
        }
        }
			return arr;

	}


    public String[] arrayExpander(String[] arr) {
        String[] nArr = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            nArr[i] = arr[i];
        }

        return nArr;
    }


	/**
	 * Creates a binary tree, if user doesn't create a new tree
	 */

    public Overlord binaryTree(int iterations) {
        HashMap<String, String[]> allRules = new HashMap<>();

        String[] z  = new String[3];
        z[0]        = "1[0]0";
        z[1]        = "forward";
        z[2]        = "end";

        String[] o  = new String[2];
        o[0]        = "11";
        o[1]        = "forward";

        String[] f  = new String[3];
        f[0]        = "[";
        f[1]        = "push";
        f[2]        = "left";

        String[] d  = new String[3];
        d[0]        = "]";
        d[1]        = "pop";
        d[2]        = "right";

        allRules.put("0", z);
        allRules.put("1", o);
        allRules.put("[", f);
        allRules.put("]", d);

        Vector vec = new Vector(this.width / 2, height, Math.toRadians(angle), 0, 0);
        LSystem lsys = new LSystem("0", allRules, vec, iterations);

        System.out.println(lsys);

        return new Overlord(lsys);
    }




    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

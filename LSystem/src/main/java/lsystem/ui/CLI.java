package lsystem.ui;

import lsystem.Overlord;
import lsystem.Vector;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Scanner;

public class CLI {
    private Scanner reader;
    private int height;
    private int width;
    private double angle;
    private Vector start;

    public CLI(Scanner read) {
        this.reader = read;
        this.height = 1000;
        this.width = 1000;
        this.angle = 45;
    }


	/**
	 * Handles user input 
	 */

    public Overlord command() {
        System.out.println("Teretulemas Puutuottimeen\n");
        System.out.println("Anna komento:\n\t1: tee binääripuu\n\t2: tee muu puu");
		
		while(true) {
        	String cmd = reader.nextLine();

        	if (cmd.equals("1")) {
			  	System.out.println("Iteraatioiden määrä:");
			  	int i = Integer.parseInt(reader.nextLine());
				return binaryTree(i);
        	} else if (cmd.equals("2")) {
        	    System.out.println("Aksiooma:");
        	    String axiom = reader.nextLine();

        	    HashMap<String, String[]> newRules = newRules();

        	    System.out.println("Kulma asteina:");
        	    double a = Double.parseDouble(reader.nextLine());

        	    System.out.println("Iteraatioiden määrä:");
        	    int i = Integer.parseInt(reader.nextLine());

        	    Vector vec = new Vector(width / 2, height, Math.toRadians(a), 0, 0);
        	    return new Overlord(axiom, newRules, i, vec);
        	}
			System.out.println("Yritä uudelleen");
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
            String s = reader.nextLine();
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
	  	arr[0] = reader.nextLine();

		System.out.println("Piirtosäännöt:\n\t Sallittuja sääntöjä 'forward', 'end', 'pop', 'push', 'left', 'right', 'none'");
        int i = 1;
        while (true) {
        String t = reader.nextLine();
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

        Vector vec = new Vector(this.height / 2, width, Math.toRadians(angle), 0, 0);

        return new Overlord("0", allRules, iterations, vec);
    }




    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Vector getStart() {
        return start;
    }
}

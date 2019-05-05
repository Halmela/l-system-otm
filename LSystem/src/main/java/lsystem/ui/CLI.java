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
    private LSystemDao lSysDao;
    private Overlord overlord;

    public CLI(Scanner scan, LSystemDao dao) {
        this.scanner = scan;
        this.lSysDao = dao;
        this.height = 1080;
        this.width = 1920;
        this.angle = 45;
        command();
    }


	/**
	 * Handles user input 
	 */

    public void command() {
        System.out.println("Tervetuloa Puutuottimeen\n");
		
		while(true) {

            System.out.println("Anna komento:\n\t" +
                    "1: Näytä puut\n\t" +
                    "2: Tee valmis puu\n\t" +
                    "3: Tee uusi puu\n\t" +
                    "4: Muuta näytön kokoa (nykyinen koko: " + width + " x " + height + ")\n\t" +
                    "5: Tallenna puut\n\t" +
                    "6: Muuta puuta");
            String cmd = scanner.nextLine();
            System.out.println();

            if (cmd.equals("1")) {
                ArrayList<LSystem> lSystems = lSysDao.getLSystems();

                for (int i = 0; i < lSystems.size(); i++) {
                    System.out.println("id: " + i + "\n" + lSystems.get(i) + "\n");
                }

            } else if (cmd.equals("2")) {
                System.out.println("Anna id");
                int id = selectId();

                if (id == -1) {
                    continue;
                }

                overlord = new Overlord(lSysDao.getLSystems().get(id));
                break;

            } else if (cmd.equals("3")) {
        	    LSystem lSystem = lSystemDialog();
        	    lSysDao.getLSystems().add(lSystem);

                try {
                    lSysDao.save();
                } catch (Exception e) {
                    System.out.println("tallennus epäonnistui");
                }


        	} else if (cmd.equals("4")) {
                while (!changeSize());

            } else if(cmd.equals("5")) {
                try {
                    lSysDao.save();
                    System.out.println("onnistui");
                } catch (Exception e) {
                    System.out.println("ei: " + e.getMessage());
                }
            } else if (cmd.equals("6")) {
                System.out.println("Anna id");
                int id = selectId();

                if (id == -1) {
                    continue;
                }

                LSystem lsys = lSysDao.getLSystems().get(id);
                lSysDao.getLSystems().set(id, modifyLSystem(lsys));

            } else {
                System.out.println("Yritä uudelleen");
            }
		}

    }


    /**
     * Dialog to alter existing L-Systems
     * @param lSystem
     * @return modified LSystem
     */

    public LSystem modifyLSystem(LSystem lSystem) {
        LSystem newSys = lSystem;

        System.out.println(newSys);
        System.out.println("Mitä muutetaan? Joudut elämään virheidesi kanssa...");

        boolean continues = true;
        while (continues) {
            System.out.println("\t1: aksiooma\n\t" +
                               "2: iteraatiot\n\t" +
                               "3: säännöt\n\t" +
                               "4: kulma\n\t" +
                               "5: aloituspaikka\n\t" +
                               "6: aloituskulma\n\t" +
                               "Mikä tahansa muu lopettaa");

            switch (scanner.nextLine()) {
                case "1":   newSys.setAxiom(scanner.nextLine());
                            break;

                case "2":   newSys.setIterations(Integer.parseInt(scanner.nextLine()));
                            break;

                case "3":   newSys.setRuleset(newRules());
                            break;

                case "4":   newSys.getStartVec().setAngle(Double.parseDouble(scanner.nextLine()));
                            break;

                case "5":   System.out.print("x: ");
                            newSys.getStartVec().setStartX(Double.parseDouble(scanner.nextLine()));
                            System.out.print("y: ");
                            newSys.getStartVec().setStartY(Double.parseDouble(scanner.nextLine()));
                            break;

                default:    continues = false;
                            break;
            }

        }


        return newSys;
    }


    /**
     * Change size of screen
     */

    public boolean changeSize() {
        try {
            System.out.println("Leveys:");
            int wid = Integer.parseInt(scanner.nextLine());
            System.out.println("Korkeus:");
            this.height = Integer.parseInt(scanner.nextLine());
            this.width = wid;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Select id with sanitation
     */

    public int selectId () {
        System.out.println("Anna id, -1 palaa takaisin:");
        int id = 0;

        while(true) {
            try {
                id = Integer.parseInt(scanner.nextLine());

                if ( id != -1 && (id < 0 || id >= lSysDao.getLSystems().size())) {
                    System.out.println("Yritä uudelleen");
                    continue;
                }
                break;
            } catch (Exception e){
                System.out.println("Yritä uudelleen");
            }
        }

        return id;
    }


    /**
     * Dialog for creating a new LSystem
     * @return brand new LSystem
     */

    public LSystem lSystemDialog() {
        System.out.println("Aksiooma:");
        String axiom = scanner.nextLine();

        System.out.println("Kulma asteina:");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.println("Iteraatioiden määrä:");
        int i = Integer.parseInt(scanner.nextLine());

        Vector vec = new Vector(width / 2, height, Math.toRadians(a), 0, 0);
        LSystem lSystem =  new LSystem(axiom, i, vec, newRules());
        return lSystem;
    }


	/**
	 * Asks user for new rules 
	 */

    public HashMap<String, String[]> newRules() {
        System.out.println("Kirjoita yksi merkki kerrallaan. Tyhjä rivi lopettaa");

        HashMap<String, String[]> rules = new HashMap<>();

        while (true) {
            System.out.println("Merkki: ");
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


    /**
     * A set of rules for a character
     * @return String[] containing production and drawing rules
     */

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


    /**
     * Expand array to fit one more element
     * @param arr
     * @return arr with size ++
     */

    public String[] arrayExpander(String[] arr) {
        String[] nArr = new String[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            nArr[i] = arr[i];
        }

        return nArr;
    }



    public Overlord getOverlord() {
        return overlord;
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}

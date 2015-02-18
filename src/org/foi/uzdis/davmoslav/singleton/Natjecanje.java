package org.foi.uzdis.davmoslav.singleton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;
import org.foi.uzdis.davmoslav.Main;
import org.foi.uzdis.davmoslav.prototype.Natjecatelj;

/**
 *
 * @author Moki
 */
public class Natjecanje {

    private static Natjecanje natjecanje = new Natjecanje();

    private Natjecanje() {
    }

    public static Natjecanje getInstance() {
        return natjecanje;
    }

    public static void utrke(int maxUtrka, int maxNatjecatelja, int ispis, String datoteka) {
        Natjecatelj natjecatelj = new Natjecatelj() {};

        for (int i = 1; i <= maxUtrka; i++) {
            Random random = new Random();
            int natjecateljiUtrka = random.nextInt((maxNatjecatelja * 12) + 1);
            for (int b = 1; b <= natjecateljiUtrka; b++) {

                int prijavljeniNatjecatelj = random.nextInt(maxNatjecatelja * 12) + 1;
                int vrijeme = random.nextInt(1000);
                String rezultat = " ";
                if (vrijeme <= 100) {
                    rezultat = "diskvalificiran";
                } else {
                    rezultat = Integer.toString(vrijeme) + " s";
                }

                natjecatelj = Main.natjecatelji.get("id" + prijavljeniNatjecatelj);
                natjecatelj.setRezultat(rezultat);
            }

            Writer writer = null;
            
            switch (ispis) {
                case 1:
                    System.out.println("\nRezultati utrke broj " + i + ":");
                    for (int k = 1; k <= maxNatjecatelja * 12; k++) {
                        System.out.println(Main.natjecatelji.get("id" + k).getType()
                                + "" + Main.natjecatelji.get("id" + k).getSkupina()
                                + " id:" + Main.natjecatelji.get("id" + k).getId()
                                + " rezultat:" + Main.natjecatelji.get("id" + k).getRezultat());                    
                    }

                    
                    
                    try {
                        writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(datoteka + ".txt", true), "utf-8"));
                        writer.write("\r\nRezultati utrke broj " + i + ":");
                        writer.append(System.lineSeparator());
                        for (int k = 1; k <= maxNatjecatelja * 12; k++) {
                            writer.write(Main.natjecatelji.get("id" + k).getType()
                                    + "" + Main.natjecatelji.get("id" + k).getSkupina()
                                    + " id:" + Main.natjecatelji.get("id" + k).getId()
                                    + " rezultat:" + Main.natjecatelji.get("id" + k).getRezultat());
                            writer.append(System.lineSeparator());

                        }
                    } catch (IOException ex) {
                        System.out.println("Error");
                    } finally {
                        try {
                            writer.close();
                        } catch (Exception ex) {
                        }
                    }
              
                    break;
                case 0:
                    try {
                        writer = new BufferedWriter(new OutputStreamWriter(
                                new FileOutputStream(datoteka + ".txt", true), "utf-8"));
                        writer.write("\r\nRezultati utrke broj " + i + ":");
                        writer.append(System.lineSeparator());
                        for (int k = 1; k <= maxNatjecatelja * 12; k++) {
                            writer.write(Main.natjecatelji.get("id" + k).getType()
                                    + "" + Main.natjecatelji.get("id" + k).getSkupina()
                                    + " id:" + Main.natjecatelji.get("id" + k).getId()
                                    + " rezultat:" + Main.natjecatelji.get("id" + k).getRezultat());
                            writer.append(System.lineSeparator());

                        }
                    } catch (IOException ex) {
                        System.out.println("Greska kod pisanja datoteke.");
                    } finally {
                        try {
                            writer.close();
                        } catch (Exception ex) {
                        }
                    }
                    break;
            }
        }
    }

}

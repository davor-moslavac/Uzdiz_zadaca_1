package org.foi.uzdis.davmoslav;

import org.foi.uzdis.davmoslav.prototype.Natjecatelj;
import org.foi.uzdis.davmoslav.prototype.NatjecateljCache;
import org.foi.uzdis.davmoslav.singleton.Natjecanje;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static int maxUtrka;
    public static String maxNatjecatelja;
    public static int ispis;
    public static String nazivDatoteke;
    public static HashMap<String, Natjecatelj> natjecatelji = new HashMap<String, Natjecatelj>();

    public static void main(String[] args) {

        System.out.println("Pocetak rada.");

        String sintaksa = "(\\d++) (\\d++) ([0-1]) (\\w++)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]).append(" ");
        }
        String p = sb.toString().trim();
        Pattern pattern = Pattern.compile(sintaksa);
        Matcher m = pattern.matcher(p);
        boolean status = m.matches();
        if (status) {
            System.out.println("Ispravni argumenti.");
            maxUtrka = Integer.parseInt(m.group(1));
            maxNatjecatelja = m.group(2);
            ispis = Integer.parseInt(m.group(3));
            nazivDatoteke = m.group(4);

            natjecanje(maxNatjecatelja);
            start(maxUtrka, Integer.parseInt(maxNatjecatelja), ispis, nazivDatoteke);
        } else {
            System.out.println("Pogrešni argumenti.");
        }

    }

    public static void natjecanje(String maxNatjecatelja) {

        NatjecateljCache.loadCache();

        for (int k = 0; k < (Integer.parseInt(maxNatjecatelja)) * 6; k = k + Integer.parseInt(maxNatjecatelja)) {

            for (int i = 1; i <= Integer.parseInt(maxNatjecatelja); i++) {
                Natjecatelj clonedShape = (Natjecatelj) NatjecateljCache.getShape("1");

                clonedShape.setId(String.valueOf(k + i));

                if (k == 0) {
                    clonedShape.setSkupina("-14");
                } else if (k == Integer.parseInt(maxNatjecatelja)) {
                    clonedShape.setSkupina("-18");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 2) {
                    clonedShape.setSkupina("-25");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 3) {
                    clonedShape.setSkupina("-35");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 4) {
                    clonedShape.setSkupina("-45");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 5) {
                    clonedShape.setSkupina("-ostali");
                }

                natjecatelji.put("id" + clonedShape.getId(), clonedShape);
            }

        }

        for (int k = Integer.parseInt(maxNatjecatelja) * 6; k < (Integer.parseInt(maxNatjecatelja)) * 12; k = k + Integer.parseInt(maxNatjecatelja)) {
            for (int i = 1; i <= Integer.parseInt(maxNatjecatelja); i++) {
                Natjecatelj clonedShape = (Natjecatelj) NatjecateljCache.getShape("2");

                clonedShape.setId(String.valueOf(k + i));
                
                if (k == Integer.parseInt(maxNatjecatelja) * 6) {
                    clonedShape.setSkupina("-14");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 7) {
                    clonedShape.setSkupina("-18");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 8) {
                    clonedShape.setSkupina("-25");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 9) {
                    clonedShape.setSkupina("-35");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 10) {
                    clonedShape.setSkupina("-45");
                } else if (k == Integer.parseInt(maxNatjecatelja) * 11) {
                    clonedShape.setSkupina("-ostale");
                }
                natjecatelji.put("id" + clonedShape.getId(), clonedShape);                
            }
        }
    }

    private static void start(int maxUtrka, int maxNatjecatelja, int ispis, String nazivDatoteke){
        Natjecanje natjecanje = Natjecanje.getInstance();
        natjecanje.utrke(maxUtrka, maxNatjecatelja, ispis, nazivDatoteke);
    }
    
}

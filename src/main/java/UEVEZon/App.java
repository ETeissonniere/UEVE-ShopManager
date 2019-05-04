package UEVEZon;

import UEVEZon.models.*;

public class App {
    private static String DB_PATH = "uevezon.db";

    public static void main(String[] args) {
        /*BDD mag;

        File f = new File(DB_PATH);

        try {
            if(f.exists() && !f.isDirectory()) {
                mag = BDD.connect(DB_PATH);
            } else {
                mag = BDD.create(DB_PATH);
            }

            mag.close();
        } catch (Exception e) {
            System.out.println(e);
        }*/

        Magasin mag = new Magasin();
        
        mag.engage(new Employe("teissonniere", "eliott", 100000.0, "ceo"));
        mag.engage(new Employe("dupont", "alfred", 2000.0, "caissier"));

        Gamme macbooks = new Gamme(234567890, 2000.0, 0.2);
        macbooks.enregistre(new Produit(45678));
        macbooks.enregistre(new Produit(45679));
        macbooks.enregistre(new Produit(45680));

        Gamme burgers = new Gamme(56789768, 7.5, 0.17);
        burgers.enregistre(new Produit(45678));
        burgers.enregistre(new Produit(45679));
        burgers.enregistre(new Produit(45680));

        mag.vend("macbooks", macbooks);
        mag.vend("burgers", burgers);

        Client eve = new Client("evil", "eve", "eva@veryevil.com");

        Panier p = new Panier();

        try {
            p.ajoute(mag.achete(eve, "macbooks", 2));
            p.ajoute(mag.achete(eve, "burgers", 1));
        } catch (Exception e) {
            System.out.println("pas assez de stock");
        }

        System.out.println(p);
    }
}

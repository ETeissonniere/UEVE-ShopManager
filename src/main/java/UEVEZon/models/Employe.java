package UEVEZon.models;

public class Employe extends Personne {
    public double salaire;
    public String role;

    public Employe(String nom, String prenom, double salaire, String role) {
        super(nom, prenom);

        this.salaire = salaire;
        this.role = role;
    }
}

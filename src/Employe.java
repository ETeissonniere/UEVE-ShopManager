public class Employe extends Personne {
    public Double salaire;
    public String role;

    public Employe(String nom, String prenom, Double salaire, String role) {
        super(nom, prenom);

        this.salaire = salaire;
        this.role = role;
    }
}

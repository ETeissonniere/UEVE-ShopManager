public class Client extends Personne {
    public String mail;

    public Client(String nom, String prenom, String mail) {
        super(nom, prenom);

        this.mail = mail;
    }
}

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UEVEZon;

public class App {
    private String DB_PATH = "uevezon.db";

    public static void main(String[] args) {
        Magasin mag;

        File f = new File(DB_PATH);
        if(f.exists() && !f.isDirectory()) {
            mag = Magasin.connect(DB_PATH);
        } else {
            mag = Magasin.create(DB_PATH);
        }

        mag.close();
    }
}
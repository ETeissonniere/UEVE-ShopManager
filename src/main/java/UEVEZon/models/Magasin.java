package UEVEZon.models;

import java.sql.*;

public class Magasin {
    private Connection conn;

    public Magasin(Connection conn) throws SQLException {
        this.conn = conn;
        createTablesIfNeeded();
    }

    public static Magasin create(String path) throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/db/" + path;

        Connection conn = DriverManager.getConnection(url);
        return new Magasin(conn);
    }

    public static Magasin connect(String path) throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/db/" + path;

        Connection conn = DriverManager.getConnection(url);
        return new Magasin(conn);
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    private void createTablesIfNeeded() throws SQLException {
        String sql = ""
            + "CREATE TABLE IF NOT EXISTS employes (id INTEGER PRIMARY KEY AUTO_INCREMENT, nom TEXT NOT NULL, prenom TEXT NOT NULL, role TEXT NOT NULL, salaire DECIMAL(10, 10) NOT NULL);\n"
            + "CREATE TABLE IF NOT EXISTS clients (id INTEGER PRIMARY KEY AUTO_INCREMENT, nom TEXT NOT NULL, prenom TEXT NOT NULL, email TEXT NOT NULL);\n"
            + "CREATE TABLE IF NOT EXISTS gammes (id INTEGER PRIMARY KEY AUTO_INCREMENT, codeBarre TEXT NOT NULL, prix DECIMAL(10, 5) NOT NULL);\n"
            + "CREATE TABLE IF NOT EXISTS produits (id INTEGER PRIMARY KEY AUTO_INCREMENT, dateEntree TEXT NOT NULL, numSerie TEXT NOT NULL);\n"
            + "CREATE TABLE IF NOT EXISTS fournisseurs (id INTEGER PRIMARY KEY AUTO_INCREMENT, siret TEXT NOT NULL, nom TEXT NOT NULL, addr TEXT NOT NULL);\n"
            + "CREATE TABLE IF NOT EXISTS paniers (id INTEGER PRIMARY KEY AUTO_INCREMENT, datePaiement TEXT, dateReception TEXT, etat TEXT NOT NULL, valeur DECIMAL(10, 10) NOT NULL);";

        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
}

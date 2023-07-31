package org.example.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//A
public class Connessione {

    public static Connection Connession() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/DATABASE_PROVA";
        String username = "root";
        String password = "Prova123456789!";

        //Il driver per JDBC è inserito nel progetto tramite intellij e la funzionalita "Project Structure"
        Connection con = DriverManager.getConnection(url, username, password);

        //Commit manuali
        con.setAutoCommit(false);


        //Si apre la connessione utilizzata dal programma
        return con;
    }

}

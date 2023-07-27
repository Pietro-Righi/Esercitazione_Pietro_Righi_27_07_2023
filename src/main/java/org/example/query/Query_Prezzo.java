package org.example.query;

import org.example.model.Prezzo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query_Prezzo {

    public void insertPrezzo(Prezzo prezzo, Connection conn) throws SQLException {
        try{


            PreparedStatement quer = conn.prepareStatement("insert into prezzo (prezzo , data_prezzo ) values (?,?)");

            quer.setInt(1,prezzo.getPrezzo());
            quer.setDate(2,prezzo.getData_corrente());




            quer.execute();/*inizio transaction*/
            System.out.print("Inserimento...");
            conn.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            conn.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }



    //Cancellazione dei prezzi piu vecchi cosi che non ce ne siano troppi salvati
    public void deletePrezzo(Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("delete from prezzo " +
                                                                " where data_prezzo < 2020-01-01");


            quer.execute();
            System.out.print("Cancellazione date piu vecchie...");
            con.commit();
        }
        catch(SQLException e ){
            con.rollback();
            System.out.println(e.getMessage());
        }
    }




}

package org.example.query;

import org.example.model.Ordine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query_Ordine {
    public Ordine getOrdini(){
        return null;
    }

    public void insertOrdini(Ordine ordine, Connection conn) throws SQLException {
        try{


            PreparedStatement quer = conn.prepareStatement("insert into ordine ( data_ordine, NumeroOrdine) values (?,?)");

            quer.setDate(1,ordine.getData_ordine());
            quer.setInt(2,ordine.getNumero_ordine());


            quer.execute();/*inizio transaction*/
            System.out.println("Inserimento...");
            conn.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            conn.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

    public void deleteOrdini(int NumOrdine , Connection con) throws SQLException {
        try{
            Query_DettOrdini q = new Query_DettOrdini();
            q.deleteDettOrdiniFromOrdine(NumOrdine , con );


            PreparedStatement quer = con.prepareStatement("delete from ordine where NumeroOrdine = ?");
            quer.setInt(1,NumOrdine);


            quer.execute();/*inizio transaction*/
            System.out.print("Cancellazione...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }




    public void updateOrdini(Ordine ordine, int NumOrdine , Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("UPDATE ordine " +
                                                                "SET data_prdone = ?, NumeroOrdine = ? " +
                                                                "WHERE NumeroOrdine = ?");

            quer.setDate(1,ordine.getData_ordine());
            quer.setInt(2,ordine.getNumero_ordine());
            quer.setInt(3,NumOrdine);



            quer.execute();/*inizio transaction*/
            System.out.print("Modificando il dato...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }
}

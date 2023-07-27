package org.example.query;

import org.example.model.DettOrdini;
import org.example.model.Ordine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Query_DettOrdini {

    public Ordine getDettOrdini(){
        return null;
    }

    public void insertDettOrdini(DettOrdini dettordine, Connection conn) throws SQLException {
        try{
            PreparedStatement quer = conn.prepareStatement("insert into dettordini ( OrdineID, ProdottoID) values (?,?)");
            quer.setInt(1,dettordine.getOrdineID());
            quer.setInt(2,dettordine.getProdottoID());


            quer.execute();/*inizio transaction*/
            System.out.println("Inserimento...");
            conn.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            conn.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }



    public void deleteDettOrdiniFromProdotto(String nome, Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("delete d " +
                                                                "FROM dettordini d " +
                                                                "INNER JOIN prodotto ON prodotto.ProdottoID = d.ProdottoID " +
                                                                "where nome_prodotto = ? ");

            quer.setString(1,nome);


            quer.execute();/*inizio transaction*/
            System.out.print("Cancellazione...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }


    public void deleteDettOrdiniFromOrdine(int numero, Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("delete d " +
                                                                "FROM dettordini d " +
                                                                "INNER JOIN ordine ON ordine.OrdineID = d.OrdineID " +
                                                                "where NumeroOrdine = ? ");

            quer.setInt(1,numero);


            quer.execute();/*inizio transaction*/
            System.out.print("Cancellazione...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

}

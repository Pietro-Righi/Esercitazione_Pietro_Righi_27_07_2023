package org.example.query;

import com.mysql.cj.protocol.Resultset;
import org.example.model.Prodotto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query_Prodotto {


    public ResultSet selectProdotti(Connection con) throws SQLException {
        ResultSet result = null;
        try{


            PreparedStatement quer = con.prepareStatement("select * from prodotto");

            result = quer.executeQuery();/*inizio transaction*/
            System.out.print("Trovando i risultati...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }

        return result;
    }

    public ResultSet selectProdotto(String nome, Connection con) throws SQLException {
        ResultSet result = null;
        try{


            PreparedStatement quer = con.prepareStatement("select * from prodotto where nome_prodotto = ?");
            quer.setString(1,nome);


            result = quer.executeQuery();/*inizio transaction*/
            System.out.print("Trovando il risultato...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }

        return result;
    }

    public void insertProdotto(Prodotto prod, Connection con) throws SQLException {
        try{


            PreparedStatement quer = con.prepareStatement("insert into prodotto (nome_prodotto ,marca_prodotto,PrezzoID,data_scadenza ) values (?,?,?,?)");

            quer.setString(1,prod.getNome());
            quer.setString(2,prod.getMarca());
            quer.setInt(3,prod.getPrezzo());
            quer.setDate(4,prod.getData_scadenza());


            quer.execute();/*inizio transaction*/
            System.out.print("Inserimento...");
            con.commit();/*fine transaction*/
        }
        catch(SQLException e ){
            con.rollback();/*fine transaction*/
            System.out.println(e.getMessage());
        }
    }

    public void deleteProdotto(String nome, Connection con) throws SQLException {
        try{



            Query_DettOrdini q = new Query_DettOrdini();
            q.deleteDettOrdiniFromProdotto(nome , con );



            PreparedStatement quer = con.prepareStatement("delete from prodotto where nome_prodotto = ?");
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

    public void updateProdotto(Prodotto prod , String nome,  Connection con) throws SQLException {
        try{

            PreparedStatement quer = con.prepareStatement("UPDATE prodotto " +
                                                                "SET nome_prodotto = ?, marca_prodotto = ? , PrezzoID = ?,  data_scadenza = ? " +
                                                                "WHERE nome_prodotto = ?");
            quer.setString(1,prod.getNome());
            quer.setString(2,prod.getMarca());
            quer.setInt(3,prod.getPrezzo());
            quer.setDate(4,prod.getData_scadenza());
            quer.setString(5,nome);


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

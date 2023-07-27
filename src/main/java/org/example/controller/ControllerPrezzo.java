package org.example.controller;

import org.example.model.Prezzo;
import org.example.query.Query_DettOrdini;
import org.example.query.Query_Ordine;
import org.example.query.Query_Prezzo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerPrezzo {

    //Controller operazioni su prezzo
    public static void controllerPrezzo(Connection con){

        Scanner input = new Scanner(System.in);
        Query_Ordine ordQuery = new Query_Ordine();
        Query_Prezzo prezzoQuery = new Query_Prezzo();


        System.out.print("\n1-Si vuole inserire un nuovo prezzo?\n2- O si vuole cancellare i prezzi con data piu vecchia? (1/2): ");
        try{
            String risp = input.next();
            if(risp.equalsIgnoreCase("1")){
                prezzoQuery.insertPrezzo(Prezzo.insertPrezzo(), con);
            }
            else if (risp.equalsIgnoreCase("2")) {
                prezzoQuery.deletePrezzo( con);
            }


        }catch(SQLException| InputMismatchException e){
            System.out.print(e.getMessage());
        }




    }
}

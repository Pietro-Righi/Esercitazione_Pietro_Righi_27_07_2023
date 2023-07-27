package org.example.controller;

import org.example.model.DettOrdini;
import org.example.model.Ordine;
import org.example.query.Query_DettOrdini;
import org.example.query.Query_Ordine;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerOrdine {

    //Controller operazioni su ordine
    public static void controllerOrdine(Connection con){
        Scanner input = new Scanner(System.in);
        Query_Ordine ordQuery = new Query_Ordine();
        Query_DettOrdini dettOrdiniQuery = new Query_DettOrdini();


        try{
            System.out.print("Si vuole \n1-inserire un nuovo ordine \n2-aggiungere oggetti ad un ordine \n3-update di un ordine \n4-delete di un ordine: ");
            String risp = input.next();


            switch (risp){
                case "1":
                    ordQuery.insertOrdini(Ordine.inputOrdine(), con);
                    break;

                case "2":
                    dettOrdiniQuery.insertDettOrdini(DettOrdini.inputDettOrdini(), con);
                    break;

                case "3":
                    System.out.print("Si scriva l' ordine che si vuole cancellare inserendo il numero ordine: ");
                    int risposta = input.nextInt();
                    ordQuery.deleteOrdini(risposta,con);
                    break;

                case "4":
                    System.out.print("Si scriva l' ordine che si vuole modificare inserendo il numero ordine: ");
                    int risposta2 = input.nextInt();
                    ordQuery.updateOrdini(Ordine.inputOrdine(), risposta2, con);
            }
        }
        catch(InputMismatchException | SQLException e){
            System.out.print(e.getMessage());
        }

    }
}

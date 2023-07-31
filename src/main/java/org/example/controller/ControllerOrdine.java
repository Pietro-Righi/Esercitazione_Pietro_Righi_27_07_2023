package org.example.controller;

import org.example.model.DettOrdini;
import org.example.model.Ordine;
import org.example.query.Query_DettOrdini;
import org.example.query.Query_Ordine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerOrdine {


    public static void controllerOrdine(Connection con){
        Scanner input = new Scanner(System.in);
        Query_Ordine ordQuery = new Query_Ordine();
        Query_DettOrdini dettOrdiniQuery = new Query_DettOrdini();


        try{
            System.out.print("Si vuole \n1-inserire un nuovo ordine \n2-aggiungere oggetti ad un ordine \n3-update di un ordine \n4-delete di un ordine \n5-stampa di uno o piu ordini: ");
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
                    break;

                case "5":
                    System.out.println("Vuoi stampare tutti gli ordini o solo uno in particolare ? (1/2)");
                    String risp2 = input.next();

                    ResultSet res = null;

                    if(risp2.equalsIgnoreCase("1")){

                        res = ordQuery.selectOrdini(con); // Execute query


                    }
                    else if (risp2.equalsIgnoreCase("2")) {
                        System.out.println("Inserire nome dell' oggetto");
                        risp2 = input.next();
                        res =ordQuery.selectOrdine(risp2 , con);
                    }

                    while(res.next()){
                        System.out.println();
                        System.out.print("Ordine{");
                        System.out.print(res.getString(2));
                        System.out.print(res.getString(3));
                        System.out.print(res.getInt(4));
                        System.out.print(res.getDate(5));
                        System.out.print("}");

                    }

                    break;

            }
        }
        catch(InputMismatchException | SQLException e){
            System.out.print(e.getMessage());
        }

    }
}

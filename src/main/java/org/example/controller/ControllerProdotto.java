package org.example.controller;

import org.example.model.Prodotto;
import org.example.query.Query_Prodotto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerProdotto {


    //Controller operazioni su prodotto
    public static void controllerProdotto(Connection con){
        Scanner input = new Scanner(System.in);
        Query_Prodotto prodQuery = new Query_Prodotto();


        try{
            System.out.print("Si vuole \n1-inserire un nuovo prodotto \n2-vedere uno o piu prodotti \n3-update di un prodotto \n4-delete di un prodotto: ");
            String risp = input.next();


            switch (risp){
                case "1":
                    prodQuery.insertProdotto(Prodotto.insertProdotto(), con);
                    break;

                case "2":
                    System.out.println("Vuoi stampare tutti i prodotti o solo uno in particolare ? (1/2)");
                    String risp2 = input.next();

                    ResultSet res = null;

                    if(risp2.equalsIgnoreCase("1")){

                        res = prodQuery.selectProdotti(con); // Execute query


                    }
                    else if (risp2.equalsIgnoreCase("2")) {
                        System.out.println("Inserire nome dell' oggetto");
                        risp2 = input.next();
                        res =prodQuery.selectProdotto(risp2 , con);
                    }

                    while(res.next()){
                        System.out.println();
                        System.out.print("Prodotto{");
                        System.out.print(res.getString(2));
                        System.out.print(res.getString(3));
                        System.out.print(res.getInt(4));
                        System.out.print(res.getDate(5));
                        System.out.print("}");

                    }

                    break;

                case "3":
                    System.out.print("Si scriva il nome del prodotto che si vuole modificare: ");
                    String risposta = input.next();

                    prodQuery.updateProdotto(Prodotto.insertProdotto(), risposta, con);
                    break;

                case "4":
                    System.out.print("Si scriva il nome del prodotto che si vuole cancellare: ");
                    String risposta2 = input.next();
                    prodQuery.deleteProdotto(risposta2, con);
            }
        }
        catch(InputMismatchException | SQLException e){
            System.out.print(e.getMessage());
        }
    }
}

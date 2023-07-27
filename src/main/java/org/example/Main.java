package org.example;

import org.example.controller.ControllerOrdine;
import org.example.controller.ControllerPrezzo;
import org.example.controller.ControllerProdotto;
import org.example.query.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Connection con = Connessione.Connession();
            Scanner input = new Scanner(System.in);
            String risp;


            do {
                System.out.print("Cosa si vuole fare ? \n 1-Lavorare con un ordine \n 2- Lavorare un nuovo prodotto \n 3-Lavorare un nuovo prezzo :");
                risp = input.next();


                switch (risp) {
                    case "1":
                        ControllerOrdine.controllerOrdine(con);
                        break;
                    case "2":
                        ControllerProdotto.controllerProdotto(con);
                        break;

                    case "3":
                        ControllerPrezzo.controllerPrezzo(con);
                        break;
                }

                System.out.print("Si vuole fare altro ? (S per continuare il programma):");
                risp = input.next();


            }while(risp.equalsIgnoreCase("S"));

            con.close();
            System.out.println("Chiusura connessione");


        }
        catch(SQLException | ClassNotFoundException | InputMismatchException e){
            System.out.print(e.getMessage());
        }


    }
}
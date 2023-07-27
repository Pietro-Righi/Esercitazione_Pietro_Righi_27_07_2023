package org.example.model;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DettOrdini {

    //Sul db è presente anche un id di dettordini
    private int OrdineID;
    private int ProdottoID;


    public DettOrdini(int ordineID, int prodottoID) {
        this.setOrdineID(ordineID);
        this.setProdottoID(prodottoID);
    }


    //Per l' input si usa un metodo statico per essere piu rapidi
    public static DettOrdini inputDettOrdini(){

        Scanner input = new Scanner(System.in);
        DettOrdini dettord = null;
        System.out.println("");

        try{
            System.out.print("Inserire codice ordine: ");
            int codOrd = input.nextInt();
            System.out.print("Inserire codice prodotto: ");
            int codProd = input.nextInt();

            dettord = new DettOrdini(codOrd, codProd);
        }

        catch(InputMismatchException e){
            System.out.print(e.getMessage());
        }





        return dettord;

    }




    public int getOrdineID() {
        return OrdineID;
    }

    public void setOrdineID(int ordineID) {
        OrdineID = ordineID;
    }

    public int getProdottoID() {
        return ProdottoID;
    }

    public void setProdottoID(int prodottoID) {
        ProdottoID = prodottoID;
    }
}

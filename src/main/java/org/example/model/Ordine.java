package org.example.model;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ordine {


    //Sul db è presente anche un id di ordine
    private Date data_ordine;


    private int Numero_ordine;


    public Ordine(Date data_ordine, int Numero_ordine) {
        this.setData_ordine(data_ordine);
        this.setNumero_ordine(Numero_ordine);
    }





    public Date getData_ordine() {
        return this.data_ordine;
    }

    public void setData_ordine(Date data_ordine) {
        this.data_ordine = data_ordine;
    }


    public int getNumero_ordine() {
        return Numero_ordine;
    }

    public void setNumero_ordine(int numero_ordine) {
        Numero_ordine = numero_ordine;
    }


    //Per l' input si usa un metodo statico per essere piu rapidi
    public static Ordine inputOrdine(){

        Scanner input = new Scanner(System.in);
        Ordine ord = null;
        System.out.println("");



        try{
            System.out.print("Inserire il numero di ordine :");
            int risposta = input.nextInt();
            ord = new Ordine(new Date(System.currentTimeMillis()),risposta);
        }
        catch(InputMismatchException e){
            System.out.print(e.getMessage());
        }





        return ord;

    }

}

package org.example.model;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prezzo {


    //Sul db è presente anche un id di prezzo
    private int prezzo;
    private Date data_corrente;


    public Prezzo(int prezzo, Date data_corrente) {
        this.setPrezzo(prezzo);
        this.setData_corrente(data_corrente);
    }

    //Per l' input si usa un metodo statico per essere piu rapidi
    public static Prezzo insertPrezzo(){
        Scanner input = new Scanner(System.in);
        Prezzo prezzo = null;

        try{
            System.out.print("Inserisci un prezzo: ");
            int risposta = input.nextInt();
            prezzo  = new Prezzo(risposta,new Date(System.currentTimeMillis()));
        }
        catch(InputMismatchException e){
            System.out.print(e.getMessage());
        }






        return prezzo;
    }





    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public Date getData_corrente() {
        return data_corrente;
    }

    public void setData_corrente(Date data_corrente) {
        this.data_corrente = data_corrente;
    }

}

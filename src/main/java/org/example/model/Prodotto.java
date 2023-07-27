package org.example.model;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prodotto {

    //Sul db è presente anche un id di prodotto
    private String nome;
    private String marca;
    private int prezzo;
    private Date data_scadenza;


    public Prodotto(String nome, String marca, int prezzo, Date data_scadenza) {
        this.setNome(nome);
        this.setMarca(marca);
        this.setPrezzo(prezzo);
        this.setData_scadenza(data_scadenza);
    }


    //Per l' input si usa un metodo statico per essere piu rapidi
    public static Prodotto insertProdotto(){

        Scanner input = new Scanner(System.in);
        Prodotto prod = null;
        System.out.println("");



        try{
            System.out.print("Inserire il nome :");
            String nome = input.next();

            System.out.print("Inserire la marca");
            String marca = input.next();

            System.out.print("Inserire il tag o id del prezzo");
            int prezzo = input.nextInt();

            prod = new Prodotto(nome,marca,prezzo,new Date(System.currentTimeMillis()));
        }
        catch(InputMismatchException e){
            System.out.print(e.getMessage());
        }





        return prod;
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }


    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }
}

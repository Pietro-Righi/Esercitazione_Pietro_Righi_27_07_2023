package org.example.exception;

public class NullValueException extends Throwable{
    @Override
    public String getMessage() {
        return super.getMessage()+"Hai inserito un valore nullo, inserisci un valore corretto";
    }
}

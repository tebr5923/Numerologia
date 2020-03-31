package com.example.numerologia.calculate.exceptions;

public class EmptyStringException extends Exception {
    public EmptyStringException() {
    }

    @Override
    public String toString() {
        return "EmptyStringException{пустая строка}";
    }


}

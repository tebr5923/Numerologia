package com.example.numerologia.calculate.exceptions;

public class NotRusLetterException extends Exception {
    private char letter;

    public NotRusLetterException(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return "NotRusLetterException{" +
                "ввели не русскую букву " + letter +
                '}';
    }

}

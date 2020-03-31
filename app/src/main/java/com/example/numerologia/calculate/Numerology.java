package com.example.numerologia.calculate;

import com.example.numerologia.calculate.exceptions.EmptyStringException;
import com.example.numerologia.calculate.exceptions.NotRusLetterException;

public class Numerology {
    private String surname, name, middlename, date;
    private int numberOfFate, numberOfSoul, numberOfPersonality, numberOfLifePath;

    public Numerology(String surname, String name, String middlename, String date) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.date = date;
    }

    //вычисляем число судьбы(11 и 22 тоже можно)
    public void calculateNumberOfFate() throws NotRusLetterException, EmptyStringException {
        String strOfNums;
        int result;
        strOfNums = Integer.toString(UtilsForNumerology.resultSumOfNumbers(UtilsForNumerology.lettersToStrOfNums(name))) +
                Integer.toString(UtilsForNumerology.resultSumOfNumbers(UtilsForNumerology.lettersToStrOfNums(surname))) +
                Integer.toString(UtilsForNumerology.resultSumOfNumbers(UtilsForNumerology.lettersToStrOfNums(middlename)));
        result = UtilsForNumerology.resultSumOfNumbersForFate(strOfNums);
        this.numberOfFate = result;
    }

    //вычисляем число личности
    public void calculateNumberOfPersonality() throws NotRusLetterException, EmptyStringException {
        String fio, strOfNums;
        int result;
        fio = name + surname + middlename;
        strOfNums = UtilsForNumerology.lettersToStrOfNums(UtilsForNumerology.stayConsonatLetters(fio));
        result = UtilsForNumerology.resultSumOfNumbers(strOfNums);
        this.numberOfPersonality = result;
    }


    //вычисляем число Души
    public void calculateNumberOfSoul() throws NotRusLetterException, EmptyStringException {
        String fio, strOfNums;
        int result;
        fio = name + surname + middlename;
        strOfNums = UtilsForNumerology.lettersToStrOfNums(UtilsForNumerology.stayVowelLetters(fio));
        result = UtilsForNumerology.resultSumOfNumbers(strOfNums);
        this.numberOfSoul = result;
    }

    //вычисляем число жизненного пути
    public void calculateNumberOfLifePath() throws EmptyStringException {
        String dateOnlyNumbers;
        if (this.date.length() == 0) throw new EmptyStringException();
        int result;
        dateOnlyNumbers = date.replace("/", "");
        result = UtilsForNumerology.resultSumOfNumbers(dateOnlyNumbers);
        this.numberOfLifePath = result;
    }
    public void calculateAllNumbers() throws NotRusLetterException, EmptyStringException {
        this.calculateNumberOfSoul();
        this.calculateNumberOfPersonality();
        this.calculateNumberOfLifePath();
        this.calculateNumberOfFate();
    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfFate() {
        return numberOfFate;
    }

    public int getNumberOfSoul() {
        return numberOfSoul;
    }

    public int getNumberOfPersonality() {
        return numberOfPersonality;
    }

    public int getNumberOfLifePath() {
        return numberOfLifePath;
    }

}

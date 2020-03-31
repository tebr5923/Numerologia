package com.example.numerologia.calculate;

import com.example.numerologia.calculate.exceptions.EmptyStringException;
import com.example.numerologia.calculate.exceptions.NotRusLetterException;

import java.util.ArrayList;
import java.util.List;

public class UtilsForNumerology {
    /*переводит одну букву в цифру*/
    private static byte letterToNum(char c) throws NotRusLetterException {
        if (c == 'а' | c == 'А' | c == 'и' | c == 'И' | c == 'С' | c == 'с' | c == 'ъ' | c == 'Ъ') {
            return 1;
        } else if (c == 'Б' | c == 'б' | c == 'Й' | c == 'й' | c == 'Т' | c == 'т' | c == 'Ы' | c == 'ы') {
            return 2;
        } else if (c == 'В' | c == 'в' | c == 'К' | c == 'к' | c == 'У' | c == 'у' | c == 'Ь' | c == 'ь') {
            return 3;
        } else if (c == 'Г' | c == 'г' | c == 'Л' | c == 'л' | c == 'Ф' | c == 'ф' | c == 'Э' | c == 'э') {
            return 4;
        } else if (c == 'Д' | c == 'д' | c == 'М' | c == 'м' | c == 'Х' | c == 'х' | c == 'Ю' | c == 'ю') {
            return 5;
        } else if (c == 'Е' | c == 'е' | c == 'Н' | c == 'н' | c == 'Ц' | c == 'ц' | c == 'Я' | c == 'я') {
            return 6;
        } else if (c == 'Ё' | c == 'ё' | c == 'О' | c == 'о' | c == 'Ч' | c == 'ч') {
            return 7;
        } else if (c == 'Ж' | c == 'ж' | c == 'П' | c == 'п' | c == 'Ш' | c == 'ш') {
            return 8;
        } else if (c == 'З' | c == 'з' | c == 'Р' | c == 'р' | c == 'Щ' | c == 'щ') {
            return 9;
        } else throw new NotRusLetterException(c);
    }

    // оставляем только СОГЛАСНЫЕ буквы в СТРОКЕ
    protected static String stayConsonatLetters(String strOfLetters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strOfLetters.length(); i++) {
            char c = strOfLetters.charAt(i);
            if (c == 'б' | c == 'Б' | c == 'в' | c == 'В' | c == 'г' | c == 'Г' | c == 'д' | c == 'Д'
                    | c == 'Ж' | c == 'ж' | c == 'З' | c == 'з' | c == 'Й' | c == 'й' | c == 'К' | c == 'к'
                    | c == 'Л' | c == 'л' | c == 'М' | c == 'м' | c == 'Н' | c == 'н' | c == 'П' | c == 'п'
                    | c == 'Р' | c == 'р' | c == 'С' | c == 'с' | c == 'Т' | c == 'т' | c == 'Ф' | c == 'ф'
                    | c == 'Х' | c == 'х' | c == 'Ц' | c == 'ц' | c == 'Ч' | c == 'ч' | c == 'Ш' | c == 'ш'
                    | c == 'Щ' | c == 'щ' | c == 'Ь' | c == 'ь' | c == 'Ъ' | c == 'ъ') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    // оставляем только ГЛАСНЫЕ буквы в СТРОКЕ
    protected static String stayVowelLetters(String strOfLetters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strOfLetters.length(); i++) {
            char c = strOfLetters.charAt(i);
            if (c == 'А' | c == 'а' | c == 'Е' | c == 'е' | c == 'Ё' | c == 'ё' | c == 'И' | c == 'и'
                    | c == 'О' | c == 'о' | c == 'У' | c == 'у' | c == 'Э' | c == 'э' | c == 'Ю' | c == 'ю'
                    | c == 'Я' | c == 'я' | c == 'Ы' | c == 'ы') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


    /*переводит строку из букв в строку из цифр*/
    public static String lettersToStrOfNums(String strOfLetters) throws NotRusLetterException, EmptyStringException {
        if (strOfLetters.length() == 0) throw new EmptyStringException();
        StringBuilder strOfNums = new StringBuilder();
        for (int i = 0; i < strOfLetters.length(); i++) {
            strOfNums.append(letterToNum(strOfLetters.charAt(i)));
        }
        return strOfNums.toString();
    }

    /*переводит строку из букв в List<Integer> */
    public static List<Integer> lettersToListOfNums(String strOfLetters) throws NotRusLetterException {
        List<Integer> listOfNums = new ArrayList<>();

        for (int i = 0; i < strOfLetters.length(); i++) {
            listOfNums.add((Byte.toUnsignedInt(letterToNum(strOfLetters.charAt(i)))));
        }
        return listOfNums;
    }

    //считаем сумму цифр(один раз) из строки
    public static int sumOfNums(String nums) {
        int sum = 0;
        for (int i = 0; i < nums.length(); i++) {
            sum = sum + Character.getNumericValue(nums.charAt(i));
        }
        return sum;
    }

    //считаем сумму цифр из List<Integer>
    public static int sumOfNums(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        return sum;
    }

    //считаем сумму из строки букв(сумма должна быть <10)
/*    public static int resultSumOfLetters(String letters) {
        String strOfNums;
        int result = 0;
        try {
            strOfNums = Utils.lettersToStrOfNums(letters);
// --------------рекурсия begin
            result = Utils.sumOfNums(strOfNums);
            while (result > 9) {
                if (result == 11 | result == 22) break;//????надо или нет это тут????
                result = Utils.sumOfNums(Integer.toString(result));
            }
// --------------рекурсия end
        } catch (NotRusLetterException | EmptyStringException e) {
            e.printStackTrace();
            //clear;
            //всплывающая подсказка об ошибке буквы
        }
        return result;
    }
    */

    //считаем сумму цифр из строки пока не будет <10
    public static int resultSumOfNumbers(String numbers) {
        int result = 0;
        // --------------рекурсия begin
        result = UtilsForNumerology.sumOfNums(numbers);
        while (result > 9) {
            result = UtilsForNumerology.sumOfNums(Integer.toString(result));
        }
// --------------рекурсия end
        return result;
    }

    //считаем сумму цифр из строки пока не будет <9
    //или 11 или 22
    public static int resultSumOfNumbersForFate(String numbers) {
        String strOfNums;
        int result = 0;
        // --------------рекурсия begin
        result = UtilsForNumerology.sumOfNums(numbers);
        while (result > 9) {
            if (result == 11 | result == 22) break;
            result = UtilsForNumerology.sumOfNums(Integer.toString(result));
        }
// --------------рекурсия end
        return result;
    }
}

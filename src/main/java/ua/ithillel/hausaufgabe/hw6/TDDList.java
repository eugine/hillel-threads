package ua.ithillel.hausaufgabe.hw6;

import java.util.ArrayList;
import java.util.List;

//https://lms.ithillel.ua/groups/63852b47be0edd7e228232f4/homeworks/63e279cc551a44726f48c924
//https://github.com/ShcherbataIrina/JavaHomeWork6/pull/1/files

public class TDDList {
/*
// порахувати кількість входжень елемента у списку
    public static int countOccurance(List<String> list, String item) {
        int count = 0;
        for (String element : list) {
            if (element.equals(item)) {
                count++;
            }
        }
        return count;
    }

// Перетворити масив у список
    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

//      Створити метод findUnique, що приймає на вхід числовий список, що складається з довільних значень, які можуть повторюватися в необмеженій кількості.
//      Необхідно повернути новий числовий список, що містить тільки унікальні числа.
//      (Використовуючи лише List)
    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (!result.contains(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }


//     Створити метод calcOccurance, який приймає на вхід рядковий список як параметр.
//     Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
//     Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль.

    public static String calcOccurance(List<String> list) {
        List<String> uniqueElements = new ArrayList<>();
        String element = "";
        String countEachElementInList = "";
        for (int i = 0; i < list.size(); i++) {
            int count = 0;

            if (!uniqueElements.contains(list.get(i))) {
                element = list.get(i);
                uniqueElements.add(element);

                for (int j = 0; j < list.size(); j++) {
                    if (element.equals(list.get(j))) {
                        count++;
                    }
                }

                countEachElementInList += list.get(i) + " = " + count + " ";
            }
        }
        return countEachElementInList;
    }


// Створити метод findOccurance, що приймає на вхід рядковий список як параметр.
//  Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
//  Обчислити скільки разів трапляється кожне слово.
//  Результат повернути у вигляді списку структур, що описують повторення кожного окремого взятого слова.
    public  static List<Result> findOccurance(List<String> list) {
        var countEachElementInList= new ArrayList<Result>();
        List<String> uniqueElements = new ArrayList<>();
        String element = "";

        for (int i = 0; i < list.size(); i++) {
            int count = 0;

            if (!uniqueElements.contains(list.get(i))) {
                element = list.get(i);
                uniqueElements.add(element);

                for (int j = 0; j < list.size(); j++) {
                    if (element.equals(list.get(j))) {
                        count++;
                    }
                }
                countEachElementInList.add(new Result(element, count));

            }
        }
        return countEachElementInList;
    }

*/

}


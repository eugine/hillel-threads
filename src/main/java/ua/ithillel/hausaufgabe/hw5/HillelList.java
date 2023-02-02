package ua.ithillel.hausaufgabe.hw5;

public interface HillelList {
    /**
     * Додати новий елемент до списка
     */
    void add(String item);

    /**
     * Видалити елемент із списка за визначенним індексом
     *
     * @return видалений елемент
     */
    String remove(int index);

    /**
     * Перевіряє чи є такий елемент у списку.
     *
     * @return true - якщо є, false - якщо ні
     */
    boolean contains(String item);

    /**
     * Знайти індекс елемента у списку
     *
     * @return індекс (0 - відповідає першому елементу), -1 - якщо не знайдено
     */
    int indexOf(String item);

    /**
     * Розмір списка
     */
    int size();

    /**
     * Повертає елемент списка за вказанним індексом
     */
    String get(int index);

    /**
     * Всі елементи списка
     */
    String[] getAll();
}

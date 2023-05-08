package ua.ithillel.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.spring.core.card.Cart;

public class SpringCoreExample {

    /*
    1. Реалізувати клас Product які складається з: id, назва, ціна
    2. Товари зберігаються у класі-біні ProductRepository, у вигляді списку. Цей список ініціалізується даними при старті програми.
    3. ProductRepository дозволяє отримати весь список або один товар за ID.
    4. Реалізувати клас-бін Cart для, в який можна додавати та видаляти товари за id.
    5. Реалізувати консольну програму для керування кошиком.
        5.1 Додавання товару до кошика
        5.2 Видалення товару з кошика
    6. Щоразу при запиті екземпляра-біна кошика з контексту додатка повинен повертатися новий екземпляр кошика.
    */

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        var cart = context.getBean(Cart.class);

        cart.add(1);
        cart.add(2);

        System.out.println(cart);

        var cart2 = context.getBean(Cart.class);

        cart2.add(3);

        System.out.println(cart2);

    }
}

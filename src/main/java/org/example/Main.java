package org.example;

import org.example.config.DefaultAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    //при запуске попадаем в меню приложения
    //отображается показать контакты /добавить/удалить контакт
        //показать контакты - если пусто - вывести страницу что список пустой
        //добавить контакт - вывести добавить ФИО, следующая строка Телефон,
        //следующая строка, емейл (предусмотреть регулярки и возможность выйти)
    //возможность удалить по емейл
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);

        context.getBean(ProfileWorker.class).doWork();

        context.getBean(PersonInfo.class);
        context.getBean(ControllerContacts.class);

    }
}

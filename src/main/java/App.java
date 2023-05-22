import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        HelloWorld bean =
//                (HelloWorld) context.getBean("helloworld");
//        System.out.println(bean.getMessage());

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld helloWorld = context.getBean("HelloWorldBean", HelloWorld.class);
        HelloWorld helloWorld1 = context.getBean("HelloWorldBean", HelloWorld.class);

        Cat cat = context.getBean("CatBean", Cat.class);
        Cat cat1 = context.getBean("CatBean", Cat.class);

        System.out.print("У экземпляров Класса HelloWorld, bean == Singltone? ");
        System.out.print(helloWorld == helloWorld1);

        System.out.println();

        System.out.print("У экземпляров Класса Cat, bean == Singletone? ");
        System.out.print(cat == cat1);
        // Прочитал что контекст не обязательно закрывать в не многопоточной среде, но в любом случае хороший тон
        // тут он у меня почему то не закрывается,context не находит close метод
    }
}
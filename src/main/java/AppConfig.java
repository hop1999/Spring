import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean(name = "HelloWorldBean")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }

    @Bean("CatBean") // По дефолту Bean был бы cat, то-есть был бы равен названию класса с маленькой буквы.
                    // щас прочитал что надо было создать bean -> cat, надеюсь переделывать не придется :(
    @Scope("prototype") // Дефолтный скоп Bean == Singletone, его стоит использовать когда обьект хранит состояние,
                       //то есть когда он является stateless, prototype же, когда объекты stateful.
    public Cat getCat() {
        return new Cat();
    }
}
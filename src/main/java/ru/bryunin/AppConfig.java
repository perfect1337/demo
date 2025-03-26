package ru.bryunin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Configuration
public class AppConfig {
    Random random = new Random();
    private List<Integer> n;
    @Bean
    public String helloWorld() {
        return "Hello world";
    }

    @Bean
    public Date date() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> range() {
        return num -> num >= 2 && num <= 5;
    }

    @Bean(name = "min")
    public int min() {
        return 3;
    }

    @Bean(name = "max")
    public int max() {
        return 100;
    }

    @Bean
    public int random() {
            n = new ArrayList<>();
            for (int i = min(); i <= max(); i++) {
                n.add(i);
            }

        if (n.isEmpty()) {
            throw new IllegalStateException("чисел больше нет");
        }

        int rand = random.nextInt(n.size());
        return n.remove(rand);
    }


}

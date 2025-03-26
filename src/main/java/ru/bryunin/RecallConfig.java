package ru.bryunin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class RecallConfig {
    AppConfig appConfig = new AppConfig();

    @Bean
    public Recall recall1() {
        return new Recall("well", 4);
    }

    @Bean
    public Recall recall2() {
        return new Recall("неплохо", 3);
    }

    @Bean
    public Recall recall3() {
        int x = appConfig.random(); // Получаем случайное число из AppConfig
        return new Recall("hard to say", x);
    }

    @Bean
    public Recall bestRecall(
            Recall recall1,
            Recall recall2,
            Recall recall3) {

        List<Recall> recalls = List.of(recall1, recall2, recall3);
        return recalls.stream()
                .max((recallA, recallB) -> Integer.compare(recallA.getMark(), recallB.getMark()))
                .orElse(null); // Возвращает null, если список пуст
    }
}

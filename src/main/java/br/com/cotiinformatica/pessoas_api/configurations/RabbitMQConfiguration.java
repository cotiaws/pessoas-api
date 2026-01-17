package br.com.cotiinformatica.pessoas_api.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    Queue queue() {
        return new Queue("pessoas-api");
    }

}

package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterFunctionConfig {
    private static final List<String> NOUN = Arrays.asList("Cookie", "Pie", "Mousse", "Donut", "Pudding");
    private static final List<String> ADJ = Arrays.asList("Carrot", "Marzipan", "Peanut", "Banana", "Honey");

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/names/gum"), request -> ServerResponse.ok().body(getNames(), String.class) );
    }

    private Flux<String> getNames(){
        Random random = new Random();
        return Flux.create(emitter -> {
            for (int i = 0; i < NOUN.size(); i++) {
                int n = random.nextInt(NOUN.size());
                int a = random.nextInt(ADJ.size());
                emitter.next(ADJ.get(a) + " " + NOUN.get(n) + "\n");
            }
            emitter.complete();
        });
    }
}
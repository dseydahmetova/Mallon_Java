package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.ILoggerFactory;


public class Main {
    static WebClient webclient = WebClient.create("http://localhost:8080");

    public static void main(String[] args) {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
//        webclient.get().uri("account/1").retrieve().bodyToMono(Account.class);
        Account account = new Account(4, "saving", 547);
        postAccount (account);

    }
    public static void postAccount(Account account){
        final Logger logger = LoggerFactory.getLogger(Account.class);

        webclient.post()
                .uri("/accounts")
                .body(Mono.just(account), Account.class)
                .retrieve()
                .bodyToMono(Account.class)
                .subscribe(
                        confirmation -> logger.info(confirmation.toString()),
                        error -> logger.error("Post account failed: " + error)
                );
    }
}

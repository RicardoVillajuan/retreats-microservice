package com.bank.webclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;
import com.bank.model.Account;
import com.bank.model.Movement;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

public class RepoWebClient {
    /**
     * Objeto WebClient para hacer conultas a otras entidades.
     */
    private WebClient.Builder webclient = WebClient.builder(); 
    /**
     * Metodo para obtener la cuenta de la entidad account.
     * @param id
     * @return
     */
    public Mono<Account> getAccount(String id) {
        return webclient.build().get().uri("http://localhost:8095/account/{id}", id)
            .retrieve().bodyToMono(Account.class); 
    } 
    /**
     * Metodo para buscar por el numero de cuenta.
     * @param accountnumber
     * @return
     */
    public Mono<Account> findByAccountNumber(String accountnumber) {
        return webclient.build().get()
            .uri("http://localhost:8095/account/accountnumber/{accountnumber}", accountnumber)
            .retrieve().bodyToMono(Account.class); 
    }
    /**
     * Metodo para actualizar la cuenta.
     * @param id
     * @param account
     * @return
     */
    public Mono<Account> updateAccount(String id, Account account) {
        return webclient.build().put().uri("http://localhost:8095/account/accountnumber/{accountnumber}", id)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(account))
            .retrieve()
            .bodyToMono(Account.class); 
    }
    /**
     * Metodo para salvar el movimiento.
     * @param movement
     * @return
     */
    public Mono<Movement> saveMovement(Movement movement) {
        return webclient.build().post()
            .uri("http://localhost:8098/movement").contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(movement)).retrieve().bodyToMono(Movement.class); 
    }
}

package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Retreat;
import reactor.core.publisher.Mono;

public interface IRetreatdb {
    /**
     * Metodo que recibe un objeto y lo guarda en la entidad.
     * @param retreat
     * @return
     */
    Mono<Account> send(Retreat retreat);
}

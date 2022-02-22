package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Retreat;
import reactor.core.publisher.Mono;

public interface IRetreatdb {
	
	Mono<Account> send(Retreat retreat);
}

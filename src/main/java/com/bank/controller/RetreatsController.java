package com.bank.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.model.Retreat;
import com.bank.service.IRetreatdb;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/retreat")
public class RetreatsController {

	private final IRetreatdb serviceRetreat;

	@PostMapping
	public Mono<Account> save(@RequestBody Retreat retreat){
		return serviceRetreat.send(retreat);
	}
}

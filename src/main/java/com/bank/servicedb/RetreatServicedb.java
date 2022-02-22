package com.bank.servicedb;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Movement;
import com.bank.model.Retreat;

import com.bank.service.IRetreatdb;
import com.bank.webclient.repoWebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RetreatServicedb implements IRetreatdb{

	private repoWebClient repoweb=new repoWebClient();

	@Override
	public Mono<Account> send(Retreat retreat) {
		Mono<Account> account=repoweb.findByAccountNumber(retreat.getAccountnumber());
			
		return account.doOnNext(e->{
			if(e.getAmmount()<retreat.getAmmount())
				throw new RuntimeException("No cuenta con el saldo suficiente para esta operacion");
		}).flatMap(e->{
			Movement movement=new Movement();
			movement.setCommissioncharged(0.0);
			if(e.getMaxmovements()==0)
				retreat.setAmmount(retreat.getAmmount()-1);
				movement.setCommissioncharged(1.0);
			
			e.setAmmount(e.getAmmount()-retreat.getAmmount());
			if(e.getMaxmovements()>=1) 
				e.setMaxmovements(e.getMaxmovements()-1);
			
			movement.setIdcustomer(e.getIdclient());
			movement.setDate(new Date());
			movement.setAmmount(retreat.getAmmount());
			movement.setTypemovement("Retreat");
			repoweb.saveMovement(movement).subscribe();
			
			return repoweb.updateAccount(retreat.getAccountnumber(), e);
		});
	}

}

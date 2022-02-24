package com.bank.servicedb;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Movement;
import com.bank.model.Retreat;

import com.bank.service.IRetreatdb;
import com.bank.webclient.RepoWebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RetreatServicedb implements IRetreatdb {
    /**
     * Variable que me retorna los metodos del WebClient.
     */
    private RepoWebClient repoweb = new RepoWebClient();
    /**
     * Metodo que recibe un objeto Retreat y devuelve un Mono de tipo Account.
     */
    @Override
    public Mono<Account> send(Retreat retreat) {
        Mono<Account> account = repoweb.
                findByAccountNumber(retreat.getAccountnumber());

        return account.doOnNext(e -> {
            if (e.getAmmount() < retreat.getAmmount()) {
                throw new RuntimeException("No cuenta con el saldo suficiente para esta operacion");
            }
        }).flatMap(e -> {
            Movement movement = new Movement();
            movement.setCommissioncharged(0.0);
            if (e.getMaxmovements() == 0) {
                retreat.setAmmount(retreat.getAmmount());
                movement.setCommissioncharged(1.0);
            }
            e.setAmmount((long) (e.getAmmount() - retreat.getAmmount() - movement.getCommissioncharged()));
            if (e.getMaxmovements() >= 1) {
                e.setMaxmovements(e.getMaxmovements() - 1);
            }
            movement.setIdcustomer(e.getIdclient());
            movement.setDate(new Date());
            movement.setNameproduct(e.getNameproduct());
            movement.setAmmount(retreat.getAmmount());
            movement.setTypemovement("Retreat");
            movement.setIdproduct(e.getIdproduct());
            repoweb.saveMovement(movement).subscribe();

            return repoweb.updateAccount(retreat.getAccountnumber(), e);
        });
    }

}

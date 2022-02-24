package com.bank.model;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    /**
     * Variable que almancena el idAccount.
     */
    private String id;
    /**
     * Variable que almacena el idcliente.
     */
    private String idclient;
    /**
     * Variable que almacena el idproducto.
     */
    private String idproduct;
    /**
     * Variable que almacena el nombre del product.
     */
    private String nameproduct;
    /**
     * Variable que almacena el numero de cuenta.
     */
    private String accountnumber;
    /**
     * Variable que almacena los movimientos maximos que puede tener la cuenta.
     */
    private int maxmovements;
    /**
     * Variable que almacena el la comision por mantenimiento mensual.
     */
    private double maintenancecommission;
    /**
     * Variable que almacena el monto o saldo de la cuenta.
     */
    private long ammount;
    /**
     * Variable que almacena el los firmantes y titulares.
     */
    private Authorities authorities;
    /**
     * Variable que almacena la fecha.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}

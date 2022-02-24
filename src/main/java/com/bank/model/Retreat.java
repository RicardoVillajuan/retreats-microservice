package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Retreat {
    /**
     * Variable que almacena el numero de cuenta.
     */
    private String accountnumber;
    /**
     * Variable que almacena el monto a retirar.
     */
    private Long ammount;
}

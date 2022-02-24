package com.bank.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Authorities {
    /**
     * Variable de tipo lista que almacena los titulares.
     */
    private List<Holders> holders; 
    /**
     * Variable de tipo lista que almacena los firmantes.
     */
    private List<Signatories> signatories; // firmantes
}

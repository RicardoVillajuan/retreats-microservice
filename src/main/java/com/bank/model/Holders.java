package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Holders {
    /**
     * Variable que almacena el nombre de los holder.
     */
    private String names;
    /**
     * Variable que almacena el los apelldidos de los holder.
     */
    private String surnames;
    /**
     * Variable que almacena el dni de los holder.
     */
    private String dni;
}

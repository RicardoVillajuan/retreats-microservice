package com.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Signatories {
    /**
	 * Variable que almacena el nombre del del firmante.
	 */
    private String names;
    /**
     * Variable que almacena el apellido del del firmante.
     */
    private String surnames;
    /**
     * Variable que almacena el dni del del firmante.
     */
    private String dni;
}

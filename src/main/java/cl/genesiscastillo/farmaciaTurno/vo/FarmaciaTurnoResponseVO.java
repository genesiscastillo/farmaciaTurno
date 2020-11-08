package cl.genesiscastillo.farmaciaTurno.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FarmaciaTurnoResponseVO {

	private String local;
	private String direccion;
	private String telefono;
	private String latitud;
	private String longitud;
	
}

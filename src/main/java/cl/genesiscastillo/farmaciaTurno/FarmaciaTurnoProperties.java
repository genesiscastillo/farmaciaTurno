package cl.genesiscastillo.farmaciaTurno;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "url.rest.minsal")
public class FarmaciaTurnoProperties {

	
	private String comunasPorRegiones;
	private String localesPorRegiones;
	
}

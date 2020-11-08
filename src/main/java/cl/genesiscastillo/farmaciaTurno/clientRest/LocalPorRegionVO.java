package cl.genesiscastillo.farmaciaTurno.clientRest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocalPorRegionVO {

	@JsonProperty("fecha")
	private String fecha;

	@JsonProperty("local_id")
	private String localId;

	@JsonProperty("local_nombre")
	private String localNombre;

	@JsonProperty("comuna_nombre")
	private String comunaNombre;

	@JsonProperty("localidad_nombre")
	private String localidadNombre;

	@JsonProperty("local_direccion")
	private String localDireccion;

	@JsonProperty("funcionamiento_hora_apertura")
	private String funcionamientoHoraApertura;

	@JsonProperty("funcionamiento_hora_cierre")
	private String funcionamientoHoraCierre;

	@JsonProperty("local_telefono")
	private String localTelefono;

	@JsonProperty("local_lat")
	private String localLat;

	@JsonProperty("local_lng")
	private String localLng;

	@JsonProperty("funcionamiento_dia")
	private String funcionamientoDia;

	@JsonProperty("fk_region")
	private String fkRegion;

	@JsonProperty("fk_comuna")
	private String fkComuna;

}

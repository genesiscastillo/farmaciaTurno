package cl.genesiscastillo.farmaciaTurno.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.genesiscastillo.farmaciaTurno.clientRest.LocalPorRegionVO;
import cl.genesiscastillo.farmaciaTurno.clientRest.MinsalClientRest;
import cl.genesiscastillo.farmaciaTurno.vo.ComunaPorRegionResponseVO;
import cl.genesiscastillo.farmaciaTurno.vo.FarmaciaTurnoRequestVO;
import cl.genesiscastillo.farmaciaTurno.vo.FarmaciaTurnoResponseVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/farmacia")
@Slf4j
public class FarmaciaEnTurnoController {

	@Autowired
	MinsalClientRest minsalClientRest;

	@PostMapping(value = "/postListaFarmaciaEnTurno" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FarmaciaTurnoResponseVO>> getListaFarmaciaEnTurno(
			@RequestBody FarmaciaTurnoRequestVO farmaciaTurnoRequestVO) {

		List<LocalPorRegionVO> localPorRegionVOs = minsalClientRest.obtenerLocalesPorRegiones(7);

		List<FarmaciaTurnoResponseVO> farmaciaTurnoResponseVOs = localPorRegionVOs.stream()
				.filter(obj -> obj.getComunaNombre().equals( farmaciaTurnoRequestVO.getComuna() ))
				.filter(obj -> obj.getLocalNombre().equals( farmaciaTurnoRequestVO.getLocal() ))
				.map( obj -> {
					FarmaciaTurnoResponseVO responseVO = new FarmaciaTurnoResponseVO();
					responseVO.setDireccion( obj.getLocalDireccion());
					responseVO.setLocal( obj.getLocalNombre());
					responseVO.setLatitud( obj.getLocalLat());
					responseVO.setLongitud( obj.getLocalLng());
					responseVO.setTelefono( obj.getLocalTelefono());
					return responseVO;
				})
				.collect(Collectors.toList());

		farmaciaTurnoResponseVOs.forEach( obj -> log.info( obj.toString()));

		return farmaciaTurnoResponseVOs.isEmpty() ? new ResponseEntity<List<FarmaciaTurnoResponseVO>>(HttpStatus.NOT_FOUND) : ResponseEntity.ok( farmaciaTurnoResponseVOs);
	}
	
	@GetMapping(value = "/getListaComunasPorRegion" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComunaPorRegionResponseVO> getListaComunas(){
		String resultados = minsalClientRest.obtenerComunasPorRegion();
		ComunaPorRegionResponseVO  responseVO = new ComunaPorRegionResponseVO();
		responseVO.setResultado(resultados);
		return ResponseEntity.ok( responseVO );
	}	
}

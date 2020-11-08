package cl.genesiscastillo.farmaciaTurno.clientRest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.genesiscastillo.farmaciaTurno.FarmaciaTurnoProperties;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MinsalClientRest {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	FarmaciaTurnoProperties properties;

	public List<LocalPorRegionVO> obtenerLocalesPorRegiones(Integer id_region) {
		List<LocalPorRegionVO> localPorRegionVOs = new ArrayList<LocalPorRegionVO>();
		try {
			String uri = properties.getLocalesPorRegiones();

			URI targetUrl = UriComponentsBuilder.fromUriString(uri).queryParam("id_region", id_region).build().encode()
					.toUri();
			String result = restTemplate.getForObject(targetUrl, String.class);
			ObjectMapper mapper = new ObjectMapper();
			localPorRegionVOs = Arrays.asList(mapper.readValue(result, LocalPorRegionVO[].class));
		} catch (Exception exception) {
			log.error(exception.getMessage());
		}
		return localPorRegionVOs;
	}

	public String obtenerComunasPorRegion() {
		String uri = properties.getComunasPorRegiones();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("reg_id", 7);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
		String result = restTemplate.postForObject(uri, requestEntity, String.class);
		return result;
	}

}

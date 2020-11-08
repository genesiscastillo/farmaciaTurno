package cl.genesiscastillo.farmaciaTurno;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.genesiscastillo.farmaciaTurno.clientRest.LocalPorRegionVO;
import cl.genesiscastillo.farmaciaTurno.clientRest.MinsalClientRest;
import cl.genesiscastillo.farmaciaTurno.vo.FarmaciaTurnoRequestVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class FarmaciaTurnoApplicationTests extends AbstractTest {

	@Autowired
	MinsalClientRest minsalClientRest;
	
	@Test
	public void testClientRestComunasPorRegion() {
		String result = 	minsalClientRest.obtenerComunasPorRegion();
		log.info("resultado "+result);
		assertTrue( result.startsWith("<option value='0' selected>Elija Comuna</option>"));
	}
	
	@Test
	public void testClienteRestLocalPorRegion() throws Exception {
		List<LocalPorRegionVO> localPorRegionVOs =  minsalClientRest.obtenerLocalesPorRegion();
		localPorRegionVOs.forEach(System.out::println);
		
		assertTrue(localPorRegionVOs.size() > 0);
	}
	
	@Test
	public void test1() throws Exception	{
		FarmaciaTurnoRequestVO farmaciaTurnoRequestVO = new FarmaciaTurnoRequestVO();
		farmaciaTurnoRequestVO.setComuna("BUIN");
		farmaciaTurnoRequestVO.setLocal("AHUMADA");
		
		final String uri = "/getListaFarmaciaEnTurno";
		
		String inputJson = super.objectToJson(farmaciaTurnoRequestVO);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		String content = mvcResult.getResponse().getContentAsString();
		log.info(content);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//@SuppressWarnings("rawtypes")
		//List lista	= mapper.readValue(content, List.class);
		
		//assertTrue(lista.size() == 1);
	}
}

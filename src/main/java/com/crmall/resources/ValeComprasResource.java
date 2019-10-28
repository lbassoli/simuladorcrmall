package com.crmall.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crmall.dto.ConsultaValeComprasDTO;
import com.crmall.dto.ResponseConsultaValeCompras;

@RestController
@RequestMapping(value="/instant-prize")
public class ValeComprasResource {
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseConsultaValeCompras> consultar(HttpServletRequest servletRequest, @RequestParam MultiValueMap<String, String> obj) {
		ResponseConsultaValeCompras rsp = new ResponseConsultaValeCompras();
		rsp.setCode(400);
		ConsultaValeComprasDTO cons = new ConsultaValeComprasDTO();
		cons.setStoreDocument(String.valueOf(obj.getFirst("storeDocument")));
		cons.setDocument(String.valueOf(obj.getFirst("document")));
		cons.setValue(Double.valueOf(obj.getFirst("value")));
		if (cons.getDocument().equalsIgnoreCase("000.000.001-91") &&
				cons.getStoreDocument().equalsIgnoreCase("00.000.000/0001-90")) {
			rsp.setCode(200);
			rsp.setMessage("Dirija-se a Central de Atendimento");
			rsp.setData("Parabens Voce Saiu no Lucro: R$ 50,00" );
		}
		return ResponseEntity.ok().body(rsp);
	}
}

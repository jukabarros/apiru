package br.api.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.api.dao.PratoDAO;
import br.api.helper.AppProperties;
import br.api.model.Prato;
import br.api.util.JsonParser;
import br.api.model.Error;

@RestController
@RequestMapping("/pratos")
public class PratoController {

	@Autowired
	private PratoDAO pratoDAO;
	
	@Autowired
	private AppProperties prop;
	
	/**
	 * GET todos os pratos. Possui parametros opcionais (dias da semana)
	 * @param request Reques
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> getPratos(HttpServletRequest request,
			@RequestParam(value = "diaSemana", required = false) List<String> diasSemana) {
	 	try {
	 		List<Prato> pratos = new ArrayList<Prato>();
	 		if (diasSemana != null){
	 			pratos = this.pratoDAO.getByDiaSemana(diasSemana);
	 		}else{
	 			pratos = this.pratoDAO.getListaPratos();
	 		}
	 		
	 		System.out.println(prop.toString());
	 		return new ResponseEntity<List<Prato>>(pratos, HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
	/**
	 * GET prato pelo codigo.
	 * @param request Request
	 * @param codigo Codigo do prato
	 * @return
	 */
	@RequestMapping(value = "/{codigoPrato}" ,method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> getPratosByCodigo(HttpServletRequest request, @PathVariable int codigoPrato) {
	 	try {
	 		Prato prato = this.pratoDAO.getByCodigo(codigoPrato);
	 		
	 		if (prato == null){
	 			return new ResponseEntity<Error>(new Error(404, "Prato não encontrado"), HttpStatus.NOT_FOUND); 
	 		}
	 		
	 		return new ResponseEntity<Prato>(prato, HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
	/**
	 * POST prato
	 * @param request
	 * @param json recurso
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> postPrato(HttpServletRequest request, @RequestBody String json) {
		
	 	try {
	 		JsonParser jsonParser = new JsonParser();
	 		
	 		Prato prato = jsonParser.jsonToPrato(json);
	 		this.pratoDAO.addPrato(prato);
	 		
	 		return new ResponseEntity<String>(HttpStatus.OK);
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	}	 	
	}
	
	/**
	 * Delete prato pelo ID
	 * @param request request
	 * @param idPrato codigo do prato que vai ser deletado
	 * @return
	 */
	@RequestMapping(value = "/{codigoPrato}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> deletePratoByCodigo(HttpServletRequest request, 
			@PathVariable int codigoPrato) {
	 	try {
	 		
	 		Prato prato = this.pratoDAO.getByCodigo(codigoPrato);
	 		if (prato != null){
	 			this.pratoDAO.deletePrato(prato);
	 			return new ResponseEntity<String>(HttpStatus.OK);
	 			
	 		}
	 		
	 		return new ResponseEntity<Error>(new Error(404, "Prato não encontrado"), HttpStatus.NOT_FOUND); 
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
	
	/**
	 * Update prato pelo ID
	 * @param request request
	 * @param idPrato codigo do prato que vai ser deletado
	 * @return
	 */
	@RequestMapping(value = "/{codigoPrato}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
	public ResponseEntity<?> putPratoByCodigo(HttpServletRequest request, @RequestBody String json,
			@PathVariable int codigoPrato) {
	 	try {
	 		
	 		JsonParser jsonParser = new JsonParser();

	 		Prato checkPrato = this.pratoDAO.getByCodigo(codigoPrato);
	 		if (checkPrato != null){
	 			Prato pratoUpdated = jsonParser.jsonToPrato(json);
	 			this.pratoDAO.updatePrato(pratoUpdated);
	 			return new ResponseEntity<String>(HttpStatus.OK);
	 			
	 		}
	 		
	 		return new ResponseEntity<Error>(new Error(404, "Prato não encontrado"), HttpStatus.NOT_FOUND); 
	 		
	 	} catch (Exception e) {
	 		System.err.println(e.getMessage());
	 		return new ResponseEntity<Error>(new Error(500, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	 	} 	
	}
}

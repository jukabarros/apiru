package integration;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import br.app.RestAPIApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestAPIApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class PratoTest {

	public static final String DIA_SEMANA = "Quarta-Feira";
	
	public static final String PRATO_NOME = "Sarapatel";
	
	public static final int CODIGO_PRATO = 4;
	
	public static final int CODIGO_PRATO_DELETE = 2;
	
	static {
		RestAssured.port = 9000;
	}
	
	/**
	 * Retorna um prato de acordo com o ID
	 */
	@Test
	public void getPratoByCodigo() {
		RestAssured
				.given()
				.when()
					.get("/pratos/"+CODIGO_PRATO)
				.then()
					.statusCode(HttpStatus.OK.value())
					.body("descricao", Matchers.equalToIgnoringCase(PRATO_NOME));
	}
	
	/**
	 * Retorna todos os pratos
	 */
	@Test
	public void getAllPratos() {
		RestAssured
				.given()
				.when()
					.get("/pratos")
				.then()
					.statusCode(HttpStatus.OK.value())
					.body("size()", Matchers.greaterThan(0));
	}
	
	/**
	 * Retorna uma lista de pratos de acordo com o dia da semana
	 */
	@Test
	public void getPratosByDiaSemana() {
		RestAssured
				.given()
				.when()
				.param("diaSemana", DIA_SEMANA)
					.get("/pratos")
				.then()
					.statusCode(HttpStatus.OK.value())
					.body("size()", Matchers.greaterThan(0));
	}
	
	/**
	 * Adiciona um Prato
	 */
	@Test
	public void postPrato() {
		Map<String, Object> mapNewPrato = this.makePostPrato();
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.content(mapNewPrato)
				.when()
					.post("/pratos")
				.then()
					.statusCode(HttpStatus.OK.value());
	}
	
	/**
	 * Remove um prato
	 */
	@Test
	public void deletePrato() {
		RestAssured
				.given()
				.when()
					.delete("/pratos/"+CODIGO_PRATO_DELETE)
				.then()
					.statusCode(HttpStatus.OK.value());
	}
	
	/**
	 * Atualiza um Prato
	 */
	@Test
	public void putPrato() {
		Map<String, Object> mapPratoUpdated = this.makePutPrato();
		RestAssured
				.given()
				.contentType(ContentType.JSON)
				.content(mapPratoUpdated)
				.when()
					.put("/pratos/"+CODIGO_PRATO)
				.then()
					.statusCode(HttpStatus.OK.value());
	}
	
	
	/*
	 * MAPS
	 */
	private Map<String, Object> makePostPrato(){
		Map<String, Object> mapNewPrato = new LinkedHashMap<String, Object>();
		mapNewPrato.put("codigo", 123);
		mapNewPrato.put("descricao", "Canjica");
		mapNewPrato.put("quantidadeKcal", 765.42);
		mapNewPrato.put("diasSemana", Arrays.asList("Terça-Feira", "Quinta-Feira"));
		mapNewPrato.put("livreGluten", false);
		mapNewPrato.put("livreLactose", false);
		mapNewPrato.put("livreGlicose", true);
		mapNewPrato.put("tipoPrato", "Jantar");
		
		return mapNewPrato;
	}
	
	private Map<String, Object> makePutPrato(){
		Map<String, Object> mapPutPrato = new LinkedHashMap<String, Object>();
		mapPutPrato.put("codigo", CODIGO_PRATO);
		mapPutPrato.put("descricao", "Pamonha");
		mapPutPrato.put("quantidadeKcal", 200.15);
		mapPutPrato.put("diasSemana", Arrays.asList("Segunda-Feira", "Sexta-Feira"));
		mapPutPrato.put("livreGluten", true);
		mapPutPrato.put("livreLactose", true);
		mapPutPrato.put("livreGlicose", false);
		mapPutPrato.put("tipoPrato", "Almoço");
		
		return mapPutPrato;
	}
}

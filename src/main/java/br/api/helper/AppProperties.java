package br.api.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Classe com mapeamento dos properties
 * @author marcela.oliveira
 *
 */
@Component
public class AppProperties {

	@Value("${server}")
	private String server;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;
	
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

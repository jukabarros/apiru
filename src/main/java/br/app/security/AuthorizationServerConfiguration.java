package br.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManagerBean;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		// @formatter:off
		clients.inMemory().withClient("my-client")
		 			.resourceIds(ResourceServerConfiguration.RESOURCE_ID)
		 			.authorizedGrantTypes("authorization_code", "implicit")
		 			.authorities("ROLE_CLIENT")
		 			.scopes("read", "write")
		 			.secret("secret");
		// @formatter:on
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManagerBean);
	}

}
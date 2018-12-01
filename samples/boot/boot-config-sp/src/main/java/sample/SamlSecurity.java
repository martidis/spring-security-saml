/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.saml.boot.registration.SamlBootConfiguration;
import org.springframework.security.saml.serviceprovider.SamlServiceProviderConfigurer;
import org.springframework.security.saml.serviceprovider.bean.OpenSamlTransformerConfiguration;
import org.springframework.security.saml.serviceprovider.bean.SamlServiceProviderBeanConfiguration;


@EnableWebSecurity
@Import
	({
		SamlBootConfiguration.class,
		OpenSamlTransformerConfiguration.class,
		SamlServiceProviderBeanConfiguration.class
	})
@Configuration
public class SamlSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	public SamlServiceProviderConfigurer saml2Login() {
		return SamlServiceProviderConfigurer.saml2Login();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.antMatcher("/**")
				.authorizeRequests()
				.anyRequest().authenticated()
			.and()
				.logout()
			.and()
			.apply(
				saml2Login()
			);
		// @formatter:on
	}
}

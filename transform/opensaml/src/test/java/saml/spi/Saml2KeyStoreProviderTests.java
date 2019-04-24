/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package saml.spi;

import java.time.Clock;

import org.springframework.security.saml2.Saml2KeyStoreProvider;
import org.springframework.security.saml2.spi.opensaml.OpenSaml2Implementation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.springframework.security.saml2.spi.ExamplePemKey.IDP_RSA_KEY;
import static org.springframework.security.saml2.spi.ExamplePemKey.RSA_TEST_KEY;
import static org.springframework.security.saml2.spi.ExamplePemKey.SP_RSA_KEY;

public class Saml2KeyStoreProviderTests {

	@BeforeAll
	public static void initProvider() {
		new OpenSaml2Implementation(Clock.systemUTC()).init();
	}
	@Test
	public void test_example() {
		new Saml2KeyStoreProvider(){}.getKeyStore(RSA_TEST_KEY.getSimpleKey("alias"));
	}

	@Test
	public void test_idp_1024() {
		new Saml2KeyStoreProvider(){}.getKeyStore(IDP_RSA_KEY.getSimpleKey("alias"));
	}

	@Test
	public void test_sp_1024() {
		new Saml2KeyStoreProvider(){}.getKeyStore(SP_RSA_KEY.getSimpleKey("alias"));
	}
}
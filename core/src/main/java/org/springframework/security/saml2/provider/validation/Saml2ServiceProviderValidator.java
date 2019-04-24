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

package org.springframework.security.saml2.provider.validation;

import java.util.List;

import org.springframework.security.saml2.Saml2ValidationResult;
import org.springframework.security.saml2.provider.Saml2ServiceProviderInstance;
import org.springframework.security.saml2.model.Saml2Object;
import org.springframework.security.saml2.model.Saml2SignableObject;
import org.springframework.security.saml2.model.key.Saml2KeyData;
import org.springframework.security.saml2.model.signature.Saml2Signature;

public interface Saml2ServiceProviderValidator {
	Saml2Signature validateSignature(Saml2SignableObject saml2Object, List<Saml2KeyData> verificationKeys);

	/**
	 * Performs an object validation on behalf of a service or identity provider on the respective object
	 *
	 * @param saml2Object the object to be validated according to SAML specification rules
	 * @param provider    the object used to resolve metadata
	 */
	Saml2ValidationResult validate(Saml2Object saml2Object, Saml2ServiceProviderInstance provider);
}
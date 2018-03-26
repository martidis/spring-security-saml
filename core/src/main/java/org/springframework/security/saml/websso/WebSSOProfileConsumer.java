/* Copyright 2009 Vladimir Schäfer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.saml.websso;

import javax.xml.bind.ValidationException;

import org.opensaml.saml.common.SAMLException;
import org.opensaml.xmlsec.encryption.support.DecryptionException;
import org.opensaml.xmlsec.signature.support.SignatureException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.context.SAMLMessageContext;

/**
 * @author Vladimir Schäfer
 */
public interface WebSSOProfileConsumer {

    SAMLCredential processAuthenticationResponse(SAMLMessageContext context)
        throws SAMLException, SecurityException, ValidationException, DecryptionException, SignatureException, org.opensaml.security.SecurityException, org.opensaml.compat.validation.ValidationException;

}
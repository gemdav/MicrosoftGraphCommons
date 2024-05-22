// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * Decodes a JWT string into a plain text JSON for the header and payload. This enables the user to implement a specific JSON mapping that decodes the header or payload. Throws an exception when the token could not be decoded or verified.
 */
public class DecodeVerifyJWTPlainText extends CustomJavaAction<java.lang.String>
{
	private java.lang.String encodedJWT;
	private java.lang.String issuer;
	private java.lang.String audience;
	private java.lang.String jwksUri;
	private java.lang.Long leeway;

	public DecodeVerifyJWTPlainText(IContext context, java.lang.String encodedJWT, java.lang.String issuer, java.lang.String audience, java.lang.String jwksUri, java.lang.Long leeway)
	{
		super(context);
		this.encodedJWT = encodedJWT;
		this.issuer = issuer;
		this.audience = audience;
		this.jwksUri = jwksUri;
		this.leeway = leeway;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		//Get the Key ID from the token
		DecodedJWT jwt = JWT.decode(encodedJWT);
		String kid = jwt.getKeyId();
		
		//Get the proper public key
		JwkProvider provider = new UrlJwkProvider(new URL(jwksUri));
		Jwk jwk = provider.get(kid); 
		Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);		
		
		//Verify
		Verification verification = JWT.require(algorithm)
	        .withIssuer(issuer);
	    if (audience != null) {
	    	verification.withAudience(audience);
	    }
		if (leeway != null) {
			verification.acceptLeeway(leeway);
		}
		JWTVerifier verifier = verification.build(); //Reusable verifier instance
		DecodedJWT jwtv = verifier.verify(encodedJWT);
		return new String(Base64.getUrlDecoder().decode(jwtv.getPayload()));
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DecodeVerifyJWTPlainText";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

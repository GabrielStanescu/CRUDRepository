package com.crudrepo.user.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.crudrepo.user.exceptions.InvalidJWTException;
import com.crudrepo.user.model.JWTHeader;
import com.crudrepo.user.model.JWTRequest;
import com.crudrepo.user.model.JWTResponse;
import com.crudrepo.user.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Service
public class JWTService {

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withClaim("id", user.getId())
                .withClaim("age", (int) user.getAge())
                .withClaim("email", user.getEmail())
                .withClaim("firstName", user.getFirstName())
                .withClaim("lastName", user.getLastName())
                .sign(algorithm);
        return "Bearer " + token;
    }

    public User getUserByJWT(JWTResponse jwtResponse) throws NoSuchAlgorithmException, InvalidKeyException, InvalidJWTException {
        String token = jwtResponse.getJwtToken().replace("Bearer ", "");
        String[] chunks = token.split("\\.");

        if (isSignatureValid(chunks[0] + "." + chunks[1], chunks[2])) {
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));
            Gson gson = new Gson();
            JWTHeader jwtHeader = gson.fromJson(header, JWTHeader.class);
            if (!isHeaderValid(jwtHeader))
                throw new InvalidJWTException("Invalid JWT Header");
            return gson.fromJson(payload, User.class);
        } else {
            throw new InvalidJWTException("Invalid JWT Signature.");
        }
    }

    private boolean isSignatureValid(String token, String givenSignature) throws NoSuchAlgorithmException, InvalidKeyException {
        // set signature in base64 format
        givenSignature += "=";
        // hash first 2 jwt's parts using sha256
        SecretKeySpec secretKeySpec = new SecretKeySpec("secret".getBytes(), "HmacSha256");
        Mac mac = Mac.getInstance("HmacSha256");
        mac.init(secretKeySpec);
        String base64Signature = Base64.getUrlEncoder().encodeToString(mac.doFinal(token.getBytes()));
        return givenSignature.equals(base64Signature);
    }

    private static String bytesToHex(byte[] in) {
        final StringBuilder builder = new StringBuilder();
        for (final byte b: in)
            builder.append(String.format("%02x", b));
        return builder.toString();
    }

    private boolean isHeaderValid(JWTHeader jwtHeader) {
        return jwtHeader.getTyp().equals("JWT") && jwtHeader.getAlg().equals("HS256");
    }
}

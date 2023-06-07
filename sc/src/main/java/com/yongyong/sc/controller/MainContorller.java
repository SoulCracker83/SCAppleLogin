package com.yongyong.sc.controller;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jwt.*;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.StringReader;
import java.security.interfaces.RSAPublicKey;

@Controller
public class MainContorller {

    @RequestMapping(value = "/")
    public String main(){

        return "index.html";
    }

//    @RequestMapping(value = "/appleLoginCallBack")
//    @ResponseBody
//    public TokenResponse servicesRedirect(ServicesResponse serviceResponse) {
//
//        if (serviceResponse == null) {
//            return null;
//        }
//
//        String code = serviceResponse.getCode();
//        String client_secret = appleService.getAppleClientSecret(serviceResponse.getId_token());
//
//        System.out.println("================================");
//        System.out.println("id_token ‣ " + serviceResponse.getId_token());
//        System.out.println("payload ‣ " + appleService.getPayload(serviceResponse.getId_token()));
//        System.out.println("client_secret ‣ " + client_secret);
//        System.out.println("================================");
//
//        return appleService.requestCodeValidations(client_secret, code, null);
//    }

    @RequestMapping(value = "/appleLoginCallBack")
    public ResponseEntity<String> handleAppleLogin(@RequestBody String idToken) {

        System.out.println("idToken : " + idToken);
        return ResponseEntity.ok("OK");
//        try {
//            // 애플 서버의 공개 키를 사용하여 JWT 검증
//            JWSObject jwsObject = JWSObject.parse(idToken);
//
//            PEMParser pemParser = new PEMParser(new StringReader(""));
//            JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
//            SubjectPublicKeyInfo publicKeyInfo = (SubjectPublicKeyInfo) pemParser.readObject();
//            JWSVerifier verifier = new RSASSAVerifier((RSAPublicKey) converter.getPublicKey(publicKeyInfo));
//
//            if (jwsObject.verify(verifier)) {
//                // JWT 검증 성공
//                JWTClaimsSet claimsSet = jwsObject.getJWTClaimsSet();
//                // 클라이언트에서 전달한 사용자 정보나 토큰의 유효성을 확인하고 필요한 처리 수행
//                // 예를 들어, 사용자 정보를 DB에 저장하거나 세션을 생성할 수 있습니다.
//                // 검증이 성공하면 사용자 식별자를 반환
//                String userId = claimsSet.getStringClaim("sub");
//
//                // 필요한 추가 처리 수행
//
//                return ResponseEntity.ok(userId);
//            } else {
//                // JWT 검증 실패
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid ID token");
//            }
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
//        }
    }

}

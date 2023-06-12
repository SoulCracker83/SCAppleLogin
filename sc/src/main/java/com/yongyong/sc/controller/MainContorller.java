package com.yongyong.sc.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.auth0.jwt.JWT;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class MainContorller {

    @RequestMapping(value = "/")
    public String main(){

//        String idToken = "eyJraWQiOiJmaDZCczhDIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJodHRwczovL2FwcGxlaWQuYXBwbGUuY29tIiwiYXVkIjoiY29tLnBheWFwcGNhZmUiLCJleHAiOjE2ODYzNzU1MjAsImlhdCI6MTY4NjI4OTEyMCwic3ViIjoiMDAxMDgyLjY4YmJhNDI0ZjhiNzQ1OTQ4ZDM5OWExYzk2NWI0ZWMxLjAxNTciLCJjX2hhc2giOiJqUDFMRmJhZEUwSGctdjJuTUpyOGpBIiwiZW1haWwiOiJhaW4wNjMwQG5hdmVyLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjoidHJ1ZSIsImF1dGhfdGltZSI6MTY4NjI4OTEyMCwibm9uY2Vfc3VwcG9ydGVkIjp0cnVlfQ.kpngr6OwDDROHV-g8f4hbfKmzZ4OaYr5r8CrAJH1C6PAfsuk_NnUraqOyglAViGQAHxJiBk-3xXXhkxpXV96xWdFPN7S95x32_rTSvfxsrXE1S4sqVG35ygBqTHZvARY9kGeTr1nj-llGSo4-pZfBmgEJLIz0uMHcXMP2Pcdlqg3YFsAcCsKeRAg-mdF1ivkYoC-7lAxKYGk8iWHEDxv7TkEeYHT6n39aXdG1BQ_8HWMfg701F6DmmOmAUWBkLV_sBUKdOCOG2KCJrfYZp1_wYLHE1LGsaQbskpEzXQqkuYL_UNKGhnBSur_DLH-G0_c6ci2HFOq6bvsjGeiIDdRHA";
//
//        DecodedJWT decodedJWT = JWT.decode(idToken);
//
//        String userId = decodedJWT.getSubject();
//        String email = decodedJWT.getClaim("email").asString();
//        String name = decodedJWT.getClaim("name").asString();
//        System.out.println("userId : " + userId);
//        System.out.println("email : " + email);
//        System.out.println("name : " + name);


        return "index.html";
    }

    @RequestMapping(value = "/appleLoginCallBack", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public ResponseEntity<String> handleAppleLogin(@RequestBody Map<String, String> payload) {

        System.out.println("payload : " + payload);

//        DecodedJWT decodedJWT = JWT.decode(idToken);
//
//        String userId = decodedJWT.getSubject();
//        String email = decodedJWT.getClaim("email").asString();
//        String name = decodedJWT.getClaim("name").asString();
//
//        System.out.println("userId : " + userId);
//        System.out.println("email : " + email);
//        System.out.println("name : " + name);

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

package com.yongyong.sc.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yongyong.sc.vo.AppleIdTokenPayload;
import com.yongyong.sc.vo.AppleLoginUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RequiredArgsConstructor
@Controller
public class MainContorller {

    private final ObjectMapper objectMapper;

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

        return "index";
    }
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, Model model) {
        String strJson = "{\"name\":{\"firstName\":\"kwangyong\",\"lastName\":\"kim\"},\"email\":\"ain0630@naver.com\"}";

        String idToken = "eyJpc3MiOiJodHRwczovL2FwcGxlaWQuYXBwbGUuY29tIiwiYXVkIjoiY29tLnBheWFwcGNhZmUiLCJleHAiOjE2ODY3ODg3ODcsImlhdCI6MTY4NjcwMjM4Nywic3ViIjoiMDAxMDgyLjY4YmJhNDI0ZjhiNzQ1OTQ4ZDM5OWExYzk2NWI0ZWMxLjAxNTciLCJjX2hhc2giOiJoQThPYVU5dm9HbGxLRzd5UU9iUVRBIiwiZW1haWwiOiJhaW4wNjMwQG5hdmVyLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjoidHJ1ZSIsImF1dGhfdGltZSI6MTY4NjcwMjM4Nywibm9uY2Vfc3VwcG9ydGVkIjp0cnVlfQ";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] headDecodedBytes = decoder.decode(idToken);
        System.out.println("인코딩 전 : " + new String(headDecodedBytes));
//
//        String[] jwt = idToken.split("[.]");
//        Base64.Decoder decoder = Base64.getDecoder();
//
//        byte[] headDecodedBytes = decoder.decode(jwt[0]);
//        System.out.println("인코딩 전 : " + new String(headDecodedBytes));
//        byte[] payloadDecodedBytes = decoder.decode(jwt[1]);
//        System.out.println("인코딩 전 : " + new String(payloadDecodedBytes));
//
//        DecodedJWT decodedJWT = JWT.decode(idToken);
//
//        String userId = decodedJWT.getSubject();
//        String email = decodedJWT.getClaim("email").asString();
//        String name = decodedJWT.getClaim("name").asString();
//
//        System.out.println("userId : " + userId);
//        System.out.println("email : " + email);
//        if(null != name) {
//            System.out.println("name : " + name);
//        }
//        else {
//            name = "";
//            System.out.println("name is null");
//        }
//        model.addAttribute("userId",userId);
//        model.addAttribute("email",email);
//        model.addAttribute("name",name);

        return "result";
    }


    @RequestMapping(value = "/appleLoginCallBack")
    public String handleAppleLogin(HttpServletRequest request, Model model) {
        String idToken = request.getParameter("id_token");
        if(null == idToken || idToken.isEmpty()) {
            model.addAttribute("userId","");
            model.addAttribute("email","");
            model.addAttribute("name","");
        } else {
            String user = request.getParameter("user");
            System.out.println("id_token : " + idToken);
            System.out.println("user : " + user);

            AppleLoginUserInfo appleLoginUserInfo = null;
            if(null != user) {
                // 최초 로그인
                Gson gson = new GsonBuilder().create();
                appleLoginUserInfo = gson.fromJson(user, AppleLoginUserInfo.class);
                model.addAttribute("name",appleLoginUserInfo.getName().getLastName() +" "+ appleLoginUserInfo.getName().getFirstName());
            } else {
                // 2번쨰 이후 로그인..
                model.addAttribute("name","");
            }

            AppleIdTokenPayload appleIdTokenPayloadVO = convert(idToken, AppleIdTokenPayload.class);
            System.out.println("AppleIdTokenPayload id : " + appleIdTokenPayloadVO.getSub());
            System.out.println("AppleIdTokenPayload email : " + appleIdTokenPayloadVO.getEmail());

            model.addAttribute("userId",appleIdTokenPayloadVO.getSub());
            model.addAttribute("email",appleIdTokenPayloadVO.getEmail());
        }

        return "result";
    }

    private <T> T convert(String idToken, Class<T> toClass) {
        DecodedJWT decode = JWT.decode(idToken);
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println("payload data : " + decode.getPayload());
        byte[] payloadBytes = decoder.decode(decode.getPayload());
        String strPayload = new String(payloadBytes);
        System.out.println("payload json data : " + strPayload);

        try {
            return objectMapper.readValue(strPayload, toClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

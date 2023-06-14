package com.yongyong.sc.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
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

        return "index";
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
            if(null != user) {
                // 최초 로그인
                Gson gson = new GsonBuilder().create();
                try {
                    AppleLoginUserInfo appleLoginUserInfo = gson.fromJson(user, AppleLoginUserInfo.class);
                    model.addAttribute("name",appleLoginUserInfo.getName().getLastName() +" "+ appleLoginUserInfo.getName().getFirstName());
                } catch (JsonSyntaxException e) {
                    model.addAttribute("name","");
                }
            } else {
                // 2번쨰 이후 로그인..
                model.addAttribute("name","");
            }

            AppleIdTokenPayload appleIdTokenPayloadVO = convert(idToken, AppleIdTokenPayload.class);
            if(null != appleIdTokenPayloadVO) {
                model.addAttribute("userId",appleIdTokenPayloadVO.getSub());
                model.addAttribute("email",appleIdTokenPayloadVO.getEmail());
            } else {
                model.addAttribute("userId","");
                model.addAttribute("email","");
            }
        }

        return "result";
    }

    private <T> T convert(String idToken, Class<T> toClass) {
        DecodedJWT decode = JWT.decode(idToken);
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] payloadBytes = decoder.decode(decode.getPayload());
        String strPayload = new String(payloadBytes);

        try {
            return objectMapper.readValue(strPayload, toClass);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}

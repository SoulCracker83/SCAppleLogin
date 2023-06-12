package com.yongyong.sc.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;

import javax.servlet.http.HttpServletRequest;
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

        return "index";
    }
    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request, Model model) {
        String idToken = "eyJraWQiOiJmaDZCczhDIiwiYWxnIjoiUlMyNTYifQ.eyJpc3MiOiJodHRwczovL2FwcGxlaWQuYXBwbGUuY29tIiwiYXVkIjoiY29tLnBheWFwcGNhZmUiLCJleHAiOjE2ODYzNzU1MjAsImlhdCI6MTY4NjI4OTEyMCwic3ViIjoiMDAxMDgyLjY4YmJhNDI0ZjhiNzQ1OTQ4ZDM5OWExYzk2NWI0ZWMxLjAxNTciLCJjX2hhc2giOiJqUDFMRmJhZEUwSGctdjJuTUpyOGpBIiwiZW1haWwiOiJhaW4wNjMwQG5hdmVyLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjoidHJ1ZSIsImF1dGhfdGltZSI6MTY4NjI4OTEyMCwibm9uY2Vfc3VwcG9ydGVkIjp0cnVlfQ.kpngr6OwDDROHV-g8f4hbfKmzZ4OaYr5r8CrAJH1C6PAfsuk_NnUraqOyglAViGQAHxJiBk-3xXXhkxpXV96xWdFPN7S95x32_rTSvfxsrXE1S4sqVG35ygBqTHZvARY9kGeTr1nj-llGSo4-pZfBmgEJLIz0uMHcXMP2Pcdlqg3YFsAcCsKeRAg-mdF1ivkYoC-7lAxKYGk8iWHEDxv7TkEeYHT6n39aXdG1BQ_8HWMfg701F6DmmOmAUWBkLV_sBUKdOCOG2KCJrfYZp1_wYLHE1LGsaQbskpEzXQqkuYL_UNKGhnBSur_DLH-G0_c6ci2HFOq6bvsjGeiIDdRHA";

        DecodedJWT decodedJWT = JWT.decode(idToken);

        String userId = decodedJWT.getSubject();
        String email = decodedJWT.getClaim("email").asString();
        String name = decodedJWT.getClaim("name").asString();

        System.out.println("userId : " + userId);
        System.out.println("email : " + email);
        if(null != name) {
            System.out.println("name : " + name);
        }
        else {
            name = "";
            System.out.println("name is null");
        }
        model.addAttribute("userId",userId);
        model.addAttribute("email",email);
        model.addAttribute("name",name);

        return "result";
    }


    @RequestMapping(value = "/appleLoginCallBack")
    public String handleAppleLogin(HttpServletRequest request, Model model) {

        System.out.println("id_token : " + request.getParameter("id_token"));

//        System.out.println("size : " + payload.size());
//        System.out.println("payload : " + payload);
//        System.out.println("state : " + payload.get("state"));
//        System.out.println("id_token : " + payload.get("id_token"));
//        System.out.println("code : " + payload.get("code"));
//
//        DecodedJWT decodedJWT = JWT.decode(payload.get("id_token"));
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

}

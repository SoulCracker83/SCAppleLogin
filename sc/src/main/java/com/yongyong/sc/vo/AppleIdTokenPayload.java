package com.yongyong.sc.vo;

import lombok.Data;

@Data
public class AppleIdTokenPayload {
    private String iss;
    private String aud;
    // id
    private String sub;
    private String c_hash;
    // email
    private String email;
    private String email_verified;
    private long exp;
    private long iat;
    private long auth_time;
    private boolean nonce_supported;
}

package com.yongyong.sc.vo;

import lombok.Data;

@Data
public class AppleIdTokenPayload {
    private String iss;
    private String aud;
    /** ID */
    private String sub;
    private String c_hash;
    /** EMAIL */
    private String email;
    private String email_verified;
    /** 토큰 만료 시간 */
    private long exp;
    /** 토큰 생성 시간 */
    private long iat;
    private long auth_time;
    private boolean nonce_supported;
}

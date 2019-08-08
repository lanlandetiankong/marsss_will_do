package com.marsss.marsss_will_do.bean.user;

public class UserToken {
    private String id ;
    private String userId ;

    private String sessionId ;
    private String md5Token ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMd5Token() {
        return md5Token;
    }

    public void setMd5Token(String md5Token) {
        this.md5Token = md5Token;
    }
}

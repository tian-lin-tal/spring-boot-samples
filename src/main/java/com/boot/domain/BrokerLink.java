package com.boot.domain;


/**
 * @author l.tian@aftership.com
 * @date 2020/6/8
 */
public class BrokerLink {
    private String identityProvider;
    private String userId;
    private String brokerUserId;

    public String getBrokerUserId() {
        return brokerUserId;
    }

    public void setBrokerUserId(String brokerUserId) {
        this.brokerUserId = brokerUserId;
    }

    public String getIdentityProvider() {
        return identityProvider;
    }

    public void setIdentityProvider(String identityProvider) {
        this.identityProvider = identityProvider;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

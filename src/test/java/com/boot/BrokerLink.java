package com.boot;

import java.util.Map;

/**
 * @author l.tian@aftership.com
 * @date 2020/8/21
 * {"providerId":"google","userId":"f:6f7e6de9-411b-43d1-8c63-cbce920a7f99:997d84f0437d49c4a24904771d269179","email":"business@zeroforfive.com","brokerUserId":"102166296194109667969","realm":"business"},
 */
public class BrokerLink {
    private String providerId;
    private String userId;
    private String email;
    private String brokerUserId;
    private String realm;

    private String accountEmail;

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrokerUserId() {
        return brokerUserId;
    }

    public void setBrokerUserId(String brokerUserId) {
        this.brokerUserId = brokerUserId;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    @Override
    public String toString() {
        return "BrokerLink{" +
                "providerId='" + providerId + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", brokerUserId='" + brokerUserId + '\'' +
                ", realm='" + realm + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                '}';
    }
}

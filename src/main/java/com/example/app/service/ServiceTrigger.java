package com.example.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ServiceTrigger {
    private static final Logger log = LoggerFactory.getLogger(ServiceTrigger.class);
    private GenerateLongTermAccessTokenGoogleOauth2 generateLongTermAccessTokenGoogleOauth2;

    @Value("${google.api.clientid}")
    private String clientId;

    @Value("${google.api.clientsecret}")
    private String clientSecret;

    @Value("${google.api.authuri}")
    private String authUri;

    @Value("${google.api.tokenuri}")
    private String tokenUri;

    @Value("${google.api.redirecturi}")
    private String redirectUri;

    public ServiceTrigger(GenerateLongTermAccessTokenGoogleOauth2 generateLongTermAccessTokenGoogleOauth2){
        this.generateLongTermAccessTokenGoogleOauth2 = generateLongTermAccessTokenGoogleOauth2;
    }

    public void TriggerService(){
    try{
    //Initialization Logs
    log.info("Begining to Get Authorization TOken");

    //Trigger Services
    //Generate Token
    String LongTermToken = generateLongTermAccessTokenGoogleOauth2.getRefreshToken(clientId, clientSecret, authUri, tokenUri, redirectUri);
    log.info("The value of the LongLivedToken is: " + LongTermToken);

    } catch (Exception e){
        log.error("Error getting token, Please verify that all environment variables are specified in application.yml: " + e.getMessage());
        }
    }
}

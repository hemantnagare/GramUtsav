package com.gramutsav.config;

import com.phonepe.sdk.pg.Env;
import com.phonepe.sdk.pg.payments.v2.StandardCheckoutClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhonePeConfig {

    private final String clientId = "M22D6AQH6RE1N_2605231506";
    private final String clientSecret = "OWJjMjRmNDgtNjcxZS00YTk1LTlkY2MtNGNmNDQyMzcyY2I1";
    private final Integer clientVersion = 1;


    @Bean
    public StandardCheckoutClient phonePeClient() {

        return StandardCheckoutClient.getInstance(
                clientId,
                clientSecret,
                clientVersion,
                Env.SANDBOX   // change to PRODUCTION later
        );
    }
}
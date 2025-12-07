//package com.hrservices.hrservicesbackend.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.*;
//
//@Configuration
//public class CorsConfig {
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("https://hr-services-av80ql2pw-abhinav-jains-projects-3d191c7f.vercel.app");
//        config.addAllowedOriginPattern("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//}
package com.hrservices.hrservicesbackend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;
        import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow your exact frontend origin(s).
        // Use allowed origin patterns if you need subdomain wildcards, e.g. "https://*.vercel.app"
        config.setAllowedOrigins(List.of(
                "https://hr-services-av80ql2pw-abhinav-jains-projects-3d191c7f.vercel.app"
        ));

        // OR, if you need to support any vercel preview subdomain, use patterns instead:
        // config.setAllowedOriginPatterns(List.of("https://*.vercel.app"));

        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}

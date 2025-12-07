package com.hrservices.hrservicesbackend.Config;

import com.hrservices.hrservicesbackend.Entity.IntegrationRecord;
import com.hrservices.hrservicesbackend.Repositories.IntegrationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {
    @Bean
    CommandLineRunner seedIntegrations(IntegrationRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(make("Google Workspace", "API-KEY-GOOGLE", "Email/Calendar sync", "https://logo.clearbit.com/google.com"));
                repo.save(make("Microsoft 365", "API-KEY-MS", "Outlook/Teams", "https://logo.clearbit.com/microsoft.com"));
                repo.save(make("Slack", "API-KEY-SLACK", "Notifications", "https://logo.clearbit.com/slack.com"));
            }
        };
    }

    private IntegrationRecord make(String name, String key, String desc, String logo) {
        IntegrationRecord i = new IntegrationRecord();
        i.setSystemName(name);
        i.setApiKey(key);
        i.setDescription(desc);
        i.setLogoUrl(logo);
        i.setConnected(false);
        return i;
    }
}
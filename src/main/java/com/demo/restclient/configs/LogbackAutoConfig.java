package com.demo.restclient.configs;

import org.concepts.scheduler.LogbackAutoconfigureScheduler;
import org.concepts.services.LogbackAutoconfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogbackAutoConfig {
    @Value("${minio.bucket}")
    private String bucketName;

    @Value("${minio.file-path}")
    private String filePath;

    @Value("${minio.endpoint}")
    private String minioEndpoint;

    @Value("${minio.access-key}")
    private String minioAccessKey;

    @Value("${minio.secret-key}")
    private String minioSecretKey;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public LogbackAutoconfigureScheduler getLogbackAutoconfigureScheduler() {
        LogbackAutoconfigService logbackAutoconfigService = new LogbackAutoconfigService(minioEndpoint, minioAccessKey,
                minioSecretKey, bucketName, filePath);
        return new LogbackAutoconfigureScheduler(logbackAutoconfigService);
    }
}

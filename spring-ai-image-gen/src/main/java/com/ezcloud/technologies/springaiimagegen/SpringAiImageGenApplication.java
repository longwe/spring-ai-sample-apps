package com.ezcloud.technologies.springaiimagegen;

import org.springframework.ai.image.ImageClient;
import org.springframework.ai.openai.OpenAiImageClient;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringAiImageGenApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAiImageGenApplication.class, args);


    }
    @Bean
    public ImageClient imageClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
        OpenAiImageApi openAiImageApi = new OpenAiImageApi(apiKey);
        return new OpenAiImageClient(openAiImageApi);
    }
}

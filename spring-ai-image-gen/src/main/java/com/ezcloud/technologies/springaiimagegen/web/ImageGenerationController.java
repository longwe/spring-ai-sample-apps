package com.ezcloud.technologies.springaiimagegen.web;

import com.ezcloud.technologies.springaiimagegen.model.ImageGenetationRequest;
import org.springframework.ai.image.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ImageGenerationController {

    private final ImageClient imageClient;

    public ImageGenerationController(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    @PostMapping("/api/v1/genimage")
    public String generateImage(@RequestBody ImageGenetationRequest prompt) {
        ImageOptions imageOptions = ImageOptionsBuilder.builder()
                .withModel("dall-e-3")
                .build();
        ImagePrompt imagePrompt = new ImagePrompt(prompt.prompt(), imageOptions);
        ImageResponse imageResponse = imageClient.call(imagePrompt);
        var imageUrl = imageResponse.getResult().getOutput().getUrl();
        return "redirect:" + imageUrl;
    }
}

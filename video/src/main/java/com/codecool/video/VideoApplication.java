package com.codecool.video;

import com.codecool.video.controller.repository.VideoRepository;
import com.codecool.video.model.Video;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/video/**"))
				.build();
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner init(VideoRepository repository) {
		return args -> {
			repository.save(Video.builder()
					.name("Answer to life")
					.url("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
					.build()
			);

			repository.save(Video.builder()
					.name("AssClap")
					.url("https://www.youtube.com/watch?v=NdqbI0_0GsM")
					.build()
			);

			repository.save(Video.builder()
					.name("Moist")
					.url("https://www.youtube.com/watch?v=E11YwzpmLfU")
					.build()
			);

			repository.save(Video.builder()
					.name("Ding Dong")
					.url("https://www.youtube.com/watch?v=iPrnduGtgmc")
					.build()
			);
		};
	}
}

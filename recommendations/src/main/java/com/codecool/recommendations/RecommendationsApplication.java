package com.codecool.recommendations;

import com.codecool.recommendations.controller.repository.RecommendationRepository;
import com.codecool.recommendations.model.Recommendation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class RecommendationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommendationsApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/recommendation/**"))
				.build();
	}

	@Bean
	public CommandLineRunner init(RecommendationRepository repository) {
		return args -> {
			repository.save(Recommendation.builder()
					.videoId(1L)
					.comment("This is simply amazing!")
					.rating(5)
					.build()
			);
			repository.save(Recommendation.builder()
					.videoId(1L)
					.comment("The answer to the universe")
					.rating(5)
					.build()
			);
			repository.save(Recommendation.builder()
					.videoId(1L)
					.comment("WOW!!!1!!1!1!!1!!!!!!111!")
					.rating(5)
					.build()
			);
			repository.save(Recommendation.builder()
					.videoId(1L)
					.comment("Simply mindblowing!")
					.rating(5)
					.build()
			);
		};
	}
}

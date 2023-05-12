package kr.ziz.ecommercemall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OttMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(OttMallApplication.class, args);
    }
}

package redis.testredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestRedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestRedisApplication.class, args);
    }



}

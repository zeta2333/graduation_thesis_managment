package usts.cs2020;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-21 3:56 PM
 */
@SpringBootApplication
@MapperScan("usts.cs2020.mapper")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}

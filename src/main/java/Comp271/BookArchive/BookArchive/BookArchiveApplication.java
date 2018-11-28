package Comp271.BookArchive.BookArchive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BookArchiveApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookArchiveApplication.class, args);
	}
}

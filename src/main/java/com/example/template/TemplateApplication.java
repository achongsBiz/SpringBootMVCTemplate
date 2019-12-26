package com.example.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TemplateApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(TemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {

		// Data prop any tables and data you want loaded into H2 here.
		// You can use the pattern below:

		log.info("Creating example table");
		jdbcTemplate.execute("DROP TABLE sampleTab IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE sampleTab(id SERIAL,  description VARCHAR(100))");
		jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('gym')");
		jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('ultraviolet radiation')");
		jdbcTemplate.execute("INSERT INTO sampleTab(description) VALUES ('laundry')");

	}
}

package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
public class TodoApplication {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder()
				// Does not it need to add "addScripts"
				// because schema.sql and data.sql read automatically?
				// .addScripts("schema.sql", "data.sql")
				.setType(EmbeddedDatabaseType.H2).build();
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}

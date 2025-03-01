package com.ecommerce_backend.Ecommerce.Backend.Project.config;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseHealthCheck {

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void checkDatabaseHealth() {

		try(
				Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();

				) {

			boolean isConnected = statement.execute("select 1");
			System.out.println("Database Connection Successful");


		} catch (Exception e) {
			System.err.println("Database Connection Failed: " + e.getMessage());	
		}
	}

}

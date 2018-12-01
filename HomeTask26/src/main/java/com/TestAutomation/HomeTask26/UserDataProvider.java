package com.TestAutomation.HomeTask26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDataProvider {

	public static User getUserData() throws NumberFormatException, SQLException {
		String url = "jdbc:mysql://localhost:3306/mail?useSSL=false&serverTimezone=UTC";
		String login = "root";
		String password = "parabellum";
		String query = "SELECT * from mail.data;";

		ResultSet resultSet = getResultSet(url, login, password, query);
		return getUser(resultSet);
	}

	private static User getUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		resultSet.next();
		user.setId(Integer.parseInt(resultSet.getString(1)));
		user.setLogin(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		return user;

	}

	private static ResultSet getResultSet(String url, String login, String password, String query) throws SQLException {
		ResultSet resultSet = null;
		Connection connection = DriverManager.getConnection(url, login, password);
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		return resultSet;
	}
}

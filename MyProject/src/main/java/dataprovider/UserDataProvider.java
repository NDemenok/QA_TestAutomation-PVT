package dataprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businessobject.User;

public class UserDataProvider {

	private static final String URL = "jdbc:mysql://localhost:3306/mail?useSSL=false&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "parabellum";

	public static User getUserData() throws NumberFormatException, SQLException, ClassNotFoundException {
		String query = "SELECT * from mail.data;";
		ResultSet resultSet = getResultSet(query);
		return getUser(resultSet);
	}

	private static User getUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		resultSet.next();
		user.setLogin(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		return user;
	}

	private static ResultSet getResultSet(String query) throws SQLException, ClassNotFoundException {
		ResultSet resultSet = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery(query);
		return resultSet;
	}
}

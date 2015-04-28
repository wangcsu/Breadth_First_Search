import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBase {
	private static final String driverName = "org.sqlite.JDBC";
	private String url = "jdbc:sqlite:../sqlite/";
	private String dbname;

	public DataBase(String name) {
		 dbname = name;
		 url = url + dbname;
	}
	public ResultSet execute(String query) {
		ResultSet rs = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();
			stmt.execute(query);
			rs = stmt.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}

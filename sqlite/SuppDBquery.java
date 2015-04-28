import java.sql.*;
public class SuppDBquery {
  public static void main(String args[]) {
    try {
      // 1: load specific code to talk to mysql
      Class.forName("org.sqlite.JDBC");

      // 2: establish connection to file (DB) using protocol, file loacation
      // This connection is for java files on ex1, ex2, etc.
      // Connection con = DriverManager.getConnection("jdbc:sqlite:../sqlite/SuppDB");
      // This connection is for SuppDBquery located on the sqlite dir itself
      Connection con = DriverManager.getConnection("jdbc:sqlite:SuppDB");

      // 3: environment for queries
      Statement stmt = con.createStatement();

      // 4: SQL query of a supplier table
      stmt.execute("select * from S where STATUS > 10");

      // 5: rs encapsulates rows which match the query
      ResultSet rs = stmt.getResultSet();

      // 6: iterate through the rows with a cursor
      //    next() returns false when cursor goes beyond results
      while (rs.next()) {

         // 7: extract columns from the row pointed to by the cursor
         System.out.println(rs.getString("S_NO") + " " + rs.getInt("STATUS"));
      }
      // 8: closes READ action, allows READ or WRITE action later
      rs.close();
    } catch (Exception e) {System.out.println(e.getMessage());}
  }
}


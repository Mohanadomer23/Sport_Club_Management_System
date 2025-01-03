package DB;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sportingclub.Tools;
import sportingclub.Tools.Table;
import java.sql.Date;

public class go {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root"; // Externalize these credentials for production
    private static final String PASSWORD = "";
    private static Connection con;

    // Establishes a database connection
    private static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, "Error establishing connection", ex);
            Tools.msgBox("Database connection failed: " + ex.getMessage());
        }
        return con;
    }

    // Closes the database connection
    private static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.WARNING, "Error closing connection", ex);
        }
    }

    // Secure user and password check using PreparedStatement
    public static boolean checkUserAndPass(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND pass = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Tools.msgBox("Error: " + ex.getMessage());
        }
        return false;
    }

    // Executes non-query SQL statements
    public static boolean runNonQuery(String sqlStatement) {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlStatement);
            return true;
        } catch (SQLException ex) {
            Tools.msgBox("Error: " + ex.getMessage());
            return false;
        }
    }
    public static String getAutoNumber(String tableName, String columnName)
    {
     try{
         getConnection();
         Statement stmt = con.createStatement();
         String strAuto = "select max(" + columnName + ")+1 as autonum" + " from " + tableName;
         stmt.executeQuery(strAuto);
         String Num = "";
         while(stmt.getResultSet().next())
         {
         Num=stmt.getResultSet().getString("autonum");
     }
     if(Num==null|| "".equals(Num))
     {
         return "1";
     }
     else
         return Num;
     }
     catch(SQLException ex)
     {
         Tools.msgBox(ex.getMessage());
        
             return "0";
     }
    }
    public static Table getTableData(String statement)
    {
           Tools t = new Tools();
          try
          {
              getConnection();
              Statement stmt = con.createStatement();
              ResultSet rs;
              rs = stmt.executeQuery(statement);
              
              ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
              int c = rsmd.getColumnCount();
              
              Table table = new Table(c);
              while(rs.next())
              {
                  Object row[]= new Object[c];
                  for(int i=0;i<c;i++)
                  {
                      row[i]= rs.getString(i+1);
                  }
                  table.addNewRow(row);
          }
              return table;
          }
          catch(SQLException ex)
            {
                Tools.msgBox(ex.getMessage());
                return new Table(0);
            }
    }

  
    public static void fillCombo(String tableName,String columnName,JComboBox combo)
    {
        try
        {
            getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs;
            
            String strSelect = "select " + columnName + " from " + tableName;
            rs = stmt.executeQuery(strSelect);
            // let the cursor at last row
            rs.last();
            int c = rs.getRow();
            // let the curlsor at the begining
            rs.beforeFirst();
            String values[] = new String[c];
            int i=0;
            while(rs.next())
            {
                values[i]=rs.getString(1);
                i++;
                
            }
            //con.close();
            combo.setModel(new DefaultComboBoxModel(values));
            
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
        }
    }
    
    public static void fillToJTable(String tableNameOrSelectStatement, JTable table)
    {
        try
        {
            getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String SPart = tableNameOrSelectStatement.substring(0,7).toLowerCase();
            String strSelect;
            if("select ".equals(SPart))
            {
               strSelect =  tableNameOrSelectStatement;
            }
            else{
                strSelect = "select * from " + tableNameOrSelectStatement;
            }
            rs = stmt.executeQuery(strSelect);
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int c = rsmd.getColumnCount();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Vector row = new Vector();
            model.setRowCount(0);
            //while for rows and for for columns
            while(rs.next())
            {
                row = new Vector(c);
                for(int i=1;i<=c;i++)
                {
                    row.add(rs.getString(i));
                }
                model.addRow(row);
            }
            if(table.getColumnCount() != c)
            {
                Tools.msgBox("JTable columns Count Not Equal To Query Columns Count\nJtable Columns Count Is: " + table.getColumnCount() + "\nQuery Columns Count Is: " + c);
            }
            con.close();
        }
        catch(SQLException ex)
        {
            Tools.msgBox(ex.getMessage());
        }
    }
 
  public static boolean checkUserExists(String username) { 
    Connection connection = null; 
    Statement statement = null; 
    ResultSet resultSet = null; 
    boolean exists = false; 
 
    try { 
      // Load the MySQL JDBC driver 
      Class.forName("com.mysql.jdbc.Driver"); 
 
      // Connect to the database 
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "user", "password"); 
 
      // Create a statement 
      statement = connection.createStatement(); 
 
      // Execute the query 
      resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'"); 
 
      // Check if the user exists 
      if (resultSet.next()) { 
        exists = true; 
      } 
 
    } catch (ClassNotFoundException e) { 
      e.printStackTrace(); 
    } catch (SQLException e) { 
      e.printStackTrace(); 
    } finally { 
      try { 
        if (resultSet != null) { 
          resultSet.close(); 
        } 
        if (statement != null) { 
          statement.close(); 
        } 
        if (connection != null) { 
          connection.close(); 
        } 
      } catch (SQLException e) { 
        e.printStackTrace(); 
      } 
    } 
 
    return exists; 
  } 
}
    

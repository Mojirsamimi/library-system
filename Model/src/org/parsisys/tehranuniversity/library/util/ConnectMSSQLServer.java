package org.parsisys.tehranuniversity.library.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class ConnectMSSQLServer
{
   public void dbConnect(String db_connect_string,
            String db_userid,
            String db_password)
   {
     CallableStatement cstmt=null;
     Connection conn =null;
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          conn = DriverManager.getConnection(db_connect_string,
                  db_userid, db_password);
         System.out.println("connected");
//         Statement statement = conn.createStatement();
//         String queryString = "select * from sysobjects";
//         ResultSet rs = statement.executeQuery(queryString);
//         while (rs.next()) {
//            System.out.println(rs.getString(1));
//         }
           
       cstmt = conn.prepareCall("{? = call dbo.fx0269_stdauth(?,?,?)}");
      cstmt.registerOutParameter(1, Types.CHAR);
      cstmt.setString(2, "910389074");
        cstmt.setString(3, "1234567");
        cstmt.setInt(4, 910389074);
      cstmt.execute();
      System.out.println("RETURN STATUS: " + cstmt.getString(1));
      cstmt.close();
 conn.close();
  
      } catch (Exception e) {
         e.printStackTrace();
        
                try {
                  if(cstmt!=null)
                    cstmt.close();
                    if(conn!=null)
                        conn.close();
                } catch (SQLException f) {
                    f.printStackTrace();
                }
        }
   }
 
   public static void main(String[] args)
   {
      ConnectMSSQLServer connServer = new ConnectMSSQLServer();
      connServer.dbConnect("jdbc:sqlserver://192.168.111.111:1070;databaseName=UtGol;", "Libuser",
               "LB*#17QTS");
   }
}

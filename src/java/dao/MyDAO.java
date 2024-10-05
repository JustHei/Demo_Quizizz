package dao;
// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com

import DB.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class MyDAO extends DBContext {
  public Connection con = null;
  public PreparedStatement ps = null;
  public ResultSet rs = null;
  public String xSql = null;

  public MyDAO() {
     con = connection;
  }
  public void finalize() {
     try {
        if(con != null) con.close();
     }
     catch(Exception e) {
        e.printStackTrace();
     }
  }
    
}

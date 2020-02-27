package com.eomcs.sql;

import java.sql.Connection;
import com.eomcs.util.DataSource;

public class PlatformTransactionManager {


  DataSource dataSource;

  public PlatformTransactionManager(DataSource conFactory) {
    this.dataSource = conFactory;
  }

  public void beginTransaction() throws Exception {
    Connection con = dataSource.getConnection();

    con.setAutoCommit(false);
  }

  public void commit() throws Exception {
    Connection con = dataSource.getConnection();

    con.commit();
    con.setAutoCommit(true);
  }

  public void rollback() throws Exception {
    Connection con = dataSource.getConnection();

    con.rollback();
    con.setAutoCommit(true);
  }
}

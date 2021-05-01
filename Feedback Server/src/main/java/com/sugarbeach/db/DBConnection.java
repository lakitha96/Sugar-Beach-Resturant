package com.sugarbeach.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Lakitha Prabudh on 3/11/21
 */
public class DBConnection {
    public static String dbUrl = "jdbc:mysql://localhost:3306/sugar_beach?useSSL=false";

    public static String user = "admin-user";

    public static String password = "password";

    public static int maxPoolSize = 5;

    private static HikariDataSource ds;


    public static Connection getConnection() throws SQLException {
        if (ds == null) {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            config.setUsername(user);
            config.setPassword(password);
            config.setConnectionTestQuery("SELECT 1");
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("useSSL", "false");
            config.setMaximumPoolSize(maxPoolSize);
            config.setConnectionTimeout(10000);
            ds = new HikariDataSource(config);
            return ds.getConnection();
        }
        return ds.getConnection();
    }
}

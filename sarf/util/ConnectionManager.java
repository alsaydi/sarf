package sarf.util;

import java.sql.Connection;
import java.sql.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: «‰‘«¡ « ’«· „⁄ ﬁ«⁄œ… «·„⁄ÿÌ«     </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ConnectionManager {
    private ConnectionManager() {
        try {
            Class cl = Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            java.sql.Driver dr = (java.sql.Driver) cl.newInstance();
            java.sql.DriverManager.registerDriver(dr);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        catch (InstantiationException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static ConnectionManager instance = new ConnectionManager();

    /**
     * getInstance
     *
     * @return Object
     */
    public static ConnectionManager getInstance() {
        return instance;
    }

    /**
     * createNewConnection
     *
     * @return Connection
     */
    public Connection createNewConnection() {
        try {
            return DriverManager.getConnection("jdbc:odbc:tripleVerbs", " ", "");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Connection createNewConnection(String dbName) {
        try {
            return DriverManager.getConnection("jdbc:odbc:"+dbName, " ", "");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }


}

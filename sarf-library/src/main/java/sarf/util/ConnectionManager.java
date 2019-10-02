package sarf.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: انشاء اتصال مع قاعدة المعطيات    </p>
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
            java.sql.Driver dr = (java.sql.Driver) (cl.getConstructors()[0].newInstance());
            java.sql.DriverManager.registerDriver(dr);
        }
        catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }

    private static final ConnectionManager instance = new ConnectionManager();

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

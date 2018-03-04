package sarf.util;

import java.sql.*;
// ‰›Ì– «” ⁄·«„«  ⁄·Ï ﬁ«⁄œ… «·„⁄ÿÌ« 
public class QueryExecuter {

    private Connection connection;

    public QueryExecuter(String dbName) {
        connection = ConnectionManager.getInstance().createNewConnection(dbName);
    }

    public ResultSet executeQuery(String statement){
        try{
            //we do not parameter any things because they are not supported in all db engines
            Statement stmt = connection.createStatement();
            return  stmt.executeQuery(statement);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean executeAndClose(String sql) {
        try {
            executeQuery(sql).getStatement().close();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteAllFromTable(String tableName) {
        try {
            executeQuery("DELETE FROM "+tableName).getStatement().close();
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}

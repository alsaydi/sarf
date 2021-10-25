/*
 *
 * MIT License
 *
 * Copyright (c) 2021 Abdalaziz Alsaydi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SqlDatabaseWriter implements DatabaseWriter {

    private static final int SQL_QUERY_TIMEOUT_SECONDS = 2;
    private Connection sarfDbConnection;
    private String dbFilename;
    private final String insertSql = "INSERT INTO words(word, roots, voweledWords) VALUES(?, ?, ?);";

    public void init(String dbFilename) throws SQLException, FileAlreadyExistsException {
        this.dbFilename = dbFilename;
        if (Files.exists(Path.of(dbFilename))) {
            System.out.println("Database already exists");
            throw new FileAlreadyExistsException(dbFilename);
        }
        initialize();
    }

    public void write(HashMap<String, WordData> wordDataHashMap) throws SQLException {
        var keys = wordDataHashMap.keySet();
        for (var key : keys) {
            var roots = String.join(",", wordDataHashMap.get(key).getRoots());
            var voweledWords = String.join(",", wordDataHashMap.get(key).getVoweledForms());
            insert(key, roots, voweledWords);
        }
    }

    private void insert(String word, String roots, String voweledWords) throws SQLException {
        try {
            var statement = sarfDbConnection.prepareStatement(insertSql);
            statement.setQueryTimeout(SQL_QUERY_TIMEOUT_SECONDS);
            statement.setString(1, word);
            statement.setString(2, roots);
            statement.setString(2, voweledWords);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void close() {
        if (sarfDbConnection == null) {
            return;
        }
        try {
            sarfDbConnection.commit();
            sarfDbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize() throws SQLException {
        try {
            sarfDbConnection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbFilename));
            sarfDbConnection.setAutoCommit(false);
            Statement statement = sarfDbConnection.createStatement();
            statement.setQueryTimeout(SQL_QUERY_TIMEOUT_SECONDS);
            statement.executeUpdate("create table words (id integer, word string, roots string, voweledWords string)");
        } catch (SQLException e) {
            if (sarfDbConnection != null && !sarfDbConnection.isClosed()) {
                sarfDbConnection.close();
            }
            throw e;
        }
    }
}

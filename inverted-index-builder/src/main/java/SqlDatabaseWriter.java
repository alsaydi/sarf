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

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;

public class SqlDatabaseWriter implements DatabaseWriter {

    private static final int SQL_QUERY_TIMEOUT_SECONDS = 2;
    private Connection sarfDbConnection;
    private String dbFilename;
    private final String insertSql = "INSERT INTO words(word, roots) VALUES(?, ?);";

    public void init(String dbFilename) throws DatabaseWriterException {
        this.dbFilename = dbFilename;
        if (Files.exists(Path.of(dbFilename))) {
            throw new DatabaseWriterException(String.format("Database already exists, %s.", dbFilename));
        }
        initialize();
    }

    public void write(HashMap<String, WordData> verbSet, HashMap<String, WordData> nounSet)
            throws DatabaseWriterException {
        var keys = verbSet.keySet();
        for (var key : keys) {
            var nounRoots = new HashSet<String>();
            if (nounSet.containsKey(key)) {
                nounRoots = nounSet.get(key).getRoots();
            }
            var allRoots = verbSet.get(key).getRoots();
            allRoots.addAll(nounRoots);

            var roots = String.join(",", allRoots);
            insert(key, roots);
        }

        for (var key : nounSet.keySet()) {
            if (verbSet.containsKey(key)) {
                continue;
            }
            var roots = nounSet.get(key).getRoots();
            var rootsString = String.join(",", roots);
            insert(key, rootsString);
        }
    }

    private void insert(String word, String roots) throws DatabaseWriterException {
        try {
            var statement = sarfDbConnection.prepareStatement(insertSql);
            statement.setQueryTimeout(SQL_QUERY_TIMEOUT_SECONDS);
            statement.setString(1, word);
            statement.setString(2, roots);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseWriterException(e);
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

    private void initialize() throws DatabaseWriterException {
        try {
            sarfDbConnection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", dbFilename));
            sarfDbConnection.setAutoCommit(false);
            Statement statement = sarfDbConnection.createStatement();
            statement.setQueryTimeout(SQL_QUERY_TIMEOUT_SECONDS);
            statement.executeUpdate("create table words (id integer, word string, roots string)");
        } catch (SQLException e) {
            try {
                if (sarfDbConnection != null && !sarfDbConnection.isClosed()) {
                    sarfDbConnection.close();
                }
            } catch (SQLException e1) {
                System.err.println("Error closing database connection: " + e1.getMessage());
            }
            throw new DatabaseWriterException(e);
        }
    }
}

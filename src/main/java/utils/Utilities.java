package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Utilities {

    private static Connection con;
    public static Properties db_Config;

    public static void readConfig() throws IOException {

        db_Config = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\DBconfig.properties");

        db_Config.load(objfile);
    }

    public static void setConnection() {

        try {
            readConfig();

            con = DriverManager.getConnection(db_Config.getProperty("url"), db_Config.getProperty("user"), db_Config.getProperty("password"));//Establishing connection
            System.out.println("Connected With the database successfully");

        }
        catch (IOException e) {
            System.out.println("Error while connecting to the database");
        }
        catch (SQLException e) {
            System.out.println("Error while reading the db configs");
            e.printStackTrace();}
    }

    public static ResultSet getValues(String sqlQuery) {
        ResultSet resultSet;

        try {
            resultSet=con.createStatement().executeQuery(sqlQuery);

            System.out.println("Successfully fetched records from the database");
            return resultSet;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error while fetching records from the database");
            e.printStackTrace();
            return null;
        }

    }
    public static void closeConnection() throws SQLException {
        con.close();
    }
}

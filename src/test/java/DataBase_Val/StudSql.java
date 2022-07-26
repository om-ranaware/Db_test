package DataBase_Val;

import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudSql {

    static String getStudentSql="Select * from Student";

    public static void verifyStudName(ResultSet rs, String exp) throws SQLException {

        Assert.assertEquals(rs.getString("StudName"), exp,"Student name mismatch");

    }

    public static void verifyStudID(ResultSet rs, String exp) throws SQLException {

        Assert.assertEquals(rs.getInt("StudID"), exp,"Student ID mismatch");
    }


    public static void verifyDivision(ResultSet rs, String exp) throws SQLException {

        Assert.assertEquals(rs.getString("Division"), exp,"Division mismatch");

    }

    public static void verifyMarks(ResultSet rs, String exp) throws SQLException {

        Assert.assertEquals(rs.getString("Marks"), exp,"Marks not correct");
    }

}

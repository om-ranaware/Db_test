package DataBase_Val;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudTest {
    @BeforeClass
    public void startup() {

        Utilities.setConnection();
    }

    @AfterClass
    public void teardown() throws SQLException {

        Utilities.closeConnection();
    }
    @Test
    public void getStudTest() throws SQLException {

        ResultSet rs=Utilities.getValues(StudSql.getStudentSql);
        rs.next();
        StudSql.verifyStudName(rs, "Jems");
        StudSql.verifyStudID(rs, "01");

    }
}

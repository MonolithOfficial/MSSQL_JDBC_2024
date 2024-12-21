package ge.tbc.testautomation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbc.testautomation.data.DatabaseSteps;
import ge.tbc.testautomation.data.MSSQLConnection;
import ge.tbc.testautomation.data.UserDataProvider;
import ge.tbc.testautomation.data.UserModel;
import ge.tbc.testautomation.steps.LoginSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;

public class SauceDemoTest {
    DatabaseSteps databaseSteps;
    LoginSteps loginSteps;

    @BeforeClass
    public void setUp() {
        databaseSteps = new DatabaseSteps();
        loginSteps = new LoginSteps();
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        WebDriverManager.chromedriver().setup();
        open("https://www.saucedemo.com/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

//    @Test
//    public void testDb() {
//        HashMap<String, String> users = databaseSteps.getAllUsernamesAndPasswords();
//        System.out.println(users);
//    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "getUserData")
    public void testSauceDemo(String username, String password) {
        loginSteps
                .fillUsername(username)
                .fillPassword("secret_sauce");
    }

    @Test
    public void testModel() {
        UserModel user = databaseSteps.getSpecificUser();
        System.out.println(user);
    }
}

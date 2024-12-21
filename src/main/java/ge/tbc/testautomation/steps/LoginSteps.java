package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    public LoginSteps fillUsername(String username) {
        loginPage.usernameField.sendKeys(username);

        return this;
    }

    public LoginSteps fillPassword(String password) {
        loginPage.passwordField.sendKeys(password);

        return this;
    }
}

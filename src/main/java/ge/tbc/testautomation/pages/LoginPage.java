package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement usernameField = $("#user-name");
    public SelenideElement passwordField = $("#password");
}

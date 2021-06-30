package SkillUPPetProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private String loginPageLink;
    private static final By USERNAME_FIELD_LOCATOR = By.id("user-name");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("password");
    private static final By LOGIN_BUTTON_LOCATOR = By.id("login-button");
    private static final By ERROR_MESSAGE_LOCATOR = By.id("login-button");
    private static final By SHOP_CONTAINER = By.id("inventory_container");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        loginPageLink = "https://www.saucedemo.com/";
    }

    public boolean fillField(By locator, String text) {
        try {
            WebElement tempInput = driver.findElement(locator);
            tempInput.clear();
            tempInput.sendKeys(text);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean clickButton(By locator) {
        try {
            WebElement tempButton = driver.findElement(locator);
            tempButton.click();
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean openLoginPage() {

        try {
            driver.get(loginPageLink);
            return true;
        } catch (NoSuchWindowException exception) {
            return false;
        }
    }

    public void closeLoginPage(WebDriver driver) {
        driver.close();
    }

    public boolean fillLoginAndPassword(String login, String password) {
        return fillField(USERNAME_FIELD_LOCATOR, login) && fillField(PASSWORD_FIELD_LOCATOR, password);
    }

    public boolean clickLoginButton() {
        return clickButton(LOGIN_BUTTON_LOCATOR);
    }

    public boolean checkIfUserLogin() {
        try {
            return driver.findElement(SHOP_CONTAINER).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
package SkillUPPetProject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SkillUPPetProject.pages.LoginPage;

public class LoginTests {


    private WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.openLoginPage());
    }

    @Test
    public void loginWithCorrectCredentials() {
        Assert.assertTrue(loginPage.fillLoginAndPassword("standard_user", "secret_sause"));
        Assert.assertTrue(loginPage.clickLoginButton());
        Assert.assertTrue(loginPage.checkIfUserLogin(), "User not logged in");
    }

    @Test
    public void loginWithIncorrectCredentials() {
        Assert.assertTrue(loginPage.fillLoginAndPassword("locked_out_user", "secret_sause"));
        Assert.assertTrue(loginPage.clickLoginButton());
        Assert.assertFalse(loginPage.checkIfUserLogin(), "User is logged in, when shouldn't");
    }

    @AfterTest
    public void postSteps() {
        loginPage.closeLoginPage(driver);
    }
}

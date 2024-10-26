import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessAccountTrustRegistrationTest extends TestAndDriverSetup {
    @Test
    public void registrationForBusinessAccountTrustTest(){

        RegisterPage registerPage = new RegisterPage(webDriver);

        registerPage.navigateTo();
        Assert.assertTrue(registerPage.isPageLoaded(), "Register page isn't loaded");
        registerPage.clickCookiesButton();
        registerPage.clickBusinessAccount();

        registerPage.clickTrustForBusiness();

        registerPage.typeLegalCompanyName();
        registerPage.typeAmount();
        registerPage.typeFirstName();
        registerPage.typeLastName();
        registerPage.typeEmail();
        registerPage.typeCellNumber();
        registerPage.clickTermsAndCond();
        registerPage.clickNewsAndOffers();
        registerPage.enterMathResult();
        registerPage.clickRegisterButton();
        registerPage.navigateToVerificationPage();

        Assert.assertTrue(registerPage.isVerifPageLoaded(), "Verification page isn't loaded");
    }

}
import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BusinessAccountPublicRegistrationTest extends TestAndDriverSetup {

    @Test
    public void registrationForBusinessAccountPublicCompanyTest() {

        RegisterPage registerPage = new RegisterPage(webDriver);

        registerPage.navigateTo();
        Assert.assertTrue(registerPage.isPageLoaded(), "Register page isn't loaded");
        registerPage.clickCookiesButton();
        registerPage.clickBusinessAccount();

        registerPage.clickPublicCompanyForBusiness();

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
import PageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class EducationPublicCompanyRegistrationTest extends TestAndDriverSetup {

    @Test
    public void registrationForEducationPublicCompany(){
        RegisterPage registerPage = new RegisterPage(webDriver);

        registerPage.navigateTo();
        Assert.assertTrue(registerPage.isPageLoaded(), "Register page isn't loaded");

        registerPage.clickCookiesButton();

        registerPage.clickEducation();
        registerPage.clickPublicCompanyForEducation();
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

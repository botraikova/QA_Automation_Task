package PageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {

    public static final String REGISTRATION_PAGE_URL = "https://www.transfermate.io/en/register.asp";
    public static final String VERIFICATION_PAGE_URL = "https://www.transfermate.io/en/register_mail_verification.html?frwd_frb_country=0";

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.webDriver = driver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
    }

    public void navigateTo() {
        this.webDriver.get(REGISTRATION_PAGE_URL);
    }

    public boolean isPageLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REGISTRATION_PAGE_URL));
    }

    public void clickCookiesButton() {
        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("cookies-read-more-link"))));
        cookiesButton.click();
    }

    public void clickBusinessAccount() {
        WebElement businessAccountButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_type_of_account_business"))));
        businessAccountButton.click();
    }

    public void clickPrivateCompanyForBusiness() {
        WebElement privateCompanyForBusinessButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_business_account_type_private_company"))));
        privateCompanyForBusinessButton.click();
    }

    public void clickPublicCompanyForBusiness() {
        WebElement publicCompanyForBusinessButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_business_account_type_public_company"))));
        publicCompanyForBusinessButton.click();
    }

    public void clickPartnershipForBusiness() {
        WebElement partnershipForBusinessButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_business_account_type_partnership"))));
        partnershipForBusinessButton.click();
    }

    public void clickTrustForBusiness() {
        WebElement trustForBusinessButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_business_account_type_trust"))));
        trustForBusinessButton.click();
    }

    public void clickPersonalAccount() {
        WebElement personalAccountButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_type_of_account_business"))));
        personalAccountButton.click();
    }

    public void clickIndividualForPersonal() {
        WebElement individualForPersonalButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_personal_account_type_individual"))));
        individualForPersonalButton.click();
    }

    public void clickSoleTraderForPersonal() {
        WebElement soleTraderForPersonalButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_personal_account_type_sole_trader_form_input"))));
        soleTraderForPersonalButton.click();
    }

    public void clickEducation() {
        WebElement educationButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_type_of_account_education"))));
        educationButton.click();
    }

    public void clickPrivateCompanyForEducation() {
        WebElement privateCompanyForEducationButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_education_account_type_private_company"))));
        privateCompanyForEducationButton.click();
    }

    public void clickPublicCompany() {
        WebElement publicCompanyButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_education_account_type_public_company"))));
        publicCompanyButton.click();
    }

    public void typeLegalCompanyName() {
        String legalCompanyName = generateRandomCompanyName(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement companyNameField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("company_name"))));
        companyNameField.sendKeys(legalCompanyName);
    }

    public void typePartrnershipName(){
        String partnershipName = generateRandomCompanyName(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement partnershipNameField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("company_name"))));
        partnershipNameField.sendKeys(partnershipName);
    }

    public void typeAmount() {
        String amount = generateRandomNumbers(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("annual_equivalent_amount"))));
        amountField.sendKeys(amount);
    }

    public void typeFirstName() {
        String firstName = generateRandomName(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("first_name"))));
        firstNameField.sendKeys(firstName);
    }

    public void typeLastName() {
        String lastName = generateRandomName(10, 15);
        //String lastName = generateRandomFirstName(10,15); moje li da se izpylni s metoda za generate name? ili tr da razbivam na first i last
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("last_name"))));
        lastNameField.sendKeys(lastName);
    }

    public void typeEmail() {
        String email = generateRandomEmailAddress(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement emailTextField = wait.until(ExpectedConditions.visibilityOf(webDriver.
                findElement(By.xpath("//*[@id='email']"))));
        emailTextField.sendKeys(email);
    }

    public void typeCellNumber() {
        String cellNumber = generateRandomNumbers(10, 15);
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        WebElement amountField = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("__pin_mobile_number_mobile_phone"))));
        amountField.sendKeys(cellNumber);
    }

    public boolean clickTermsAndCond() {
        WebElement clickAgreeButton = webDriver.findElement(By.id("register_terms_of_use_agree_form_input"));

        String firstClassName = clickAgreeButton.getAttribute("class");
        clickAgreeButton.click();
        String secondClassName = clickAgreeButton.getAttribute("class");
        return secondClassName.contains("true");
    }

    public boolean clickNewsAndOffers() {
        WebElement newsAndOffersButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("register_newsletter_and_privacy_policy_agree_form_input"))));

        String firstClassName = newsAndOffersButton.getAttribute("class");
        newsAndOffersButton.click();
        String secondClassName = newsAndOffersButton.getAttribute("class");
        return secondClassName.contains("true");
    }

    public void clickRegisterButton() {
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(By.id("button_subscribe"))));
        registerButton.click();
    }

    private String generateRandomCompanyName(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

    private String generateRandomNumbers(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomNumeric(minLengthInclusive, maxLengthInclusive);
    }

    private String generateRandomName(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

    private String generateRandomEmailAddress(int minLengthInclusive, int maxLengthInclusive) {
        return generateRandomAlphabeticString(minLengthInclusive, maxLengthInclusive) + "@gmail.com";
    }

    private String generateRandomAlphabeticString(int minLengthInclusive, int maxLengthInclusive) {
        return RandomStringUtils.randomAlphanumeric(minLengthInclusive, maxLengthInclusive);
    }

    public void enterMathResult() {
        WebElement captchaContainer = webDriver.findElement(By.id("cal_captcha_f2462_question"));

        StringBuilder mathExpression = new StringBuilder();
        for (WebElement span : captchaContainer.findElements(By.tagName("span"))) {
            mathExpression.append(span.getText().trim());
        }

        String problem = mathExpression.toString();
        double result = evaluateMathExpression(problem);

        WebElement answerField = webDriver.findElement(By.id("__calc_captcha_text"));
        answerField.sendKeys(String.valueOf((int) result));
    }

    private double evaluateMathExpression(String problem) {
        return 0;
    }

    public void navigateToVerificationPage() {
        this.webDriver.get(VERIFICATION_PAGE_URL);
    }

    public boolean isVerifPageLoaded() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.urlToBe(VERIFICATION_PAGE_URL));
    }
}
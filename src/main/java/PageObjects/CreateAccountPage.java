package PageObjects;

import Helpers.DriverHelper;

import java.io.IOException;

public class CreateAccountPage extends DriverHelper {
    String firstName = "//*[@data-aui='firstName-input']",
            lastName = "//*[@data-aui='lastName-input']",
            country = "",
            email = "//*[@data-aui='email-input']",
            password = "//*[@data-aui='create-account-password-input']",
            specialOffer = "//label[@aria-label='Yes! I would like to receive updates, special offers, and other information from Universal Orlando Resort.']",
            termsOfService = "//label[@for='termsConditions']",
            spinner = "//*[@class='spinner-circle-outer']",
            successBanner = "//*[@class='notification-msg row success ng-star-inserted']",
            errorBanner = "//*[@class='error notification-msg row ng-star-inserted']",
            createAccountButton = "//*[@data-aui='create-accnt-btn']";

    /**
     * @throws IOException
     */
    public CreateAccountPage() throws IOException {
        setup();
        String uoUrl = System.getProperty("url");
        getUrl(uoUrl.replace("web/en/us", "account/en/us/account-management/create-account"));
        waitForPageToLoad(10);
    }

    /**
     * @param userFirstName
     */
    public void setFirstName(String userFirstName) {
        sendKeys(firstName, userFirstName);
    }

    public void setLastName(String userLastName) {
        sendKeys(lastName, userLastName);
    }

    public void setEmail(String emailAddress) {
        sendKeys(email, emailAddress);
    }

    public void setPassword(String userPassword) {
        sendKeys(password, userPassword);
    }

    public void selectCheckboxes() {
        waitElementToBeClickable(specialOffer, 5);
        click(specialOffer);
        click(termsOfService);
    }

    public void clickCreateAccountButton() {
        click(createAccountButton);
    }

    public void waitForSpinnerToDisappear() {
        try {
            waitForElementToBeInVisible(spinner, 10);
        } catch (Exception e) {
            System.out.println("=================================Exception================================");
            System.out.println(e);
            System.out.println("=================================Exception================================");
        }
    }

    public void validateSuccessAccountBanner() {
        isDisplayed(successBanner);
    }

    public String getSuccessBannerText() {
        return getTextValue(successBanner);
    }

    public String getErrorBannerText() {
        return getTextValue(errorBanner);
    }


}

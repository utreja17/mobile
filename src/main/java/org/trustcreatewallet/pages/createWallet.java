package org.trustcreatewallet.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.trustcreatewallet.utils.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class createWallet extends CommonActions {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Own, control, and\"]")
    private WebElement launchPage_verification;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"CreateNewWalletButton\"]/android.widget.Button\n")
    private WebElement create_WalletButtonxpath;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your passcode. Be sure to remember it so you can unlock your wallet.\"]\n")
    private WebElement passcodeText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your passcode. Be sure to remember it so you can unlock your wallet.\"]\n")
    private WebElement reenter_PasscodeText;
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.view.View/android.widget.Button\n")
    private WebElement market_DialogBox;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Create\"])[1]\n")
    private WebElement secretPhrase_Create;
    @AndroidFindBy(xpath = " //android.widget.TextView[@text=\"Those passwords didn’t match!\"]")
    private WebElement mismatch_passwordText;
    @AndroidFindBy(id = "buttonTitle")
    private WebElement enablemaket_Notification;
    @AndroidFindBy(id = "secondaryAction")
    private WebElement skipfornow_Notification;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"topBarWalletName\"]\n")
    private WebElement walletName;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"addWalletIconButton\"]/android.widget.Button\n")
    private WebElement addWalletButton;
    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"CreateNewWallet\"]\n")
    private WebElement createNewWalletButton_throughAddWallet;
   By swiftPhrase_Create = By.xpath("(//android.widget.TextView[@text=\"Create\"])[2]\n");

    public createWallet(WebDriver driver) {
        super(driver);
    }

    public void visibility_MainPage() {
        Assert.assertTrue(checkElementVisibility(launchPage_verification, "launchPage_verification"));
    }

    public void clickWalletButton_Main() {

        click(create_WalletButtonxpath, "Create Wallet Button");


    }

    public void visibility_Of_Passcode_text() {
        Assert.assertTrue(checkElementVisibility(passcodeText, "passcodeText"));
    }

    public void visibility_Of_Renter_Passcode_text() {
        Assert.assertTrue(checkElementVisibility(reenter_PasscodeText, "reenter_PasscodeText"));
    }

    public void click_Close_Icon_Market() {
        click(market_DialogBox, " Cross Icon on Market Overlay");

    }

    public void click_SecretPhrase_Click() {
        click(secretPhrase_Create, "Entering secret phrase");

    }

    public void successfulWallet_creation(String textName) {
        Assert.assertTrue(checkElementVisibility(walletName, "WalletName"));
        System.out.println(getText(walletName));
        Assert.assertEquals(getText(walletName), textName);
    }
    public void passcode_Mismatch_Text() {
        Assert.assertTrue(checkElementVisibility(mismatch_passwordText, "reenter_PasscodeText"));
    }

    public void clickWalletName()
    {
        click(walletName,"WalletName");
    }
    public void clickAddWalletButton()
    {
        click(addWalletButton,"WalletName");
    }
    public void clickcraeteWallet_throughWalletPage()
    {
        click(createNewWalletButton_throughAddWallet,"WalletName");
    }

    /*************************************************************************************************************
     Method Name         :  positive_CreateWallet
     Parameters          :   NA
     Description By       :  function to create wallet for new user
     ************************************************************************************************************
     */

    public void positive_CreateWallet(){
        visibility_MainPage();
        clickWalletButton_Main();
        getPasscodeDigit();
        getPasscodeDigit();
        click_Close_Icon_Market();
        click_SecretPhrase_Click();
        successfulWallet_creation("Main Wallet 1");

    }
    /*************************************************************************************************************
     Method Name         :  mainPageverification
     Parameters          :   NA
     Description By       :  function to verify launch screen is displaying  on launching application
     ************************************************************************************************************
     */
    public void mainPageverification() {
        visibility_MainPage();
        clickWalletButton_Main();
    }

    /*************************************************************************************************************
     Method Name         :  passcodetextValidation
     Parameters          :   NA
     Description By       :  function to verify passcode text to be displayed to user
     ************************************************************************************************************
     */
    public void passcodetextValidation() {
        visibility_MainPage();
        clickWalletButton_Main();
        visibility_Of_Passcode_text();
    }

    /*************************************************************************************************************
     Method Name         :  reenter_passcodetextValidation
     Parameters          :   NA
     Description By       :  function to verify re-enter passcode text to be displayed to user
     ************************************************************************************************************
     */

    public void reenter_passcodetextValidation() {
        visibility_MainPage();
        clickWalletButton_Main();
        visibility_Of_Passcode_text();
        getPasscodeDigit();
        visibility_Of_Renter_Passcode_text();
    }

    /*************************************************************************************************************
     Method Name         :  reenter_passcodetextValidation
     Parameters          :   NA
     Description By       :  function to verify validation message when there is mismatch between passcode and re-enter passcode
     ************************************************************************************************************
     */

    public void mismatchPasscode()
    {
    visibility_MainPage();
    clickWalletButton_Main();
    visibility_Of_Passcode_text();
    getPasscodeDigit();
    visibility_Of_Renter_Passcode_text();
    getmismatchPasscodeDigit();
    passcode_Mismatch_Text();
    }

    /*************************************************************************************************************
     Method Name         :  positive_CreateWallet_Walletpage
     Parameters          :   NA
     Description By       :  function to verify existing user can add new wallet
     ************************************************************************************************************
     */

    public void positive_CreateWallet_Walletpage() {
        visibility_MainPage();
        clickWalletButton_Main();
        getPasscodeDigit();
        getPasscodeDigit();
        click_Close_Icon_Market();
        click_SecretPhrase_Click();
        successfulWallet_creation("Main Wallet 1");
        clickWalletName();
        clickAddWalletButton();
        clickcraeteWallet_throughWalletPage();
        click_SecretPhrase_Click();
        successfulWallet_creation("Main Wallet 2");
        
    }
}

package tests;

import org.trustcreatewallet.pages.createWallet;
import org.testng.annotations.Test;

import static org.trustcreatewallet.driver.MobileDriverHolder.getDriver;

public class createWalletTest extends BaseTest {

    @Test(description = "User should be navigated to Main page if user enter correct password and confirm the password")
    public void successful_createwallet() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(2000);
        wallet.positive_CreateWallet();
    }
   @Test(description = "Verify create wallet button is displaying on launching the application")
    public void mainPageVerification() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(3000);
        wallet.mainPageverification();
    }

    @Test(description = "Verify the instruction text on create passcode page and keypad should display to enter passcode\n")
    public void createpasscode_text() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(3000);
        wallet.passcodetextValidation();
    }
    @Test(description = "Verify the instruction text on create passcode page and keypad should display to enter passcode\n")
    public void reenterpasscode_text() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(3000);
        wallet.reenter_passcodetextValidation();
    }
    @Test(description = "Error should display when user enter mismatch passcode on confirm passcode screen\n")
    public void mismatch_passcode_confirmPasscode() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(3000);
        wallet.mismatchPasscode();
    }
    @Test(description = "Verify existing user should able to add new wallet")
    public void createPasscode_throughwalletpage() throws InterruptedException {
        createWallet wallet=new createWallet(getDriver());
        Thread.sleep(3000);
        wallet.positive_CreateWallet_Walletpage();
    }
}

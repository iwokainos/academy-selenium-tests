import org.junit.Test;

import framework.FunctionalTest;
import pages.ReceiptPage;
import pages.SignUpPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SignUpFormTest extends FunctionalTest {

    @Test
    public void signMeUp() {
        driver.get("http://www.kimschiller.com/page-object-pattern-tutorial/index.html");

        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInitialised());

        signUpPage.enterName("Iwo", "Sadecki");

        ReceiptPage receiptPage = signUpPage.submit();

        /**this assertion checks if Receipt Page generates Thank you! message following submission */
        assertEquals("Thank you!", receiptPage.confirmationHeader());
        assertEquals("You are now subscribed to our service.", receiptPage.subscriptionText());
    }
}

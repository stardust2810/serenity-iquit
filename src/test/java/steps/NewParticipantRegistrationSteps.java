package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import questions.PublicRegistrationResults;
import tasks.*;
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.ValueOf.the;
import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;
import static org.hamcrest.core.Is.is;

public class NewParticipantRegistrationSteps {

    private static Logger log = LogManager.getLogger(NewParticipantRegistrationSteps.class);
    private PublicRegistrationPage page = new PublicRegistrationPage();

    //@Managed
    //@Managed(uniqueSession = true, clearCookies = BeforeEachTest, driver="chrome")
    //@Managed(uniqueSession = true, clearCookies = BeforeEachTest, driver="chrome")
    @Managed(uniqueSession = true, clearCookies = BeforeEachTest)
    public WebDriver theBrowser;

    @Before
    public void set_the_stage() {
        System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        System.setProperty("webdriver.firefox.driver","geckodriver.exe");
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) registers for an account$")
    public void registers_for_an_account(String actorName) throws Throwable {
        //loads the landing page
        theActorCalled(actorName).wasAbleTo(OpenPublicRegistrationPage.open());

        //fills in the step 1 form
        theActorCalled(actorName).attemptsTo(FillInRegistrationFormStepOne.enterDetails("Jeffrey Ng", "S9999999X", "Chinese", "99999999", "jeffrey_NG@hpb.gov.sg", "111111"));

        //show see the results page for recipe analyst
        theActorCalled(actorName).should(seeThat(the(PublicRegistrationPage.SUBMIT_BUTTON,isVisible())));

    }
}

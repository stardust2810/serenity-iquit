package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import questions.RegistrationReviewResults;
import tasks.ClickConfirmRegistrationForm;
import tasks.FillInRegistrationFormCommonFields;
import tasks.FillInRegistrationFormEOFields;
import tasks.OpenPublicRegistrationPage;
import ui.EORegistrationPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

public class EOParticipantRegistrationSteps {

    private static Logger log = LogManager.getLogger(EOParticipantRegistrationSteps.class);
    private EORegistrationPage page = new EORegistrationPage();

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

    @Given("^(.*) registers a member of public$")
    public void registers_a_member_of_public(String actorName) throws Throwable {
        //loads the landing page
        theActorCalled(actorName).wasAbleTo(OpenPublicRegistrationPage.open());

        //fills in the step 1 form
        theActorCalled(actorName).attemptsTo(FillInRegistrationFormCommonFields.enterDetails("Jeffrey Ng", "S9999999X", "Chinese", "99999999", "jeffrey_NG@hpb.gov.sg", "111111"));
        theActorCalled(actorName).attemptsTo(FillInRegistrationFormEOFields.enterDetails("QuitLine", "roadshow 4", "location 6", "company 5", actorName, "2", "This is a test"));
        theActorCalled(actorName).attemptsTo(ClickConfirmRegistrationForm.clickButton());

        //show see the review page
        theActorCalled(actorName).should(seeThat(RegistrationReviewResults.exists(),  org.hamcrest.Matchers.comparesEqualTo(Boolean.TRUE)));

        //reviews and submits the registration
        //theActorCalled(actorName).attemptsTo(SubmitRegistration.submitsRegistration());

        //show see the ack page
        //theActorCalled(actorName).should(seeThat(RegistrationReviewResults.exists(),  org.hamcrest.Matchers.comparesEqualTo(Boolean.TRUE)));
    }
}

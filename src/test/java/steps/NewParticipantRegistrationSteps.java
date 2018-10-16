package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import tasks.*;
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class NewParticipantRegistrationSteps {

    private static Logger log = LogManager.getLogger(NewParticipantRegistrationSteps.class);
    private PublicRegistrationPage page = new PublicRegistrationPage();

    @Managed
    WebDriver theBrowser;

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) registers for an account$")
    public void registers_for_an_account(String actorName) throws Throwable {
        //loads the landing page
        theActorCalled(actorName).wasAbleTo(OpenPublicRegistrationPage.open());

        //clicks the register link

        //fills in the step 1 form

        //fills in the step 2 form
        theActorCalled(actorName).attemptsTo(FillInRegistrationFormStepOne.enterDetails("Jeffrey Ng", "S9999999X", "99999999", "jeffrey_NG@hpb.gov.sg"));
    }
}

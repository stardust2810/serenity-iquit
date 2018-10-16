package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.EnterValueIntoTarget;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillInRegistrationFormStepOne implements Task {

    private static Logger log = LogManager.getLogger(FillInRegistrationFormStepOne.class);
    private final String full_name;
    private final String nric;
    private final String mobile;
    private final String email;

    protected FillInRegistrationFormStepOne(String full_name, String nric, String mobile, String email) {
        this.full_name = full_name;
        this.nric = nric;
        this.mobile = mobile;
        this.email = email;
    }

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.FULLNAME));
        actor.attemptsTo(new EnterValueIntoTarget(full_name, PublicRegistrationPage.FULLNAME));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.NRIC));
        actor.attemptsTo(new EnterValueIntoTarget(nric, PublicRegistrationPage.NRIC));
/*
        actor.attemptsTo(new ScrollToTarget(ACMLandingPage.Q3_TEXTFIELD));
        actor.attemptsTo(new EnterValueIntoTarget(days1, ACMLandingPage.Q3_TEXTFIELD));

        actor.attemptsTo(new ScrollToTarget(ACMLandingPage.Q4_TEXTFIELD));
        actor.attemptsTo(new EnterValueIntoTarget(mins1, ACMLandingPage.Q4_TEXTFIELD));

        actor.attemptsTo(new ScrollToTarget(ACMLandingPage.PARQ_CHECKBOX));
        actor.attemptsTo(new ClickOnTarget(ACMLandingPage.PARQ_CHECKBOX));

        actor.attemptsTo(new ScrollToTarget(ACMLandingPage.PARQPROCEED_BUTTON));
        actor.attemptsTo(new ClickOnTarget(ACMLandingPage.PARQPROCEED_BUTTON));
*/
    }

    public static FillInRegistrationFormStepOne enterDetails(String full_name, String nric, String mobile, String email){
        return instrumented(FillInRegistrationFormStepOne.class, full_name, nric, mobile, email);
    }

}


package tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.EnterValueIntoTarget;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FillInRegistrationFormStepOne implements Task {

    private static Logger log = LogManager.getLogger(FillInRegistrationFormStepOne.class);
    private final String full_name;
    private final String nric;
    private final String race;
    private final String mobile;
    private final String email;
    private final String postal_code;

    protected FillInRegistrationFormStepOne(String full_name, String nric, String race, String mobile, String email, String postal_code) {
        this.full_name = full_name;
        this.nric = nric;
        this.race = race;
        this.mobile = mobile;
        this.email = email;
        this.postal_code = postal_code;
    }

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.FULLNAME));
        actor.attemptsTo(new EnterValueIntoTarget(full_name, PublicRegistrationPage.FULLNAME));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.NRIC));
        actor.attemptsTo(new EnterValueIntoTarget(nric, PublicRegistrationPage.NRIC));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.RACE));
        actor.attemptsTo(SelectFromOptions.byVisibleText(race).from(PublicRegistrationPage.RACE));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.YEAR_OF_BIRTH));
        actor.attemptsTo(SelectFromOptions.byVisibleText("1977").from(PublicRegistrationPage.YEAR_OF_BIRTH));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.MOBILE_NO));
        actor.attemptsTo(new EnterValueIntoTarget(mobile, PublicRegistrationPage.MOBILE_NO));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.EMAIL));
        actor.attemptsTo(new EnterValueIntoTarget(email, PublicRegistrationPage.EMAIL));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.POSTAL_CODE));
        actor.attemptsTo(new EnterValueIntoTarget(postal_code, PublicRegistrationPage.POSTAL_CODE));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.STICKS_PER_DAY));
        actor.attemptsTo(new EnterValueIntoTarget("8", PublicRegistrationPage.STICKS_PER_DAY));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.TRIED_QUITTING));
        actor.attemptsTo(SelectFromOptions.byVisibleText("Yes").from(PublicRegistrationPage.TRIED_QUITTING));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.MOTIVATION));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.MOTIVATION));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.QUITLINE));
        actor.attemptsTo(SelectFromOptions.byVisibleText("I will call QuitLine on my own").from(PublicRegistrationPage.QUITLINE));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.INTEREST_AREA));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.INTEREST_AREA));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.SUPPORTER_NAME));
        actor.attemptsTo(new EnterValueIntoTarget("Jamie", PublicRegistrationPage.SUPPORTER_NAME));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.SUPPORTER_MOBILE));
        actor.attemptsTo(new EnterValueIntoTarget("88888888", PublicRegistrationPage.SUPPORTER_MOBILE));


        WebDriverWait wait = new WebDriverWait(getDriver(), 120);

        //Wait until text box has value greater or equal 12 character
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    log.debug("========================================================================");
                    log.debug("Status:" + SelectedStatus.of(PublicRegistrationPage.TERMS).viewedBy(actor).asBoolean());
                    return (SelectedStatus.of(PublicRegistrationPage.TERMS).viewedBy(actor).asBoolean());
                }
            });
        } catch (Exception e) {
            log.error(e);
        }
/*
        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.TERMS));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.TERMS));
*/
        /*
        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.CAPTCHA));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.CAPTCHA));
        */

        //new WebDriverWait(getDriver(), 30).until(visibilityOfElementLocated(By.cssSelector("._ksh")));
        //new WebDriverWait(getDriver(), 30).until(visibilityOfElementLocated(By.cssSelector("._ksh")));

        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.BUTTON));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.BUTTON));
    }

    public static FillInRegistrationFormStepOne enterDetails(String full_name, String nric, String race, String mobile, String email, String postal_code){
        return instrumented(FillInRegistrationFormStepOne.class, full_name, nric, race, mobile, email, postal_code);
    }

}


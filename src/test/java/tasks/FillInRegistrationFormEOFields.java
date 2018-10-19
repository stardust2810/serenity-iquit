package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.ClickOnTarget;
import net.serenitybdd.screenplay.actions.EnterValueIntoTarget;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.EORegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class FillInRegistrationFormEOFields implements Task {

    private static Logger log = LogManager.getLogger(FillInRegistrationFormEOFields.class);
    private final String channel;
    private final String roadshow_name;
    private final String roadshow_location;
    private final String eo_company;
    private final String eo_name;
    private final String smokerlyser_result;
    private final String remarks;

    protected FillInRegistrationFormEOFields(String channel, String roadshow_name, String roadshow_location, String eo_company, String eo_name, String smokerlyser_result, String remarks) {
        this.channel = channel;
        this.roadshow_name = roadshow_name;
        this.roadshow_location = roadshow_location;
        this.eo_company = eo_company;
        this.eo_name = eo_name;
        this.smokerlyser_result = smokerlyser_result;
        this.remarks = remarks;
    }

    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.SIGNUP_CHANNEL));
        actor.attemptsTo(SelectFromOptions.byVisibleText(channel).from(EORegistrationPage.SIGNUP_CHANNEL));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.ROADSHOW_NAME));
        actor.attemptsTo(SelectFromOptions.byVisibleText(roadshow_name).from(EORegistrationPage.ROADSHOW_NAME));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.ROADSHOW_LOCATION));
        actor.attemptsTo(SelectFromOptions.byVisibleText(roadshow_location).from(EORegistrationPage.ROADSHOW_LOCATION));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.EO_COMPANY));
        actor.attemptsTo(SelectFromOptions.byVisibleText(eo_company).from(EORegistrationPage.EO_COMPANY));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.STAFF_ID));
        actor.attemptsTo(new EnterValueIntoTarget(eo_name, EORegistrationPage.STAFF_ID));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.SMOKERLYSER_RESULT));
        actor.attemptsTo(new EnterValueIntoTarget(smokerlyser_result, EORegistrationPage.SMOKERLYSER_RESULT));

        actor.attemptsTo(new ScrollToTarget(EORegistrationPage.VALIDATION_REMARKS));
        actor.attemptsTo(new EnterValueIntoTarget(remarks, EORegistrationPage.VALIDATION_REMARKS));

        WebDriverWait wait = new WebDriverWait(getDriver(), 120);

        //Wait until text box has value greater or equal 12 character
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    log.debug("========================================================================");
                    log.debug("Status:" + SelectedStatus.of(EORegistrationPage.TERMS).viewedBy(actor).asBoolean());
                    return (SelectedStatus.of(EORegistrationPage.TERMS).viewedBy(actor).asBoolean());
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

        //actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.REVIEW_BUTTON));
        //actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.REVIEW_BUTTON));
    }

    public static FillInRegistrationFormEOFields enterDetails(String channel, String roadshow_name, String roadshow_location, String eo_company, String eo_name, String smokerlyser_result, String remarks){
        return instrumented(FillInRegistrationFormEOFields.class, channel, roadshow_name, roadshow_location, eo_company, eo_name, smokerlyser_result, remarks);
    }

}


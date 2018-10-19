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
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SubmitRegistration implements Task {

    private static Logger log = LogManager.getLogger(SubmitRegistration.class);

    protected SubmitRegistration() {
    }

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new ScrollToTarget(PublicRegistrationPage.SUBMIT_BUTTON));
        actor.attemptsTo(new ClickOnTarget(PublicRegistrationPage.SUBMIT_BUTTON));
    }

    public static SubmitRegistration submitsRegistration(){
        return instrumented(SubmitRegistration.class);
    }
}


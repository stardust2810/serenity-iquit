package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import ui.EORegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenEORegistrationPage implements Task{
    EORegistrationPage page;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(page)
        );
    }

    public static OpenEORegistrationPage open() {
        return instrumented(OpenEORegistrationPage.class);
    }
}
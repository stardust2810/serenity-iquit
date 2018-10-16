package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import ui.PublicRegistrationPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenPublicRegistrationPage implements Task{
    PublicRegistrationPage page;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(page)
        );
    }

    public static OpenPublicRegistrationPage open() {
        return instrumented(OpenPublicRegistrationPage.class);
    }
}
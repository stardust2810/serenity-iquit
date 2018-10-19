package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Presence;
import ui.PublicRegistrationPage;

@Subject("Show the confirmation page before submitting the registration")
public class RegistrationReviewResults implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return Presence.of(PublicRegistrationPage.SUBMIT_BUTTON)
                .viewedBy(actor).asBoolean();
    }

    public static Question<Boolean> exists(){
        return new RegistrationReviewResults();
    }
}

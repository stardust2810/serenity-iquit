package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.SelectedStatus;
import net.serenitybdd.screenplay.questions.Text;
import ui.PublicRegistrationPage;

@Subject("Show the confirmation page before submitting the registration")
public class PublicRegistrationResults implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return SelectedStatus.of(PublicRegistrationPage.SUBMIT_BUTTON)
                .viewedBy(actor)
                .asString();
    }

    public static Question<String> text(){
        return new PublicRegistrationResults();
    }
}

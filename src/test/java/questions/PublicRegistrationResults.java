package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("Show results after selecting a programme from the drop down")
public class PublicRegistrationResults implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        /*
        return Text.of(PublicRegistrationPage.REGISTRATION_LINK)
                .viewedBy(actor)
                .asString();
                */
        return null;
    }

    public static Question<String> text(){
        return new PublicRegistrationResults();
    }
}

package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

@DefaultUrl("http://18.136.62.147/register")
public class PublicRegistrationPage extends PageObject {

    private static Logger log = LogManager.getLogger(PublicRegistrationPage.class);

    //main landing page
    public static Target FULLNAME = Target.the("full name").locatedBy("#full_name");
    public static Target NRIC = Target.the("nric").locatedBy("#nric");
    public static Target GENDER = Target.the("gender").located(By.cssSelector("input[name='gender'][value='M']"));
    public static Target RACE = Target.the("race").locatedBy("#race");
    public static Target YEAR_OF_BIRTH = Target.the("year_of_birth").locatedBy("#year_of_birth");
    public static Target MOBILE_NO = Target.the("mobile_number").locatedBy("#mobile_number");
    public static Target EMAIL = Target.the("email_address").locatedBy("#email_address");
    public static Target POSTAL_CODE = Target.the("postal_code").locatedBy("#postal_code");
}

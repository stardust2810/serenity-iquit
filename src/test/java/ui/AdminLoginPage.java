package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@DefaultUrl("http://18.136.62.147/login")
public class AdminLoginPage extends PageObject {

    private static Logger log = LogManager.getLogger(AdminLoginPage.class);

    //main landing page
    public static Target USER_ID = Target.the("email_address_input").locatedBy("#email_address_input");
    public static Target PASSWORD = Target.the("password_input").locatedBy("#password_input");

    //button
    public static Target LOGIN_BUTTON = Target.the("login_button").locatedBy("#login_button");
}

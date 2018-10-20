package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.By;

@DefaultUrl("http://18.136.62.147/register")
public class PublicRegistrationPage extends PageObject {

    private static Logger log = LogManager.getLogger(PublicRegistrationPage.class);

    //main landing page
    public static Target FULLNAME = Target.the("full name").locatedBy("#full_name");
    public static Target NRIC = Target.the("nric").locatedBy("#nric");
    public static Target GENDER = Target.the("gender").locatedBy("input[name='gender'][value='M']");
    public static Target RACE = Target.the("race").locatedBy("#race");
    public static Target YEAR_OF_BIRTH = Target.the("year_of_birth").locatedBy("#year_of_birth");
    public static Target MOBILE_NO = Target.the("mobile_number").locatedBy("#mobile_number");
    public static Target EMAIL = Target.the("email_address").locatedBy("#email_address");
    public static Target POSTAL_CODE = Target.the("postal_code").locatedBy("#postal_code");

    //Preference
    public static Target STICKS_PER_DAY = Target.the("sticks_smoked_per_day").locatedBy("#sticks_smoked_per_day");
    public static Target TRIED_QUITTING = Target.the("have_you_tried_quitting_before").locatedBy("#have_you_tried_quitting_before");
    public static Target MOTIVATION = Target.the("motivations health").locatedBy("#motivations_of_quitting_4");
    public static Target QUITLINE = Target.the("do_you_need_quitline_assistance").locatedBy("#do_you_need_quitline_assistance");
    public static Target INTEREST_AREA = Target.the("interests_area sports").locatedBy("#interests_area_4");

    //Nominated supporter
    public static Target SUPPORTER_NAME = Target.the("nominated_supporter_name").locatedBy("#nominated_supporter_name");
    public static Target SUPPORTER_MOBILE = Target.the("nominated_supporter_mobile_number").locatedBy("#nominated_supporter_mobile_number");
    public static Target LANGUAGE = Target.the("nominated_supporter_language_preference_for_SMS_Chinese").locatedBy("#nominated_supporter_language_preference_for_SMS_Chinese");

    //T&Cs
    public static Target TERMS = Target.the("accept_terms").locatedBy("#accept_terms");

    //captcha
    //public static Target CAPTCHA = Target.the("recaptcha-anchor").locatedBy("#recaptcha-anchor");

    //button
    public static Target REVIEW_BUTTON = Target.the("review_button").locatedBy("#review_button");

    //confirmation page
    public static Target SUBMIT_BUTTON = Target.the("submit_button").locatedBy("#submit_button");
}

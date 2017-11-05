package hotel.booking;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@cucumber.api.CucumberOptions(tags={"@hotelBooking"}, strict=true, format = {"html:cucumber-html-reports", "json:cucumber-reports-with-handlebars/cucumber-report.json"})
public class RunTest {
}


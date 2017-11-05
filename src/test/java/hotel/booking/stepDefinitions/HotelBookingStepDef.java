package hotel.booking.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hotel.booking.driver.DriverManager;
import hotel.booking.pageObjects.BookingPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class HotelBookingStepDef {

    private static BookingPage bookingPage;
    private WebDriver driver;


    @Before
    public void beforeScenario() throws IOException {
        driver = new DriverManager().getDriver();
        System.out.println("Set-up before the scenario");
    }

    @After
    public void afterScenario() {
        DriverManager.destroyDriver(driver);
        System.out.println("Clean-up after the scenario");
    }

    @Given("^customer navigates to the hotel booking page$")
    public void customer_navigates_to_the_hotel_booking_page() throws Throwable {
        bookingPage = new BookingPage(driver);
        bookingPage.open();
    }

    @When("^customer deletes the first booking on the page$")
    public void i_should_be_able_to_delete_my_first_booking() throws Throwable {
        bookingPage.deleteFirstBooking();
    }

    @Then("^first booking should not be visible on the booking page$")
    public void first_booking_should_not_be_visible() throws Throwable {
        bookingPage.assertDeleteBooking();
    }

    @When("^customer creates the booking with below details:$")
    public void customer_creates_the_booking(DataTable dataTable) throws Throwable {

        for (Map<String, String> newBooking : dataTable.asMaps(String.class, String.class)) {
            bookingPage.createABooking(newBooking);
        }
    }

    @Then("^new booking should be displayed on the booking page$")
    public void booking_should_be_created() throws Throwable {
        bookingPage.assertCreateBooking();
    }

}

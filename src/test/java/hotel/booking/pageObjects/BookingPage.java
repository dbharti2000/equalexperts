package hotel.booking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookingPage extends BasePage {

    private final static String PAGE_TITLE = "Hotel booking form";
    private static String firstBookingToBeDeletedDivId;
    private static int bookingCountBeforeCreatingANewBooking = 0;

    public BookingPage(WebDriver myDriver) {
        super(myDriver, PAGE_TITLE);
        URL = "http://hotel-test.equalexperts.io/";
    }

    public String findFirstBookingDivId() {
        WebElement firstBookingID = waitForElement(driver, By.xpath("//div[@id='bookings']/div[2]"));
        assertNotNull("No booking found", firstBookingID);

        return firstBookingID.getAttribute("id").toString();
    }

    public void deleteFirstBooking() throws InterruptedException {
        firstBookingToBeDeletedDivId = findFirstBookingDivId();
        WebElement firstDeleteButton = waitForElement(driver, By.xpath("//div[@id='bookings']/div[2]/div/input[@value='Delete']"));
        assertNotNull("Booking not found", firstDeleteButton);

        firstDeleteButton.click();
        System.out.println("Booking id deleted is " + firstBookingToBeDeletedDivId);
        driver.navigate().refresh();
    }

    public void assertDeleteBooking() {
        waitForElement(driver, By.xpath("//input[@value = ' Save ']"));
        assertTrue(driver.findElements(By.id(firstBookingToBeDeletedDivId)).size() == 0);
    }

    private int findNumberOfExistingBookings() {
        return driver.findElements(By.xpath("//div[@id='bookings']/div")).size();
    }

    public void createABooking(Map<String, String> newBooking) throws InterruptedException {
        driver.findElement(By.id("firstname")).sendKeys(newBooking.get("FirstName"));
        driver.findElement(By.id("lastname")).sendKeys(newBooking.get("LastName"));
        driver.findElement(By.id("totalprice")).sendKeys(newBooking.get("Price"));
        WebElement dropdownlist = driver.findElement(By.id("depositpaid"));
        Select depositeDropdownList = new Select(dropdownlist);
        depositeDropdownList.selectByVisibleText(newBooking.get("Deposit").toLowerCase());


        driver.findElement(By.id("checkin")).click();

        driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
        driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
        driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ']")).click();

        bookingCountBeforeCreatingANewBooking = findNumberOfExistingBookings();
        System.out.println("Bookings count before the new booking " + bookingCountBeforeCreatingANewBooking);
        driver.findElement(By.xpath("//input[@value = ' Save ']")).sendKeys(Keys.RETURN);

    }

    public void assertCreateBooking() {
        driver.navigate().refresh();
        waitForElement(driver, By.xpath("//input[@value = 'Delete']"));
        System.out.println("Bookings count after new booking " + findNumberOfExistingBookings());
        assertTrue("Booking creation failed", findNumberOfExistingBookings() - bookingCountBeforeCreatingANewBooking >= 1);
        System.out.println("Booking created sucessfully");
    }
}

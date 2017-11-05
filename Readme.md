# Hotel Booking

I've created below two tests:
- Create a hotel booking on first saturday of next month
- Delete first hotel booking on the booking page

### Prerequisites
- Language - Java 1.8
- Automation Tool - Selenium Webdriver 2.53.1
- Test Framework - Junit 4.12
- Build Tool - Maven
- IDE - Intellij Idea Tool

### Tested on below browsers 

#### Mac
- FF - 34
- Chrome - 61.0

#### Windows
- FF - 47.0.2
- Chrome - 61.0

Note - I've uploaded the chrome drivers kept at src/test/resources/chromeDrivers/chromedriver.
- If you run the tests on windows, it'll pick up chromeDriver.exe
- If you run the tests on mac, it'll pick up chromeDriver

At present config.properties file contains chrome driver so it'll run the tests on chrome. If you want to
run the tests on FF, change the browser value to "firefox".

### Execution Steps

- Clone the repository or download as a zip file
- Run the tests using RunTest class

OR

Through command line, use maven command

```
mvn test

```


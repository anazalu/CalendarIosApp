package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"New\"`]")
    private RemoteWebElement newEventPageContainer;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Starts']/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsHourPickerButton;

    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean newEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageContainer)).isDisplayed();
    }

    public void chooseStartHour(String hour, String minutes) {
        startsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
        minutePicker.sendKeys(minutes);
    }
}

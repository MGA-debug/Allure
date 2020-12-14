package sberbank.mortgage.freamwork.util;

import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.util.ResultsUtils;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;

import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;

public class ScreenshotUtils extends AllureJunit4 {


    public void testFailure(Failure failure) {
      addScreenshot();
      super.testFailure(failure);
    }

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}



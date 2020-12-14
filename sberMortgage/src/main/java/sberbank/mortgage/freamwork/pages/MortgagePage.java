package sberbank.mortgage.freamwork.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MortgagePage extends BasePage {

    @FindBy(xpath = "//div//b[text()='Подать заявку']")
    WebElement buttonApply;

    @FindBy(xpath = "//h1[@class='shell_commonHeadingHeader']")
    WebElement headerMortgageForm;


    @Step("Нажать кнопку подать заявку")
    public MortgageFormPage clickApply() {
        waitUtilElementToBeClickable(buttonApply);
        buttonApply.click();

        waitUtilElementToBeVisible(headerMortgageForm);
        Assert.assertEquals("Вы находитесь не на той странице", headerMortgageForm.getText(),
                "Выберите программу и рассчитайте условия");

        return app.getMortgageFormPage();
    }
}

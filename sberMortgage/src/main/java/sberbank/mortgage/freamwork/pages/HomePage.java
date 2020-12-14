package sberbank.mortgage.freamwork.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class HomePage extends BasePage {
    List<WebElement> subMenu;

    @FindBy(xpath = "//ul[@class='kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center']/*")
    List<WebElement> topMenu;

    @FindBy(xpath = "//a[@data-cga_click_menu_banner_image='Начните новую жизнь с поиска жилья']")
    WebElement checkSubMenu;

    @FindBy(xpath = "//button[@class='kitt-cookie-warning__close']")
    WebElement closeCookie;

    @FindBy(xpath = "//div//b[text()='Подать заявку']")
    WebElement checkMortgagePage;

    @Step("Выбрать интересующий пункт в верхнем меню '{menuName}'")
    public HomePage selectMenu(String menuName) {
        waitUtilElementToBeVisible(closeCookie);
        closeCookie.click();

        for (WebElement menuElement : topMenu) {
            if (menuElement.getText().toLowerCase().contains(menuName)) {
                menuElement.click();
                subMenu = menuElement.findElements(By.xpath("./div/div/ul/li"));
                waitUtilElementToBeVisible(checkSubMenu);
                return this;
            }
        }
        Assert.fail("Такого пункта меню нет");
        return this;
    }


    @Step("Выбрать интересующий пункт подменю {subMenuName}")
    public MortgagePage selectSubMenu(String subMenuName) {

        if (subMenu.size() != 1) {
            for (WebElement subMenuElement : subMenu) {
                if (subMenuElement.getText().toLowerCase().contains(subMenuName)) {
                    subMenuElement.click();
                    waitUtilElementToBeVisible(checkMortgagePage);
                    return app.getMortgagePage();
                }
            }
        }
        Assert.fail("Подменю отсутствует");
        return app.getMortgagePage();
    }
}

import io.qameta.allure.Attachment;
import org.junit.Test;

public class FirstTest extends BaseTests {

    @Test
    public void firstTest() {
        app.getHomePage()
                .selectMenu("ипотека")
                .selectSubMenu("готовое жильё")
                .clickApply()
                .selectCondition("стоимость недвижимости", "5180000")
                .selectCondition("первоначальный взнос", "3058000")
                .selectCondition("срок кредита", "30")
                .selectAdditionalServices("страхование жизни", "нет")
                .selectAdditionalServices("молодая семья", "да")
                .checkFieldValues();
    }
}

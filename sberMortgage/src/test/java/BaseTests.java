import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import sberbank.mortgage.freamwork.managers.InitializeManager;
import sberbank.mortgage.freamwork.managers.PageManagers;

import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;
import static sberbank.mortgage.freamwork.managers.InitializeManager.props;
import static sberbank.mortgage.freamwork.util.PropertiesConstants.APP_URL;

public class BaseTests {

    protected PageManagers app = PageManagers.getManagerPages();


    @BeforeClass
    public static void beforeAll() {
        InitializeManager.initFramework();
    }

    @Before
    public void beforeEach() {
        getDriver().get(props.getProperty(APP_URL));
    }

    @AfterClass
    public static void afterEach() {
        InitializeManager.quitFramework();
    }
}

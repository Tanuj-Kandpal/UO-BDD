import Helpers.DriverHelper;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class test extends DriverHelper {

    @Test
    public void uotest() throws IOException {
        HomePage hp = new HomePage();
    }
}

import Helpers.DriverHelper;
import PageObjects.HomePage;

import java.io.IOException;

public class Test extends DriverHelper {

    @org.testng.annotations.Test
    public void uotest() throws IOException {
        HomePage hp = new HomePage();
    }
}

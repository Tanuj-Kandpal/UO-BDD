package PageObjects;

import Helpers.DriverHelper;

import java.io.IOException;

public class HomePage {

    DriverHelper dh = new DriverHelper();
    String searchBar = "//*[@id='gh-ac']",
            firstBook = "(//*[contains(@class, 's-item__info')]//a)[3]";

    public HomePage() throws IOException {
        dh.waitForPageToLoad(10);
    }

    public void clickSearchBar() {
        dh.findElement("//*[@id='gh-ac']");
    }

}

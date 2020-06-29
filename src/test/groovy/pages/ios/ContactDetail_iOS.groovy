package pages.ios

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactDetail_iOS extends Page {

    static at = {
        sleep(3000)
        waitFor { barTitle.value() == 'Contact Details' }
    }

	static content = {
        barTitle                    { $(MobileBy.className('XCUIElementTypeStaticText'))[0] }
        parameters                  { $(MobileBy.className('XCUIElementTypeStaticText'))}
        name                        { parameters[1] }
        phone                       { parameters[3] }
        email                       { parameters[5] }
        address1                    { parameters[7] }
        address2                    { parameters[1] }
    }

}

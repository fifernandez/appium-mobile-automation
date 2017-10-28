package pages.ios

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactDetail_iOS extends Page {

    static at = {
        println 'viene a detalles'
        sleep(10000)
        waitFor { barTitle.value() == 'Contacts' }
    }

	static content = {
        barTitle                    { $(MobileBy.xpath('//XCUIElementTypeNavigationBar[@name="Contact Details"]')) }
        parameters                  { $(MobileBy.xpath('//XCUIElementTypeApplication[@name="Contacts"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther')).find(By.className('XCUIElementTypeStaticText'))}
        name                        { parameters[0]  }
    }

}

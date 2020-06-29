package pages.ios

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactsList_iOS extends Page {

    static at = {
        sleep(3000)
        waitFor { barTitle.value() == 'Contacts' }
    }

	static content = {
        barTitle                                                { $(MobileBy.className('XCUIElementTypeStaticText'))[0] }
        contactNames                                            { $(MobileBy.className('XCUIElementTypeCell')).find(MobileBy.xpath("//XCUIElementTypeStaticText")) }
        contactName             (to: ContactDetail_iOS)         { int pos -> contactNames[pos] }
    }

    void clickOnFirstContact() {
        contactName(0).click()
    }

}

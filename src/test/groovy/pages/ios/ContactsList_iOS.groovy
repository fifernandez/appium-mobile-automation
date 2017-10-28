package pages.ios

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactsList_iOS extends Page {

    static at = {
        waitFor { barTitle.text() == 'Contacts' }
    }

	static content = {
        barTitle                                                { $(MobileBy.xpath("//XCUIElementTypeApplication[@name=\"Contacts\"]")) }
        contactNames                                            { $(MobileBy.xpath('//XCUIElementTypeApplication[@name="Contacts"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable')).find(By.className('XCUIElementTypeCell')).find(By.className('XCUIElementTypeStaticText'))}
        contactName             (to: ContactDetail_iOS)         { int pos -> contactNames[pos] }
    }

    void clickOnFirstContact() {
        contactName(0).click()
        sleep(3000)
    }

}

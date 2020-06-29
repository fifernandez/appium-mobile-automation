package pages.android

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactsList_Android extends Page {

    static at = {
        waitFor { barTitle.text() == 'Contacts' }
    }

	static content = {
        barTitle                                                    { $(MobileBy.id('action_bar')).find(By.className('android.widget.TextView'))}
        contactNames                                                { $(MobileBy.id('name'))}
        contactName             (to: ContactDetail_Android)         { int pos -> contactNames[pos] }
	}

    void clickOnFirstContact() {
        contactName(0).click()
    }

}

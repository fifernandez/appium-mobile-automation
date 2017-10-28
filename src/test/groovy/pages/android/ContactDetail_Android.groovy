package pages.android

import geb.Page
import io.appium.java_client.MobileBy
import org.openqa.selenium.By

class ContactDetail_Android extends Page {

    static at = {
        sleep(3000)
        waitFor { barTitle.text() == 'Contacts' }
    }

    static content = {
        barTitle                { $(MobileBy.id('action_bar')).find(MobileBy.className('android.widget.TextView')) }
        parameters              { $(MobileBy.id('content')).find(By.className('android.widget.TextView')) }
        name                    { $(MobileBy.id('detail_name')) }
        phone                   { $(MobileBy.id('phonenumber')) }
        email                   { $(MobileBy.id('email')) }
        address1                { $(MobileBy.id('street1')) }
        address2                { $(MobileBy.id('street2')) }
    }

}

package steps

import pages.GlobalEnvironment
import pages.android.ContactsList_Android
import pages.ios.ContactsList_iOS
import static cucumber.api.groovy.EN.*

Given(~/I am on the '((?:Contact List))'/) { String activityName ->
    switch (activityName) {
        case 'Contact List':
            if (GlobalEnvironment.getOsx() == 'Android')
                at ContactsList_Android
            else
                at ContactsList_iOS
            break
    }
}

Given(~/I click on the first contact name/) { ->
    page.clickOnFirstContact()
}

Then(~/On the contact detail screen, I must see: '((?:Name|Phone|Email|Address1|Address2))'/) { String item ->
    switch (item) {
        case 'Name':
            assert page.name.isDisplayed()
            break
        case 'Phone':
            assert page.phone.isDisplayed()
            break
        case 'Email':
            assert page.email.isDisplayed()
            break
        case 'Address1':
            assert page.address1.isDisplayed()
            break
        case 'Address2':
            assert page.address2.isDisplayed()
            break
        default:
            println "Item not declared!"
            assert false
            break
    }
}
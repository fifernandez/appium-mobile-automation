package steps

import pages.android.ContactsList_Android
import pages.ios.ContactsList_iOS
import static cucumber.api.groovy.EN.*

String osx = System.properties.getProperty('osx')

Given(~/I am on the '((?:Contact List))'/) { String activityName ->

	switch (activityName) {
		case 'Contact List':
			if (osx == 'android')
				at ContactsList_Android
			else
				at ContactsList_iOS
			break
	}

}

Given(~/I click on the first contact name/) { ->

	page.clickOnFirstContact()

}
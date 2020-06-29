import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver
import pages.GlobalEnvironment

DesiredCapabilities capabilities = new DesiredCapabilities()

environments {

	Android5 {
		GlobalEnvironment.setOSX('Android')
		capabilities.setCapability("deviceName", "Android5")
		capabilities.setCapability("platformVersion", "5.1.1")
	}

	Android7 {
		GlobalEnvironment.setOSX('Android')
		capabilities.setCapability("deviceName", "Android7")
		capabilities.setCapability("platformVersion", "7.0")
	}

	iPhone7 {
		GlobalEnvironment.setOSX('iOS')
		capabilities.setCapability("deviceName", "iPhone 7")
		capabilities.setCapability("platformVersion", "12.0")
	}

	capabilities.setCapability('noReset', true)
	if (GlobalEnvironment.getOsx() == 'Android') {
		String apkDir = "${new File(".").getCanonicalPath()}/app/Android/Contacts.apk"
		File app = new File(apkDir)
		capabilities.setCapability("app", app.getAbsolutePath())
		capabilities.setCapability("platformName", "Android")
		driver = {new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities) }
	}
	if (GlobalEnvironment.getOsx() == 'iOS') {
		String apkDir = "${new File(".").getCanonicalPath()}/app/iOS/ContactsSimulator.app"
		File app = new File(apkDir)
		capabilities.setCapability("app", app.getAbsolutePath())
		capabilities.setCapability("platformName", "iOS")
		capabilities.setCapability("automationName", "XCUITest")
		driver = { new IOSDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities) }
	}

}
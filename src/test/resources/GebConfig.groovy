import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver

String osx = System.properties.getProperty('osx')

DesiredCapabilities capabilities = new DesiredCapabilities()


environments {

	Android5 {
		capabilities.setCapability("deviceName", "Android5")
		capabilities.setCapability("platformVersion", "5.1.1")
	}

	Android7 {
		capabilities.setCapability("deviceName", "Android7")
		capabilities.setCapability("platformVersion", "7.1")
	}

	DeviceA52 {
		capabilities.setCapability("deviceName", "FranProne")
		capabilities.setCapability("platformVersion", "5.0.2")
	}

	DeviceA44 {
		capabilities.setCapability("deviceName", "SCH-l605")
		capabilities.setCapability("platformVersion", "4.4.2")
	}

	iPhone7 {
		capabilities.setCapability("platformName", "iOS")
		capabilities.setCapability("deviceName", "iPhone 7")
		capabilities.setCapability("platformVersion", "10.3")
	}

	iPhoneFran {
		capabilities.setCapability("platformName", "iOS")
		capabilities.setCapability("deviceName", "FranPhone")
		//capabilities.setCapability("platformVersion", "10.3.3")
		capabilities.setCapability("udid", "d7628209403c0f82bc174f69150f72875f6270c3")
	}


	if (osx == 'android') {
		String apkDir = "${new File(".").getCanonicalPath()}/app/Android/Contacts.apk"
		File app = new File(apkDir)
		capabilities.setCapability("app", app.getAbsolutePath())
		capabilities.setCapability("platformName", "Android")
		driver = {new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities) }
	}
	if (osx == 'ios') {
		String apkDir = "${new File(".").getCanonicalPath()}/app/iOS/ContactsSimulator.app"
		File app = new File(apkDir)
		capabilities.setCapability("app", app.getAbsolutePath())
		capabilities.setCapability("platformName", "iOS")
		capabilities.setCapability("deviceName", "iPhone 7")
		capabilities.setCapability("platformVersion", "10.3")
		capabilities.setCapability("automationName", "XCUITest")
		driver = { new IOSDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities) }
	}



}
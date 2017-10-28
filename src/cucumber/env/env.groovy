import static cucumber.api.groovy.Hooks.*
import org.openqa.selenium.OutputType
import geb.Browser
import geb.binding.BindingUpdater

def bindingUpdater
def theBrowser

Before { scenario ->
	if(!binding.hasVariable('browser')) {
		theBrowser = new Browser()
		bindingUpdater = new BindingUpdater(binding, theBrowser)
		bindingUpdater.initialize()
	} else {
		theBrowser = browser
	}

}

After { scenario ->
	if(scenario.failed) {
		scenario.embed(theBrowser.driver.getScreenshotAs(OutputType.BYTES), "image/png")

	}
	bindingUpdater?.remove()
	theBrowser.driver.resetApp()

}
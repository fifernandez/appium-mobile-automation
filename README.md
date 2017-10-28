# Basic Mobile Automation

The idea of this project is to help you start doing automation for cross platform Apps (Android & iOS).

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
If you want to run
Things you need to install
* [Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  with JAVA_HOME environment variable configured.
    * [Windows](https://stackoverflow.com/questions/2619584/how-to-set-java-home-on-windows-7/)
    * [Linux](https://stackoverflow.com/questions/24641536/how-to-set-java-home-in-linux-for-all-users)
    * [Mac](https://stackoverflow.com/questions/1348842/what-should-i-set-java-home-to-on-osx)
* [Appium](http://appium.io/) 
    * You can install it using [npm](https://www.npmjs.com/get-npm?utm_source=house&utm_medium=homepage&utm_campaign=free%20orgs&utm_term=Install%20npm)
    * Then you can run ```npm install -g appium```
* For Android: [Android SDK](https://git-for-windows.github.io/) with environment variables configured.
* For iOS: [XCode](https://developer.apple.com/xcode/)
* IntelliJ IDEA [(Community Version)](https://www.jetbrains.com/idea/download)
* Gitbash [(Only if using windows)](https://git-for-windows.github.io/)


### Installing

Clone this repo:

```
https://github.com/fifernandez/basic-mobile-automation.git
```

Navigate to the repo folder and run

```
./gradlew build idea
```

Run IntelliJ and before opening the project
```
click on configure -> project defaults -> project structure.
Inside project sdk click on new and search the folder where you installed java sdk, and click on Ok.
Now go to configure -> plugins -> install jetbrains plugins.
Search cucumber for groovy and isntall it with all the other required plugins that intellij informs.
Close and restart when prompted.
```

Now lets open the project in IntelliJ
```
Click on open, search for the project folder and click on ok.
Wait for loading.
Click on import gradle project and click on ok.
Wait for loading.
On the menu bar clin on view -> tool windows -> project
folders : features and groovy must be marked as test sources root (green)
folders: resources must be marked as test resources root (yellow icon)
```

## Running the tests
To start the Appium server, Open a console and run:
```
appium -a 127.0.0.1 -p 4444
```

Then ou can run the tests, open a different console (leave the previous one running) and run:
```
./gradlew cucumber -Pdevice=Android7 -Posx=android
```

Same sample for iOS:
```
./gradlew cucumber -Pdevice=iPhone7 -Posx=ios
```

#### Special Parameters

* -Posx: defines the system where you will run.
    * Availables: android | ios
* -Pdevice: defines the model of the device you will run (real, simulator, emulator)
    * Availables:
        * iPhone7: Simulator for iPhone7 with ios 10.3
        * Android7: Android Emulator with Android 7.1
        * Android5: Android Emulator with Android 5.1.1
    * You can add your models in GebConfig.groovy file.
* -Ptags: defines the scenario/s you want to run
    * If not present then it will run for all
    * The tag is define in the first line of the cucumber file
    * Sample: -Ptags="@Boca"


### And coding style tests

* Write the features in the features folder
    * Assign tags to them
    * You can parametrize the scenario using 'Scenario Outline'
* Define your steps in the steps folder
   * Parametrize buttons, fields, inputs so you can easily reuse steps
   * Keep good organization of the files, it' a good idea to have one step file per page
* Create your pages/modules files in the groovy folder
    * Make a good use of the [Page Object pattern](http://docs.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern)
* To config your drivers edit: GebConfig.groovy 
* For changing cucumber configs edit: env.groovy

## Built With

* [Cucumber](https://cucumber.io/) - For writing the tests scenarios
* [Geb](http://www.gebish.org/) - For the browser automation
* [Appium](http://appium.io/documentation.html) - For the Android driver
* [Groovy](http://groovy-lang.org/) - For writing the steps implementations
* [Gradle](https://gradle.org/) - For building and running

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

* **Fran Fernandez** - [fifernandez](https://github.com/fifernandez)

See also the list of [contributors](https://github.com/fifernandez/basic-web-automation) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

*
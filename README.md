cibrary-2014
============

Repository used for the library application developed during Ciber academy 2014

# Clone the repository
* Start git bash.
* Change directory (cd) into a directory where development projects are stored (e.g. `c:\dev\`,
but the actual directory is immaterial)
* Create directory CiberAcademy2014 (mkdir)
* Type `git clone git@github.com:CiberNorge/cibrary-2014.git`
* Change directory to the downloaded directory (“cibrary-2014”)
* Type `gradlew clean build` (output: Build successful)

# Open project in IntelliJ
* Open IntelliJ and choose import project
* Select the academy-2014 directory
* Import project from external model
* Make sure the radio button “Use customizable gradle wrapper” is enabled. The gradle project path is
`<pathToProject>\build.gradle`.

#Run the application
* Locate the class `LocalApplication` in the project view.
(´cibrary-2014\src\test\java\no\ciber\academy\LocalApplication´)
* Right click in the project view and select `Run/Debug LocalApplication....main()`
* When the Console says 'Started LocalApplication in ....' open a browser and go to url [http://localhost:8080/](http://localhost:8080/)
* You're supposed to see some text.


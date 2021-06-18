Jenkins – Maven Project Integration 
====================================

Make sure Maven is installed in your system

-   Downloading Maven - <https://maven.apache.org/download.cgi>

-   Add a MAVEN_HOME system variables and point it to the Maven folder.

-   Check Maven Installation by Running "**mvn –version**" on command line

### Configure Maven in Jenkins

Install below plug-ins in Jenkins

-   Maven Integration

-   Maven SNAPSHOT Check

Jenkins Dashboard \> Manage \> Global Tool Configuration

![](media/7183673595b859bffc140df03217d21a.png)

To configure Java, click on "Add JDK"

![](media/f42dc08069ee10ac7603523819a110e0.png)

Provide Name, JAVA_HOME - Provide Java Home Path – save

![](media/d1a753ffccc73d5b2e8c6e4cbdc8f6b4.png)

To configure Maven, click on "Add Maven" , MAVEN_HOME- Provide Maven Home Path

![](media/f44bd50eb4f542c19403a5c1f730ba92.png)

![](media/262cd233268b075a901a52efdc71c431.png)

### Jenkins –Creating Maven Job 

I have a sample maven project in my local system at
**C:\\Users\\Kavetis\\Downloads\\springmvcexample**”. To build this project with
Jenkins follow below steps.

Make sure **Maven Integration** plugin is installed. Click on the New Item link
to create a CI job. & Select the Maven project radio button

![](media/16c4f7a8e30ea8a9f1c4f08531825cfd.png)

Go to the Build section of new job.

-   In the Root POM textbox, enter full path to pom.xml

-   In Goals and options section, enter **clean install** (*without mvn*)&
    Save/Apply

![](media/13a057ae6ff5f40c531128c8d5cbf311.png)

click on the **Build Now** link.

![](media/2aa1cfc342d011975e3bbb8fe954744d.png)

![](media/6a8a37707f0c13962d0c8ed8e71fdc02.png)

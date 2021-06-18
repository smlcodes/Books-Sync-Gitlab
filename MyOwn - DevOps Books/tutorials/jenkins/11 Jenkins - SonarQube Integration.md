Jenkins - SonarQube Integration
===============================

**Add SonarQube Plug-in**

Go to Jenkins dashboard -\> Manage Jenkins -\> Manage Plugins -\> Available -\>
[SonarQube Scanner](https://plugins.jenkins.io/sonar)-\> Install without
restart.

![](media/7e915c5c71451dd0486d13b2cca08320.png)

**Configure SonarQube Server in Jenkins**

Manage Jenkins \> Configure System \> **SonarQube servers \>** Check : Enable
Injection & Add SonarQube

![](media/0de98b1e012db93e8aea30cd74e8e60a.png)

**Create a Job to Configure SonarQube integration**

-   Go to Jenkins dashboard \> New Item (Maven-SonarQube) \> Maven project.

-   Provide the repository URL (e.g.
    [github](https://github.com/shivajivarma/bus-reservation-system)) in the SCM
    section of the project configuration window.

**Build Environment** : [Tick] - Prepare SonarQube Scanner environment

![](media/25c97aeb30f73dfd89288896bd12baf9.png)

**Build** : Normal maven build

![](media/dbdaf5e06fadc306ff4ac17146eb7938.png)

**Post-build Actions** \> Add post-build action \> Select : **SonarQube analysis
with Maven**

![](media/70efbdce136e580139a48974d2d9a52a.png)

**Save & Build Now**

it will publish results to SonarQube Server once scan complete.

![](media/e06a38cb549b71dadd549a18c76d6c36.png)

![](media/7b9c77d0238abe485a60917e54ea0f75.png)

Click on SonarQube link , it will navigate to Sonarqube Server ,Shows Project
Results

![](media/e10c1cf77b37c6c9d2ed8c9d57bebef3.png)

Jenkins – Build Metrics 
========================

Jenkins metrics are useful to see the build and to understand how frequently
they fail/pass over time.

### Build History Metrics Plugin

We have **"Build History Metrics Plugin",** provides the following metrics for
all of the build

-   MTTF (Metrics Time to Failure)

-   MTTR (Mean Time to Recovery)

-   Standard Deviation of Build Times

Install Plugin.

![](media/965207426207acfd9c1642e68c473e56.png)

No additional configuration required. Just open any job

![](media/890ec2835cd5aea5c75d6d5714105638.png)

### Build-metrics 

We have another plugin - **Build-metrics** , display build stats in a graphical
format

Install Plugin : **Build-metrics** 

Manage Jenkins \> Global Build Stats \> **Initialize stats**

![](media/d68de477f3a85c16b4a94229fe641828.png)

![](media/0aaf069bae05c60cb7c0ad2792a0c629.png)

Once you click the **Initialize stats** button, Jenkins will gather all the
existing build records which are already been carried out, and **charts can be
created based on these results**.

Once you click this button, you will see a text "**data successful
initialized**"

**Create Chart**

Once the data has been initialized, it is the time to create a new chart. To
create the new chart, click on "**Create new chart configuration**" link.
Provide details, for example

-   Title - give any label, I have given "Result"

-   Chart Width - 600

-   Chart Height - 500

-   Chart time scale - Daily

-   Chart time length - 30 days

![](media/5522eb7ff23039c2015ea6ec14fe7acb.png)

It will Display the Stats on Same page.

![](media/c4b747aaf4cb68e9c6f1bf51611e12f4.png)

Jenkins – Back up Jenkins
-------------------------

Jenkins provides a **backup** plugin which can be used to get backup critical
configuration settings - includes job configs, plugins, build logs, plugin
configuration, etc.

Install Plugin : **backup**

![](media/ac0c39af6e1cf250eb5b6411aa7ad128.png)

Now, go to Manage Jenkins \> Backup manager \> **setup : provide details**

![](media/efbe1b41789d72401ec129f8e23b93fa.png)

**To Backup : Click on ‘Backup Hudson Configuration’**

![](media/17957b5e39d929c0e5dcad74737b2d26.png)

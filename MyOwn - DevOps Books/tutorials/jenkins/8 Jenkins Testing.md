Jenkins Testing
===============

Jenkins – Junit Reporting using ANT
-----------------------------------

Create Job \> Free Style

**Build \>Add Build Step\> Invoke Ant :** provide below details

![](media/2c7bfbd8e3638d86ecfbc6f27f2fc674.png)

Next, **Post-build Step \> choose “Publish Junit test result report”**

![](media/22e8488d66438de94697342c8bd409ad.png)

Test report XMLs - location of reports xmls

![](media/004e3e129518a1aca5112478563ba4c9.png)

-   For maven projects it will automatically generates the JUnit Reports.

    ![](media/14df6d6ac6d3587198a4323f3f070507.png)

-   For selenium, we need to add **“Hudson Selenium Plugin”**

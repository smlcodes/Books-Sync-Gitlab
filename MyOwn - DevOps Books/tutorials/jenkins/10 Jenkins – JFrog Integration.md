Jenkins – JFrog Integration
===========================

**Add Artifactory Plugin to Jenkins**

Go to Jenkins dashboard -\> Manage Jenkins -\> Manage Plugins -\> Available -\>
**Artifactory** -\> Install without restart.

![](media/eba32591d8010451d1eaf7f1b369dcd2.png)

**Configure Artifactory-related settings in Jenkins**

Go to Jenkins dashboard -\> Configure System -\>Artifactory section -\>Add
artifactory server -\> provide the details -\> Test the connection -\>apply &
save

![](media/75cc82c80875a5447590ea03ffccfe00.png)

**Configure Project** : to creates package file after compiling all of the
source files.

Go to Build Environment section -\> Resolve artifacts from artifactory -\> Click
on refresh Repositories -\>select the repository in release and snapshot field
from the lists.

![](media/0f068c38e8e38d32dad95b531caadf02.png)

**post-build section**

Go to Add post-build section -\>select **deploy artifacts to artifactory** -\>
click on refresh -\> choose the target releases and snapshot repository
(repositories created earlier) -\>save

![](media/1d41855cdc2ddc8f3098ad16358bbb64.png)

**Click on Build now.**

Jar files are resolved from the local repository or Artifactory.

**check the package**

Once the package is created, it is stored in artifactory too. Go in the
artifactory and check the package.

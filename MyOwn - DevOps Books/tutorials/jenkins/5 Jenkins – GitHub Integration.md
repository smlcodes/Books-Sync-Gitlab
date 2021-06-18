Jenkins – GitHub Integration 
=============================

Jenkins is a Continuous Integration Tool; it needs to check out source code from
a repository and build code.

### Install GitHub Plugin

Jenkins Dashboard\> Manage Jenkins\> Manage Plugins.

![](media/d635884914bfc0e544cf525446df42b6.png)

Next page – click on the "Available tab”. Search for "Git Plugin", Install it.
Installed plug-ins can be shown in "installed" tab.

![](media/1194ad37d35667bd7e04ac8d51aa4357.png)

­­

### Integrating Jenkins with GitHub

We must have Git installed in your system

Jenkins Dashboard \> Create new job

![](media/96b2c284e650a42476838aabdafafcc1.png)

Now enter the item name and select the job type. For example, item name is
"GithubJob" and job type is "Freestyle project". Then OK

![](media/4e3bb0f14b01779333263570246ab678.png)

Go to “Source Code Management” Tab \> Select Git \> Provide Github Repo URL
\>Save / Apply

Example : <https://github.com/smlcodes/JSPMaven.git>

![](media/2706278a413914dbdf8d0d8d1293e0cf.png)

To Check Integration just Build it.

![](media/0a59301b464c4207a21122863520d523.png)

If build Success, it is integrated propetly.

![](media/76d514cd676985695b2ba40fcb676d84.png)

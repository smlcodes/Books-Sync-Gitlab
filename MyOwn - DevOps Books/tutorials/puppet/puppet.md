Puppet – Introduction
=====================

Puppet is a Configuration Management tool that is used for deploying,
configuring and managing servers. It performs the following functions:

-   Defining distinct configurations for each and every host, and continuously
    checking and confirming whether the required configuration is in place and
    is not altered (if altered Puppet will revert back to the required
    configuration) on the host.

-   Dynamic scaling-up and scaling-down of machines.

-   Providing control over all your configured machines, so a centralized
    (master-server or repo-based) change gets propagated to all, automatically.

Puppet Introduction
-------------------

Puppet comes in two varieties, Puppet Enterprise and open source Puppet. It runs
on most Linux distributions, various UNIX platforms, and Windows.

**Puppet master(Puppet Server)** server—which runs the Puppet Server
software—can be used to control all your other servers, or **Puppet
agent** nodes.

![puppet configuration](media/b4b32be4d588feb8f5cda141d7d15948.jpg)

Puppet will always check the configuration from remote for every 30 minutes , if
any changes it will automatically update those.

### **The Puppet Environment** 

-   **Puppet Labs**- The Company behind Puppet

-   **Puppet**- The Opensource version

-   **Puppet Enterprise** - The commercial version

-   **Puppet Documentation** - Main and Official reference

-   **The Community** - Forums, User groups etc.

-   Puppet Modules on: Module Forge and GitHub

Architecture of Puppet
----------------------

![](media/2b1c1ed91b9b1916e3a5e892e8bc7ae5.jpg)

**Puppet Master**

Puppet Master is the key mechanism which handles all the configuration related
stuff. It applies the configuration to nodes using the Puppet agent.

**Puppet Agent**

Puppet Agents are the actual working machines which are managed by the Puppet
master. They have the Puppet agent daemon service running inside them.

**Config Repository**

This is the repo where all nodes and server-related configurations are saved and
pulled when required.

**Facts**

**Facts** are the details related to the node or the master machine, which are
basically used for analyzing the current status of any node. On the basis of
facts, changes are done on any target machine. There are pre-defined and custom
facts in Puppet.

**Catalog**

All the manifest files or configuration which are written in Puppet are first
converted to a compiled format called catalog and later those catalogs are
applied on the target machine.

How it Works

![Puppet Master Slave Architecture - Puppet Tutorial - Edureka](media/1f06c5f4488c4f10512e5c9552630abe.png)

The following functions are performed in the above image:

-   The Puppet Agent sends the Facts to the Puppet Master. Facts are
    basically key/value data pair that represents some aspect of Slave state,
    such as its IP address, up-time, operating system, or whether it’s a virtual
    machine. I will explain Facts in detail later in the blog.

-   Puppet Master uses the facts to compile a Catalog that defines how the
    Slave should be configured. Catalog is a document that describes the desired
    state for each resource that Puppet Master manages on a Slave. I will
    explain catalogs and resources in detail later.

-   Puppet Slave reports back to Master indicating that Configuration is
    complete, which is visible in the Puppet dashboard.

Puppet Master and Slave Communication
-------------------------------------

![ SSL Connection Between Puppet Master and Puppet Slave - What is Puppet - Edureka](media/014df738b0965951c226c0e82b150d3e.png)

As you can see from the above Image:

-   Puppet Slave asks for Puppet Master certificate.

-   After receiving Puppet Master certificate, Master requests for Slave
    certificate.

-   Once Master has signed the Slave certificate, Slave requests for
    configuration/data.

-   Finally, Puppet Master will send the configuration to Puppet Slave.

![Image result for chef vs puppet](media/1189013ac8a501903749a1fa9d14f5b7.png)

-   Puppet is used as either a local system command line tool or in a
    client-server relationship

-   Server acts as the **Puppet master** and applies configuration to multiple
    client systems using a **Puppet agent**

-   This provides a way to automatically configure newly provisioned systems,
    either individually or simultaneously to create a specific infrastructure

Puppet Terminology
------------------

![](media/82ffc5cb84ab025a7013e7c35bd57a9d.png)

**Resources**

-   File

-   User

-   Service

-   Package

**Modules**

Group of Resources are called Modules

**Profiles**

Group of Modules are called as Profiles.

**Roles**

Group of Profiles are called as Roles

### Resources 

Puppet code is primarily composed of resource declarations

A resource describes about the state of the system, e.g. a certain user or file
should exist, or a package should be installed

Resource declarations can be formatted as follows:

resource_type

{

'resource_name'

attribute =\> value

...

}

Example for Resource declaration :

user

{

'mitchell':

ensure =\> present,

uid =\> '1000',

gid =\> '1000',

shell =\> '/bin/bash',

home =\> '/home/mitchell'

}

This resource declaration describes a user resource named 'mitchell', with the
specified attributes

To list all of the default resource types that are available to Puppet, enter
the following command:

puppet resource --types

### Manifests

Puppet programs are called manifests. Manifests are composed of puppet code and
their filenames use the .pp extension

The default main manifest in Puppet installed via apt is :

/etc/puppet/manifests/site.pp.

### Class

In Puppet, classes are code blocks that can be called in a code elsewhere. Using
classes allows you to reuse Puppet code, and can make reading manifests easier

Class Definition

class example_class

{

...

code

...

}

Class declaration occurs when a class is called in a manifest .A class
declaration tells Puppet to evaluate the code within the class .

Class declarations come in two different flavors: normal and resource-like

**A normal class declaration** occurs when the include keyword is used in Puppet
code, like:

include example_class

**A resource-like** class declaration occurs when a class is declared like a
resource, like:

class { 'example_class': }

### Modules

-   A module is a collection of manifests and data (such as facts, files, and
    templates), and they have a specific directory structure

-   Modules are useful for organizing your Puppet code, because they allow you
    to split your code into multiple manifests

-   It is considered best practice to use modules to organize almost all of your
    Puppet manifests

-   To add a module to Puppet, place it in the **/etc/puppet/modules directory**

![](media/5c5214b279c0a49a61bdc58a927af2dc.png)

**Node**

A node is an individual server or device managed by Puppet.

**Resources**

Resources are individual units of configuration in Puppet.

-   **Built-in resource types** include things like files and system users.

-   **Custom resource types** that combine built-in types can also be defined.

**Class**

-   A class is a collection of Puppet code that makes sense as a logical group.

-   Classes group together resources under a name that can be included in other
    code.

**Manifest**

-   A Manifest is a text file for holding Puppet code.

-   Manifests use a .pp file extension.

-   A Manifest should contain a single class or defined resource type.

**Profile**

A Profile is a class that defines a specific set of configuration, generally
grouping together other classes with specific parameters. Profiles should be
limited in the scope of what they configure.

**Role**

-   A role is a class that defines the so-called business role of a node.

-   Roles are generally built of several profile classes.

-   Each node should have only one role.

-   If two nodes are nearly identical, they should still have unique roles
    defined.

Installation
------------

Debian, Ubuntu  
Available by default

apt-get install puppet       \# On clients (nodes)

apt-get install puppetmaster \# On server (master)

RedHat, Centos, Fedora  
Add EPEL repository or RHN Extra channel

yum install puppet        \# On clients (nodes)

yum install puppet-server \# On server (master)

### Puppet Master Installation 

**Install Puppet Server on CentOS**

Hostname

\#Add puppet repository

rpm -Uvh <https://yum.puppet.com/puppet6-release-el-7.noarch.rpm>

\#Install puppetserver

yum install -y puppetserver git vim

vim /etc/sysconfig/puppetserver

git --version

vim --version

puppet –version

\#Check Status puppetserver

systemctl start puppetserver

systemctl status puppetserver

\#to make puppetserver start with system boot

systemctl enable puppetserver

vi /etc/sysconfig/puppetserver

systemctl start puppetserver

vi /etc/sysconfig/puppetserver

#### Configurations

**Open Firewall Ports on Machines**

To make the Puppet server manage the client’s server centrally, one needs to
open a specified port on all the machines, i.e. **8140**

**Puppet Configuration File**

The main configuration file for Puppet is **etc/puppet/puppet.conf**.

All Puppet related settings such as the definition of Puppet master, Puppet
agent, Puppet apply and certificates are defined in this file.

To this host as **puppetmaster** as well as **puppetnode** edit

vi /etc/puppetlabs/puppet/puppet.conf

\# This file can be used to override the default puppet settings.

\# See the following links for more details on what settings are available:

\# - https://puppet.com/docs/puppet/latest/config_important_settings.html

\# - https://puppet.com/docs/puppet/latest/config_about_settings.html

\# - https://puppet.com/docs/puppet/latest/config_file_main.html

\# - https://puppet.com/docs/puppet/latest/configuration.html

[master]

vardir = /opt/puppetlabs/server/data/puppetserver

logdir = /var/log/puppetlabs/puppetserver

rundir = /var/run/puppetlabs/puppetserver

pidfile = /var/run/puppetlabs/puppetserver/puppetserver.pid

codedir = /etc/puppetlabs/code

[agent]

server = master.puppet.vm

We need to use Puppet Specific ruby version to install gems. For that

\# vi .bash_profile

PATH=\$PATH:/opt/puppetlabs/puppet/bin

PATH=\$PATH:\$HOME/.local/bin:\$HOME/bin

export PATH

\# save and active bash

exec bash

source .bash_profile

Install our first Gem, r10k

gem install r10k

### Puppet Agent Node Installation

If one wants to manage any server using the Puppet master, the **Puppet agent**
software needs to be installed on that particular server.

In general, the Puppet agent will be installed on all the machines excluding the
Puppet master machine on any given infrastructure.

Running Puppet agent
--------------------

Run below command to start puppet agent

puppet agent -t

[root\@puppet vagrant]\# puppet agent -t

Info: Using configured environment 'production'

Info: Retrieving pluginfacts

Info: Retrieving plugin

Info: Retrieving locales

Info: Caching catalog for puppet.master.vm

Info: Applying configuration version '1584098543'

Info: Creating state file /opt/puppetlabs/puppet/cache/state/state.yaml

Notice: Applied catalog in 0.13 seconds

Version Control System 
-----------------------

Puppet defines your infrastructure as code, so we can use version control to
track those changes.

To use version control for Puppet, we'll set up what's called a control
repository, or control repo. We'll configure an open source tool called r10k to
point at the control repo. 

And, when it runs, it will deploy the code to the Puppet master. The control
repo is a set of directories and files set up in a specific way that r10k
understands. 

![](media/0acb2be202b76ca35217280e791a282b.png)

### Create GitHub repository

Login into Github, create new Repository

![](media/070b759fabbfdd6f5b96c838574ff9a8.png)

**Create new Brach “production” and make production as default branch.**

On Branches Menu, type \`production\` & create branch

![](media/a5941dd99369272cc6777137d118884d.png)

To make default branch, Go to Settings \> Branches \> select default Branch :
Production

![](media/d010f75ff2a06a79ca91182321083fef.png)

Delete master branch – to avoid confusion.

Go to Home Code Tab \> on Top select Branches \> Delete master branch

![](media/a409d5c654e300a16c7718842f45e808.png)

### Clone/Download code from Github

We are using r10k. We need to tell r10k where our puppet_repo is. For that we
need to provide some configuration on the master.

**Create Directory for saving code**

mkdir /etc/puppetlabs/r10k

**Create yaml file, r10k.yaml**

\# vi /etc/puppetlabs/r10k/r10k.yaml

\---

:cachedir: 'var/cache/r10k'

:sources:

:my-org

remote: 'https://github.com/smlcodes/puppet_repo.git'

basedir: '/etc/puppetlabs/code/environments'

To deploy/download code we use below command

r10k deploy environment -p

It will clone/download code from github to basedir,
i.e:/etc/puppetlabs/code/environments

\# check them

cd /etc/puppetlabs/code/environments

![](media/b8c571e41f808226662dcaf627fcd1b8.png)

Puppet Directory
----------------

Directory Structure

\- manifests

\\- site.pp

\- modules

\\- your modules

\- test

\\- update-puppet.sh

\\- Vagrantfile

\- puppet.conf

Puppet – Resources
==================

Resources are a way of defining a specific unit of configuration. For example, a
file or a system user would be a single resource.

### Resource Syntx

![](media/76d0b5ddc6bdbf39830b6eb38ba9a936.png)

![](media/58c781ff44ed324f6d45bbb60ff391b1.png)

![](media/3b14ccad359037764741a940ed809856.png)

Hello world
-----------

![](media/5dfb57df55e5fb537a10b713c9f791f5.png)

Push to master

![](media/73909d6f73b1c44523236d1924c83a82.png)

Class
-----

![](media/e989356bff5c504257ce647178831b9e.png)

![](media/0d877c4e975f204ab2ba33f017d56a10.png)

Puppet forge
------------

<https://forge.puppet.com/>

Puppet code can be packaged into modules in order to be shared with others on
the Puppet Forge.

Ref.
====

<https://www.linkedin.com/learning/learning-puppet/what-is-puppet?u=2057244>

<https://www.digitalocean.com/community/tutorials/getting-started-with-puppet-code-manifests-and-modules>

Errors
======

#### Job for puppetserver.service failed because the control process exited with error code

Changed memory to 250m (JAVA_ARGS="-Xms250m -Xmx250m). It worked.  
May be its 50% of free memory (free -m)

free memory was 440 initially. i kept 400 in JAVA_ARGS initially.

#### ubuntu systemctl: command not found

1.  First you need to check if **systemd** package is installed - sudo dpkg -l
    \| grep systemd.

2.  If not then install it by hands sudo apt-get install systemd. But if it does
    it might be damaged, so you may try to reinstall it sudo apt-get install
    --reinstall systemd.

3.  If the package is installed, even after reinstallation it does not work,
    list the full path of the files inside this package sudo dpkg -L systemd.
    Maybe binary files are located in a directory that is not included
    into **\$PATH** variable.

#### puppetserver.service: Loaded: error (Reason: No such file or directory)

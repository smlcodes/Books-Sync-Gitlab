Chef – Provisioning
===================

Chef Provisioning helps you to use the power of Chef to create your whole
infrastructure for you.

No matter whether you want to create a cluster of Vagrant
boxes, [Docker](https://subscription.packtpub.com/tech/docker) instances, or
Cloud servers, Chef Provisioning lets you define your infrastructure in a simple
recipe and run it idempotently.

how “to create a Vagrant machine and install nginx “on it
---------------------------------------------------------

Chef Provisioning comes with a selection of drivers for all kinds of
infrastructures, including Fog (supporting Amazon
EC2, [OpenStack](https://subscription.packtpub.com/search?released=Available&tool=OpenStack),
and others), VMware VSphere, Vagrant (supporting Virtualbox and VMware Fusion),
various Containers, such as
LXC [Docker](https://subscription.packtpub.com/tech/docker) “and Secure Shell
(SSH).

In this recipe, we make sure that we can use the directives provided by Chef
Provisioning by requiring *chef/provisioning* library.

Then, we configure the driver that we want to use. We use Vagrant and tell Chef
to use the *opscode-ubuntu-14.04* Vagrant box to spin up our machine.

Using the machine resource, we ask Chef to spin up a Vagrant machine and
configure it using Chef by applying the role *web_server*.

The *web_server* role uses the cookbook *my_cookbook* to configure the newly
created Vagrant machine. To make sure that all the required cookbooks are
available to Chef, we use *berks install* and *berks vendor cookbooks*.
The *berks vendor cookbooks* installs all the required cookbooks in the local
cookbooks directory. The Chef client can access the cookbooks here, without the
need for a Chef server.

Finally, we use the Chef client to execute our Chef Provisioning recipe. It will
spin up the defined Vagrant machine and execute a Chef client run on it.

Chef Provisioning will put the Vagrant Virtual Machine (VM) definition into the
directory *\~/.chef/vms*. To manage the Vagrant VM, you need to change to this
directory.

**Describe your Vagrant machine in a recipe called mycluster.rb:**

mma\@laptop:\~/chef-repo \$ subl mycluster.rb

require 'chef/provisioning'

with_driver 'vagrant'

with_machine_options :vagrant_options =\> { 'vm.box' =\> 'opscode-ubuntu-14.04'
}

machine 'web01' do

role 'web_server'

end

**Install all required cookbooks in your local chef-repo:**

mma\@laptop:\~/chef-repo \$ berks install

mma\@laptop:\~/chef-repo \$ berks vendor cookbooks

Resolving cookbook dependencies...

Using apt (2.6.1)

...TRUNCATED OUTPUT...

Vendoring yum-epel (0.6.0) to cookbooks/yum-epel

Run the Chef client in local mode to bring up the Vagrant machine and execute a
Chef run on it:

mma\@laptop:\~/chef-repo \$ chef-client -z mycluster.rb

[2015-03-08T21:09:39+01:00] INFO: Starting chef-zero on host localhost, port
8889 with repository at repository at /Users/mma/work/chef-repo

...TRUNCATED OUTPUT...

Recipe: \@recipe_files::/Users/mma/work/chef-repo/mycluster.rb

\* machine[webserver] action converge[2015-03-08T21:09:43+01:00] INFO:
Processing machine[web01] action converge
(\@recipe_files::/Users/mma/work/chef-repo/mycluster.rb line 6)

...TRUNCATED OUTPUT...

[2015-03-08T21:09:47+01:00] INFO: Executing sudo chef-client -l info on
vagrant\@127.0.0.1

[web01] [2015-03-08T20:09:21+00:00] INFO: Forking chef instance to converge...

Starting Chef Client, version 12.1.0

...TRUNCATED OUTPUT...

Chef Client finished, 18/25 resources updated in 73.839065458 seconds

...TRUNCATED OUTPUT...

[2015-03-08T21:11:05+01:00] INFO: Completed chef-client -l info on
vagrant\@127.0.0.1: exit status 0

\- run 'chef-client -l info' on web01

[2015-03-08T21:11:05+01:00] INFO: Chef Run complete in 82.948293 seconds

...TRUNCATED OUTPUT...

Chef Client finished, 1/1 resources updated in 85.914979 seconds

Change” into the directory where Chef put the Vagrant configuration:

mma\@laptop:\~/chef-repo \$ cd \~/.chef/vms

Validate that there is a Vagrant machine named web01 running:

mma\@laptop:\~/.chef/vms \$ vagrant status

Current machine states:

web01 running (virtualbox)

Validate that nginx is installed and running on the Vagrant machine:

mma\@laptop:\~/.chef/vms \$ vagrant ssh

vagrant\@web01:\~\$ wget localhost:80

...TRUNCATED OUTPUT...

2015-03-08 22:14:45 (2.80 MB/s) - 'index.html' saved [21/21]

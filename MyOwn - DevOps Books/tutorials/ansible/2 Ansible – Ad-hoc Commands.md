Ansible – Ad-hoc Commands
=========================

An Ansible ad-hoc command uses the **/usr/bin/ansible** command-line tool to
automate a single task on one or more managed nodes. Ad-hoc commands are great
for tasks you repeat rarely.

for example, if you want to power off all the machines in your lab for Christmas
vacation, you could execute a quick one-liner in Ansible without writing a
playbook.

**Syntax**

ansible [hsotpattern] -m [module] -a "[module options]"

Ad-hoc tasks can be used to reboot servers, copy files, manage packages and
users etc.

Ex \#1 - I want to re-boot all [web] servers

ansible web -a "/sbin/reboot"

Ex \#2 - By default Ansible uses only 5 simultaneous processes, I have 100
Servers - To reboot the [web] servers with 10 parallel forks/processes

ansible web -a "/sbin/reboot" -f 10

**Copy Module** : used for transfer files from Master to host nodes.

\# To transfer a file from Ansible master to all servers in the [web] group:

ansible web -m copy -a "src=/etc/hosts dest=/tmp/hosts"

**File Module** : used for Create/Copy/Delete files or folders from Hosts

\# file module allows changing ownership and permissions on files.

ansible web -m file -a "dest=/srv/foo/a.txt mode=600"

ansible web -m file -a "dest=/srv/foo/b.txt mode=600 owner=mdehaan
group=mdehaan"

\#The file module can also create directories, similar to mkdir -p:

ansible web -m file -a "dest=/path/to/c mode=755 owner=mdehaan group=mdehaan
state=directory"

\#To delete directories (recursively) and delete files:

ansible webservers -m file -a "dest=/path/to/c state=absent"

**yum Module**: to install, update, or remove packages on managed nodes

\# To ensure a specific version of a package is installed:

\$ ansible webservers -m yum -a "name=acme-1.5 state=present"

\# To ensure a package is at the latest version:

\$ ansible webservers -m yum -a "name=acme state=latest"

\# To ensure a package is not installed:

\$ ansible webservers -m yum -a "name=acme state=absent"

**user Module**: create, manage, and remove user accounts

\$ ansible all -m user -a "name=foo password=\<crypted password here\>"

\$ ansible all -m user -a "name=foo state=absent"

**service Module**: start/stop services

\# Ensure a service is started on all webservers:

\$ ansible webservers -m service -a "name=httpd state=started"

\# restart a service on all webservers:

\$ ansible webservers -m service -a "name=httpd state=restarted"

\# Ensure a service is stopped:

\$ ansible webservers -m service -a "name=httpd state=stopped"

Ansible – Command Line Tools
----------------------------

1.  **ansible**

Used to Define and run a single task ‘playbook’ against a set of hosts. Mostly
we used this for running Ad-hoc commands

ansible web -a "/sbin/reboot"

1.  **ansible-config**

View ansible configuration.

vagrant\@master:\~/Ansible\$ ansible-config --version

ansible-config 2.9.4

config file = /etc/ansible/ansible.cfg

configured module search path = [u'/home/vagrant/.ansible/plugins/modules',
u'/usr/share/ansible/plugins

/modules']

ansible python module location = /usr/lib/python2.7/dist-packages/ansible

executable location = /usr/bin/ansible-config

python version = 2.7.6 (default, Nov 13 2018, 12:45:42) [GCC 4.8.4]

1.  **ansible-console**

    a REPL that allows for running ad-hoc tasks against a chosen inventory

2.  **ansible-doc**

    displays information on modules installed in Ansible libraries. It displays
    a terse listing of plugins and their short descriptions, provides a printout
    of their DOCUMENTATION strings, and it can create a short “snippet” which
    can be pasted into a playbook.

3.  **ansible-galaxy**

    command to manage Ansible roles in shared repositories, the default of which
    is Ansible Galaxy https://galaxy.ansible.com.

4.  **ansible-inventory**

    used to display or dump the configured inventory as Ansible sees i

5.  **ansible-playbook**

    Runs Ansible playbooks, executing the defined tasks on the targeted hosts.

6.  **ansible-pull**

    pulls playbooks from a VCS repo and executes them for the local host

7.  **ansible-vault**

    encryption/decryption utility for Ansible data files

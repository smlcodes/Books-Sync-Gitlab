Ansible – Modules 
==================

Ansible [modules](https://docs.ansible.com/ansible/latest/user_guide/modules.html) are
standalone scripts that can be used inside an Ansible playbook. A playbook
consists of a play, and a play consists of tasks.

**1. Package management**

-   There is a module for most popular package managers, such as DNF and APT, to
    enable you to install any package on a system.

-   It covers YUM module (required for Python 2 compatibility)
    is [yum_module](https://docs.ansible.com/ansible/latest/modules/yum_module.html),
    while the APT module
    is [apt_module](https://docs.ansible.com/ansible/latest/modules/apt_module.html),
    the Slackpkg module
    is [slackpkg_module](https://docs.ansible.com/ansible/latest/modules/slackpkg_module.html),
    and so on.

Example

\- name: Install a list of packages

yum:

name:

\- nginx

\- postgresql

\- postgresql-server

state: present

This installs the list of packages and helps download multiple packages

**2: Service**

After installing a package, you need a module to start it. The service module
enables you to start, stop, and reload installed packages; this comes in pretty
handy.

Example 1:

\- name: Start service foo, based on running process /usr/bin/foo

service:

name: foo

pattern: /usr/bin/foo

state: started

This starts the service foo.

Example 2:

\- name: Restart network service for interface eth0

service:

name: network

state: restarted

args: eth0

This restarts the network service of the interface eth0.

**3: Copy**

The [copy
module](https://docs.ansible.com/ansible/latest/modules/copy_module.html) copies
a file from the local or remote machine to a location on the remote machine.

Example 1:

**- name: **Copy a new **"ntp.conf file into place, backing up the original if
it differs from the copied version**  
**  copy:**  
**    src: /mine/ntp.conf**  
**    dest: /etc/ntp.conf**  
**    owner: root**  
**    group: root**  
**    mode: '0644'**  
**    backup: yes**

Example 2:

**- name: **Copy file with owner and permission, using symbolic representation  
**  copy**:  
**    src: **/srv/myfiles/foo.conf  
**    dest: **/etc/foo.conf  
**    owner: **foo  
**    group: **foo  
**    mode: **u=rw,g=r,o=r

**4.File**

The [file
module](https://docs.ansible.com/ansible/latest/modules/file_module.html) manages
the file and its properties.

-   It sets attributes of files, symlinks, or directories.

-   It also removes files, symlinks, or directories.

**Example 1:**

\- name: Change file ownership, group and permissions  
  file:  
    path: /etc/foo.conf  
    owner: foo  
    group: foo  
    mode: '0644'

This creates a file named **foo.conf** and sets the permission to **0644**.

**Example 2:**

\- name: Create a directory if it does not exist  
  file:  
    path: /etc/some_directory  
    state: directory  
    mode: '0755'

This creates a directory named **some_directory** and sets the permission
to **0755**.

**5.Lineinfile**

The lineinfile module manages lines in a text file.

-   It ensures a particular line is in a file or replaces an existing line using
    a back-referenced regular expression.

-   It's primarily useful when you want to change just a single line in a file.

Example 1:

\- name: Ensure SELinux is set to enforcing mode

lineinfile:

path: /etc/selinux/config

regexp: '\^SELINUX='

line: SELINUX=enforcing

This sets the value of SELINUX=enforcing.

Example 2:

\- name: Add a line to a file if the file does not exist, without passing regexp

lineinfile:

path: /etc/resolv.conf

line: 192.168.1.99 foo.lab.net foo

create: yes

This adds an entry for the IP and hostname in the resolv.conf file.

**6.User Module**

The module manages users accounts with there attributes. This is handy do to the
fact that the user properties and attributes can all be configured from this
Ansible module.

**Example**

*\# Add the user 'exampleuser' with a specific uid and a primary group of
'admin'*  
- user:  
name: exampleuser  
comment: "Example User"  
uid: 1040  
group: admin*\# Remove the user 'exampleuser'*  
- user:  
name: exampleuser  
state: absent  
remove: yes

**7.shell module**

Ansible’s shell module executes shell commands on remote hosts.

\- name: create a text file in \$HOME with the /bin/sh shell

shell: echo "Hello, World!" \> \$HOME/test_file.txt

\- name: read all text files in \$HOME with the /bin/bash shell

shell: cat \< \$HOME/\*.txt

args:

executable: /bin/bash

#### 8.Ansible Apt

APT stands for "Advanced Packaging Tool" , It allows us to install new packages,
update them, and remove the packages from Ubuntu systems. Here are **3 APT
related command-line tools**, such as:

-   **Apt-get:** All the basic package management operations can be done by
    using this tool. Ansible apt-get module provides this functionality.

-   **Apt-add-repository**: It is used for adding a new repository to the
    repository list. The default repository may not have the latest version of
    all the packages. So you need to add additional repositories for some
    software maintainers. Ansible apt_repository module provides the
    functionality for adding a new repository.

-   **Apt-key:** It is used to manage the list of keys for authenticating apt
    packages. Ansible apt_key module is used to manage the keys.

**Installing new Apt Packages**

-   To install the new packages, you have to give the name of the package in the
    name parameter and the desired state of the package.

-   The default state of the package is "present". Also, it is better to set the
    update_cache to true.

-   The below example will do a cache update to synchronize the index. Check if
    the 'zip' package is installed on the target server. And if it is not
    installed, the package will be installed. If the package is already
    installed, then it won't be upgraded.

\-hosts: loc

tasks:

\-name: Ansible apt install packages

apt:

name: zip

state: present

update_cache: true

**1. Installing the latest version of a package**

If you set the state of the packages to "present", then Ansible will only check
if the package is present. So if the new package is available, it will not be
able to install.

\-hosts: loc

tasks:

\-name: ansible apt install latest version

apt:

name: zip

state: latest

update_cache: true

**2. Ansible install multiple packages**

In the below example, we are going to install 3 packages: docker-ce, Nginx, and
git.

\-hosts: loc

tasks:

\-name: ansible apt with_items

apt:

name: "{{item}}"

update_cache: true

state: present

with_items:

\-'docker-ce'

\-'nginx'

\-'git'

**3.Removing Apt Packages**

You can also remove the packages using apt module by setting the state parameter
to absent.

\-hosts: loc

tasks:

\-name: ansible apt remove package

apt:

name: zip

state: absent

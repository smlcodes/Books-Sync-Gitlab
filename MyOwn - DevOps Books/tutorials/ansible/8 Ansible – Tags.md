Ansible – Tags
==============

If you have a large playbook, it becomes useful to be able to run only a
specific part of it rather than running everything in the playbook. Ansible
supports a tag attribute for this reason.

When you apply tags on things, then you can control whether they are executed by
adding command-line options.

When you execute a playbook, you can filter tasks based on the tags in two ways,
such as:

1.  On the command line, with the **-tags** or **-skip-tags** options.

2.  In Ansible configuration settings, with
    the **TAGS_RUN** and **TAGS_SKIP** options.

an example that tags two tasks with different tags, such as:

tasks:

\- yum:

name: "{{ item }}"

state: present

loop:

\- httpd

\- memcached

tags:

\- packages

\- template:

src: templates/src.j2

dest: /etc/foo.conf

tags:

\- **configuration**

If you want to run the configuration and packages part of a very long playbook,
then you can use the -tags option on the command line.

ansible-playbook example.yml --tags "configuration,packages"

if you want to run a playbook without certain tagged tasks, then you can use
the **-skip-tags** command-line option.

ansible-playbook example.yml --skip-tags "packages"  

Ansible – Templates 
====================

Managing configurations of multiple servers and environments are one of the
significant uses of Ansible. But these configuration files may vary for each
remote servers or each cluster. But apart from some few parameters, all other
settings will be same.

A template in Ansible is a file which contains all your configuration
parameters, but the dynamic values are given as variables. During the playbook
execution, depending on the conditions like which cluster you are using, the
variables will be replaced with the relevant values.

The variables in a template file will be denoted by the double curly braces, ‘{{
variables }}’. The template files will usually have the .j2 extension, which
denotes the Jinja2 templating engine used.

**A Basic Example**

In the following task, I am using the template module on the example1.j2 file
which will replace the default variables with values given in the playbook.

**File: Playbook.yml**

\---

\- hosts: all

vars:

variable1: 'Hello...!!!'

variable2: 'My first playbook using template'

tasks:

\- name: Basic Template Example

template:

src: example1.j2

dest: /home/knoldus/Documents/Ansible/output.txt

File: example1.j2

{{ variable1 }}

No effects on this line

{{ variable2 }}

File: output.txt

Hello...!!!

No effects on this line

My first playbook using template

As you can see, both variables in the example1.j2 are replaced by their values.

**A Basic Example of Ansible Template Module**

At the bare minimum, you need to have two parameters when using
the [Ansible](http://i.viglink.com/?key=4c25935c12fea5c8c0662bcffb1047e2&insertId=c59dd375fdc156d1&type=H&exp=60%3ACI1C55A%3A2&libId=k6mfcy3c010250tu000DLbbu6wbgt&loc=https%3A%2F%2Fwww.mydailytutorials.com%2Fansible-template-module-examples%2F&v=1&iid=c59dd375fdc156d1&out=https%3A%2F%2Fwww.amazon.com%2Fdp%2F1491915323&ref=https%3A%2F%2Fwww.google.com%2F&title=How%20to%20Work%20with%20Ansible%20Template%20Module%20with%20Examples%20-%20My%20Daily%20Tutorials&txt=%3Cspan%3EAnsible%3C%2Fspan%3E) module.

src: the source of the template file. This can be relative or absolute path.

dest: the destination path on the remote server

These are some of the other parameters which we can use to change some default
behavior of template module :

-   **force –** If the destination file already exists, then this parameter
    decides whether it should be replaced or not. By default, the value is
    ‘yes’.

-   **mode –** If you want to set the permissions for the destination file
    explicitly, then you can use this parameter.

-   **backup –** If you want a backup file to be created in the destination
    directory, you should set the value of the backup parameter to ‘yes’. By
    default, the value is ‘no’. The backup file will be created every time there
    is a change in the destination directory.

-   **group –** Name of the group that should own the file/directory. It is
    similar to executing *chown* for a file in Linux systems.

**Using lists in Ansible templates**

In the next example, I’ll be using the template module to print all the items
present in a list using the for the loop.

File: Playbook.yml

\- hosts: all

vars:

list1: ['Apple','Banana','Cat', 'Dog']

tasks:

\- name: Template Loop example.

\- template:

src: example2.j2

dest: /home/knoldus/Documents/Ansible/output.txt

File: example2.j2

Example of template module loop with a list.

{% for item in list1 %}

{{ item }}

{% endfor %}

File: output.txt

Example of template module loop with a list.

Apple

Banana

Cat

Dog

**Working With Multiple Files in Ansible**

We can use the with_items parameter on a dictionary to render multiple files.
For example, if we want to render three templates each with different source and
destination, with_items parameter can be put to use. An illustration is given
below.

\- hosts: all

tasks:

\- name: Template with_items example.

template:

src: "{{ item.src }}"

dest: "{{ item.dest }}"

with_items:

\- {src: 'example.j2',dest: '/home/knoldus/Documents/Ansible/output.txt'}

\- {src: 'example1.j2',dest: '/home/knoldus/Documents/Ansible/output1.txt'}

\- {src: 'example2.j2',dest: '/home/knoldus/Documents/Ansible/output2.txt'}

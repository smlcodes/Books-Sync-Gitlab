Ansible - Loops
===============

Ansible loop provides a lot of methods to repeat certain tasks until a condition
is met.

A basic example which can be used to install a lot of Linux packages can be
written like the below example.

\- name: Ansible Loop example

apt:

name: "{{ item }}"

state: present

with_items:

\- python3

\- ca-certificates

\- git

In the above task, instead of writing 3 separate task we have consolidated them
into
a [single task](http://i.viglink.com/?key=4c25935c12fea5c8c0662bcffb1047e2&insertId=bfb5626eea5abde6&type=H&exp=60%3ACI1C55A%3A4&libId=k6md4eg0010250tu000DLbbu6wbgt&loc=https%3A%2F%2Fwww.mydailytutorials.com%2Fworking-with-ansible-loop%2F&v=1&iid=bfb5626eea5abde6&out=https%3A%2F%2Fwww.amazon.com%2Fdp%2F1107075998&ref=https%3A%2F%2Fwww.google.com%2F&title=Working%20with%20Ansible%20loop%20-%20My%20Daily%20Tutorials&txt=%3Cspan%3Esingle%20%3C%2Fspan%3E%3Cspan%3Etask%3C%2Fspan%3E).In
each iteration, the value of **with_items **block will be inserted in place
of **{{ item }}. **

#### Ansible loop with Index

In some scenarios knowing the index value might come in handy. You can use
the **“with indexed_items” **for this. The loop index will be available
at **item.0** and the value will be available at **item.1**. index value starts
at zero as usual.

\- hosts: all

tasks:

\- name: Ansible loop with index example

debug:

msg: "echo loop index at {{ item.0 }} and value at {{item.1}}"

with_indexed_items:

\- "hello1"

\- "hello2"

\- "hello3"

You can also make changes to the index value like addition, subtraction etc.

\- name: Ansible loop with index modification example

debug:

msg: "echo loop index at {{ item.0 + 1}} and value at {{item.1}}"

#### Ansible loop with conditional

You can also use the “**when”** conditional statement along with the loop
structure. Thus you can control the looping based on a variable or system facts.

The following example will run the task when the loop value is the same as the
“loop_1” variable. Note that “**item**” is not enclosed in double brackets.

\- hosts: all

vars:

loop_1: "hello1"

tasks:

\- name: Ansible loop with conditional example

debug:

msg: "{{ item }}"

with_items:

\- "hello1"

\- "hello2"

\- "hello3"

when: item == "{{ loop_1 }}"

Ansible – Dynamic Inventory
===========================

In Ansible, a static inventory file is a plain text file that contains a list of
managed hosts declared under a host group using either hostnames or IP
addresses.

But in real time, inventory file keeps constantly changing as you add or
decommission servers, keeping tabs on the hosts defined in the inventory file
becomes a real challenge.

-   Ansible will accept any kind of executable file as an inventory file, so you
    can build your own dynamic inventory however you like, as long as you can
    pass it to Ansible as JSON.

-   A dynamic inventory is a shell script written in Python, PHP or any other
    programming language. It comes in handy in cloud environments such as AWS
    where IP addresses change once a virtual server is stopped and started
    again.

-   Ansible already has developed inventory scripts for public cloud platforms
    such as Google Compute Engine, Amazon EC2 instance, OpenStack, RackSpace,
    cobbler, among others

Utilize an Existing Dynamic Inventory Script

A script that is used to create a dynamic inventory has to be made executable so
that Ansible can use it.

To retrieve information about the hosts inside a dynamic inventory script simply
run.

\# ./script --list

As pointed earlier, the output should be in JSON in the format below.

Sample Output

{

"webservers": {

"hosts": [

"webserver1.example.com",

"webserver2.example.com"

],

"vars": {}

},

"database_servers": {

"hosts": [

"mysql_db1",

"mysql_db2"

],

"vars": {}

},

"_meta": {

"hostvars": {

"mysql_db2": {},

"webserver2.example.com": {},

"webserver1.example.com": {},

"mysql_db1": {}

}

}

}

To use this

ansible-playbook my_playbook.yml -i ./dyn_inv.py

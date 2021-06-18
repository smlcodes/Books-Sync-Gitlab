Chef – Data bags
================

A data bag is a global variable that is stored as JSON data and is accessible
from a Chef server.Using Databags, we can secure/encrypt sensitive data such as
passwords, keys, etc.

A data bag is a container for items that represent information about your
infrastructure that is not tied to a single node. Data bags contain information
that needs to be shared among more than one node. For example:

-   Shared passwords

-   License keys for software installs

-   Shared lists of users and groups

Elements of Chef Databags

-   DATA BAG

-   DATA BAG ITEM

-   DATA BAG ITEM ELEMENTS

We would need to create a data-bag to encrypt the sensitive data.

knife data bag create \<my_databag\> \<my_databag_item\>

This would create a directory named “my_databag” which is our data-bag and this
directory has created a file named “my_databag_item.json” which is a data-bag
item.

we have “plain-text” content to encrypt:

{

"id": "my_databag",

"password1": “abc123”,

"password2": “123abc”

}

And after encryption this file would look like:

{

"id": "my_databag",

"password1": {

"encrypted_data": "XXXXXXXXXXXXXXXXXXXXXXXXX",

"iv": "XYXYXYXYXYYXYXYXYXYXYXY",

"version": 1,

"cipher": "aes-256-cbc"

},

"password2": {

"encrypted_data": "YYYYYYYYYYYYYYYYYYYYYYYYYY",

"iv": "YXYXYXYXYXYXYXYXYXYXYXYX",

"version": 1,

"cipher": "aes-256-cbc"

}

}

Data Bags Example
-----------------

In this example we create a data bag, which will hold the Employees endpoint URL
details(<http://dummy.restapiexample.com/>) and use it in our recipe.

Create data bag directory inside /chef-repo/.

mkdir data_bags/employees

Create a data bag item for storing URL

vi data_bags/employees/get.json {

"id": "get_url",

"url": "http://dummy.restapiexample.com/api/v1/employees"

}

Create a data bag on the Chef server

knife data bag create employees

Created data_bag[employees]

Upload the data bag to the Chef server

knife data bag from file employees get.json

Updated data_bag_item[employees::get_url]

Update the default recipe of the cookbook to receive the required cookbook from
a data bag.

vi cookbooks/learn_chef_apache2/recipes/default.rb

package 'apache2'

service 'apache2' do

supports :status =\> true

action [:enable, :start]

end

template '/var/www/html/index.html' do

source 'index.html.erb'

end

employees = data_bag_item('employees', 'get_url')

http_request 'callback' do

url employees['get_url']

end

Upload the modified cookbook to the Chef server.

knife cookbook upload learn_chef_apache2

Uploading learn_chef_apache2 [0.3.0]

Uploaded 1 cookbook.

Run the Chef client on the node to check if the http request bin gets executed.

sudo chef-client

root\@web1:/home/vagrant\# sudo chef-client

Starting Chef Client, version 11.8.2

resolving cookbooks for run list: ["learn_chef_apache2"]

Synchronizing Cookbooks:

\- learn_chef_apache2

Compiling Cookbooks...

Converging 4 resources

Recipe: learn_chef_apache2::default

\* package[apache2] action install (up to date)

\* service[apache2] action enable

\- enable service service[apache2]

\* service[apache2] action start (up to date)

\* template[/var/www/html/index.html] action create (up to date)

\* http_request[callback] action get

\- http_request[callback] GET to
http://dummy.restapiexample.com/api/v1/employees

Chef Client finished, 2 resources updated

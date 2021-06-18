Chef - Policies
===============

Policy maps business and operational requirements, process, and workflow to
settings and objects stored on the Chef Infra Server:

-   Roles define server types, such as “web server” or “database server”

-   Environments define process, such as “dev”, “staging”, or “production”

-   Certain types of data—passwords, user account data, and other sensitive
    items—can be placed in data bags, which are located in a secure sub-area on
    the Chef Infra Server that can only be accessed by nodes that authenticate
    to the Chef Infra Server with the correct SSL certificates

-   The cookbooks (and cookbook versions) in which organization-specific
    configuration policies are maintained

#### Cookbook Versions

A cookbook version represents a set of functionalities that is different from
the cookbook on which it is based. A version may exist for many reasons, such as
ensuring the correct use of a third-party component, updating a bug fix, or
adding an improvement. A cookbook version is defined using syntax and operators,
may be associated with environments, cookbook metadata, and/or run-lists, and
may be frozen (to prevent unwanted updates from being made).

A cookbook version is maintained just like a cookbook, with regard to source
control, uploading it to the Chef Infra Server, and how Chef Infra Client
applies that cookbook when configuring nodes.

#### Data Bags (Secrets)

Data bags store global variables as JSON data. Data bags are indexed for
searching and can be loaded by a cookbook or accessed during a search.

#### Environments

An environment is a way to map an organization’s real-life workflow to what can
be configured and managed when using Chef Infra. This mapping is accomplished by
setting attributes and pinning cookbooks at the environment level. With
environments, you can change cookbook configurations depending on the system’s
designation. For example, by designating different staging and production
environments, you can then define the correct URL of a database server for each
environment. Environments also allow organizations to move new cookbook releases
from staging to production with confidence by stepping releases through testing
environments before entering production.

#### Roles

A role is a way to define certain patterns and processes that exist across nodes
in an organization as belonging to a single job function. Each role consists of
zero (or more) attributes and a run-list. Each node can have zero (or more)
roles assigned to it. When a role is run against a node, the configuration
details of that node are compared against the attributes of the role, and then
the contents of that role’s run-list are applied to the node’s configuration
details. When a Chef Infra Client runs, it merges its own attributes and
run-lists with those contained within each assigned role.

#### Policyfile

A Policyfile is an optional way to manage role, environment, and community
cookbook data with a single document that is uploaded to the Chef Infra Server.
The file is associated with a group of nodes, cookbooks, and settings. When
these nodes perform a Chef Infra Client run, they utilize recipes specified in
the Policyfile run-list

A Policyfile file allows you to specify in a single document the cookbook
revisions and recipes that Chef Infra Client will apply. A Policyfile file is
uploaded to the Chef Infra Server, where it is associated with a group of nodes.
When these nodes are configured during a Chef Infra Client run, Chef Infra
Client will make decisions based on your Policyfile settings and will build a
run-list based on that information. A Policyfile file may be versioned, and then
promoted through deployment stages to safely and reliably deploy new
configuration.

**Syntax**[¶](https://docs.chef.io/policyfile.html#syntax)

A Policyfile.rb is a Ruby file in which run-list and cookbook locations are
specified. The syntax is as follows:

name "name"

run_list "ITEM", "ITEM", ...

default_source :SOURCE_TYPE, \*args

cookbook "NAME" [, "VERSION_CONSTRAINT"] [, SOURCE_OPTIONS]

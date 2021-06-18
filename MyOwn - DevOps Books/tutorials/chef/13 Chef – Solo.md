Chef – Solo
===========

**Chef-solo** behaves as a standalone system, it is in itself a client & a
server.

Errors
======

#### Net::HTTPServerException: 412 "Precondition Failed" :No such cookbook: apache_cookbook

May be we need to create cookbooks under cookbooks folder.

#### ERROR: RuntimeError: Please set EDITOR environment variable.

You have to define EDITOR as environment variable.

Try

export EDITOR=\$(which vi)

To persist this, add it to \~/.bashrc or \~/.bash_profile.

#### ERROR: Cannot find a cookbook named learn_chef_apache2; did you forget to add metadata to a cookbook?

Make sure you copy cookbook to chef-repo/cookbooks folder

#### Vagrant : default: Warning: Connection aborted. Retrying..

inserting ' config.ssh.insert_key = false' which resolved my issue.

<https://www.thisprogrammingthing.com/2016/fixing-vagrant-connection-error/>

#### ERROR: Net::SSH::HostKeyMismatch: fingerprint … does not match for “…”

If the known_hosts file already contains an entry for a different server with
the same IP address, we get the error message

ERROR: Net::SSH::HostKeyMismatch: fingerprint … does not match for “…”

Open the **\~/.ssh/known_hosts** file and delete the line that contains the IP
address of the server.

#### [shorten file path in Any terminal](https://askubuntu.com/questions/302667/shorten-file-path-in-terminal)

**PS1='\\W\> '**

**Or**

PS1='\\u\@\\h:\\W:\\\$'

PS1='\\u\@\\h:\\w:\\\$'

Ref. 
=====

Installation.

<https://docs.chef.io/install_workstation.html>

Best

<https://www.youtube.com/watch?v=4aaK2rzzOLc&list=PLsgnv1SN76ILtD3TnVtXpX1hmwjyY9OuT&index=1>

<https://www.youtube.com/watch?v=LTIjUJEehDA>

part1

<https://youtu.be/LTIjUJEehDA?list=PL9ooVrP1hQOFDz4cy_X-oeDIrpfkqIIZw>

Best:<https://www.digitalocean.com/community/tags/chef?subtype=tutorial_series>

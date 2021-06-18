Jenkins - Real Time pipeline Example
====================================

After Completion of all Tools

Errors & Solutions
==================

ERROR: Server rejected the 1 private key(s) for jenkins
-------------------------------------------------------

I solve this issue following below step:

**From the target slave node's console**

1.  Switch to the “root” user.

sudo su

1.  Add a jenkins user with the home “/var/lib/jenkins”. {Note : I am keeping my
    home directory in /var/lib/jenkins} :

useradd -d /var/lib/jenkins Jenkins

**From the Jenkins Master**

Copy the id_rsa.pub key from the **Jenkins** user on the master.

cat /var/lib/jenkins/.ssh/id_rsa.pub

**From the target slave node's console**

Create an authorized_keys file for the Jenkins user.

mkdir /var/lib/jenkins/.ssh

vi /var/lib/jenkins/.ssh/authorized_keys

Paste the key from the Jenkins master into the file vim. Save with “:wq!”.

Caused by: java.io.IOException: Server returned HTTP response code: 403 for URL: http://localhost:6666/manager/text/list
------------------------------------------------------------------------------------------------------------------------

add roles "manager-script" to the user,

Users with the manager-gui role should not be granted either the manager-script
or manager-jmx roles.

Ref.
====

<https://javatpoint.com/jenkins>

<https://www.edureka.co/blog/what-is-jenkins/>

<https://medium.com/@anusha.sharma3010/ci-cd-using-jenkins-pipeline-as-code-8879e08031e2>

<https://cloudacademy.com/lab/create-jenkins-cicd-pipeline-sonarqube-integration/>

<https://linuxize.com/post/how-to-install-jenkins-on-centos-7/>

Master Slave

-   <https://www.howtoforge.com/tutorial/ubuntu-jenkins-master-slave/>

-   <https://hostadvice.com/how-to/how-to-setup-jenkins-master-and-slave-on-ubuntu-18-04-lts/>

JFROG : artifactory

<https://c4clouds.com/>

Sonar

<https://medium.com/@anusha.sharma3010/integrating-jenkins-with-sonarqube-500578fd1770>

<https://medium.com/@amitvermaa93/jenkins-sonarqube-integration-129f5c49c4ca>

<https://medium.com/@anusha.sharma3010>

<https://www.edureka.co/blog/jenkins-pipeline-tutorial-continuous-delivery>

<https://youtu.be/-GsvomI4CCQ>

<https://dzone.com/articles/building-a-continuous-delivery-pipeline-using-jenk>

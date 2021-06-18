Jenkins – Manage users
======================

We can manage users & their access in 3 ways

1.  Users & Role Management – Using Jenkins plugin

2.  Using LDAP

3.  Using SSO

Users & Role Management 
------------------------

By default, when you create a user in Jenkins, it can access almost everything.
In this, you can create multiple users and assign different roles and privileges
to different users. For doing that we need to install **"Role-based
Authorization Strategy** ".

**Jenkins \>Manage Jenkins\> Available tab**\>filter - search "**Role-based
Authorization Strategy**" , install the plugin.

![](media/0ffcd66127887de42f69f7bca2478612.png)

After Plugin installation, go to the **'Manage Jenkins**' and then click on
**'Configure Global Security'**.

-   Check on **Enable security** option.

-   On the Security Realm section, select **'jenkins' own user database**'.

-   On Authorization section, select **'Role-Based Strategy'**.

![](media/988d5f0eecaaf39b2859693e24358004.png)

### Now add users

**Dashboard\> Manage Jenkins \> Manage Users \> Create User**

![](media/6bd06255af184b000e1f565f5da1352c.png)

Add required no. of users

![](media/95da9d27b8a58816821a1af3eb93bd42.png)

### Adding Roles

**Manage Jenkins\> Manage and Assign Roles\> Manage Roles\> Role to add** -
Provide details& Save

![](media/6a6112210cbb82ec62cd7607d55ab5e4.png)

Provide Access levels for that role. Ex: only Build & configure jobs

![](media/32bd9d7eff42ce41c82f8b194f30cc17.png)

### Assign Roles to Users

Manage Jenkins\> Manage and Assign Roles\> Manage Roles\> Assign Roles

-   Add the User name on **User/group to add** option.

-   Click on **Add** button.

![](media/195efc3a887ce311783a262e99f92131.png)

![](media/24f9af492e8c446d08334e042ec741f1.png)

LDAP Configuration
------------------

If we configure Jenkins with LDAP Integration, it will allow users to login with
their Domain accounts, and manage permissions using the **Role Based Security
plugin**.

For doing this we need to install below two plug-ins

-   [The Active Directory
    Plugin](https://wiki.jenkins.io/display/JENKINS/Active+Directory+Plugin)**(**only
    for AD accounts integration**)**

-   [The Role-based Authorization Strategy
    Plugin](https://wiki.jenkins.io/display/JENKINS/Role+Strategy+Plugin)

![](media/e5ed607b51039d12204624464b5feaac.png)

Once above plugins got install follow below steps to move forward.

**Manage Jenkins \> Configure Global Security \>**Check "Enable Security"
checkbox is ticked.

![](media/3b36687f136f0606f62c4f08ceb92246.png)

Under **Security Realm \> select LDAP** radio button

Provide required details & save

![](media/c545f4072a53d7f48081d43b149481cd.png)

To Test the LDAP Configuration, click on Test LADP settings

![](media/c83d6f35df9354f8c1755c68402e9c75.png)

SSO Configuration
-----------------

To provide SSO Services in our environment, we do use Keycloak as the central
service. To use this in [Jenkins](http://www.jenkins.io/), we do use the OpenId
Connect Plugin.

For this to work, a new client has to be created in the Keycloak System, and a
couple of endpoints have to be configured in the Jenkins Security Settings.

**Keycloak Settings**

All Settings done in the Keycloak Server are described in this section.

**Keycloak Client**

The Keycloak client needs to get configured in the following way. The Client
needs to have a unique name (in this case 'jenkins') and the 'Access Type' needs
to get defined as 'confidential'. Please note especially the 'Valid Redirect
URIs', which needs to get set to the URL of the Jenkins System
(http://loccalhost:3000 in the screenshot).

![Keycloak Jenkins Client](media/025ba29d34308c9456861854925b3a40.png)

**Keycloak Credentials**

Because we have set the 'Access Type' to 'confidential' we do get offered the
Credentials Tab. On this tab, we get a secret, which needs to get put into the
corresponding Setting of the Jenkins OpenId Connect plugin. This secret allows
to initiate a secure connection between the Keycloak System and your client
application (Jenkins in this case).

![Keycloak Credentials](media/9a6d7323ebdb8a555ad764222ff9445d.png)

**Keycloak Mappers**

In order to provide some necessary user information to the Redmine System, the
standard Keycloak Mappers have to be adopted and a new Mapper has to get
created.

![Keycloak Mapper](media/3620a446d6a736ebd2f0c693c2173dea.png)

**Jenkins OpenId Connect Settings**

-   The Settings done in the OpenId Connect Plugin Settings page are described
    in here.

-   The most relevant settings are the 'Client ID', the 'Client Secret' and the
    'Urls'.

-   The 'Client ID' is the name of the client in your Keycloak System (jenkins
    in our case). By Specification, this should be a URI, but a plain name is
    working as well, and seems to be easier IMHO.

-   The 'Urls' have to be set to the Keycloak Server with the path
    /auth/realms/. Please adopt the REALMNAME (devopskube in the picture), to
    your own needs.

-   The 'Client Secret' is the secret found in the Keycloak Credentials page
    (see above), and should be copied from there.

![Jenkins OpenId Connect Plugin Settings](media/19a7d562eaf139311b6b539a98d26a64.png)

Jenkins -Email Notification
===========================

Manage Jenkins \> Manage Plugins \> install "[Email Extension
Plugin](https://plugins.jenkins.io/email-ext)" and "Email Extension template
Plugin".

![](media/faf67c475d24993d42691d4dd94e48f8.png)

**Manage Jenkins \> Configure System \> E-mail Notification**

Provide SMTP Server Details. for Example, here I’m using Gmail, for that
configure below things

Gmail SMTP server name: smtp.gmail.com

![](media/cdfc358f8cd30c03142af99cfebb36da.png)

Check [ ] - **Use SMTP Authentication** & provide below details

![](media/90afcbb9607d888346d4e98d904f2deb.png)

Save & Test Email

**For any Issues, please do below things**

-   Update mailer plugin to 1.1 in Jenkins. Update jenkins to latest
    version(optional )

-   In Google Account Settings : Allow less secure app access:
    click <https://www.google.com/settings/security/lesssecureapps> and select
    Turn on.

-   Unlock captcha: click <https://accounts.google.com/DisplayUnlockCaptcha> and
    select continue

### Configure mail notification on Build failure/Success

Open already Created Job \> **configure option**.

**Post-build actions \> E-mail Notification** section. Enter the receipt email
id and select **'send e-mail for every unstable build**' option.

![](media/7c3d43c638bdc74086744ae5917eec9e.png)

Try to fail the Build. See Console output & Check mentioned emails

![](media/cb754a98d1bd92eaf0cfa94968a6a46e.png)

![](media/7b667485197ffdbf9b4e82e1c86c26fa.png)


# Application deploy and settings.

GitHub apps must have a url as a web application.
There are many Paas to set up as a web, like `Heroku`, `AWS Elastic Beanstalk`.
So you use one and deploy this application. 

After you deploy as a web application, you get the url.
The url is filled in GitHub apps's `Webhook URL`.  

## Application's permissions and webhooks

To execute this application as a GitHub apps,
register following permissions and webhooks in GitHub apps's settings.

| Permissions | Access |
| ----------- | ------ |
| Issues | Read & Write |
| Pull requests | Read & Write |

| Webhooks |
| --------- |
| Issue comment |


# For authentication
You can get pem file from GitHub (refer to [generate a private key](https://developer.github.com/apps/building-github-apps/authentication-options-for-github-apps/#generating-a-private-key)), but the format is not suitable for Java,
then you change GitHub's pem file `priv1.pem` to new pem file `priv8.pem`.
This command changes the format in pem from PKCS#1 to PKCS#8.

```
$ openssl pkcs8 -topk8 -inform PEM -outform PEM -in priv1.pem -out priv8.pem -nocrypt
```

The output file `priv8.pem` must move to the `resources` folder.
If your file name is not `priv8.pem`, you change `application.pem-file` in `application.properties` file.

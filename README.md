

You can get pem file from GitHub, but the format is not suitable for Java,
then you change GitHub's pem file `priv1.pem` to new pem file `priv8.pem`.
This command is changing the format in pem from PKCS#1 to PKCS#8.

```
$ openssl pkcs8 -topk8 -inform PEM -outform PEM -in priv1.pem -out priv8.pem -nocrypt
```
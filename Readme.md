# privli
(privacy-focused) link shortener

# dev setup
In the mysql shell
```
CREATE DATABASE privli;
use privli
CREATE USER 'privli'@'localhost' IDENTIFIED BY 'privli';
GRANT ALL PRIVILEGES ON privli.* TO 'privli'@'localhost';
FLUSH PRIVILEGES;
```

```
mysql -u privli -p'privli' privli < ./resources/schema.sql
```

# todo
- security (login/register, maybe with login w/ github)
- create shortlink page
  - alias generator
- overview page
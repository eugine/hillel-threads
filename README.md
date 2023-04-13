# hillel-java-pro

## Docker
### Basic
1. Hello world
```shell
 docker pull hello-world
 docker run hello-world
```
2. Run Postgres 
```shell
    run-db.bat / run-db.sh
```

### DB Dump
````shell
  docker exec -it <image> pg_dump -U hillel postgres > dump.sql
````


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
1. Create a dump
````shell
  docker exec -it <image> pg_dump -U hillel postgres > dump.sql
````
2. Copy the dump from docker image: 
   1. docker exec -it <image> cat xxx > dump.sql 
   2. docker cp <image>:dump.sql dump-xx.sql
3. drop tables in db
4. Make sure the dump is in the image: 
   1. docker cp dump.sql <image>:dump.sql
5. Import the dump:
   1. docker exec -it <image> bash 
   2. psql -U hillel < dump.sql

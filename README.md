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
 docker pull postgres:14.2
 docker run -itd -e POSTGRES_USER=hillel -e POSTGRES_PASSWORD=hillel -p 5432:5432 -v ./data:/var/lib/postgresql/data --name postgresql postgres:14.2
```


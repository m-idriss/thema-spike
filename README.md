## Thema-spike Application

- PostgreSQL database
- Java backend (Spring Boot)
- Angular frontend

The entry point for a user is a website which is available under the
address: **http://localhost:4200/**

---

### Prerequisites

In order to run this application you need to install two tools: **Docker** & **Docker Compose**.

Instructions how to install **Docker** on [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/) , [Mac](https://docs.docker.com/docker-for-mac/install/) .

**Dosker Compose** is already included in installation packs for *Windows* and *Mac*, so only Ubuntu users needs to follow [this instructions](https://docs.docker.com/compose/install/) .

### How to run it?

An entire application can be ran with a single command in a terminal:

```
$ docker-compose up -d
```

If you want to stop it use following command:

```
$ docker-compose down
```

#### thema-postgres (Database)

PostgreSQL database contains only single schema with two tables - thema
and task table.

After running the app it can be accessible using this connectors:

- Host: *localhost*
- Database: *thema*
- User: *thema*
- Password: *thema*

Like other parts of application Postgres database is containerized and
the definition of its Docker container can be found in
*docker-compose.yml* file.

```yml
  thema-postgres:
    image: "postgres:10.4-alpine"
    container_name: thema-postgres
    volumes:
      - thema-data:/var/lib/postgresql/data
    ports:
      - 5432:5432
    environment:
      - POSTGRES_DB:thema
      - POSTGRES_USER:thema
      - POSTGRES_PASSWORD:thema
```
#### thema-app (REST API)

This is a Spring Boot (Java) based application that connects with a
database that and expose the REST endpoints that can be consumed by
frontend. It supports multiple HTTP REST methods like GET, POST, PUT and
DELETE

Full list of available REST endpoints could be found in Swagger UI,
which could be called using link: **http://localhost:8080/api/swagger-ui.html**

#### thema-front (Frontend)

This is a real endpoint for a user where they can manipulate their
themas and tasks. It consumes the REST API endpoints provided by
*thema-app*.

It can be entered using link: **http://localhost:4200/**

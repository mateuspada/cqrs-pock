# bank-account-cqrs-pock

This project is divided in two modules. The first one is the command module, and the second is the query module.

To run the project, you'll need to have docker in your machine.

First of all, run the docker compose:

```
docker-compose up -d
```

it will start the postgres, rabbitmq management and pgadmin into your machine.

To access the rabbitmq, you can access the url: http://localhost:15672

The pgadmin is in this url: http://localhost:12345

The pgadmin will ask for username and password. By default, I let into the docker-compose.yml file configured this username: mateuspada@live.com and this password: postgres - you can change as you wish with any value.

the postgres server is running into host: localost and the default port: 5432

To configure postgres connection into pgadmin, you will need to specify the host as "postgres", because pgadmin & postgres are into docker machine, and they don't know "localhost", so I created a network and you can refer them by the service name.

After putting the infraestructure online, you just need to open this project with you IDE and run the modules.

I highly recommend yo use IntelliJ to do that easily, but it's a Maven project, with a parent and 2 modules referring the parent, and you can do it with any IDE.
For Backend to start, database and flyway must be running, therefore we start the application in two commands:

`docker-compose up --detach db flyway`
When database is running and migrations applied, we can build and start the app:

`docker-compose up --build`

For development purposes, there is docker compose file which starts only database and flyway, use:

`docker-compose -f docker-compose.local.yml up`
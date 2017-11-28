# socweb

A clojure project meant to improve my clojure webdev skills.

The idea is to deploy:

- A simple REST service
- A simple Web UI

Together they'll calculate and present the current standing in a penalty point
competition.

## Usage

`lein run 8000` if you want to run the webserver on port 8000
`git push heroku master` if you want to deploy on heroku

The (developing) website is
[here](https://legendary-mastermind-science.herokuapp.com). Because it's a free
heroku app, it'll spin down within half an hour (or something like that), so the
first call to the webpage might take a while to return; app has to spin up again.

## Setup

### Prerequisites

- Java installed
- Leiningen installed
- Postgresql installed

### Postgresql

#### MacOS

Prerequisite: homebrew installed and updated, no earlier version of postgresql on the machine
(check with 'which psql'), brew services installed (otherwise install with brew tap gapple/services)

```bash
brew install postgres                    # Install postgres via homebrew
brew services start postgres             # Start postgres service OR
pg_ctl -D /usr/local/var/postgres start  # Start postgres service manually
pg_ctl -D /usr/local/var/postgres stop   # (to stop manually when needed)
ps aux | grep postgres                   # Check postgres processes
which psql                               # Check if the path is ok
psql -l                                  # List current databases in postgres
```

Create PostgreSQL roles:

```bash
createuser --echo --createdb --encrypted --pwprompt lms-client
## type in lms-client password
createuser --echo --createdb --createrole --superuser --encrypted --pwprompt lms-admin
## type in lms-admin password
```

Create Database:

```bash
createdb --echo --template=template0 --encoding=utf8 --locale=en_US --owner=lms-client lms
```

Delete Database (when needed):

```bash
dropdb --echo --interactive lms
```

Some psql statements which might come in handy:

```bash
psql postgres
SELECT * FROM pg_stat_activity WHERE datname='lms';
\?              # list of very useful pqsl shortcuts e.g.:
\l              # list all databases
\d              # list all public tables
\d <tablename>  # describe table
\du             # describe user roles
```

- [PostgreSQL query plan visualization](http://tatiyants.com/postgres-query-plan-visualization/)
- [PostgreSQL date-time calculations](http://www.tutorialspoint.com/postgresql/postgresql_date_time.htm)


## Lessons learned

There are 3 parts to **Ring**:

- Adapters
- Handlers
- Middleware

**Adapters** adapt existing JVM webserver libraries to become compatible with the
ring specification. They accept a http request, convert it to a standard ring
request and pass the ring request to a handler. At some point the handler
returns a ring response which is converted to a http response by the adapter.

**Handlers** convert Ring Requests to Ring Responses. They are functions with a
single argument (Ring Request) which return a single value: the Ring Response.

**Middleware** Middleware are higher-level functions that add additional
functionality to handlers. The first argument of a middleware function should be
a handler, and its return value should be a new handler function that will call
the original handler. Most common task: transform the ring request before it is
passed to the handler OR transform the ring response before it is passed back to
the adapter. Example: add a content-type header. That's not a task that
`defines` your web application. Therefore, the functionality should be added as
middleware. Lots of default middleware available, e.g. wrap-reload to reload all
changed namespaces on request.

An app typically consists of:

- An adapter
- n middleware handlers
- A Handler

There are 2 parts to **Compojure**:

- Routing; running different code based on the URL path (e.g. "/", "/about")
- HTTP Method switching: running different code based on the called HTTP request
  method (e.g. GET, POST, PUT, DELETE)

## Ideas

- Push newest version to heroku (setup db first)

## License

Use the code the way you want it at your own risk. It is not copyrighted.

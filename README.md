# socweb

A clojure project meant to improve my clojure webdev skills.

The idea is to deploy:

- A simple REST service
- A simple Web UI

Together they'll calculate and present the current standing in a penalty point
competition.

## Usage

`lein run 8000` if you want to run the webserver on port 8000

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

There are 2 parts to **Compojure**:

- Routing; running different code based on the URL path (e.g. "/", "/about")
- HTTP Method switching: running different code based on the called HTTP request
  method (e.g. GET, POST, PUT, DELETE)



## License

Use the code the way you want it at your own risk. It is not copyrighted.

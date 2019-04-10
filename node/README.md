# cljs-express-node-wordpress

A sample of writing a Express on Node.js app using ClojureScript. Backend is wordpress.

## Requirement

- Node.js (and npm)
- Clojure, ClojureScript (using CLI Tool)
- Docker
- docker-compose

## Launching the Node app

```
$ cd cljs-express-node-wordpress/node
$ clj -A:fig --build dev --repl
```
If you have access to http://localhost:3000 and "Hello, World" string is displayed. This sample using figwheel-main. If you want to restart node, type ```(hello.core/restart!)``` on REPL.

## Launching the Wordpress

```
$ cd cljs-express-node-wordpress
$ docker-compose up -d
```

Nginx web server launches on port 8080. Access to "wp-*" connects to Wordpress Container. Images(png,jpg,gif) are processing on the Nginx web server, and other access is connecs to the Node app(Host). You can change these settings by editing the "nginx/conf.d/default.conf".


## Setup Wordpress

Access http://localhost:8080/wp-login.php and do the initial setup. Update the permalink settings to use the Rest API.

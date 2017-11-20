(ns socweb.core
  (:require [ring.adapter.jetty     :as    jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core         :refer [defroutes GET]]
            [compojure.route        :refer [not-found]]))


(defn hello [request]
  {:status 200
   :body   "Hello, world!"})


(defn goodbye [request]
  {:status 200
   :body   "Goodbye, world!"})


(defroutes app
  (GET "/"        [] hello)
  (GET "/goodbye" [] goodbye)
  (not-found "Page not found."))


(defn -main [port]
  (jetty/run-jetty
   app
   {:port (Integer. port)}))


;; Main that's only used in development;
;; Hot reloads changed namespaces
(defn -dev-main [port]
  (jetty/run-jetty
   (wrap-reload #'app)
   {:port (Integer. port)}))

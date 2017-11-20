(ns socweb.core
  (:require [ring.adapter.jetty     :as    jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.handler.dump      :refer [handle-dump]]
            [compojure.core         :refer [defroutes GET]]
            [compojure.route        :refer [not-found]]))


(defn hello [request]
  {:status 200
   :body   "Website to visualise soccer penalty point stats."})


(defn about [request]
  {:status 200}
  {:body   "Soccer penalty point stats will follow soon."})


(defroutes app
  (GET "/"        [] hello)
  (GET "/request" [] handle-dump) ;; standard ring handler; see dependencies
  (GET "/about"   [] about)
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

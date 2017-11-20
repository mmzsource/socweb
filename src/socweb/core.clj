(ns socweb.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn greet [req]
  (if (= (:uri req) "/")
    {:status  200
     :body    "Hello, world!"
     :headers {}}
    {:status  404
     :body    "Not Found"
     :headers {}}))


(defn -main [port]
  (jetty/run-jetty
   greet
   {:port (Integer. port)}))


;; Main that's only used in development;
;; Hot reloads changed namespaces
(defn -dev-main [port]
  (jetty/run-jetty
   (wrap-reload #'greet)
   {:port (Integer. port)}))

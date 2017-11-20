(ns socweb.core
  (:require [ring.adapter.jetty :as jetty]))

(defn -main [port]
  (jetty/run-jetty
   (fn [req]
     {:status  200
      :body    "Hello world!"
      :headers {}})
   {:port (Integer. port)}))

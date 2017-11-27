(ns socweb.league.handler
  (:require [socweb.league.model :refer [read-leagues]]))

(defn handle-leagues [request]
  (let [db      (:socweb/db request)
        leagues (read-leagues db)]
    {:status 200
     :body (str "<html><head></head><body><div>"
                (mapv :name leagues)
                "</div></body></html>")}))

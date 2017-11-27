(ns socweb.league.handler
  (:require [socweb.league.model :refer [get-leagues]]
            [socweb.league.view  :refer [league-page]]))

(defn handle-get-leagues [request]
  (let [db      (:socweb/db request)
        leagues (get-leagues db)]
    {:status 200
     :body (league-page leagues)}))

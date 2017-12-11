(ns socweb.competition.handler
  (:require [socweb.competition.model :refer [get-competitions]]
            [socweb.competition.view  :refer [competition-page]]))

(defn handle-get-competitions [request]
  (let [db           (:socweb/db request)
        competitions (get-competitions db)]
    {:status 200
     :body   (competition-page competitions)}))

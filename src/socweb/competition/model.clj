(ns socweb.competition.model
  (:require [clojure.java.jdbc :as db]))

(defn get-competitions [db]
  (db/query
   db
   ["SELECT name, matchdays
     FROM competition
     ORDER BY name;"]))

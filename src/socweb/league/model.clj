(ns socweb.league.model
  (:require [clojure.java.jdbc :as db]))

(defn read-leagues [db]
  (db/query
   db
   ["SELECT   id, name, code, icon
     FROM     league
     ORDER BY id ASC"]))

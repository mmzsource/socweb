(ns socweb.league.model
  (:require [clojure.java.jdbc :as db]))

(defn get-leagues [db]
  (db/query
   db
   ["SELECT   id, name, code, logo
     FROM     league
     ORDER BY id ASC"]))

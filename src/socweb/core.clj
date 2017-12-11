(ns socweb.core
  (:require [socweb.league.handler      :refer [handle-get-leagues]]
            [socweb.competition.handler :refer [handle-get-competitions]])
  (:require [ring.adapter.jetty         :as    jetty]
            [ring.middleware.params     :refer [wrap-params]]
            [ring.middleware.reload     :refer [wrap-reload]]
            [ring.handler.dump          :refer [handle-dump]]
            [compojure.core             :refer [defroutes GET]]
            [compojure.route            :refer [not-found]]))


(def db "jdbc:postgresql://localhost/lms")


(defn welcome [request]
  {:status 200
   :body   "Website to visualise soccer penalty point stats."})


(defn about [request]
  {:status 200}
  {:body   "Soccer penalty point stats will follow soon."})


(defroutes routes
  (GET "/"         [] welcome)
  (GET "/about"    [] about)

  (GET "/request"  [] handle-dump) ;; standard ring handler; see dependencies

  (GET "/leagues" [] handle-get-leagues)

  (GET "/competitions" [] handle-get-competitions)

  (not-found "Page not found."))


(defn wrap-db [hdlr]
  (fn [request]
    (hdlr (assoc request :socweb/db db))))


(def app
  (wrap-db
   (wrap-params
    routes)))


(defn -main [port]
  (jetty/run-jetty
   app
   {:port (Integer. port)}))


(defn -dev-main
  "Main that's only used in development. Hot reloads changed namespaces."
  [port]
  (jetty/run-jetty
   (wrap-reload #'app)
   {:port (Integer. port)}))

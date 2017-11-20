(ns socweb.core
  (:require [ring.adapter.jetty     :as    jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.handler.dump      :refer [handle-dump]]
            [compojure.core         :refer [defroutes GET]]
            [compojure.route        :refer [not-found]]))


(defn welcome [request]
  {:status 200
   :body   "Website to visualise soccer penalty point stats."})


(defn about [request]
  {:status 200}
  {:body   "Soccer penalty point stats will follow soon."})


(def ops
  {"+" +
   "-" -
   "*" *
   ":" /})


(defn calc [request]
  (let [op          (get-in request [:route-params :op])
        x (Integer. (get-in request [:route-params :x]))
        y (Integer. (get-in request [:route-params :y]))
        f (get ops op)]
    (if f
      {:status 200
       :body   (str x " " op " " y " = " (f x y))}
      {:status 404
       :body   (str "Unknown operator: " op " Supported operators: + - * :")})))


(defroutes app
  (GET "/"         [] welcome)
  (GET "/about"    [] about)
  (GET "/request"  [] handle-dump) ;; standard ring handler; see dependencies
  (GET "/calc/:x/:op/:y" [] calc)
  (not-found "Page not found."))


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

(defproject socweb "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.3"]
                 [compojure "1.6.0"]
                 [org.clojure/java.jdbc "0.7.3"]
                 [org.postgresql/postgresql "42.1.4"]
                 [hiccup "1.0.5"]]

  :min-lein-version "2.0.0"

  :uberjar-name "socweb.jar"

  :main socweb.core

  :profiles {:dev
             {:main socweb.core/-dev-main}})

(ns socweb.competition.view
  (:require [hiccup.page :refer [html5]]
            [hiccup.core :refer [html h]]))

(defn competition-page [competitions]
  (html5 {:lang :en}
         [:head
          [:title "LMS Competitions"]]
         [:body
          [:div.container
           [:table
            [:tr
             [:th "Competition Name"]
             [:th "Number of Matchdays"]]
            (for [competition competitions]
              [:tr
               [:td (h (:name      competition))]
               [:td (h (:matchdays competition))]])]]]))

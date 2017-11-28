(ns socweb.league.view
  (:require [hiccup.page :refer [html5]]
            [hiccup.core :refer [html h]]))

(defn league-page [leagues]
  (html5 {:lang :en}
         [:head
          [:title "LMS Leagues"]]
         [:body
          [:div.container
           [:table
            (for [league leagues]
              [:tr
               [:td
                [:a {:href   (h (:standings league))
                     :target "_blank"}
                 [:img {:src   (h (:logo league))
                        :style "width:128px;height:128px;"
                        :alt   (h (:name league))}]]]])]]]))

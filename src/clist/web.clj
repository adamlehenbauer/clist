(ns clist.web
  (:use compojure.core ring.adapter.jetty clist.db)
  (:use hiccup.core)
  (:use hiccup.page-helpers)
  (:require [compojure.route :as route])
  (:require [compojure.handler :as handler]))

(defn view-layout [& content]
  (html
    (doctype :xhtml-strict)
    (xhtml-tag "en"
      [:head
       [:meta {:http-equiv "Content-type"
               :content "text/html; charset=utf-8"}]
       [:title "clist"]]
      [:body content])))

(defroutes main-routes
  (GET "/" [] "<h1>Hello at world</h1>")
  (GET "/user/:id" [id]
    (str "<h1>hello mr. " id "</h1>"))
  (GET "/list/" []
    (view-layout
      [:h2 "the list!"]
      [:ul
       (map #(vec 
               [:li 
                [:a {:href (:url %)}
                (:summary %)]]) (select-from-db))]))
  
  (route/not-found "<h1>Page not found</h1>"))

;(run-jetty main-routes {:port 8084})

(def app
  (handler/site main-routes))

(ns clist.web
  (:use compojure.core ring.adapter.jetty)
  (:use hiccup.core)
  (:use hiccup.page-helpers)
  (:require [clist.db :as db])
  (:require [compojure.route :as route])
  (:require [compojure.handler :as handler]))

(def online-users (ref {}))

(defn view-layout [& content]
  (html
    (doctype :xhtml-strict)
    (xhtml-tag "en"
      [:head
       [:meta {:http-equiv "Content-type"
               :content "text/html; charset=utf-8"}]
       [:title "clist"]]
      [:body content])))

(defn add-item [summary url]
  (db/insert summary url))

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
                (:summary %)]]) (db/select-from-db))]))
  
  (route/not-found "<h1>Page not found</h1>"))

;(run-jetty main-routes {:port 8084})

(def app
  (handler/site main-routes))

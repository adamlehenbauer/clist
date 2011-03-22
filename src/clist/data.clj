(ns clist.data
  (:use [clojure.contrib.sql :as sql])
  (import java.util.Date))

(defn insert-starting-data
  []
  (sql/insert-values
    :items
    [:userid :summary :url :date_added]
    [1 "Bullet Earphones" "http://store.munitio.com/siti-s-bullet-earphones.html" (java.util.Date.)]))
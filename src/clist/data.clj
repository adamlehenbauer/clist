(ns clist.data
  (:use [clojure.contrib.sql :as sql])
  (import java.util.Date))

(defn now
  []
  (java.util.Date.))

(defn insert-starting-data
  []
  (sql/insert-values
    :items
    [:userid :summary :url :date_added]
    [1 "Bullet Earphones" "http://store.munitio.com/siti-s-bullet-earphones.html" (now)]
    [1 "Modernist Cuisine" "http://www.amazon.com/Modernist-Cuisine-Art-Science-Cooking/dp/0982761007/ref=sr_1_1?s=books&ie=UTF8&qid=1300733351&sr=1-1" (now)]
    [1 "Art of Computer Programming, Vols 1-4A" "http://www.amazon.com/Computer-Programming-Volumes-1-4A-Boxed/dp/0321751043/ref=sr_1_2?s=books&ie=UTF8&qid=1300733453&sr=1-2" (now)]
    [1 "Sausage Grinder" "http://www.amazon.com/Villaware-V268-10-Manual-Meat-Grinder/dp/B000I1YIW2" (now)]))

(defn create-items
  []
  (sql/create-table
    :items
    [:id :int "NOT NULL AUTO_INCREMENT PRIMARY KEY"]
    [:userid :int "NOT NULL"]
    [:summary "varchar(255)" "NOT NULL"]
    [:url "varchar(255)" "DEFAULT NULL"]
    [:date_added "datetime" "NOT NULL"])
  (sql/do-commands 
    "ALTER TABLE `items` CONVERT TO CHARACTER SET utf8"
    "ALTER TABLE `items` ENGINE=InnoDB"))

(defn drop-items
  []
  (sql/drop-table :items))

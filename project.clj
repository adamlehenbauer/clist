(defproject clist "1.0.0-SNAPSHOT"
  :description "FIXME: write"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.6.2"]
                 [hiccup "0.3.4"]
                 [ring "0.3.7"]
                 [mysql/mysql-connector-java "5.1.7"]
                 [jline/jline "0.9.94"]
                 [commons-dbcp/commons-dbcp "1.2.1"]]
  :dev-dependencies [[lein-ring "0.3.2"]]
  :ring {:handler clist.web/app})

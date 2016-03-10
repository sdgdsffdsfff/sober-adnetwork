(defproject sober-adnetwork "0.1.0-SNAPSHOT"
  :description "a network of publisher and advertiser"
  :url "http://adnetwork.xxxx.com"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.0"]
                 
                 ;;JDBC dependencies
                 [org.clojure/java.jdbc "0.4.2"]
                 [mysql/mysql-connector-java "5.1.38"]
                 [com.jolbox/bonecp "0.8.0.RELEASE"]
                 
                 [hiccup "1.0.5"]
                 [ring "1.4.0"]
                 [ring-server "0.4.0"]
                 
                 ;;
                 [org.slf4j/slf4j-log4j12 "1.7.2"]
                 [log4j/log4j "1.2.17"]
                 ]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler sober-adnetwork.handler/app
         :init sober-adnetwork.handler/init
         :destroy sober-adnetwork.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring/ring-mock "0.3.0"] [ring/ring-devel "1.4.0"]]}})

(defproject clota "0.1.0-SNAPSHOT"
  :description "Clota - IOTA Library Implemented in Clojure"
  :url "https://github.com/tuddman/iota.lib.clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha16"]
                 [cheshire "5.8.0"]
                 [clj-http "3.7.0"]
                 [environ "1.1.0"]]

 :min-lein-version "2.5.1" 
 :main clota.client)

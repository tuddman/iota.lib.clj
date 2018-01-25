(defproject clota "0.1.2-SNAPSHOT"
  :description "Clota - IOTA Library Implemented in Clojure"
  :url "https://github.com/tuddman/iota.lib.clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [base64-clj "0.1.1"]
                 [cheshire "5.8.0"]
                 [clj-http "3.7.0"]
                 [clj.qrgen "0.4.0"]
                 [environ "1.1.0"]
                 [com.taoensso/timbre "4.10.0"]]

 :min-lein-version "2.5.1" 
 :main clota.client)

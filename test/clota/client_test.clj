(ns clota.client-test
  (:require [clojure.test :refer :all]
            [clota.client :refer :all]
            [cheshire.core :as json]
            [clj-http.client :as client]))

(def localhost "http://localhost:14700")
(def bitfinex "http://iota.bitfinex.com:80")

(def host-node bitfinex)

(deftest test-get-node-info
  (let [host host-node]
  (testing "does get-node-info return data"
    (is (= "IRI" (-> (get-node-info host) :appName))))))

(deftest test-get-neighbors
  (let [host host-node]
  (testing "does get-node-info return data"
    (is (>= 0 (-> (get-neighbors host) :duration)))
    (is (not-empty (-> (get-neighbors host) :neighbors))))))

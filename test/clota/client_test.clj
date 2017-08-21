(ns clota.client-test
  (:require [clojure.test :refer :all]
            [clota.client :refer :all]
            [cheshire.core :as json]
            [clj-http.client :as client]))

(def localhost "http://localhost:14700")
(def bitfinex "http://iota.bitfinex.com:80")

(def test-node bitfinex)

(deftest test-get-node-info
  (let [host test-node]
  (testing "does get-node-info return data"
    (is (= "IRI" (-> (get-node-info host) :appName))))))

(deftest test-get-neighbors
  (let [host test-node]
  (testing "does get-node-info return data"
    (is (>= 0 (-> (get-neighbors host) :duration)))
    #_(is (not-empty (-> (get-neighbors host) :neighbors))))))

(deftest test-add-neighbors
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-remove-neighbors
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-get-tips
  (let [host test-node]
  (testing "does get-tips return a vector of tip hashes"
    (is (not-empty (-> (get-neighbors host) :hashes))))))   

(deftest test-find-transactions
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-get-trytes
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-get-inclusion-states
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-get-balances
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-get-transactions-to-approve
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-attach-to-tangle
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-interrupt-attaching-to-tangle
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-broadcast-transactions
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-store-transactions
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-find-transactions
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

(deftest test-find-transactions
  (let [host test-node]
  (testing ""
    (is (= true (or true "test not yet implmented"))))))

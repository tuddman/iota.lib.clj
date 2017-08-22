(ns clota.client-test
  (:require [clojure.test :refer :all]
            [clota.client :refer :all]
            [cheshire.core :as json]
            [clj-http.client :as client]
            [environ.core :refer [env]]))

(def localhost "http://localhost:14700")
(def ci-host-node (env :iota-test-node))
(def ci-host-neighbor (env :iota-test-neighbor))

(def test-node ci-host-node)

(deftest test-get-node-info
  (let [host test-node]
  (testing "does get-node-info return data"
    (is (= "IRI" (-> (get-node-info host) :appName))))))

(deftest test-get-neighbors
  (let [host test-node]
  (testing "does get-node-info return data"
    (is (<= 0 (-> (get-neighbors host) :duration)))
    #_(is (not-empty (-> (get-neighbors host) :neighbors))))))

(deftest test-add-neighbors
  (let [host test-node
        neighbor ci-host-neighbor
        added-neighbor-resp (add-neighbors host [neighbor])
        neighbors (map :address (:neighbors (get-neighbors test-node)))]
  (testing "does a neighbor get added"
    #_(is (= 1 (:addedNeighbors added-neighbor-resp)))
    #_(is (= true (not (empty (some #{neighbor} neighbors)))) ))))

(deftest test-remove-neighbors
  (let [host test-node
        neighbor ci-host-neighbor
        remove-neighbor-resp (remove-neighbors host [neighbor])
        neighbors (map :address (:neighbors (get-neighbors test-node)))]
  (testing "does a neighbor get removed"
    #_(is (= 1 (:removedNeighbors remove-neighbor-resp)))
    #_(is (= nil (some #{neighbor} neighbors)) ))))

(deftest test-get-tips
  (let [host test-node]
  (testing "does get-tips return a vector of tip hashes"
    (is (not-empty (-> (get-tips host) :hashes))))))   

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

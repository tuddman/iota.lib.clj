(ns clota.crypto-test
  (:require [clojure.test :refer :all]
            [clota.crypto :refer :all]))

(deftest test-generate-seed
  (let [seed (generate-seed)]
  (testing "does seed generation work"
    (is (= 81 (count seed)))
    (is (identical? seed (re-matches #"[9A-Z]{0,81}" seed))))))


(deftest test-generate-paranoid-seed
  (let [seed (generate-paranoid-seed)]
  (testing "does seed generation work"
    (is (= 81 (count seed)))
    (is (identical? seed (re-matches #"[9A-Z]{0,81}" seed))))))





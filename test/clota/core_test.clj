(ns clota.client-test
  (:require [clojure.test :refer :all]
            [clota.client :refer :all]
            [cheshire.core :as json]
            [clj-http.client :as client]))

(deftest test-get-node-info
  (is (= (get-node-info "http://localhost:14700") {})))

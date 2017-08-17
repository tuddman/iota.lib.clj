(ns clota.client
  (:require  
    [clojure.spec.alpha :as s]
    [cheshire.core :as json]
    [clj-http.client :as client]))


(def fields
  #{"seed" "address" "message" "transaction" "trytes" "hash" "bundles" "addresses" "tags" "approvees" "securityLevel" "minWeightMagnitude" "uris"})

(def iota-hostname "http://localhost:14265")

;; from https://iota.readme.io/docs

(defn get-iota-version [] (json/encode {:version "1.2.0"}))

(defn- build-iota-command-req
  "params 
    - command { String }
    - params { Map } Optional "
  [command & [params]]
  (let [req-body { :command command }
        body (json/encode (merge req-body (or params {})))
        req (try (client/post (str  iota-hostname)
                              {:body body
                               :content-type :json})
                 (catch Exception e (ex-data e)))]
    (-> req
        :body
        (json/decode true))))

(defn get-node-info []          
  (build-iota-command-req "getNodeInfo"))

(defn get-neighbors [] 
  (build-iota-command-req "getNeighbors"))

(defn add-neighbors [] 
  (build-iota-command-req "addNeighbors"))

(defn remove-neighbors [] 
  (build-iota-command-req "removeNeighbors"))

(defn get-tips [] 
  (build-iota-command-req "getTips"))

(defn find-transactions [] 
  (build-iota-command-req "findTransactions"))
 
(defn get-trytes [] 
  (build-iota-command-req "getTrytes"))

(defn get-inclusion-states [] 
  (build-iota-command-req "getInclusionStates"))

(defn get-balances [] 
  (build-iota-command-req "getBalances"))

(defn get-transactions-to-approve [] 
  (build-iota-command-req "getTransactionsToApprove"))

(defn attach-to-tangle [] 
  (build-iota-command-req "attachToTangle"))

(defn interrupt-attaching-to-tangle [] 
  (build-iota-command-req "interruptAttachingToTangle"))

(defn broadcast-transactions [] 
  (build-iota-command-req "broadcastTransactions"))

(defn store-transactions [] 
  (build-iota-command-req "storeTransactions"))


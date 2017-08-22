(ns clota.client
  (:require  
    [clojure.spec.alpha :as s]
    [cheshire.core :as json]
    [clj-http.client :as client]))


(def fields
  #{"seed" "address" "message" "transaction" "trytes" "hash" "bundles" "addresses" "tags" "approvees" "securityLevel" "minWeightMagnitude" "uris"})

(def iota-localhost "http://localhost:14265")

;; from https://iota.readme.io/docs

(defn get-iota-version [] (json/encode {:version "1.2.0"}))

(defn- build-iota-req
  "params 
    - command { String }
    - params { Map } Optional "
  [{:keys [host command] :or {host iota-localhost}} & [params]]
  (let [body (json/encode (merge {:command command} (or params {})))
        req (try (client/post (str host)
                              {:body body
                               :content-type :json })
                 (catch Exception e (ex-data e)))]
    (-> req
        :body
        (json/decode true))))

(defn get-node-info 
  [host]          
  (build-iota-req {:host host
                   :command "getNodeInfo"}))

(defn get-neighbors 
  [host] 
  (build-iota-req {:host host
                   :command "getNeighbors"}))

(defn add-neighbors 
 [host [uris]] 
  (build-iota-req {:host host
                   :command "addNeighbors"}
                  {:uris [uris]}))

(defn remove-neighbors
  [host [uris]] 
  (build-iota-req {:host host
                   :command "removeNeighbors"}
                  {:uris [uris]}))

(defn get-tips 
  [host] 
  (build-iota-req {:host host
                   :command "getTips"}))

(defn find-transactions 
  "find-transactions can take as inputs a map of ONE of:
    - bundles [...] : List of bundle hashes. The hashes needs to be extended to 81 trytes by padding the hash with 9's.
    - addresses [...]  : List of addresses.
    - tags [...] : List of tags. Has to be 27 trytes. 
    - approvees [...] : List of approvee transaction hashes.
  
  e.g. (find-transaction host {:addresses [AA9... AB9...]}"
  [host inputs] 
  (build-iota-req {:host host
                   :command "findTransactions"}
                  inputs))
 
(defn get-trytes 
  "@param trytes : List of transaction hashes of which you want to get trytes from."
  [host [trytes]] 
  (build-iota-req {:host host
                   :command "getTrytes"}
                  {:hashes [trytes]}))

(defn get-inclusion-states 
  [host {:keys [transactions tips] :as params}] 
  (build-iota-req {:host host
                   :command "getInclusionStates"}
                  params))

(defn get-balances 
  [host {:keys [addresses threshold] :as params}] 
  (build-iota-req {:host host
                   :command "getBalances"}
                  params))

(defn get-transactions-to-approve 
  [host {:keys [depth] :as params}] 
  (build-iota-req {:host host
                   :command "getTransactionsToApprove"}
                  params))

(defn attach-to-tangle 
  [host {:keys [trunk-transaction branch-transaction min-weight-magnitude trytes] :as params}] 
  (build-iota-req {:host host
                   :command "attachToTangle"}
                  {:trunkTransaction trunk-transaction
                   :branchTransaction branch-transaction
                   :minWeightMagnitude min-weight-magnitude
                   :trytes trytes}))

(defn interrupt-attaching-to-tangle  
  [host] 
  (build-iota-req {:host host
                   :command "interruptAttachingToTangle"}))

(defn broadcast-transactions
  "@param transactions : List of raw data of transactions to be rebroadcast."
  [host [transactions]] 
  (build-iota-req {:host host
                   :command "broadcastTransactions"}
                  {:trytes [transactions]}))

(defn store-transactions  
  "@param transactions : List of raw data of transactions to store locally."
  [host [transactions]] 
  (build-iota-req {:host host
                   :command "storeTransactions"}
                  {:trytes [transactions]}))


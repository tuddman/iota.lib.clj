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
  [{:keys [host command]} & [params]]
  (let [hostname (or host iota-localhost)
        req-body { :command command }
        body (json/encode (merge req-body (or params {})))
        req (try (client/post (str hostname)
                              {:body body
                               :content-type :json})
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
  [{:keys [host neighbors]}] 
  (build-iota-req {:host host
                   :command "addNeighbors"}
                  neighbors))

(defn remove-neighbors
  [{:keys [host neighbors]}] 
  (build-iota-req "removeNeighbors"))

(defn get-tips 
  [host] 
  (build-iota-req {:host host
                   :command "getTips"}))

(defn find-transactions 
  [] 
  (build-iota-req "findTransactions"))
 
(defn get-trytes [] 
  (build-iota-req "getTrytes"))

(defn get-inclusion-states [] 
  (build-iota-req "getInclusionStates"))

(defn get-balances [] 
  (build-iota-req "getBalances"))

(defn get-transactions-to-approve [] 
  (build-iota-req "getTransactionsToApprove"))

(defn attach-to-tangle [] 
  (build-iota-req "attachToTangle"))

(defn interrupt-attaching-to-tangle [] 
  (build-iota-req "interruptAttachingToTangle"))

(defn broadcast-transactions [] 
  (build-iota-req "broadcastTransactions"))

(defn store-transactions [] 
  (build-iota-req "storeTransactions"))


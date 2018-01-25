(ns clota.qr
  (:require 
    [clj.qrgen :as qr]
    [clota.crypto :refer [generate-seed]]
    [taoensso.timbre :as log])) 

(defn generate-iota-qr
  ([] 
   (let [seed (generate-seed)]
        (log/info seed)
       (qr/as-file 
        (qr/from seed))))
  ([seed] (qr/as-file
            (qr/from seed))))

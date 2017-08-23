(ns clota.crypto
  (:import java.security.SecureRandom))
  
(defn trytes
  [size]
  (let [tryte-alphabet  "9ABCDEFGHIJKLMNOPQRSTUVWXYZ"]
    (apply str (take size (repeatedly #(.charAt tryte-alphabet (.nextInt (SecureRandom.) 27)))))))

(defn generate-seed []
  (trytes 81))

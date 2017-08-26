(ns clota.crypto
  (:import java.security.SecureRandom))
  
(defn trytes
  [size]
  (let [tryte-alphabet  "9ABCDEFGHIJKLMNOPQRSTUVWXYZ"]
    (apply str (take size (repeatedly #(.charAt tryte-alphabet (.nextInt (SecureRandom.) 27)))))))

(defn generate-seed []
  (trytes 81))

(defn generate-paranoid-seed
  "this fn generates a seed by:
    - Forms an 81x81 matrix of seeds. Each of which could be used as perfectly secure seed. But why stop there?
    - Securely & randomly selects an element from each row. Result is also a perfectly secure seed. 
   Some would say this is overkill to get to the same-level-of-security seed as (generate-seed).
   Those people aren't paranoid and this function is not for them. 
   This function is for you, my paranoid friend."
  []
  (let [rand-selector-fn (fn [seed] (nth seed (.nextInt (SecureRandom.) (count seed))))
        m (take 81 (repeatedly generate-seed))]
    (->> m
      (map rand-selector-fn)
      (apply str))))

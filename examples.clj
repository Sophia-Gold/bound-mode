(defn chain
  [f g order]
  (let [f (nth (iterate add-dim f)
               (dec (long (count (ffirst g)))))
        f' (diff-unmixed1 f order 1)
        g' (diff g order)] 
    (->> order
         partition-set
         (map #(->> %
                    (map #(->> %
                               (map-indexed #(*' (long (Math/pow 10 %1)) 
                                                 %2))
                               (reduce +')
                               (get g')))
                    (apply mul)
                    (mul (multi-compose (nth f' (dec (count %))) g))))
         (apply add))))

(defn chain'
  [f g order]
  (let [f (nth (iterate add-dim f)
               (dec (long (count (ffirst g)))))
        f' (diff-unmixed1 f order 1)
        g' (diff g order)]
    (fn-> order
          partition-set
          (map (->> %1
                    (map (->> %2
                              (interleave (range))
                              (partition 2) 
                              (map (->> %3 ((fn [[idx v]] (*' (long (Math/pow 10 idx)) v))))) 
                              (reduce +')
                              (get g')))
                    (apply mul)
                    (mul (multi-compose (nth f' (dec (count %1))) g))))
          (apply add))))

(def pred  #(#(#(% #(% #(% %))) %) %))
(def pred' #(((%1 (%5 (%4 %2))) %3) (%6)))

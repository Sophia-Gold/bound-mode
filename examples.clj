


(defn chain
  [f g order]
  (let [f (nth (iterate add-dim f)
               (dec (long (count (ffirst g)))))
        f' (diff-unmixed1 f order 1)
        g' (diff g order)] 
    (->> order
    	 partition-set
         (map (fn [p]
                (mul (multi-compose (nth f' (dec (count p))) g)
                     (->> p
                          (map (fn [b] (->> b 
                                           (map-indexed #(*' (long (Math/pow 10 %1)) 
                                                             %2))
                                           (reduce +')
                                           (get g'))))
                          (apply mul)))))
         (apply add))))



(defn chain
  [f g order]
  (let [f (nth (iterate add-dim f)
               (dec (long (count (ffirst g)))))
        f' (diff-unmixed1 f order 1)
        g' (diff g order)
        x (partition-set order)
        xf1 #(*' (long (Math/pow 10 %1)) %2)
        xf2 #(->> %
                  (reduce +')
                  (get g'))
        xf3 #(->> %
                  (apply mul)
                  (mul (multi-compose (nth f' (dec (count %))) g)))]
    (apply add
           (map
            (comp xf3
                  #(map xf2 %)
                  #(map #(map-indexed xf1 %) %))
            x))))



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



(defn chain
  [f g order]
  (let [f (nth (iterate add-dim f)
               (dec (long (count (ffirst g)))))
        f' (diff-unmixed1 f order 1)
        g' (diff g order)]
    (fn->> order
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



(fn [n]
  (fn [f]
    (fn [x]
      (((n (fn [g]
             (fn [h]
	       (h (g f)))))
	(fn [u] x))
      (fn [u] u)))))



#(#(#(% #(% #(%1 %2))) %) %)



(fn-> (((%1 (%5 (%4 %2))) %3) %6))




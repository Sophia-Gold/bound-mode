(def chain 
  '(fn [f g order]
     (let [f (nth (iterate add-dim f)  ;; coerce `f` to dimensionality of `g`
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
            (apply add)))))

(defmacro pred   [n] '(fn [f] (fn [x] (((n (fn [g] (fn [h] (h (g f))))) (fn [u] x)) (fn [u] u)))))
(defmacro pred [n]   '#(((n (%4 (%3 %1))) %2) (%5)))
(defmacro pred [n] #(#((n #(% #(% %))) %) %))
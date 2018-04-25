;; TO DO:
;; params in different colors matching their occurrences in the body
;; indexed literals in different colors
;; match parens

(setq bound-highlights 
      '(("%[0-9]\\|%" . font-lock-function-name-face)
	("#\\s(" . font-lock-function-name-face)
	("fn\\s-*[\n]*\\[[^]]+]" . font-lock-function-name-face)
	("defn\\s-*\\w+\\s-*[\n]*\\s-*\\[[^]]+\\]" . font-lock-function-name-face)))

(define-derived-mode bound-mode fundamental-mode "bound"
"major mode for highlighting bound variables in clojure"
  (setq font-lock-defaults '(bound-highlights)))

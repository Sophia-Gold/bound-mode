;; TO DO:
;; params in different colors matching their occurrences in the body
;; indexed literals in different colors
;; match parens

(setq bound-highlights 
      '(("defn\\s-*\\w+\\s-*[\n]*\\s-*\\[[^]]+\\]" . font-lock-function-name-face)
	("fn\\s-*[\n]*\\[[^]]+]" . font-lock-function-name-face)
	(" f \\|(f \\| f)\\|(f)" . font-lock-function-name-face) 
	(" g \\|(g \\| g)\\|(g)" . font-lock-function-name-face) 
	(" order \\|(order \\| order)\\|(order)" . font-lock-function-name-face)
	(" p \\|(p \\| p)\\|(p)" . font-lock-function-name-face)
	(" p \\|(p \\| p)\\|(p)" . font-lock-function-name-face)
	("%[0-9]\\|%" . font-lock-keyword-face)
	("#\\s(" . font-lock-keyword-face)))

(define-derived-mode bound-mode fundamental-mode "bound"
"major mode for highlighting bound variables in clojure"
  (setq font-lock-defaults '(bound-highlights)))

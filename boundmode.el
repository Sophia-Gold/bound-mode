(setq bound-highlights
      '(("fn \\[u\\] x" . font-lock-function-name-face)
       	("fn\\s-*[\n]*\\[[^]]+]*]" . font-lock-function-name-face) 
	(" p[^a-z]". font-lock-function-name-face)  
	("[^a-z]h " . font-lock-function-name-face)
	("[^a-z]n " . font-lock-function-name-face)
 	(" b " . font-lock-function-name-face) 
	("idx" . font-lock-function-name-face)
	(" v" . font-lock-function-name-face) 
	("g f" . font-lock-function-name-face) 
	(" u" . font-lock-function-name-face) 
	("fn->+" . font-lock-string-face) 
	("%[1-9]" . font-lock-string-face)
	("#" . font-lock-keyword-face)
	("%" . font-lock-keyword-face)))

(define-derived-mode bound-mode fundamental-mode "bound"
"major mode for highlighting bound variables in clojure"
  (setq font-lock-defaults '(bound-highlights)))

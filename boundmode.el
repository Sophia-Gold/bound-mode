(setq bound-highlights
      '(("#" . font-lock-function-name-face)
	("fn->" . font-lock-function-name-face)
	("%[1-9]" . font-lock-string-face)
	("%" . font-lock-keyword-face)))

(define-derived-mode bound-mode fundamental-mode "bound"
"major mode for highlighting bound variables in clojure"
  (setq font-lock-defaults '(bound-highlights)))

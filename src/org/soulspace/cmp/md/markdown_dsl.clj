;;;;
;;;;   Copyright (c) Ludger Solbach. All rights reserved.
;;;;
;;;;   The use and distribution terms for this software are covered by the
;;;;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;;;;   which can be found in the file license.txt at the root of this distribution.
;;;;   By using this software in any fashion, you are agreeing to be bound by
;;;;   the terms of this license.
;;;;
;;;;   You must not remove this notice, or any other, from this software.
;;;;

(ns org.soulspace.cmp.md.markdown-dsl
  "Functions to generate standard and github flavored markdown."
  (:require [clojure.string :as str]))

(def ^:private indent (atom 0))
(defn- inc-indent [] (swap! indent inc))
(defn- dec-indent [] (swap! indent dec))

;;;
;;; formatting for standard markdown
;;;

(defn markdown
  [& coll]
  (apply str coll))

(defn h1
  "First level heading (standard markdown)."
  [s]
  (str s "\n" (apply str (repeat (count s) "=")) "\n"))

(defn h2
  "Second level heading (standard markdown)."
  [s]
  (str s "\n" (apply str (repeat (count s) "-")) "\n"))

(defn h3
  "Third level heading (standard markdown)."
  [s]
  (str "### " s))

(defn h4
  "Fourth level heading (standard markdown)."
  [s]
  (str "#### " s))

(defn h5
  "Fifth level heading (standard markdown)."
  [s]
  (str "##### " s))

(defn h6
  "Sixth level heading (standard markdown)."
  [s]
  (str "###### " s))

(defn p
  "Paragraph (standard markdown)."
  [& coll]
  (str (apply str coll) "\n\n"))

(defn br
  "Line break (standard markdown)."
  []
  "  ")

(defn ul
  "Unordered list (standard markdown)."
  [& coll]
  (inc-indent)
  (let [s (apply str (map #(str "* " % "\n") coll))]
    (dec-indent)
    s))

(defn ol
  "Ordered list (standard markdown)."
  [& coll]
  (inc-indent)
  (let [s (apply str (map #(str %1 ". " %2 "\n") (iterate inc 1) coll))]
    (dec-indent)
    s))

(defn em
  "Emphasis (standard markdown)."
  [s]
  (str "*" s "*"))

(defn strong
  "Strong emphasis (standard markdown)."
  [s]
  (str "**" s "**"))

(defn very-strong
  "Very strong emphasis (standard markdown)."
  [s]
  (str "***" s "***"))

(defn code-inline
  "Code inline (standard markdown)."
  [s]
  (str "`" s "`"))

(defn code
  "Code (standard markdown)."
  [s]
  (apply str (map #(str "    " % "\n") (str/split s #"(\r\n|\n|\r)"))))

(defn block-quote
  "Block quote (standard markdown)."
  [s]
  (str "> " s))

(defn link
  "Link (standard markdown)."
  [& coll]
  (str "[" (first coll) "]" "(" (second coll) ")"))

(defn link-id
  "Link (standard markdown)."
  [& coll]
  (str "[" (first coll) "]" "[" (second coll) "]"))

(defn link-ref
  "Link reference (standard markdown)."
  [& coll]
  (str "[" (first coll) "]: " (second coll) (when (seq (nnext coll)) (str " \"" (nnext coll) "\""))))

(defn image
  "Image (standard markdown)."
  [& coll]
  (str "![" (first coll) "]" "(" (second coll) ")"))

(defn image-id
  "Image ID (standard markdown)."
  [& coll]
  (str "![" (first coll) "]" "[" (second coll) "]"))

(defn image-ref
  "Image reference (standard markdown)."
  [& coll]
  (str "![" (first coll) "]: " (second coll) (when (seq (nnext coll)) (str " \"" (nnext coll) "\""))))

(defn hr
  "Horizontal ruler (standard markdown)."
  []
  "------------------------------------------------------------------------")

;;;
;;; additional formatting for Github flavored markdown
;;;

(defn strike-through
  "Strike through text (Github flavoured markdown)."
  [s]
  (str "~~" s "~~"))

(defn fenced-code
  "Fenced code (Github flavoured markdown)."
  ([s]
   (str "```\n" s "```\n"))
  ([s lang]
   (str "```" lang "\n" s "```\n")))

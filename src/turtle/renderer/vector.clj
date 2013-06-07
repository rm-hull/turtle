^{:cljs
  (ns turtle.renderer.vector
    (:use [clojure.string :only [join]]
          [turtle.core :only [move-op?]]
          [dommy.template :only [->node-like]])
    (:use-macros [dommy.macros :only [node]]))
}
(ns turtle.renderer.vector
  (:use [clojure.string :only [join]]
        [turtle.core :only [move-op?]] 
        [hiccup.core :only [html]]))

(defn- transform [[a b c d e f]]
  (str "translate(" e "," f ") scale(" a "," d ")"))

(defn- d-instr [command]
  (str  
    (if (move-op? command) "M" "L")
    (join "," (:coords command))))

(defn- path [[initial commands]]
  (let [initial (assoc (last initial) :move true)]
  [:path 
    { :style (str "fill:none;stroke-width:3;stroke:" (name (:color initial)) ";") 
      :d (->> commands (cons initial) (map d-instr) (apply str))}]))

(defn- segmenter [data]
  (->>
    data
    (partition-by #(contains? % :color))
    (partition-all 2)))

(defn ->svg [data [w h] bounds matrix]
  (^{:cljs node} html 
    [:svg 
     { :xmlns "http://www.w3.org/2000/svg"
       :xmlns:xlink "http://www.w3.org/1999/xlink"
       :width w :height h
       :zoomAndPan "magnify"
       :preserveAspectRatio "xMidYMid meet"
       :overflow "visible"
       :version "1.0" }
      [:g {:transform (transform matrix)}
        (map path (segmenter data))]]))

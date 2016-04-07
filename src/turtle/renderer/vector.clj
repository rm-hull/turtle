^{:cljs
  (ns turtle.renderer.vector
    (:require
      [clojure.string :refer [join]]
      [turtle.core :refer [move-op?]]
      [hipo.core :as hipo]))}

(ns turtle.renderer.vector
  (:require
    [clojure.string :refer [join]]
    [turtle.core :refer [move-op?]]
    [hiccup.core :refer [html]]))

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
  (^{:cljs hipo/create} html
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

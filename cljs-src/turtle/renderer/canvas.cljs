(ns turtle.renderer.canvas
  (:use [monet.canvas :only [save restore stroke-width stroke-cap stroke-style 
                             begin-path line-to move-to stroke close-path transform]]))

(defn- draw-op [state]
  (if (or (:restore-point state) (:move state)) 
    move-to 
    line-to))

(defn- draw-path-segments! [ctx data]
  (doseq [state data]
    (.log js/console (pr-str "state" state))
    (when-let [color (:color state)]
      (stroke-style ctx color))
    (apply (draw-op state) ctx (:coords state)))
  ctx) ; return the context for threading

(defn ->canvas [ctx]
  (fn [data [w h] bounds matrix]
    (.log js/console (pr-str "screen-size" [w h]))
    (.log js/console (pr-str "bounds" bounds))
    (.log js/console (pr-str "matrix" matrix))
    (->
      (apply transform ctx matrix)
      (stroke-width 3)
      (stroke-cap :square)
      (begin-path)
      (draw-path-segments! data)
      (stroke)
      (close-path))))

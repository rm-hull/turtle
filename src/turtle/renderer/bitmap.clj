(ns turtle.renderer.bitmap
  (:use [turtle.core :only [move-op?]])
  (:import [java.awt.image BufferedImage]
           [java.awt.geom AffineTransform GeneralPath]  
           [java.awt Color Graphics2D RenderingHints BasicStroke GraphicsEnvironment]))

(def color-mapper 
   { :red      Color/RED 
     :green    Color/GREEN 
     :blue     Color/BLUE
     :yellow   Color/YELLOW
     :cyan     Color/CYAN
     :magenta  Color/MAGENTA
     :orange   Color/ORANGE
     :black    Color/BLACK
     "#663300" (Color. 0x663300)
     "#68FF33" (Color. 0x68FF33) })

(defn- draw-shape [g2d data]
  (let [path (GeneralPath.)]
    (.moveTo path 0.0 0.0)
    (loop [data data
           x1 0.0
           y1 0.0]
      (if (nil? data)
        (.draw g2d path)
        (let [d (first data)
              x2 (double (get-in d [:coords 0])) 
              y2 (double (get-in d [:coords 1]))]
          (when-let [color (:fill d)]
            (.closePath path)
            (.setBackgroundColor g2d (get color-mapper color))
            (.fill g2d path)
            (.draw g2d path)
            (.reset path)
            (.moveTo path x1 y1))
          (when-let [color (:color d)]
            (.draw g2d path)
            (.reset path)
            (.setColor g2d (get color-mapper color))
            (.moveTo path x1 y1)) 
          (if (move-op? d) (.moveTo path x2 y2) (.lineTo path x2 y2) )
          (recur (next data) x2 y2))))))

(defn create-image [w h]
  (if (GraphicsEnvironment/isHeadless)
    (BufferedImage. w h BufferedImage/TYPE_INT_RGB)
    (.createCompatibleImage 
       (.getDefaultConfiguration 
         (.getDefaultScreenDevice 
           (GraphicsEnvironment/getLocalGraphicsEnvironment)))
       w h)))

(defn ->img [data [w h] bounds matrix]
  (let [img (create-image w h) 
        g2d (.createGraphics img)]
    (doto g2d
      (.setBackground Color/WHITE)
      (.clearRect 0 0 w h)
      (.setStroke (BasicStroke. 3)) 
      (.setTransform (AffineTransform. (into-array Double/TYPE matrix))) 
      (.setRenderingHint RenderingHints/KEY_ANTIALIASING RenderingHints/VALUE_ANTIALIAS_ON)
      (.setRenderingHint RenderingHints/KEY_RENDERING RenderingHints/VALUE_RENDER_QUALITY))
    (draw-shape g2d data) 
    (.dispose g2d)
    img))

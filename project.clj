(defproject rm-hull/turtle "0.1.9-SNAPSHOT"
  :description "A lightweight Clojure/ClojureScript turtle-graphics library for SVG, Graphics2D and HTML5 canvas rendering"
  :url "https://github.com/rm_hull/turtle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2202"]
                 [rm-hull/dommy "0.1.3-SNAPSHOT"]
                 [hiccup "1.0.5"]
                 [jayq "2.5.0"]
                 [rm-hull/monet "0.1.10"]]
  :plugins [[lein-cljsbuild "1.0.3"]
            [com.birdseye-sw/lein-dalap "0.1.0"]]
  :hooks [leiningen.dalap]
  :source-paths ["src" "target/generated-src"]
  :cljsbuild {
    :builds [{:source-paths ["target/generated-src"], :id "main", :jar true}]}
  :min-lein-version "2.3.4")

(defproject rm-hull/turtle "0.1.6"
  :description "A ClojureScript turtle-graphics library"
  :url "https://github.com/rm_hull/turtle"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1806"]
                 [prismatic/dommy "0.1.1"]
                 [hiccup "1.0.3"]
                 [jayq "2.3.0"]
                 [rm-hull/monet "0.1.7"]]
  :plugins [[lein-cljsbuild "0.3.0"]
            [com.birdseye-sw/lein-dalap "0.1.0"]]
  :hooks [leiningen.dalap leiningen.cljsbuild]
  :source-path "src"
  :cljsbuild {
    :builds [{:source-paths ["cljs-src"], :id "main", :jar true}]}
  :min-lein-version "2.1.1"
  :description "A lightweight turtle drawing library for HTML5 canvas" 
) 

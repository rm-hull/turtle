(defproject rm-hull/turtle "0.1.9-SNAPSHOT"
  :description "A lightweight Clojure/ClojureScript turtle-graphics library for SVG, Graphics2D and HTML5 canvas rendering"
  :url "https://github.com/rm_hull/turtle"
  :license {
    :name "The MIT License (MIT)"
    :url "http://opensource.org/licenses/MIT"}
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [org.clojure/clojurescript "1.8.40"]
    [hipo "0.5.2"]
    [hiccup "1.0.5"]
    [rm-hull/monet "0.2.2"]]
  :scm {
    :url "git@github.com:rm-hull/turtle.git"}
  :plugins [
    [lein-cljsbuild "1.1.3"]
    [com.birdseye-sw/lein-dalap "0.1.1"]]
  :hooks [leiningen.dalap]
  :source-paths ["src" "target/generated-src"]
  :cljsbuild {
    :builds [{
      :source-paths ["target/generated-src"]
      :id "main"
      :jar true}]}
  :min-lein-version "2.6.1"
  :profiles {
    :dev {
      :global-vars {*warn-on-reflection* true}
      :plugins [
        [lein-cloverage "1.0.6"]]}})

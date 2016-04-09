(ns turtle.renderer.vector-test
  (:require
    [clojure.test :refer :all]
    [turtle.core :refer [draw!]]
    [turtle.renderer.vector :refer [->svg]]))

(deftest check-svg-generation
  (let [triangle (take 12 (cycle [:fwd 200, :right 120]))]
    (is (= (slurp "test/triangle.svg") (draw! ->svg triangle [800 600])))))
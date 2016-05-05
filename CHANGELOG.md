Changelog
=========
0.1.9
-----
* Dependency versions bumped
* pop-state doesn't crash if no restore point
* Add basic test
* Remove duplicate path points in SVG rendering
* Make SVG paths slightly more readable (separate with spaces)
* Rounding to 5 d.p.

0.1.8
-----
* Travis CI config
* Re-org generated source directory
* Dependency versions bumped

0.1.7
-----
* Dependency versions bumped

0.1.6
-----
* Fill operation (canvas/bitmap only, not SVG yet)

0.1.5
-----
* SVG rendering (clojurescript)

0.1.4
-----
* SVG rendering (clojure only)
* Renamed PNG renderer to bitmap

0.1.3
-----
* Added margin
* Added type-hints

0.1.2
-----
* Bug: distinct cause problems with restore-points
* No scaling if no target screen dimensions supplied

0.1.1
-----
* Extracted turtle functionality out of https://github.com/rm-hull/lindenmayer-systems
* Added operations :origin, :pen up/down
* Bug: Initial orientation should be due north
* Implemented color handling on canvas renderer
* Performance improvements
* Bug: matrix calculation and turning malfunction

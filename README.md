Turtle
======

A lightweight turtle graphics library for Clojure &amp; ClojureScript. 
Includes renderer for PNG images for Clojure, and a HTML5 canvas renderer
for ClojureScript.

Examples
--------

### Clojure

```clojure
(ns example
  (:use [turtle.core :only [draw!]]
        [turtle.renderer.png :only [->img]]))

(def triangle (take 12 (cycle [:fwd 20, :right 120]))) 

(draw! ->img [800 600] triangle)
```

Would return an AWT BufferedImage of size 800x600, with the triangle scaled 
to the full extent:

     #<BufferedImage BufferedImage@5d6b3f00: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 
     IntegerInterleavedRaster: width = 800 height = 600 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0>

This can then be rendered with javax.imageio.ImageIO into whatever graphics format.

Pre-requisites
--------------
You will need [Leiningen][1] 2.0.0 or above installed.


Building
--------
To build and install the library locally, run:

     lein install

Including in your project
-------------------------
There is a version hosted at [Clojars][2]. For leiningen include a dependency:

```clojure
[rm-hull/turtle "0.1.0-SNAPSHOT"]
```
    
For maven-based projects, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>rm-hull</groupId>
  <artifactId>turtle</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```
    
TODO
----

* Documentation

* Examples

* Tidy up renderers
    - Colors don't render properly on a single stroke [Canvas renderer]
    - Implement :move handler [PNG renderer]
    - Use no affine transform, if no bounding-box provided 

* Fix inefficient partitioning - causes double states

* Rename png renderer - it isn't really that at all...

* Implement commands: 
    - :width _n_ - set the stroke width

[1]: https://github.com/technomancy/leiningen
[2]: https://clojars.org/rm-hull/turtle

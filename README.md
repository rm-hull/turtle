Turtle
======

A lightweight turtle graphics library for Clojure &amp; ClojureScript. 
Includes renderers for SVG markup and bitmap images for Clojure, and a 
HTML5 canvas renderer for ClojureScript.

Examples
--------

### Clojure

```clojure
(ns example1
  (:use [turtle.core :only [draw!]]
        [turtle.renderer.bitmap :only [->img]]))

(def triangle (take 12 (cycle [:fwd 20, :right 120]))) 

(draw! ->img triangle [800 600])
```

Would return an AWT BufferedImage of size 800x600, with the triangle scaled 
to the full extent:

     #<BufferedImage BufferedImage@5d6b3f00: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0 
     IntegerInterleavedRaster: width = 800 height = 600 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0>

This can then be rendered with javax.imageio.ImageIO into whatever graphics format.

The same triange rendered with the SVG renderer:

```clojure
(ns example2
  (:use [turtle.core :only [draw!]]
        [turtle.renderer.vector :only [->svg]]))

(def triangle (take 12 (cycle [:fwd 20, :right 120]))) 

(draw! ->svg triangle [800 600])
```

yields:

```xml
<svg height="600" overflow="visible" preserveAspectRatio="xMidYMid meet" version="1.0" width="800" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg" zoomAndPan="magnify">
  <g transform="translate(100.00000000000003,499.99999999999983) scale(19.999999999999993,-19.999999999999993)">
    <path d="M0.0,0.0L1.2246467991473533E-15,20.0L1.2246467991473533E-15,20.0L17.320508075688767,9.999999999999991L17.320508075688767,9.999999999999991L-3.552713678800501E-15,-1.0658141036401503E-14L-3.552713678800501E-15,-1.0658141036401503E-14" style="fill:none;stroke-width:3;stroke:red;" />
  </g>
</svg>    
```

Pre-requisites
--------------
You will need [Leiningen][1] 2.1.1 or above installed.

Building
--------
To build and install the library locally, run:

     lein install

Including in your project
-------------------------
There is a version hosted at [Clojars][2]. For leiningen include a dependency:

```clojure
[rm-hull/turtle "0.1.4"]
```
    
For maven-based projects, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>rm-hull</groupId>
  <artifactId>turtle</artifactId>
  <version>0.1.4</version>
</dependency>
```
    
TODO
----

* Documentation

* Examples

* Investigate poor rendering quality on PNG renderer

* Implement commands: 
    - :width _n_ - set the stroke width

[1]: https://github.com/technomancy/leiningen
[2]: https://clojars.org/rm-hull/turtle

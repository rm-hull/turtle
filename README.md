# Turtle  [![Build Status](https://secure.travis-ci.org/rm-hull/turtle.svg)](http://travis-ci.org/rm-hull/turtle) [![Coverage Status](https://coveralls.io/repos/rm-hull/turtle/badge.svg?branch=master)](https://coveralls.io/r/rm-hull/turtle?branch=master) [![Dependencies Status](https://jarkeeper.com/rm-hull/turtle/status.svg)](https://jarkeeper.com/rm-hull/turtle) [![Downloads](https://jarkeeper.com/rm-hull/turtle/downloads.svg)](https://jarkeeper.com/rm-hull/turtle) [![Clojars Project](https://img.shields.io/clojars/v/rm-hull/turtle.svg)](https://clojars.org/rm-hull/turtle)

A lightweight turtle graphics library for Clojure &amp; ClojureScript.
Includes renderers for SVG markup and bitmap images for Clojure, and a
HTML5 canvas renderer for ClojureScript.

## Examples

### Clojure

```clojure
(ns example1
  (:require
    [turtle.core :refer [draw!]]
    [turtle.renderer.bitmap :refer [->img]]))

(def triangle
  (take 12
    (cycle
      [:fwd 20, :right 120])))

(draw! ->img triangle [800 600])
```

Would return an AWT `BufferedImage` of size 800x600, with the triangle scaled
to the full extent:

     #<BufferedImage BufferedImage@5d6b3f00: type = 1 DirectColorModel: rmask=ff0000 gmask=ff00 bmask=ff amask=0
     IntegerInterleavedRaster: width = 800 height = 600 #Bands = 3 xOff = 0 yOff = 0 dataOffset[0] 0>

This can then be rendered with `javax.imageio.ImageIO` into whatever graphics format.

The same triange rendered with the SVG renderer:

```clojure
(ns example2
  (:require
    [turtle.core :refer [draw!]]
    [turtle.renderer.vector :refer [->svg]]))

(def triangle
  (take 12
    (cycle
      [:fwd 20, :right 120])))

(draw! ->svg triangle [800 600])
```

yields:

```xml
<svg height="600" overflow="visible" preserveAspectRatio="xMidYMid meet" version="1.0" width="800" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg" zoomAndPan="magnify">
  <g transform="translate(100.0,500.0) scale(20.0,-20.0)">
    <path d="M0.0,0.0 L0.0,20.0 L17.32051,10.0 L0.0,0.0 " style="fill:none;stroke-width:3;stroke:red;"></path>
  </g>
</svg>
```

## Pre-requisites

You will need [Leiningen][1] 2.6.1 or above installed.

## Building

To build and install the library locally, run:

     lein cljsbuild once
     lein install

## Including in your project

There is a version hosted at [Clojars][2]. For leiningen include a dependency:

```clojure
[rm-hull/turtle "0.1.9"]
```

For maven-based projects, add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>rm-hull</groupId>
  <artifactId>turtle</artifactId>
  <version>0.1.9</version>
</dependency>
```


## TODO

* Documentation
* Examples
* Add tests & improve code coverage
* Investigate poor rendering quality on PNG renderer
* Implement commands:
    - :width _n_ - set the stroke width
    - :fill - close the current path and fill with the selected color
* Perform rounding to 'n' decimal places

[1]: https://github.com/technomancy/leiningen
[2]: https://clojars.org/rm-hull/turtle

## License

### The MIT License (MIT)

Copyright (c) 2016 Richard Hull

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


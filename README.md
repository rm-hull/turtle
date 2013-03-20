Turtle
======

A lightweight turtle graphics library for Clojure &amp; ClojureScript. 
Includes renderer for PNG images for Clojure, and a HTML5 canvas renderer
for ClojureScript.

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

    [rm-hull/turtle "0.1.0-SNAPSHOT"]

For maven-based projects, add the following to your `pom.xml`:

    <dependency>
      <groupId>rm-hull</groupId>
      <artifactId>turtle</artifactId>
      <version>0.1.0-SNAPSHOT</version>
    </dependency>

TODO
----
* Implement commands: 
    - :origin - return to (0,0)
    - :pen :up/:down - move to vs. line to processing
    - :width _n_ - set the stroke width

* Documentation

* Examples

[1]: https://github.com/technomancy/leiningen
[2]: https://clojars.org/rm-hull/turtle

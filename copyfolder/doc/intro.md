# Introduction to copyfolder

TODO: write [great documentation](http://jacobian.org/writing/great-documentation/what-to-write/)
## create
lein new app copyfolder

add :main copyfolder.core to project.clj defproject

(ns copyfolder.core
  (:use [clojure.java.io])
  (:import java.io.File java.io.InputStream java.io.OutputStream)
  (:gen-class))

lein uberjar


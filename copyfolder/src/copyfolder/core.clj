(ns copyfolder.core
  (:use [clojure.java.io])
  (:import java.io.File java.io.InputStream java.io.OutputStream)
  (:gen-class))

(defn copyfile
  "copy file"
  [source target]
  (println "sourcefile : " target)
  (if (.isDirectory (file source))
    (.mkdir (file target))
    (with-open [sourcereader (input-stream source)
                targetwriter (output-stream target)]
      (copy sourcereader targetwriter))))

(defn foo
  "println all the files."
  [source target]
  (let [files (file-seq (java.io.File. source))
        sourcepath (.getPath (java.io.File. source))
        targetpath (.getPath (java.io.File. target))]
    (doseq [sourcefile files]
      (println "sourcefile : " sourcefile)
      (let [targetfilepath (.getPath sourcefile)]
        (copyfile sourcefile (clojure.string/replace targetfilepath sourcepath targetpath))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (foo (first args) (second args)))
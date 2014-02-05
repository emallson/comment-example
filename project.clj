(defproject comment-example "DEV"
  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]
                 [om "0.3.3"]
                 [sablono "0.2.5"]]

  :profiles {:dev {:repl-options {:init-ns emallson.comment-example.core}
                   :plugins [[com.cemerick/austin "0.1.3"]
                             [lein-cljsbuild "1.0.1"]]
                   :cljsbuild {:builds [{:source-paths ["src/cljs"]
                                         :compiler {:output-to "target/classes/public/app.js"
                                                    :output-dir "target/classes/public/_out/"
                                                    :optimizations :simple
                                                    :source-map "target/classes/public/app.js.map"}}]}}})

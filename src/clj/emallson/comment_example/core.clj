(ns emallson.comment-example.core
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes)]  
            ring.adapter.jetty
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "repl.html")
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

(defroutes site
  (resources "/") 
  (GET "/*" req (page)))

(defn make-server
  []
  (defonce ^:private server
    (ring.adapter.jetty/run-jetty #'site {:port 8080 :join? false}))
  server)

(defn make-repl
  []
  (def repl-env (reset! cemerick.austin.repls/browser-repl-env
                        (cemerick.austin/repl-env)))
  (cemerick.austin.repls/cljs-repl repl-env))

(defn run
  []
  (make-server)
  (make-repl))


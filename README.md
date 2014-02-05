Comment Example
===============

This is a simple comment system written in ClojureScript with [Om](https://github.com/swannodette/om) and [sablono](https://github.com/r0man/sablono).

This was written to help prepare for a presentation.

Running the Example
-------------------

To build the code, you need [leiningen](http://leiningen.org/). Get it before continuing.

Clone the repository and run `lein cljsbuild once`. Then, open **index.html** in your browser.

Running the REPL
----------------

The in-browser repl can be connected as follows:

Using leiningen:

1. Run `lein repl`
1. Enter the command `(run)` into the REPL
1. Open [http://localhost:8080/](http://localhost:8080/) in your browser
1. Code executed in the REPL should now execute in the browser!


In Emacs using Cider:

1. open the `src/cljs/comment_example.cljs` file.
1. Start `clojure-mode` if it is not already started.
1. Enter `C-c M-j` or `M-x cider-jack-in` to start the server.
1. Enter the command `(run)` into the REPL
1. Open [http://localhost:8080/](http://localhost:8080/) in your browser
1. Code executed in the REPL should now execute in the browser!

A note: in Chrome cacheing can cause problems with the REPL. If the REPL isn't
interacting with the browser, try closing the tab, then re-opening it with the
JS console open.

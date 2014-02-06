Comment Example
===============

This is a simple comment system written in ClojureScript with [Om](https://github.com/swannodette/om) and [sablono](https://github.com/r0man/sablono).

This was written to help prepare for a presentation.

Running the Example
-------------------

1. `cd` into the project's root directory
1. Run `lein cljsbuild once`
1. Open `resources/index.html` in your favorite browser

Running the REPL
----------------

The REPL allows you to run mostly arbitrary ClojureScript code in the browser
without having to compile it first.

If you have not done so already, build the project as described in the previous
section.

**Starting the REPL:**

Using leiningen:

1. Run `lein repl`
1. Enter the command `(run)` into the REPL


In Emacs using Cider:

1. open the `src/cljs/comment_example.cljs` file.
1. Start `clojure-mode` if it is not already started.
1. Enter `C-c M-j` or `M-x cider-jack-in` to start the server.
1. Enter the command `(run)` into the REPL

**Using the REPL:**

1. Open [http://localhost:8080/](http://localhost:8080/) in your browser
1. Check to confirm that the REPL has connected. Enter a simple value (eg 2) and
   see if the REPL gives a response. If it does not, see the note below.
1. Run `(in-ns 'emallson.comment-example.core)` to enter the project's namespace.
1. Hack away!

A note: cacheing can cause problems with the REPL. If the REPL isn't interacting
with the browser, try opening the JS console, closing the tab, then re-opening
the tab and re-opening the JS console. This should force the browser to begin
interacting with the REPL again.

(ns emallson.comment-example.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as sab :refer [html] :include-macros true]
            [clojure.browser.repl]))

(enable-console-print!)

(def app-state
  (atom {:comments [{:name "ClojureScript" :content "ClojureScript gets translated into JavaScript!"}
                    {:name "Om and Sablono" :content "Om is a wrapper over Facebook's React.js. Sablono gives a nice HTML generation macro."}]}))

(defn comment-view [comment owner]
  "Renders a single comment view based on the input `comment`"
  (om/component
   (html [:div 
          [:h3 {:class "comment-title"} (:name comment)]
          [:div {:class "comment-content"} (:content comment)]])))

(defn comment-list-view [comments]
  "Constructs a list containing all of the comments"
  (om/component
   (html [:div {:class "comment-list"}
          (om/build-all comment-view comments {:key :name})])))

(defn update-state! [event owner key]
  "Updates state (:key owner) based on the value pointed to by the event."
  (om/set-state! owner key (.. event -target -value)))

(defn blank-comment-form! [owner]
  "Blanks out the comment form. Used after adding a comment."
  (om/set-state! owner :name "")
  (om/set-state! owner :content ""))

(defn add-comment! [app owner]
  "Adds a comment to the list."
  (let [name (om/get-state owner :name)
        content (om/get-state owner :content)]
    (when (not (and (empty? name) (empty? content)))
      ;; transact! modifies the given state's value at the given path by calling
      ;; the given function with the given arguments
      ;; eg (conj (:comments app) {....})
      (om/transact! app :comments conj {:name name, :content content})
      (blank-comment-form! owner))))

(defn add-comment-view [app owner]
  "Renders a view for comment entry."
  (reify
    om/IInitState
    (init-state [_]
      {:name ""
       :content ""})
    om/IRenderState
    (render-state [this state]
      (html [:div {:class "add-comment"}
             [:input {:type "text"
                      :placeholder "Title"
                      :value (:name state)
                      :on-change #(update-state! % owner :name)}]
             [:textarea {:value (:content state)
                         :on-change #(update-state! % owner :content)}]
             [:button {:on-click #(add-comment! app owner) } "Add"]]))))

(defn comments-view [app owner]
  "Renders the entire comments view"
  (om/component
   (html [:div
          (om/build comment-list-view (:comments app))
          (om/build add-comment-view app)])))

;;; root sets the root node
(om/root
 app-state
 comments-view
 (. js/document (getElementById "app")))

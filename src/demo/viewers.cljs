(ns demo.viewers
  (:require [demo.repro]
            [sci.core :as sci]))

(def new-ns
  (sci/copy-ns demo.repro (sci/create-ns 'demo.repro)))

(ns repro.sci
  (:require [repro.bonus]
            [sci.core :as sci]))

(def new-ns
  (sci/copy-ns repro.bonus (sci/create-ns 'repro.bonus)))

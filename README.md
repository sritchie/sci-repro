# SCI Repro

To run the benchmarks:

```
shadow-cljs node-repl repro
```

Then:

```clj
(require '[repro.sci :as r])

(let [n 100000]
  (r/sci-benchmark n)
  (r/cljs-benchmark n))
```

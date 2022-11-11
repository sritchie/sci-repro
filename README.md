# SCI Repro

Trigger:

```
rm -rf .shadow-cljs && npm ci && npm run watch
```

Output:

```
shadow-cljs - config: /Users/sritchie/code/clj/repro/shadow-cljs.edn
shadow-cljs - starting via "clojure"
shadow-cljs - server version: 2.17.4 running at http://localhost:9630
shadow-cljs - nREPL server started on port 55406
shadow-cljs - watching build :repro
[:repro] Configuring build.
[:repro] Compiling ...
[:repro] Build failure:
------ ERROR -------------------------------------------------------------------
 File: jar:file:/Users/sritchie/.m2/repository/org/babashka/sci/0.4.33/sci-0.4.33.jar!/sci/impl/namespaces.cljc:1477:20
--------------------------------------------------------------------------------
1474 |    'unchecked-subtract (copy-core-var unchecked-subtract)
1475 |    'unchecked-negate-int (copy-core-var unchecked-negate-int)
1476 |    'unchecked-inc (copy-core-var unchecked-inc)
1477 |    'unchecked-char (copy-core-var unchecked-char)
--------------------------^-----------------------------------------------------
Encountered error when macroexpanding sci.impl.namespaces/copy-var.
NullPointerException: Cannot invoke "clojure.lang.IFn.invoke(Object, Object)" because the return value of "clojure.lang.Var.getRawRoot()" is null
	sci.impl.namespaces/copy-var (namespaces.cljc:91)
	sci.impl.namespaces/copy-var (namespaces.cljc:73)
	clojure.core/apply (core.clj:671)
	clojure.core/apply (core.clj:662)
	cljs.analyzer/macroexpand-1*/fn--2736 (analyzer.cljc:3928)
	cljs.analyzer/macroexpand-1* (analyzer.cljc:3926)
	cljs.analyzer/macroexpand-1* (analyzer.cljc:3913)
	cljs.analyzer/macroexpand-1 (analyzer.cljc:3977)
	cljs.analyzer/macroexpand-1 (analyzer.cljc:3973)
	cljs.analyzer/analyze-seq (analyzer.cljc:4010)
	cljs.analyzer/analyze-seq (analyzer.cljc:3990)
	cljs.analyzer/analyze-form (analyzer.cljc:4199)
	cljs.analyzer/analyze-form (analyzer.cljc:4196)
	cljs.analyzer/analyze* (analyzer.cljc:4252)
	cljs.analyzer/analyze* (analyzer.cljc:4244)
	cljs.analyzer/analyze (analyzer.cljc:4272)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/analyze-seq (analyzer.cljc:4013)
	cljs.analyzer/analyze-seq (analyzer.cljc:3990)
	cljs.analyzer/analyze-form (analyzer.cljc:4199)
	cljs.analyzer/analyze-form (analyzer.cljc:4196)
	cljs.analyzer/analyze* (analyzer.cljc:4252)
	cljs.analyzer/analyze* (analyzer.cljc:4244)
	cljs.analyzer/analyze (analyzer.cljc:4272)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/analyze (analyzer.cljc:4265)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/analyze (analyzer.cljc:4263)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/analyze-map/fn--2750/fn--2751 (analyzer.cljc:4019)
	clojure.core/mapv/fn--8468 (core.clj:6914)
	clojure.core.protocols/iter-reduce (protocols.clj:49)
	clojure.core.protocols/fn--8170 (protocols.clj:75)
	clojure.core.protocols/fn--8170 (protocols.clj:75)
	clojure.core.protocols/fn--8110/G--8105--8123 (protocols.clj:13)
	clojure.core/reduce (core.clj:6830)
	clojure.core/mapv (core.clj:6905)
	clojure.core/mapv (core.clj:6905)
	cljs.analyzer/analyze-map/fn--2750 (analyzer.cljc:4019)
	cljs.analyzer/analyze-map (analyzer.cljc:4019)
	cljs.analyzer/analyze-map (analyzer.cljc:4015)
	cljs.analyzer/analyze-form (analyzer.cljc:4201)
	cljs.analyzer/analyze-form (analyzer.cljc:4196)
	cljs.analyzer/analyze* (analyzer.cljc:4252)
	cljs.analyzer/analyze* (analyzer.cljc:4244)
	cljs.analyzer/analyze (analyzer.cljc:4272)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/analyze (analyzer.cljc:4265)
	cljs.analyzer/analyze (analyzer.cljc:4255)
	cljs.analyzer/fn--2041/fn--2044 (analyzer.cljc:1933)
	cljs.analyzer/fn--2041 (analyzer.cljc:1931)
	cljs.analyzer/fn--2041 (analyzer.cljc:1854)
	clojure.lang.MultiFn.invoke (MultiFn.java:252)
	cljs.analyzer/analyze-seq* (analyzer.cljc:3983)
	cljs.analyzer/analyze-seq* (analyzer.cljc:3981)
	cljs.analyzer/analyze-seq*-wrap (analyzer.cljc:3988)
	cljs.analyzer/analyze-seq*-wrap (analyzer.cljc:3986)
	cljs.analyzer/analyze-seq (analyzer.cljc:4012)
	cljs.analyzer/analyze-seq (analyzer.cljc:3990)
	cljs.analyzer/analyze-form (analyzer.cljc:4199)
	cljs.analyzer/analyze-form (analyzer.cljc:4196)
	cljs.analyzer/analyze* (analyzer.cljc:4252)
	cljs.analyzer/analyze* (analyzer.cljc:4244)
	shadow.build.compiler/analyze/fn--40219 (compiler.clj:264)
	shadow.build.compiler/analyze (compiler.clj:252)
	shadow.build.compiler/analyze (compiler.clj:211)
	shadow.build.compiler/analyze (compiler.clj:213)
	shadow.build.compiler/analyze (compiler.clj:211)
	shadow.build.compiler/default-analyze-cljs (compiler.clj:408)
	shadow.build.compiler/default-analyze-cljs (compiler.clj:397)
	clojure.core/partial/fn--5857 (core.clj:2629)
	shadow.build.compiler/do-analyze-cljs-string (compiler.clj:318)
	shadow.build.compiler/do-analyze-cljs-string (compiler.clj:278)
	shadow.build.compiler/analyze-cljs-string/fn--40313 (compiler.clj:511)
	shadow.build.compiler/analyze-cljs-string (compiler.clj:510)
	shadow.build.compiler/analyze-cljs-string (compiler.clj:508)
	shadow.build.compiler/do-compile-cljs-resource/fn--40341 (compiler.clj:626)
	shadow.build.compiler/do-compile-cljs-resource (compiler.clj:607)
	shadow.build.compiler/do-compile-cljs-resource (compiler.clj:565)
	shadow.build.compiler/maybe-compile-cljs/fn--40444 (compiler.clj:958)

--------------------------------------------------------------------------------
1478 |    'unchecked-byte (copy-core-var unchecked-byte)
1479 |    'unchecked-short (copy-core-var unchecked-short)
1480 |    #?@(:cljs ['undefined? (copy-core-var undefined?)])
1481 |    'underive (core-var 'underive hierarchies/underive* true)
--------------------------------------------------------------------------------
```

Now in `src/user.clj`, if you comment out the `:require` form and don't pull in
`sci.core`, the build completes just fine.

(ns repro.sci
  (:require ["three" :as THREE]
            [sci.ctx-store]
            [sci.core :as sci]))

(defn Vector3 [] (THREE/Vector3.))
(defn Matrix4 [] (THREE/Matrix4.))

(def vs (THREE/Vector3.))

(defn spine [theta {:keys [n r1 r2 r3]}]
  (let [a (* theta n)
        b theta
        s (Math/sin a)
        c (Math/cos a)
        r (+ r2 r3)
        x (+ 1 (* c r))
        z (* s r)

        s (Math/sin b)
        c (Math/cos b)
        r r1
        x2 (* x c r)
        y2 (* x s r)
        z2 (* z r)]
    (.set vs x2 y2 z2)))

(defn circle [r1 theta]
  (doto vs
    (.set (* r1 (Math/cos theta))
          (* r1 (Math/sin theta))
          0)))

(let [vo   (THREE/Vector3.)
      vt   (THREE/Vector3.)
      vb   (THREE/Vector3.)
      vn   (THREE/Vector3.)
      mtbn (THREE/Matrix4.)
      e 0.001]
  (defn tbn [theta {:keys [n r1] :as state}]
    (doto vt
      (.copy (.copy vo (spine theta state)))
      (.sub (spine (+ theta e) state))
      (.multiplyScalar (/ 1.0 e))
      (.normalize))
    (if n
      (doto vb
        (.copy (circle r1 theta))
        (.sub (circle r1 (+ theta e)))
        (.multiplyScalar (/ 1 e)))
      (.copy vb vo))
    (.normalize vb)

    (.crossVectors vn vt vb)
    (.normalize vn)

    (.crossVectors vb vt vn)
    (.normalize vb)

    (doto mtbn
      (.set
       (.-x vt) (.-x vb) (.-x vn) (.-x vo)
       (.-y vt) (.-y vb) (.-y vn) (.-y vo)
       (.-z vt) (.-z vb) (.-z vn) (.-z vo)
       0        0        0        1))))


(defn area-expr [emit theta phi !state]
  (let [{:keys [r3] :as state} (.-state !state)
        m (tbn theta state)]
    (doto vs
      (.set 0
            (* r3 (Math/cos phi))
            (* r3 (Math/sin phi)))
      (.applyMatrix4 m))
    (emit (.-x vs)
          (.-y vs)
          (.-z vs))))

(def !state
  {:n 16
   :r1 1
   :r2 0.3
   :r3 0.1})

;; "Elapsed time: 1860.288374 msecs"

(def ctx
  (sci/init
   {:classes {'Math js/Math
              :allow :all}
    :namespaces
    {"three" {'Vector3 Vector3
              'Matrix4 Matrix4}}}))

(sci/eval-form
 ctx
 '(do (require '["three" :as THREE])

      (def vs (THREE/Vector3))

      (defn spine [theta {:keys [n r1 r2 r3]}]
        (let [a (* theta n)
              b theta
              s (Math/sin a)
              c (Math/cos a)
              r (+ r2 r3)
              x (+ 1 (* c r))
              z (* s r)

              s (Math/sin b)
              c (Math/cos b)
              r r1
              x2 (* x c r)
              y2 (* x s r)
              z2 (* z r)]
          (.set vs x2 y2 z2)))

      (defn circle [r1 theta]
        (doto vs
          (.set (* r1 (Math/cos theta))
                (* r1 (Math/sin theta))
                0)))

      (let [vo   (THREE/Vector3)
            vt   (THREE/Vector3)
            vb   (THREE/Vector3)
            vn   (THREE/Vector3)
            mtbn (THREE/Matrix4)
            e 0.001]
        (defn tbn [theta {:keys [n r1] :as state}]
          (doto vt
            (.copy (.copy vo (spine theta state)))
            (.sub (spine (+ theta e) state))
            (.multiplyScalar (/ 1.0 e))
            (.normalize))
          (if n
            (doto vb
              (.copy (circle r1 theta))
              (.sub (circle r1 (+ theta e)))
              (.multiplyScalar (/ 1 e)))
            (.copy vb vo))
          (.normalize vb)

          (.crossVectors vn vt vb)
          (.normalize vn)

          (.crossVectors vb vt vn)
          (.normalize vb)

          (doto mtbn
            (.set
             (.-x vt) (.-x vb) (.-x vn) (.-x vo)
             (.-y vt) (.-y vb) (.-y vn) (.-y vo)
             (.-z vt) (.-z vb) (.-z vn) (.-z vo)
             0        0        0        1))))

      (defn area-expr [emit theta phi !state]
        (let [{:keys [r3] :as state} (.-state !state)
              m (tbn theta state)]
          (doto vs
            (.set 0
                  (* r3 (Math/cos phi))
                  (* r3 (Math/sin phi)))
            (.applyMatrix4 m))
          (emit (.-x vs)
                (.-y vs)
                (.-z vs))))

      (def !state
        {:n 16
         :r1 1
         :r2 0.3
         :r3 0.1})))


(defn cljs-benchmark [n]
  (time
   (dotimes [_ n]
     (area-expr (fn [_ _ _]) 1 1 !state))))

(defn sci-benchmark [n]
  (time
   (sci/eval-form
    ctx
    (list 'dotimes ['_ n]
          (list 'area-expr '(fn [_ _ _]) 1 1 '!state)))))

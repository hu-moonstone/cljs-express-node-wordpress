(ns hello.core
  (:require ["express"]))

(enable-console-print!)

(set! *warn-on-infer* false)

(defonce server (atom nil))

(defn start-server []
  (println "Start server")
  (let [app (express)]
    (.get app "/" (fn [req res] (.send res "Hello, World!!")))
    (.listen app 3000 (fn [] (println "Listen port: 3000")))))

(defn start! []
  (reset! server (start-server)))

(defn restart! []
  (.close @server start!))

(set! *main-cli-fn* start!)

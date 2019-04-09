(def shared-compiler-settings '{:main hello.core
                                :npm-deps {:express "4.16.2"
                                           :ws "3.2.0"}
                                :install-deps true
                                :infer-externs true
                                :target :nodejs})

(defproject hello "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :license {:name "Mozilla Public License 2.0"
            :url "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.520" :scope "provided"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :min-lein-version "2.6.1"
  :clean-targets ^{:protect false} [:target-path :compile-path "app-dev.js" "app.js" "develop" "release"]
  :cljsbuild {:builds
              [{:id "develop"
                :source-paths ["src"]
                :figwheel {:on-jsload "hello.core/restart!"}
                :compiler ~(merge
                            {:output-to "app-dev.js"
                             :output-dir "develop"}
                            shared-compiler-settings)}
               {:id "release"
                :source-paths ["src"]
                :compiler ~(merge
                            {:output-to "app.js"
                             :output-dir "release"
                             :optimizations :simple
                             :closure-defines '{goog.DEBUG false}
                             :pretty-print false}
                            shared-compiler-settings)}]}
  :figwheel {:server-logfile "log/figwheel.log"
             :server-port 3450}
  :profiles {:dev
             {:dependencies [[figwheel "0.5.18"]
                             [figwheel-sidecar "0.5.18"]
                             [com.cemerick/piggieback "0.2.2"]]
              :source-paths ["src"]
              :plugins [[lein-figwheel "0.5.18"]]
:repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}})

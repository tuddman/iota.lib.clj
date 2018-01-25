# clota: aka iota.lib.clj

An [IOTA](https://iota.org) Client Library Implemented in Clojure

This library aims to be an idiomatic, feature-complete, client implementation of the full IOTA API Command Set.

Show your support for this library and this emerging protocol by giving this repo a **star**

## Getting Started

Get Clota from clojars:

[![Clojars Project](https://img.shields.io/clojars/v/clota.svg)](https://clojars.org/clota)

or download and install directly:

```bash
git clone https://github.com/tuddman/iota.lib.clj
cd iota.lib.clj
lein clean && lein install
```

## Usage

```clojure
;; Include Clota Library in your project

> (require '[clota.client :as iota])

;; Commands - from a REPL

> (def node-uri "http://0.0.0.0:14625")

;; OPTIONAL - if you have REMOTE_AUTH set for the node. If so, you will need to send the token along with every command.

> (def token (iota/->base64 "user:password")

> (iota/get-node-info node-uri token)

> (iota/get-neighbors node-uri token)

> (iota/add-neighbors node-uri ["udp://good.neighbor:14265" ...] token)

> (iota/remove-neighbors node-uri ["udp://bad.neighbor:14265" ...] token)

> (iota/get-tips node-uri token)

> (iota/find-transactions node-uri {:addresses ["SOMEIOTAHASHADDRESS..." ...]} token)

> (iota/get-trytes node-uri ["SOMEIOTATRYTES...999"] token)

> (iota/get-inclusion-states node-uri {:transactions ["..." ...] :tips ["..." ...]} token)

> (iota/get-balances node-uri {:addresses ["..." ...] :threshold 100} token)

> (iota/get-transactions-to-approve node-uri {:depth 27} token)

> (iota/attach-to-tangle node-uri {:trunkTransaction "..." :branchTransaction "..." :min-weight-magnitude 18 :trytes ["..." ...]} token)

> (iota/interrupt-attaching-to-tangle node-uri token)

> (iota/broadcast-transactions node-uri ["SOMETXHASH..." ...] token)

> (iota/store-transactions node-uri ["SOMETXHASH..." ...] token)

```

[read the API Docs](https://iota.readme.io)

API Command | Clota Function | Status | Test Coverage
--- | --- | --- | ---
[getNodeInfo](https://iota.readme.io/docs/getnodeinfo) | `(get-node-info ...)` | Implemented | Complete
[getNeighbors](https://iota.readme.io/docs/getneighborsactivity) | `(get-neighbors ...)` | Implemented | Complete
[removeNeighbors](https://iota.readme.io/docs/getnodeinfo) | `(remove-neighbors ...)` | Implemented | Complete
[getTips](https://iota.readme.io/docs/gettips) | `(get-tips ...)` | Implemented | Complete
[findTransactions](https://iota.readme.io/docs/findtransactions) | `(find-transactions ...)` | Implemented | None
[getTrytes](https://iota.readme.io/docs/gettrytes) | `(get-trytes ...)` | Implemented | None
[getInclusionStates](https://iota.readme.io/docs/getinclusionstates) | `(get-inclusion-states ...)` | Implemented | None
[getBalances](https://iota.readme.io/docs/getbalances) | `(get-balances ...)` | Implemented | None
[getTransactionsToApprove](https://iota.readme.io/docs/gettransactionstoapprove) | `(get-transactions-to-approve ...)` | Implemented | None
[attachToTangle](https://iota.readme.io/docs/attachtotangle) | `(attach-to-tangle ...)` | Implemented | None
[interruptAttachingToTangle](https://iota.readme.io/docs/interruptattachingtotangle) | `(interrupt-attaching-to-tangle ...)` | Implemented | None
[broadcastTransactions](https://iota.readme.io/docs/broadcasttransactions) | `(broadcast-transactions ...)` | Implemented | None
[storeTransactions](https://iota.readme.io/docs/storetransactions) | `(store-transactions ...)` | Implemented | None

for more, look in `src/clota/client.clj`

### Generate a Secure Random Seed 

```clojure
;; PLEASE BE ADVISED : DO NOT SHARE YOUR PRIVATE SEED WITH ANYONE. EVER!
;; To Generate a Secure Random Seed:

> (clota.crypto/generate-seed)

 =>  "9KHKESVOHBOMHCL9ADINALYVHSBKRHITKMOJJJHFKOHWBZDFQDVLKQMTVZTUTWHIWXISBRIFXPZEEZTUU" 

;; Or, if that's not good enough for 'ya, 
;; and you want to do some more randomized matrix math to generate your seed:

> (clota.crypto/generate-paranoid-seed)

 =>  "IKAGOIVHXAR9XRJMC9LIXHMFAXYAAXKSAXJE99ODVRMISXWNJIIGGVCQIKLVHMRQRQKESJDESRSQOUZTA"
```

## Testing

Continuous Integration Tests are provided by [Travis CI.](https://travis-ci.com/)

[![Build Status](https://travis-ci.org/tuddman/iota.lib.clj.svg?branch=master)](https://travis-ci.org/tuddman/iota.lib.clj)


To run the tests yourself:

```bash
$ lein test
```


Pull Requests Welcome.


---

Copyright © 2017 - now tuddman

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

# clota: aka iota.lib.clj

An [IOTA](https://iota.org) Client Library Implemented in Clojure

This library aims to be an idiomatic, feature-complete, client implementation of the full IOTA API Command Set.

<br>
Show your support for this library and this emerging protocol by giving this repo a **star**

[![Build Status](https://travis-ci.org/tuddman/iota.lib.clj.svg?branch=master)](https://travis-ci.org/tuddman/iota.lib.clj)


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

> (def my-node "http://0.0.0.0:14625")

> (iota/get-node-info my-node)

> (iota/get-neighbors my-node)

> (iota/add-neighbors my-node ["udp://good.neighbor:14265" ...])

> (iota/remove-neighbors my-node ["udp://bad.neighbor:14265" ...])

> (iota/get-tips my-node)

> (iota/find-transactions my-node {:addresses ["SOMEIOTAHASHADDRESS..." ...]})

> (iota/get-trytes my-node ["SOMEIOTATRYTES...999"])

> (iota/get-inclusion-states my-node {:transactions ["..." ...] :tips ["..." ...]}

> (iota/get-balances my-node {:addresses ["..." ...] :threshold 100})

> (iota/get-transactions-to-approve my-node {:depth 27})

> (iota/attach-to-tangle my-node {:trunkTransaction "..." :branchTransaction "..." :min-weight-magnitude 18 :trytes ["..." ...]})

> (iota/interrupt-attaching-to-tangle my-node)

> (iota/broadcast-transactions my-node ["SOMETXHASH..." ...])

> (iota/store-transactions my-node ["SOMETXHASH..." ...])

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
```

## Testing

Continuous Integration Tests are provided by [Travis CI.](https://travis-ci.com/)

To run the tests yourself:

```bash
$ lein test
```
<br>


Pull Requests Welcome.
<br>

---

Copyright © 2017 tuddman

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

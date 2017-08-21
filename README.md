# clota: aka iota.lib.clj

An [IOTA](https://iota.org) Client Library Implemented in Clojure

This library aims to be an idiomatic, feature-complete, client implementation of the full IOTA API Command Set.

<br>
Show your support for this library and this emerging protocol by giving this repo a **star**

[![Build Status](https://travis-ci.org/tuddman/iota.lib.clj.svg?branch=master)](https://travis-ci.org/tuddman/iota.lib.clj)


## Getting Started

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
> (iota/add-neighbors my-node {:addresses ["udp://good.neighbor:14265" ...] })
> (iota/remove-neighbors my-node {:addresses ["udp://bad.neighbor:14265" ...] })
> (iota/get-tips my-node)
> (iota/find-transactions my-node {:addresses ["RVORZ9SIIP9RCYMREUIXXVPQIPHVCNPQ9HZWYKFWYWZRE9JQKG9REPKIASHUUECPSQO9JT9XNMVKWYGVAZETAIRPTM"]})
> (iota/get-trytes my-node {:trytes ["OAATQS9VQLSXCLDJVJJVYUGONXAXOFMJOZNSYWRZSWECMXAQQURHQBJNLD9IOFEPGZEPEMPXCIVRX9999"]})
> (iota/get-inclusion-states my-node {:transactions ["..." ...] :tips ["..." ...]}
> (iota/get-balances my-node {:addresses ["..." ...] :threshold 100})
> (iota/get-transactions-to-approve my-node {:depth 27})
> (iota/attach-to-tangle my-node {:trunkTransaction "..." :branchTransaction "..." :min-weight-magnitude 18 :trytes ["..." ...]})
> (iota/interrupt-attaching-to-tangle my-node)
> (iota/broadcast-transactions my-node {:transactions ["..." ...]})
> (iota/store-transactions my-node {:transactions ["..." ...]})
```

API Command | Clota Function | Status | Test Coverage
--- | --- | --- | ---
`getNodeInfo` | `(get-node-info ...)` | Implemented | Complete
`getNeighbors` | `(get-neighbors ...)` | Implemented | Complete
`addNeighbors` | `(add-neighbors ...)` | Implemented | None
`removeNeighbors` | `(remove-neighbors ...)` | Implemented | None
`getTips` | `(get-tips ...)` | Implemented | None
`findTransactions` | `(find-transactions ...)` | Implemented | None
`getTrytes` | `(get-trytes ...)` | Implemented | None
`getInclusionStates` | `(get-inclusion-states ...)` | Implemented | None
`getBalances` | `(get-balances ...)` | Implemented | None
`getTransactionsToApprove` | `(get-transactions-to-approve ...)` | Implemented | None
`attachToTangle` | `(attach-to-tangle ...)` | Implemented | None
`interruptAttachingToTangle` | `(interrupt-attaching-to-tangle ...)` | Implemented | None
`broadcastTransactions` | `(broadcast-transactions ...)` | Implemented | None
`storeTransactions` | `(store-transactions ...)` | Implemented | None

for more, look in `src/clota/client.clj`

[read the API Docs](https://iota.readme.io)

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

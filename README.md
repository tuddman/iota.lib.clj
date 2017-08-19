# clota

An [IOTA](https://iota.org) Client Library Implemented in Clojure

[![Build Status](https://travis-ci.org/tuddman/iota.lib.clj.svg?branch=master)](https://travis-ci.org/tuddman/iota.lib.clj)

This library aims to be an idiomatic, feature-complete, FULL client implementation of the IOTA API Command Set.


## Getting Started

```bash
git clone https://github.com/tuddman/iota.lib.clj
cd iota.lib.clj
lein deps
```

## Usage

```bash
$ lein repl
> (def host "http://0.0.0.0:14625")
> (require '[clojiota.client :as iota])
> (iota/get-node-info host)
> (iota/get-neighbors host)
> (iota/get-tips host)
> ...
```

API Command | Clota Function | Status | Test Coverage
--- | --- | --- | ---
`getNodeInfo` | `(get-node-info ...)` | Implemented | Complete
`getNeighbors` | `(get-neighbors ...)` | Implemented | Complete
`addNeighbors` | `(add-neighbors ...)` | Not Yet Implemented | None
`removeNeighbors` | `(remove-neighbors ...)` | Not Yet Implemented | None
`getTips` | `(get-tips ...)` | Not Yet Implemented | None
`findTransactions` | `(find-transactions ...)` | Not Yet Implemented | None
`getTrytes` | `(get-trytes ...)` | Not Yet Implemented | None
`getInclusionStates` | `(get-inclusion-states ...)` | Not Yet Implemented | None
`getBalances` | `(get-balances ...)` | Not Yet Implemented | None
`getTransactionsToApprove` | `(get-transactions-to-approve ...)` | Not Yet Implemented | None
`attachToTangle` | `(attach-to-tangle ...)` | Not Yet Implemented | None
`interruptAttachingToTangle` | `(interrupt-attaching-to-tangle ...)` | Not Yet Implemented | None
`broadcastTransactions` | `(broadcast-transactions ...)` | Not Yet Implemented | None
`storeTransactions` | `(store-transactions ...)` | Not Yet Implemented | None

for more, look in `src/clota/client.clj`

## Testing

```bash
$ lein test
```


PRs Welcome.

License

Copyright © 2017 tuddman

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

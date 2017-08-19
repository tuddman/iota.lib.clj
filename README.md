# clota

An [IOTA](https://iota.org) Client Library Implemented in Clojure

This library aims to be an idiomatic, feature-complete, FULL client implementation of the IOTA API Command Set.



## Usage

```bash
$ lein repl
> (clojiota.client/get-node-info)
> (clojiota.client/get-neighbors-activity)
> (clojiota.client/get-tips)
> ...
```

API Command | Clota Function | Status | Test Coverage
--- | --- | ---
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

The dependencies require very specific base / GHC versions. [Info here](https://wiki.haskell.org/Base_package)
talib  requires base >=4.7 && <4.9
ib-api requires base >=4.6 && <6

I was able to install with stack with the following steps:
	- using the preferred way with stack, follow [these steps](https://gist.github.com/ipolifemo/9feff1ab53acfe4449e2e3c1e6ba6b81). I believe I changed the version from 7.10.3 to 7.10.2
	- $ stack new my-project
	- $ cd my-project
	- in stack.yaml, include 'resolver: ghc-7.10.2'
	- $ stack setup --system-ghc --resolver ghc-7.10.2
	- $ stack build
	- $ stack exec my-project-exe
	- then later I changed the stack.yaml resolver to 'resolver: lts-3.20', which I think allowed the IB.Client lib to compile





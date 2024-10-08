Nullability is inconsistent for `typeOf()` result if it is:

- Called inside inline function with reified parameter 
- which is called from another module (or from tests)
- and the result of `typeOf` is saved to a nullable field (or returned from a function returning `KType?`)

Run these tasks to test:

- `./gradlew :lib:test`
- `./gradlew :consumer:run`

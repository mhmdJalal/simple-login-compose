# simple-login-compose

## Tech stack & third party libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) + [State Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state-flow/) for asynchronous.
- [Koin](https://insert-koin.io/) as dependency injection.
- Jetpack
    - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
    - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
    - Compose: Feature that allows you to more easily write code that interacts with views.
    - Navigation Compose: Routing for single activity apps.
- Architecture
    - MVVM Architecture
    - Repository Pattern
- [Ktor](https://ktor.io/docs/): Construct the REST APIs, logging, and serialization.
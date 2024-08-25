# AndroidAppDemo


## 为什么使用 Composing builds

在 Gradle 中，构建逻辑是通过构建脚本（build script）来定义的。构建脚本是一个 Groovy 或 Kotlin 脚本，它定义了项目的构建行为。构建脚本通常包含了项目的配置、任务定义、插件应用等内容。

### buildSrc 构建方式

原理:

buildSrc 是一个 gradle 中一个可选的特殊项目文件夹, 包含 `build.gradle(.kts)` 文件和所有子项目共享的配置, 插件, 任务等代码.当运行项目构建时, Gradle 会自动检查项目根目录下是否存在 buildSrc 目录. 如果存在, Gradle 会在构建项目之前自动编译和测试 buildSrc 项目, 并将其编译后的代码和依赖项添加到构建脚本的 classpath (类路径) 中.这意味着 buildSrc 项目中的代码可以在构建脚本中直接使用, 并支持编译器的自动补全和跳转功能.

由于在 Gradle 的构建过程中, buildSrc 被看作是构建脚本的一部分. 如果 buildSrc 项目中的代码发生了变化, Gradle 会自动重新编译 buildSrc 项目, 并重新加载构建脚本, 导致整个项目重新构建.

### Composing builds 构建方式

原理:

Composing builds 通过设计一个独立的项目, 只包含完整的构建依赖, 而不是项目代码. 其基本目录结构与 buildSrc 相似, 但是需要包含一个 settings.gradle 文件, 用于指定项目的名称和根目录; 在项目根目录下包含一个 build.gradle(.kts) 文件, 用于注册配置插件; 在项目级 `settings.gradle` 文件中, 使用 includeBuild() 方法将 Composing builds 项目包含到主项目中.


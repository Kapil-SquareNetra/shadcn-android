# shadcn-android

Jetpack Compose UI components inspired by [shadcn/ui](https://ui.shadcn.com/).

## Package

Published to [GitHub Packages](https://github.com/Kapil-SquareNetra/shadcn-android/packages):

```
com.devgun.shadcn_android:shadcn-ui:0.1.0
```

### Consume from another Android project

GitHub Packages requires authentication even for public packages.

1. Create a GitHub [personal access token](https://github.com/settings/tokens) with `read:packages`.
2. In `~/.gradle/gradle.properties` (or project `gradle.properties`, not committed):

```properties
gpr.user=YOUR_GITHUB_USERNAME
gpr.key=YOUR_GITHUB_TOKEN
```

3. In the consumer `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://maven.pkg.github.com/Kapil-SquareNetra/shadcn-android")
            credentials {
                username = providers.gradleProperty("gpr.user").get()
                password = providers.gradleProperty("gpr.key").get()
            }
        }
    }
}
```

4. In the app module:

```kotlin
dependencies {
    implementation("com.devgun.shadcn_android:shadcn-ui:0.1.0")
}
```

## Publish

Publishing runs from GitHub Actions on a version tag (`v0.1.0`) or via **Actions → Publish GitHub Package → Run workflow**.

To publish locally:

```bash
export GITHUB_ACTOR=YOUR_GITHUB_USERNAME
export GITHUB_TOKEN=YOUR_GITHUB_TOKEN_WITH_WRITE_PACKAGES
./gradlew :shadcn-ui:publishReleasePublicationToGitHubPackagesRepository
```

Bump `shadcn.version` in `gradle.properties` before a new release.

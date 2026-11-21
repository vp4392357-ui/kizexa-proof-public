# android-minimal

The golden-path Kotlin Android reference project for KIZEXA Manage: one activity, no libraries, R8 on, no signing
config (the release bundle comes out unsigned and KIZEXA Manage signs it).

- Gradle 8.10.2 (committed wrapper, distribution SHA-256 pinned in `gradle/wrapper/gradle-wrapper.properties`),
  Android Gradle Plugin 8.7.3, Kotlin 2.0.21, compileSdk/targetSdk 35, minSdk 24, JDK 17.
- `applicationId` `com.kizexa.reference.minimal`. `versionCode` 1000 / `versionName` `0.0.0-source` are placeholders
  that a release must replace.
- `kizexa.yaml` is the output of `@kizexa/detect` for this folder; `apps/runner/scripts/prove-android.ts` checks that
  it still is.

Build it the way the runner does: `./gradlew --no-daemon --init-script <runner's script> -Pkizexa.versionCode=N
-Pkizexa.versionName=X :app:bundleRelease`. The end-to-end proof is described in
`docs/verification/android-build-proof.md`.

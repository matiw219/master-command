# master-command
CommandBuilder library simplifies the process of creating commands for Bukkit plugins by providing a flexible and extensible framework.

## Releases:
```groovy
repositories {
    maven {
        name "masterRepositoryReleases"
        url "https://repo.masterkaiser.me/releases"
    }
}
```

## Snapshots:
```groovy
repositories {
    maven {
        name "masterRepositorySnapshots"
        url "https://repo.masterkaiser.me/snapshots"
    }
}
```

```groovy
dependencies {
    implementation "me.masterkaiser.command:core:{version}"
    implementation "me.masterkaiser.command:bukkit:{version}"
    implementation "me.masterkaiser.command:serdes:{version}"
}
```

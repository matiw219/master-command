# master-command
CommandBuilder library simplifies the process of creating commands for Bukkit plugins by providing a flexible and extensible framework.

Specify repository type: ***releases*** or ***snapshots***.
```groovy
repositories {
    maven {
        name "masterRepositoryReleases"
        url "https://repo.masterkaiser.me/{type}"
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

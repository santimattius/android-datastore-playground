# Android Datastore Playground

Playground app using Jetpack Datastore and compose.

<p align="center">
  <img width="350" src="https://github.com/santimattius/android-datastore-playground/blob/master/capture/capture_datastore_playground.png?raw=true" alt="App Capture"/>
 </p> 
  
## DataStore Part of Android Jetpack.

Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed
objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data
asynchronously, consistently, and transactionally.

If you're currently using SharedPreferences to store data, consider migrating to DataStore instead.
Note: If you need to support large or complex datasets, partial updates, or referential integrity,
consider using Room instead of DataStore. DataStore is ideal for small, simple datasets and does not
support partial updates or referential integrity. 

### Preferences DataStore and Proto DataStore

DataStore provides two different implementations: Preferences DataStore and Proto DataStore.

- Preferences DataStore stores and accesses data using keys. This implementation does not require a predefined schema, and it does not provide type safety.
- Proto DataStore stores data as instances of a custom data type. This implementation requires you to define a schema using protocol buffers, but it provides type safety.

### Documentation

- [Android developers](https://developer.android.com/topic/libraries/architecture/datastore)
- [MAD Skill Series](https://www.youtube.com/playlist?list=PLWz5rJ2EKKc8to3Ere-ePuco69yBUmQ9C)
- You can find all posts from our Jetpack DataStore series here:
  - [Introduction to Jetpack DataStore](https://medium.com/androiddevelopers/introduction-to-jetpack-datastore-3dc8d74139e7)
  - [All about Preferences DataStore](https://medium.com/androiddevelopers/all-about-preferences-datastore-cc7995679334)
  - [All about Proto DataStore](https://medium.com/androiddevelopers/all-about-proto-datastore-1b1af6cd2879)
  - [DataStore and dependency injection](https://medium.com/androiddevelopers/datastore-and-dependency-injection-ea32b95704e3)
  - [DataStore and Kotlin serialization](https://medium.com/androiddevelopers/datastore-and-kotlin-serialization-8b25bf0be66c)
  - [DataStore and synchronous work](https://medium.com/androiddevelopers/datastore-and-synchronous-work-576f3869ec4c)
  - [DataStore and data migration](https://medium.com/androiddevelopers/datastore-and-data-migration-fdca806eb1aa)
  - [DataStore and testing](https://medium.com/androiddevelopers/datastore-and-testing-edf7ae8df3d8)

## Demo


https://user-images.githubusercontent.com/22333101/167222839-d49b0483-e7ca-4386-9bc1-003324e7d6b6.mov



## Dependencies

- [Jetpack compose]()
- [Datastore]()
- [Hilt]()



# NYTimes

## Screenshots
<table>
  <tr>
    <td align="center">Splash Screen </td>
     <td align="center">Home Screen</td>
     <td align="center">Details Screen</td>
  </tr>
  <tr>
    <td valign="top"><img src="https://github.com/ahmedmohamed299/NYTimes/blob/master/screenshots/Screenshot_2022-11-24-22-53-36-11_96d39c8b3d9890da4c462be41d85e2c7.jpg" ></td>
    <td valign="top"><img src="https://github.com/ahmedmohamed299/NYTimes/blob/master/screenshots/Screenshot_2022-11-24-22-53-59-65_96d39c8b3d9890da4c462be41d85e2c7.jpg"></td>
    <td valign="top"><img src="https://github.com/ahmedmohamed299/NYTimes/blob/master/screenshots/Screenshot_2022-11-24-22-54-12-87_96d39c8b3d9890da4c462be41d85e2c7.jpg"></td>
  </tr>
 </table>
 
 --------
## Tech Stack


-[100% Kotlin  ](https://kotlinlang.org/)
<br/>
-[clean architecture  ](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) - Modern Architecture
<br/>
-[usecase ](https://developer.android.com/reference/androidx/camera/core/UseCase)
<br/>
-[Animations ](https://developer.android.com/develop/ui/views/animations/overview)
<br/>
-[Retrofit ](https://square.github.io/retrofit/) - networking
<br/>
-[hilt ](https://dagger.dev/hilt/) - dependency injection
<br/>
-[navigation ](https://developer.android.com/guide/navigation) - in-app navigation
<br/>
-[unit test ](https://developer.android.com/training/testing/local-tests)
<br/>
-[Glide ](https://github.com/bumptech/glide)
<br/>
-[Kotlin coroutines ](https://github.com/Kotlin/kotlinx.coroutines#kotlinxcoroutines) - perform background operations
<br/>
-[Viewmodel ](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle-aware way
 
 -------
 Module Structure
 ===============
<img src="https://github.com/ahmedmohamed299/NYTimes/blob/master/screenshots/feature_structure.png">

**Data Layer**
========

Manages application data. Connect to data sources and provide data through repository to the domain layer eg. retrieve data from the internet and cache the data in disk cache (when device is offline).

Components:

Repository is exposing data to the domain layer. Depending on the application structure and quality of the external APIs repository can also merge, filter, and transform the data. These operations intend to create high-quality data source for the domain layer.
Mapper - maps data model to domain model (to keep domain layer independent from the data layer).
Data layer contains implicit layer called Data source containing all components involved with data manipulation of a given data source. Application has two data sources - Retrofit (network) and Room (local storage):
<br/>

Retrofit Service - defines a set of API endpoints
<br/>

Retrofit Response Model - definition of the network objects for given endpoint (top-level model for the data consists of ApiModels)
<br/>

Retrofit Api Data Model - defines the network objects (sub-objects of the Response Model)
<br/>
Room Database - persistence database to store app data
<br/>
Room DAO - interact with the stored data
<br/>
Room Entity - definition of the stored objects
<br/>

Both Retrofit API Data Models and Room Entities contain annotations, so given framework understands how to parse the data into objects.

**Domain Layer**
--
This is the core layer of the application. Notice that the domain layer is independent of any other layers. This allows making domain models and business logic independent from other layers. In other words, changes in other layers will not affect domain layer eg. changing the database (data layer) or screen UI (presentation layer) ideally will not result in any code change withing the domain layer.

Components:

UseCase - contains business logic
DomainModel - defines the core structure of the data that will be used within the application. This is the source of truth for application data.
Repository interface - required to keep the domain layer independent from the data layer (Dependency inversion).


**Presentation Layer**
--
This layer is closest to what the user sees on the screen.

 

--------
## Unit Testing

Unit Testing cover `News Apis` , `usecase` ,`repository` and `viewmodel`


IceCreamParlorService: Designing for Exceptions - GILA

# GILA Roles

Read more about the roles: https://w.amazon.com/bin/view/Amazon_Technical_Academy/Internal/HowTos/GILARoles

# Activity

*This activity helps you practice designing exceptions.*

Before you start, complete the form below to assign a role to each member.

If you have 3 people, combine the *Presenter* and *Reflector*.

|Team Roles    | Team Member                                                                |
|---           |---                                                                         |
|*Recorder*    |records all answers and questions, provides copies to team and facilitator. |
|*Presenter*   |talks to facilitator and other teams.                                       |
|*Manager*     |keeps track of time and makes sure everyone contributes appropriately.      |
|*Reflector*   |considers how the team could work and learn more effectively.               |

## Phase 0 - Background

|Phase 0                  |Start time:  |
|---                      |---          |
|(5 minutes) Background   |             |

Today you'll be taking a look at a preliminary design of `IceCreamParlorService`, which has an API to support vending
and managing ice cream at an ice cream parlor.

### Operations

`IceCreamParlorService` will be able to perform the following operations:

* `GetScoop`
    * Accepts name of `Flavor` of ice cream to serve
* `GetSundae`
    * Accepts `1` to `n` names of `Flavor`s of ice cream and `0` to `n` names of `Topping`s to serve
* `PrepareFlavor`
  * Makes a `Carton` of ice cream for a given `Flavor`.
* `RestockIngredient`
    * Refills stock of specified `Ingredient`
* `RestockTopping`
    * Refills stock of specified ice cream `Topping`

### Class Diagram

[Class diagram for our IceCreamParlorService](https://tiny.amazon.com/u2zdcnmh/plancorpamazplanformencohtml)

### Glossary:

* `Ingredient` -- part of a recipe to create ice cream (e.g. milk, ice, salt, cocoa, vanilla)
* `Topping` -- can be requested by a customer on a Sundae.
    Examples include: sprinkles, cookie crumbles, caramel sauce, hot fudge.

Note: All `Topping`s are distinct from `Ingredient`s. So our service can't have sprinkles *in* our ice cream.


## Phase 1: Respect what came before

|Phase 1                               |Start time:  |
|---                                   |---          |
|(10 minutes) Respect what came before |             |

In your groups, design a class hierarchy for the exceptions to be used by
`IceCreamParlorService`.

The exceptions for `IceCreamParlorService` are:

* `NoSuchFlavorException`
* `FlavorOutOfStockException`
* `NoSuchToppingException`
* `ToppingOutOfStockException`
* `InsufficientIngredientsException`
* `NoSuchIngredientException`


If "parent" exception classes occur to you that are not in this list but would
help you in developing a clear hierarchy, feel free to add them.


You can represent the hierarchy as a bulleted list, e.g.


* `ExceptionA`
    * `SubExceptionA1`
    * `SubExceptionA2`
* `ExceptionB`
    * `SubExceptionB1`
* `ExceptionC`

### Write your exception class hierarchy:



## Phase 2: Innovate (and complexify?)

|Phase 2                                 |Start time:  |
|---                                     |---          |
|(10 minutes) Innovate (and complexity?) |             |

While reviewing the design, we've realized we currently can't add new flavors! This will not do.
A new operation is called for: `AddFlavor`. This will take a `Flavor` name and list
of `Ingredient`s. It will add a list of `Ingredient`s to our `Flavor`, and add the `Flavor` to the list
of known flavors our service can prepare.


1. List any failure cases you could see `AddFlavor` encountering.
    1. 
2. Do any of these failure cases correspond to existing exceptions? If so, which ones?
    1. 
3. For any failure cases that do not have a corresponding exception, create new exceptions for them. Where do these fall in the hierarchy you designed in Phase 1?
    1. 

### Provide your updated exception class hierarchy:



## Extension 1

1. What other operations could you see `IceCreamParlorService` needing in the future?
    1. 
2. For any new operations you can think of, what would be the failure cases? Are those covered by the existing exceptions?
    1. 
3. What new exceptions might you need to add?
    1. 

### Update your exception class hierarchy:

## Phase 3: Migrate to DynamoDB

|Phase 3                             |Start time:  |
|---                                 |---          |
|(15 minutes) Migrate to DynamoDB    |             |


In the hurry to get the prototype set up, our implementation of `IceCreamParlorService` uses `S3CartonDao`
to store information about what flavors are available. This uses AWS's Simple Storage Service, S3,
one of AWS's earliest service offerings. It's a great way to store lots of data (e.g. files)
so that it's never lost, but doesn't quite offer the same structure as a database.

Going forward, we would prefer a more structured way to access this data, and so have written
`DynamoDbCartonDao` to instead retrieve this information from DynamoDB.

Your first coding task today is to migrate `IceCreamParlorService` to use `DynamoDbCartonDao`
in place of `S3CartonDao`.

1. This will require updating `IceCreamParlorService`'s member variables, constructors,
    and both `getScoop()` and `getSundae()`
2. You may also need to update part of `IceCreamCustomer`
3. You should not change `IceCreamCustomerTest`.

### Coding

Check out the code and README in the  java package `com.amazon.ata.creatingexceptions.class`
in your `ATAClassroomSnippets_U3` package. You will be modifying this code in these steps.

Your goal is to migrate `IceCreamParlorService` from `S3CartonDao` to `DynamoDbCartonDao`.
You can use workflow `creating-exceptions-classroom-phase3` to test your migration.

Hint: If you need to use a DynamoDB exception class somewhere, check which exception classes are in
the import statements of `DynamoDbCartonDao`.

Phase 3 is complete when:

* `IceCreamParlorService` uses a `DynamoDbCartonDao` instead of `S3CartonDao`
* RDE Workflow `creating-exceptions-classroom-phase3` succeeds

When you have successfully made your changes and the `creating-exceptions-classroom-phase3`
rde workflow passes, please mark the checkbox next to your role below: 

* Manager
* Presenter
* Reflector
* Recorder



## Phase 4: Update GetScoop to convert to NoSuchFlavorException

|Phase 4                       |Start time:  |
|---                           |---          |
|(10 minutes) Update GetScoop  |             |

In Phase 3, you had to update `IceCreamCustomer`'s `enjoyAnIceCreamScoop` but not `enjoyAnIceCreamSundae`.
Think about why this is (or remember the class discussion if that's happened already).

### Coding

Update `getScoop` so that when a `Flavor` is requested that is not in the
DAO it throws a `NoSuchFlavorException` instead of `ResourceNotFoundException`.

You will need to update `IceCreamCustomer` as well. You should not be 
changing `IceCreamCustomerTest`.

You can use workflow `creating-exceptions-classroom-phase4` to test
your migration.

Phase 4 is complete when:

* `getScoop` throws a `NoSuchFlavorException` instead of `ResourceNotFoundException`
* RDE Workflow `creating-exceptions-classroom-phase4` succeeds

When you have successfully made your changes and the `creating-exceptions-classroom-phase4` rde workflow passes,
please mark the checkbox next to your role below: 

* Manager
* Presenter
* Reflector
* Recorder

## Phase 5: Check stock in getScoop

|Phase 5                              |Start time:  |
|---                                  |---          |
|(15 minutes) Check stock in getScoop |             |

The ice cream `Carton`s we store our `Flavor`s in can only hold so much of one
`Flavor` at a time. We need to address this in our implementation of `getScoop`.

### Coding

Update `getScoop` to decrement the number of scoops left in the `Carton` it uses.
You can use `removeScoops` in `Carton` for this. You should also update the datastore
with this new value. You should be able to use the save method that already exists in `DynamoDbCartonDao.`
If a `Flavor`'s `Carton` is out of scoops, `getScoop` should throw an exception.
Implement an exception appropriate for this case (this should be an exception from our
hierarchy design discussion earlier).

You can use workflow `creating-exceptions-classroom-phase5` to test that your exception behavior is correct.

Phase 5 is complete when:

* `getScoop` throws an exception from our exception hierarchy earlier in class.
* Workflow `creating-exceptions-classroom-phase5` succeeds

When you have successfully made your changes and the `creating-exceptions-classroom-phase5` rde workflow passes,
please mark the checkbox next to your role below: 

* Manager
* Presenter
* Reflector
* Recorder

## Extension 2: Toppings on the Sundae! 

Our current `getSundae` implementation is missing one key thing: `Topping`s!

Given that you are by now an expert in our `IceCreamParlorService`, it's time to
add the `Topping` resource.

For this extension, you will need to implement:
* `Topping` class
* `ToppingDAO` class
* `RestockTopping` operation

You will also need to update the `Sundae` class and  the`getSundae` operation to support adding a 
list of `Topping`s to your sundae.

## Extension 3:  Adding some ingredients!

Now, what happens when we run out of scoops for a flavor of ice cream?
Unfortunately, thus far, we don't have a means to create new cartons!
Keep in mind that we can't create cartons of ice cream from nothing: we need to also track
a stock of ingredients we can use to make our ice cream!

In this extension, we will add operations to `IceCreamParlorService` to both
create new `Carton`s for a `Flavor` of ice cream, and track our stock of `Ingredients`. 

You will need to change or implement the following:
* `Ingredient`
  * A POJO representing a given ingredient
* `IngredientDao`
  * A DAO to retrieve and store ingredients in our data store, including the stock of each
* `PrepareFlavor`
  * Makes a `Carton` of ice cream for a given `Flavor`.
* `RestockIngredient`
  * Replenishes our stock of a given `Ingredient`
* `AddFlavor`
  * Creates a new `Flavor` and adds a list of `Ingredient`s needed to make a `Carton` of the flavor.
* `FlavorDao`
  * Store your known `Flavor`s, as well as the `Ingredient`s needed to make a `Carton` of each
  `Flavor`

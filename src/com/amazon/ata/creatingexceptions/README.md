# Creating Exceptions - IceCreamParlorService: How Your Exceptions Affect Others

## Logistics

**Branch name: creating-exceptions-classroom**

**RDE workflow**:
* `creating-exceptions-classroom-prep`
* `creating-exceptions-classroom-phase3`
* `creating-exceptions-classroom-phase4`
* `creating-exceptions-classroom-phase5`

## Background

We've started implementing some of the operations from the 
IceCreamParlorService design.

So far, we have simplified implementations of `GetScoop` and `GetSundae` 
that just assemble the requested flavor(s).

To test using these operations, we've created `IceCreamCustomer` which 
calls our IceCreamParlorService.

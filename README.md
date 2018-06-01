# SimErgy

## Overview

Simergy is a basic simulator for emergency departments (ED) representations.
This project was part of a final exam. Final mark : 20/20.

## Nota bene

If you want more informations, you can read the project report (in French) or send me an email at `dona.criaud@gmail.com`

## Packages

### Core

Contains classes used to represent the ED such as ressources (Physicians, Nurses...), infrastructures (Rooms, MRI...), patients, events (new patient arrival, operation's start, release of the patient...) and the system.
The system represent the state of the ED, it's the Model of the MVC Pattern used to represent the ED.

### Userinterface

Self explained : contains all the classes for CLUI and GUI.

### Exceptions

Because assignation of ressources to an event is a hard thing.
Exemple : RessourceNotAvailableException, EventStartFailedException etc...

### Tests

Because we're humans, because we're not perfect and because JUnit rocks !

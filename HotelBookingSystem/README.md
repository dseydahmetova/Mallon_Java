Project: Object-Oriented Development - Hotel Booking System
FR1: Book a Room
The most basic need is to be able to book a room for a customer. The hotel has only six rooms, and a room can only be booked to a single customer at any given time. The rooms are of different types:
2 x Double Standard (for which they currently charge £150 per night)
2 x Deluxe Double (for which they currently charge £200 per night)
1 x Junior Suite (for which they currently charge £300 per night)
1 x Grand Suite (for which they currently charge £400 per night)
All the rooms can support a maximum of 2 occupants; a primary customer, who made the booking and a guest. The name of the guest must be recorded on the booking.

FR2: Check-in and Check-out
The rooms in the hotel are available for check-in from 3pm, and guests much check out before 12 noon; leaving a 3 hour window for cleaning.
In order to facilitate this, the hotel need to track when a guest arrives at the hotel for the first time, and checks into their allocated room, as well as when they depart at the end of their stay and check out.
Guests must visit the reception desk to both check in, and check out.
If a guest has not checked in by midnight on the day of the booking, the booking should be automatically cancelled and the room should be released for other customers.

FR3: Track Room Cleaning
Before a guest can check in, rooms must be cleaned. The hotel would like to track if individual rooms have been cleaned once a guest has checked out, and before a new guest can be allocated the room on check-in.
Until a room has been cleaned on a specific day, no guests should be able to check-in.

FR4: Guest Services
The hotel provides additional services for guests, including:

Breakfast (£10 per person, per day)
Room Service (a fixed price of £20 per meal, per person on request)
Laundry Service (a fixed price of £5 per item, on request)
The hotel should be able to identify for a given booking any extra items that have been purchased and produce a final bill. The bill should be made up of the base room charge, plus any additional spending a customer may have made.

FR5: Customers and Loyalty
The hotel would like to offer a loyalty programme, so that repeat customers can get a discount on future stays. Once a customer has completed their stay (they have checked out of the room), for every night they have stayed, up to a maximum of 20 nights, they should receive a 1% discount on any future bookings.
So, if James stays at the hotel for 10 nights, on his next booking he should get a 10% discount. If he then stays a further 5 nights, on his next booking he should get a 15% discount. Finally, if he stays for a further 15 nights, he should get the maximum discount of 20% on any of his future bookings.

FR6: Manage the Rates of Rooms
The hotel would like the ability to manage the room rates for the different types of room they have.
As a stretch goal, they would like this to be based on season; for example, during winter a Double Standard room might cost £100 per night, but during summer months £175 per night.
In all cases, updating the price should not impact existing bookings (anyone who has already checked-in, and certainly anyone who has checked-out).

FR7: The Hotel is Expanding
The hotel is in the process of being extended. Once open, the extension will introduce 4 new rooms. Two of these rooms are Deluxe Double rooms, but the hotel is also introducing a new Family Room. The Family Room can sleep three occupants, and has a double bed and a single bed.
The hotel wish to be able to create, update and remove room types from the system to accommodate this expansion, and any future expansions they may have planned.
When adding a new room type, the hotel should be able to specify:
How many people the room can sleep (e.g. 3)
The initial price per night (e.g. £225 per night).
The name of the room type, e.g. "Family Room"
The number of rooms of this type that there are (e.g. 2)
When updating rooms, the hotel should be able to change:

The name of the room type, and this should impact all future bookings, but not those where someone has already checked in.
The number of rooms of the type, but this should never be able to be fewer than the number of current or future bookings.
The cost per night (see FR6).
If the hotel decides to remove a room type completely, then any future bookings, where a guest has not yet checked-in should automatically be cancelled.
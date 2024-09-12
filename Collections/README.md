Create an Order class which contains
Symbol
Quantity
Side (enum -> Buy, Sell)
Status (enum -> Placed, PartiallyFilled, Filled, Cancelled)
DateTime

Make the Order class naturally ordered by its DateTime by implementing Comparable<Order>

Create a Trade class which contains:
Symbol
Quantity
Price
DateTime

Make the Trade class have VALUE equality by implementing hashCode and equals
Make the Trade class naturally ordered by its DateTime by implementing Comparable<Trade>

Implement a simple menu
It must be able to switch user (can just be a string)
It should let the user enter details for a new order		
When the order details are entered create an instance of Order
Set the DateTime in the constructor equal to right now
Set the Status in the constructor equal to Placed

Use a HashMap which maps the user to a Sorted List of Orders
When the user creates a new order
Add the order to the List of Orders in the HashMap for the User
Check in each of the OTHER users List of Orders in reverse (oldest first)
If the Symbols of the order match AND
If the side, buy/sell, are opposite AND
If the other order does not have the Status Filled or Cancelled AND
If the Buy order has a price HIGHER than the Sell order
Create a Trade object using the order details
If the quantity being sold is LESS than bought
Set the Status in the Sell order to Filled
Reduce the Quantity in the Sell order to 0
Set the Status in the Buy order to PartiallyFilled
Reduce the Quantity in the Buy order by the amount of the original Sell order
If the quantity being sold is MORE than bought
Set the Status in the Sell order to PartiallyFilled
Reduce the Quantity in the Sell order by the amount in the Buy order
Set the Status in the Buy order to Filled
Reduce the Quantity in the Buy order to 0
The Trade object should capture the Buy price (even if it's higher than Sell)
The Trade object should capture the Quantity actually traded
The DateTime should be set in the Trade constructor to right now
Add the Trade object into a Sorted Set

Extend your menu
Implement the functionality to calculate the total value of all trades
Implement the functionality to calculate the total value of all trades in the last 10 minutes
Implement the functionality to display the total quantities of Orders based on their Symbol and Side
 
 
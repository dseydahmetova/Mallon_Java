Project: Recipe System
A local bakery has received a large amount of seed money to significantly scale up its production - providing its baked goods to cafes across the city. When the operation was smaller, they could easily calculate what to make and the ingredients to buy, but now they are enlisting your help in developing a system to help them.

This assessment should be done in pairs, assigned by your instructors, using a Test-Driven Development approach. This means, for each bit of functionality, you should write a test first to have it fail, write code to make the test pass, and then refactor (Red, Green, Refactor.) Remember that TDD is primarily an iterative process, and you should not be afraid to write poor code that gets tests passing so long as you then later refactor it.

Pair Programming is a skill, and something that requires a little time and effort to establish a successful working pattern with your partner. People often think of pair programming in terms of one "driver" (with the keyboard) and one "navigator" (thinking of the broader project.) The two of you should be talking through everything you do as you go - try to avoid a one-sided pairing. You should, at least initially, be regularly alternating who is the driver and who is the navigator - for example: have one of your pair be at the keyboard to write the test, then the other be at the keyboard to write the code associated with the test.

For this project, you do not have to produce a Command Line Interface. You need only demonstrate the functionality exists using your test suite. You should think about BET testing - having tests that cover Boundary, Erroneous, and Typical use cases for a given piece of functionality or method.

Marks for this project will be awarded primarily on the basis of good use of a Test Driven Development methodology, evidence of comprehensive testing of all functionality - including boundary/erroneous cases, and code quality. The quantity of features implemented is secondary, but considered as well. In general, a solution that completes the first three parts with good testing will perform better than a solution that completes every user story but does not test it properly.

After some interviews with the manager and their team, you have identified some key user stories for the project.

Part 1: Ingredients
Before we can get onto recipes, there are the individual ingredients that must be managed by our system.

US1. As a baker, I should be able to add ingredients to the system, such that they can later be used in recipes.
US2. As a baker, I should be able to get information about an ingredient, such that I can make informed decisions. [Its name, its price to purchase, its quantity per purchased item (e.g. "one bag of sugar") - with unit (grams, ml, etc.), and its supplier's name.]
US3. As a baker, I should be able to modify the details of an ingredient (like its price), such that I can keep the system up to date with changes.
Part 2: Recipes
The system should also be able to store recipes - sets of ingredients and their quantities that produce a number (e.g. "twelve cupcakes") of a given product.

US1. As a baker, I should be able to store a recipe in the system, such that they can be retrieved and used later.
US2. As a baker, I should be able to define a recipe as requiring one or more ingredients that make it up, such that the information can be retrieved and used later.
US3. As a baker, I should be able to provide quantities that the recipe requires for each of its ingredients and how many of the output product is created, such that calculations can be made using that information.
US4. As a baker, I should be able to calculate the amount of each ingredient I would need to purchase to carry out that recipe once, such that I can plan ahead.
US5. As a baker, I should be able to calculate the amount of each ingredient I would need to purchase to carry out that recipe a given number of times, such that I can plan ahead.
US6. As a baker, I should be able to calculate how much each unit of the product (e.g. "one individual cupcake") costs to make and what price I would have to set to ensure a given profit margin, such that I can ensure the profitability of the enterprise.
Part 3: Batches
The overall goal is a system that is capable of taking a set of output products and calculating its required input ingredients. We should introduce the concept of a batch, a set of desired output products.

US1. As a baker, I should be able to give the system a desired set of output products and have the system provide me the ingredients that are required overall, so that I can order the correct ingredients.
US2. As a baker, I should be able to give the system a desired set of output products and have the system tell me the total cost, so that I can manage my expenses.
Part 4: Outputs that are Ingredients
So far, recipes have produced products that are distinct from ingredients. Sometimes, we have intermediate products that have their own recipes, but are, in future, used in recipes themselves. For example: icing is made from sugar, milk, and vanilla extract. Icing is itself used in the creation of a cake. These intermediate products do not have a purchase price or supplier information, as they must be made rather than purchased.

US1. As a baker, I should be able to define a recipe that uses a product produced from another recipe, to better represent the process of the bakery.
US2. As a baker, I should be able to calculate the required intermediate steps for a batch, such that I can better understand complicated production chains.
US3. As a baker, I should be able to calculate the purchasable ingredients required for a given batch - e.g. recursively calculating ingredients for intermediate products, such that I can better understand complicated production chains.
US4. As a baker, I should be able to rely on the system to validate the available recipes for cycles in the recipe/ingredient graph or unavailable ingredients, such that I don't have to worry about those issues myself.
Extension: Suppliers, Quantities, and Leftovers
So far, ingredients have only had one supplier and quantity they are available in. The bakery has multiple options when it comes to ordering its ingredients, and your system should represent this.

US1. As a baker, I should be able to store multiple supplier options for a given ingredient, including the quantity and price, such that I can better plan my orders.
US2. As a baker, I should be able to calculate the ingredients to purchase for a batch while minimising leftover ingredients, such that I can make better purchasing decisions.
US3. As a baker, I should be able to calculate the ingredients to purchase for a batch while minimising the number of distinct suppliers to order from, such that I can make better purchasing decisions.
US4. As a baker, I should be able to view options as to what recipes can be used for my leftover ingredients from a batch, such that I can make better use of my supples.
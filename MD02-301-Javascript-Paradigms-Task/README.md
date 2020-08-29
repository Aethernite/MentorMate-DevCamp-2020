
### :white_check_mark: 1. Write a JavaScript function createArray() that allocates array of 20 items and initializes each element by its index multiplied by 5. *Hint: arrays can be pre-allocated with the `new` keyword.

  

### :white_check_mark: 2. Write a JavaScript function compareChars(value) that compares two arrays of chars lexicographically (letter by letter). Write a JavaScript program charComparer.js that invokes your function with the sample input data below and prints the output at the console. Examples:

**Example:**
| Input                                                                                                 	| Output    	|
|-------------------------------------------------------------------------------------------------------	|-----------	|
| ['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'] <br>['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'] 	| Equal     	|
|   ['3', '5', 'g', 'd'] <br>   ['5', '3', 'g', 'd'] 	| Not equal 	|


### :white_check_mark: 3. Sort Array. Sorting an array means to arrange its elements in increasing order.  Write a JavaScript function sortArray(value) to sort an array. Use the "selection sort" algorithm: find the smallest element, move it at the first position, find the smallest from the rest, move it at the second position, etc. Write JS program arraySorter.js that invokes your function with the sample input data below and prints the output at the console.

**Example:**  
| Input                                       | Output                                       |
|---------------------------------------------|----------------------------------------------|
| [12, 12, 50, 2, 6, 22, 51, 712, 6, 3, 3]    | 2, 3, 3, 6, 6, 12, 12, 22, 50, 51, 712       |
| [5, 4, 3, 2, 1]                             | 1, 2, 3, 4, 5                                |
| [3, 74, -1, -22, 1, 0, 17]                  | -22, -1, 0, 1, 3, 17, 74                     |
  
 ### :white_check_mark: 4. Write a JavaScript function countSubstringOccur(value) that accepts as parameter an array of 2 elements arr [keyword, text]. The function finds how many times a substring is contained in a given text (perform case insensitive search). Write JS program substringSearch.js that invokes your function with the sample input data below and prints the output at the console. 
 **Example:** 
| Input                                                                                                                                                                             | Output |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| ['in', 'We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.'] | 9      |
| ['your', 'No one heard a single word you said. They should have seen it in your eyes. What was going around your head.']                                                          | 2      |


  
  

### :white_check_mark: 5. Write a JavaScript function findPalindromes(value) that extracts from a given text all palindromes, e.g. "ABBA", "lamal", "exe". Write JS program palindromesExtract.js that invokes your function with the sample input data below and prints the output at the console.  
  
**Example:**
| Input                                                                                                                                                                             | Output |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|
| ['in', 'We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.'] | 9      |
| ['your', 'No one heard a single word you said. They should have seen it in your eyes. What was going around your head.']                                                          | 2      |

 
### :white_check_mark: 6. Write a JavaScript function findMostFreqWord(value) that finds the most frequent word in a text and prints it, as well as how many times it appears in format "word -> count". Consider any non-letter character as a word separator. Ignore the character casing. If several words have the same maximal frequency, print all of them in alphabetical order. Write a JavaScript program frequentWord.js that invokes your function with the sample input data below and prints the output at the console.  
  
Example:
| Input                                                                                                                                                                                                                                                                                                         | Output                                                                                               |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------|
| 'in the middle of the night'                                                                                                                                                                                                                                                                                  | the -> 2 times                                                                                       |
| 'Hello my friend, hello my darling. Come on, come here. Welcome, welcome darling.'                                                                                                                                                                                                                            | come -> 2 times <br>darling -> 2 times <br>hello -> 2 times <br>my -> 2 times <br>welcome -> 2 times |
| 'Huh, because I'm happy<br>Clap along if you feel like a room without a roof<br>Because I'm happy<br>Clap along if you feel like happiness is the truth<br>Because I'm happy<br>Clap along if you know what happiness is to you<br>Because I'm happy<br>Clap along if you feel like that's what you wanna do' | you -> 6 times                                                                                       |

### :white_check_mark: 7. Write a JavaScript program to test if the first character of a string is uppercase or not. Use regular expressions.

### :white_check_mark: 8. In the era of heroes, every hero has his own items which make him unique. Create a function which creates a register for the heroes, with their names, level, and items, if they have such. The register should accept data in a specified format, and return it presented in a specified format. The input comes as array of strings. Each element holds data for a hero, in the following format:
> “{heroName} / {heroLevel} / {item1}, {item2}, {item3}...”

### You must store the data about every hero. The name is a string, the level is a number and the items are all strings.
### The output is a JSON representation of the data for all the heroes you’ve stored. The data must be an array of all the heroes. Check the examples for more info.  
  


| Input                                                                                                                      | Output                                                                                                                                                                                                |
|----------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ‘Isacc / 25 / Apple, GravityGun’<br>‘Derek / 12 / BarrelVest, DestructionSword’<br>‘Hes / 1 / Desolator, Sentinel, Antara’ | [{"name":"Isacc","level":25,"items":["Apple","GravityGun"]},{"name":"Derek","level":12,"items":["BarrelVest","DestructionSword"]},{"name":"Hes","level":1,"items":["Desolator","Sentinel","Antara"]}] |
| ‘Jake / 1000 / Gauss, HolidayGrenade’                                                                                      | [{"name":"Jake","level":1000,"items":["Gauss","HolidayGrenade"]}]                                                                                                                                     |
  

### Hints

-  We need an array that will hold our hero data. That is the first thing we create.
    
-   Next, we need to loop over the whole input, and process it. Let’s do that with a simple for
    
-   Every element from the input holds data about a hero, however the elements from the data we need are separated by some delimiter, so we just split each string with that delimiter.
    
-   Next, we need to take the elements from the string array, which is a result of the string split, and parse them.
    
-   However, if you do this, you could get quite the error in the current logic. If you go up and read the problem definition again, you will notice that there might be a case where the hero has no items; in that case, if we try to take the 3rd element of the currentHeroArguments array, it will result in an error. That is why we need to perform a simple check.
    
-   If there are any items in the input, the variable will be set to the split version of them. If not, it will just remain an empty array, as it is supposed to.
    
-   We have now extracted the needed data – we have stored the input name in a variable, we have parsed the given level to a number, and we have also split the items that the hero holds by their delimiter, which would result in a string array of elements. By definition, the items are strings, so we don’t need to process the array we’ve made anymore.
    
-   Now what is left is to add that data into an object and add that object to the array.
    
-   Lastly, we need to turn the array of objects we have made, into a JSON string, which is done by the stringify() function
    

### :white_check_mark:  9. Put it on the table! There is a magical function which turns JSON data into an HTML table. You will be given JSON strings holding data about food products, including their name, type and calories. You need to parse that data into objects, and create an HTML table which holds the data for each trainee on a different row, as columns.

### The name and type of the products are strings, the calories is a number.

### The input comes as an array of strings. Each element is a JSON string which represents the data for a certain food. The output is the [HTML code of a table](https://www.w3schools.com/html/html_tables.asp) which holds the data exactly as explained above.

### Bonus Task: Visualize the generated HTML Table code in the browser.

| Input                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | Output                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [<br>  '{"type":"Fruit","name":"Apple","calories":95}',<br>  '{"type":"Fruit","name":"Avocado","calories":270}',<br>  '{"type":"Fruit","name":"Coconut","calories":351}',<br>  '{"type":"Fruit","name":"Lemon","calories":6}',<br>  '{"type":"Vegetable","name":"Brussels Sprouts","calories":56}',<br>  '{"type":"Vegetable","name":"Rice (white)","calories":223}',<br>  '{"type":"Vegetable","name":"Zucchini","calories":22}',<br>  '{"type":"Vegetable","name":"Cabbage","calories":31}',<br>  '{"type":"Meat","name":"Beef (steak)","calories":229}',<br>  '{"type":"Poultry","name":"Chicken Breast (100g)","calories":75}'<br>] | ```<table><tr><td>Fruit</td><td>Apple</td><td>95</td></tr><tr><td>Fruit</td><td>Avocado</td><td>270</td></tr><tr><td>Fruit</td><td>Coconut</td><td>351</td></tr><tr><td>Fruit</td><td>Lemon</td><td>6</td></tr><tr><td>Vegetable</td><td>Brussels Sprouts</td><td>56</td></tr><tr><td>Vegetable</td><td>Rice (white)</td><td>223</td></tr><tr><td>Vegetable</td><td>Zucchini</td><td>22</td></tr><tr><td>Vegetable</td><td>Cabbage</td><td>31</td></tr><tr><td>Meat</td><td>Beef (steak)</td><td>229</td></tr><tr><td>Poultry</td><td>Chicken Breast (100g)</td><td>75</td></tr></table>``` |
  
### Hints

-   You might want to escape the HTML. Otherwise you might find yourself victim to vicious JavaScript code in the input, which aims only to hack you.
    

  

### :white_check_mark: 10. Function Playground. Create a function with no parameters. Perform the following operations:

-   The function should print the number of its arguments and each of the arguments' type.
    

-   Call the function with different number and type of arguments.
    

-   The function should print the this object. Compare the results when calling the function from:
    

-   Global scope
    
-   Function scope
    
-   Over the object
    
-   Use call and apply to call the function with parameters and without parameters
    

  

### :x: 11.  [OPTIONAL] Create Object Prototypes / Classes that model the [input](https://caloriebee.com/diets/food-calorie-chart) from Task No. 9 (food). Consider this task as a Playground and use JavaScript as a modeling clay. Use your imagination to add as much complexity as you are comfortable with.  
  
Some ideas:

-   Create validations for each property. Don’t simply assign every passed argument.
    

-   Add other properties, such as “expiration” (Date object). Create methods that check if the product is fresh or not.
    
-   Create a method that checks if a given food is vegetarian-safe.
    
-   Create some functions that work with the instances of Food. Mix a salad and calculate how many calories is the total of the meal ;) Validate that the passed object is really eatable (e.g it’s an instance of Food).
    
-   You can create another class - HungryMan, which can cook() and eat(), etc…
    
-   Create sub-classes to experiment with inheritance. Maybe “Fruit” can be a sub-class of “Food”? What special properties could you assign to Fruits that other types of food don’t have?
    
-   Etc...

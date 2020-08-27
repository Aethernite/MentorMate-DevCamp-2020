/*
1. Write a JavaScript function createArray() that allocates array of 20 items and initializes each element by its index multiplied by 5. 
*Hint: arrays can be pre-allocated with the `new` keyword.
*/

function createArray(){
  let arr = [ ...Array(20).keys() ].map( e => e*5);
  return arr;
}
console.log(createArray());


/*
2. Write a JavaScript function compareChars(value) that compares two arrays of chars lexicographically (letter by letter). 
Write a JavaScript program charComparer.js that invokes your function with the sample input data below and prints the output at the console.
*/

let arr1 = ['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'];
let arr2 = ['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'];
console.log(arr1.length === arr2.length && arr1.every((value, index) => value === arr2[index]) ? 'Equal' : 'Not equal');

/*
Sort Array. Sorting an array means to arrange its elements in increasing order. 
Write a JavaScript function sortArray(value) to sort an array. 
Use the "selection sort" algorithm: find the smallest element, move it at the first position, find the smallest from the rest, move it at the second position, etc. 
Write JS program arraySorter.js that invokes your function with the sample input data below and prints the output at the console.
*/
function selectionSort(arr,index){
  if(arr.length-1 == index){
    return arr;
  }
  let min = Math.min(...arr.slice(index));
  let min_index = arr.lastIndexOf(min);
  let temp = arr[index];
  arr[index] = min;
  arr[min_index] = temp;
  return selectionSort(arr,++index);
}
arr = [12, 12, 50, 2, 6, 22, 51, 712, 6, 3, 3];
console.log(selectionSort(arr,0));
arr = [5, 4, 3, 2, 1];
console.log(selectionSort(arr,0));
arr = [3, 74, -1, -22, 1, 0, 17];
console.log(selectionSort(arr,0));


/*
Write a JavaScript function countSubstringOccur(value) that accepts as parameter an array of 2 elements arr [keyword, text]. The function finds how many times a substring is contained in a given text (perform case insensitive search). Write JS program substringSearch.js that invokes your function with the sample input data below and prints the output at the console. 
*/

let input = ["in", "We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days."];
let input2 = ['your', 'No one heard a single word you said. They should have seen it in your eyes. What was going around your head.']
let regex = new RegExp(input[0].toLowerCase(), "g");
let string = input[1].toLowerCase();
console.log(string.match(regex).length);
let regex2 = new RegExp(input2[0].toLowerCase(), "g");
let string2 = input2[1].toLowerCase();
console.log(string2.match(regex2).length);

/*
5. Write a JavaScript function findPalindromes(value) that extracts from a given text all palindromes, e.g. "ABBA", "lamal", "exe". Write JS program palindromesExtract.js that invokes your function with the sample input data below and prints the output at the console.
*/

function isPalindrome(inputString) {
return (inputString === inputString.split('').reverse().join(''));
}

function getPalindromes(string){
 return string.toLowerCase().replace(/\W/g, " ").split(/\s+/).filter(Boolean).filter(isPalindrome);
}

let input = 'There is a man, his name was Bob.';
getPalindromes(input);


/*
6. Write a JavaScript function findMostFreqWord(value) that finds the most frequent word in a text and prints it, as well as how many times it appears in format "word -> count". Consider any non-letter character as a word separator. Ignore the character casing. If several words have the same maximal frequency, print all of them in alphabetical order. Write a JavaScript program frequentWord.js that invokes your function with the sample input data below and prints the output at the console. 
*/



function mostFreqWord(string){
 let map = new Map();
 string.toLowerCase()
 .replace(/\W/g, " ")
 .split(/\s+/)
 .filter(Boolean)
 .forEach(word => {
   if(map.has(word)){
     map.set(word,map.get(word)+1);
   }
   else{
     map.set(word,1);
   }
 });

[...map]
.map(([key, value]) => ({ key, value }))
.filter(pair => pair.value == Math.max(...map.values()))
.sort((a,b) => a.key < b.key ? -1 : 1)
.forEach(obj => console.log(obj.key + " -> " + obj.value));
}

let input = 'Hello my friend, hello my darling. Come on, come here. Welcome, welcome darling.';
let input2 = 'in the middle of the night';
let input3 = "Huh, because I'm happy Clap along if you feel like a room without a roof Because I'm happy Clap along if you feel like happiness is the truth Because I'm happy Clap along if you know what happiness is to you Because I'm happy Clap along if you feel like that's what you wanna do";
mostFreqWord(input);
console.log("==========================");
mostFreqWord(input2);
console.log("==========================");
mostFreqWord(input3);


/*
7. Write a JavaScript program to test if the first character of a string is uppercase or not. Use regular expressions.
*/

function whatIsFirstLetter(string){
return string.match(/[A-Z]/) ? "Uppercase" : string.match(/[a-z]/) ? "Lowercase" : "Not a letter!";
}

let string = "Mentormate";
let string2 = "mentormate";
let string3 = "@#!@$!@%#$%$!"

console.log(whatIsFirstLetter(string));
console.log(whatIsFirstLetter(string2));
console.log(whatIsFirstLetter(string3));



/*
8.  In the era of heroes, every hero has his own items which make him unique. Create a function which creates a register for the heroes, with their names, level, and items, if they have such. The register should accept data in a specified format, and return it presented in a specified format.
The input comes as array of strings. Each element holds data for a hero, in the following format:
“{heroName} / {heroLevel} / {item1}, {item2}, {item3}...”
You must store the data about every hero. The name is a string, the level is a number and the items are all strings.
The output is a JSON representation of the data for all the heroes you’ve stored. The data must be an array of all the heroes. Check the examples for more info.

*/

let heroes = new Array();
let input = ["Isacc / 25 / Apple, GravityGun","Derek / 12 / BarrelVest, DestructionSword","Hes / 1 / Desolator, Sentinel, Antara"];
//let input = ["Jake / 1000 / Gauss, HolidayGrenade"];
//let input = ["Pesho / 999"];

input.forEach(hero =>{
  let info = hero.split(" / ");
  let items = info[2] ? info[2].split(", ") : new Array();
  let obj = {"name":info[0],"level":info[1],"items":items};
  heroes.push(obj);
})

let json = JSON.stringify(heroes);
console.log(json);

/*
9.  Put it on the table! There is a magical function which turns JSON data into an HTML table. You will be given JSON strings holding data about food products, including their name, type and calories. You need to parse that data into objects, and create an HTML table which holds the data for each trainee on a different row, as columns.
The name and type of the products are strings, the calories is a number.
The input comes as an array of strings. Each element is a JSON string which represents the data for a certain food. The output is the HTML code of a table which holds the data exactly as explained above. 
Bonus Task: Visualize the generated HTML Table code in the browser.
*/

let jsonStrings = [
  '{"type":"Fruit","name":"Apple","calories":95}',
  '{"type":"Fruit","name":"Avocado","calories":270}',
  '{"type":"Fruit","name":"Coconut","calories":351}',
  '{"type":"Fruit","name":"Lemon","calories":6}',
  '{"type":"Vegetable","name":"Brussels Sprouts","calories":56}',
  '{"type":"Vegetable","name":"Rice (white)","calories":223}',
  '{"type":"Vegetable","name":"Zucchini","calories":22}',
  '{"type":"Vegetable","name":"Cabbage","calories":31}',
  '{"type":"Meat","name":"Beef (steak)","calories":229}',
  '{"type":"Poultry","name":"Chicken Breast (100g)","calories":75}'];

  function toHtmlElement(string){
      let parsed = JSON.parse(string);
      let html = "<tr>" + "<td>" + parsed.type + "</td>" + "<td>" + parsed.name + "</td>" + "<td>" + parsed.calories + "</td>" + "</tr>";
      return html;
  }
var table = "<table>";
jsonStrings.forEach(e => table+=toHtmlElement(e));
table += "</table>";
console.log(table);


/*
10. Function Playground. Create a function with no parameters. Perform the following operations:
The function should print the number of its arguments and each of the arguments' type. 
Call the function with different number and type of arguments.
The function should print the this object. Compare the results when calling the function from:
Global scope
Function scope
Over the object
Use call and apply to call the function with parameters and without parameters

*/

function local(args){
  func(args);
}

function func(){
  console.log("Number of arguments:" + arguments.length);
  Array.from(arguments).forEach(arg => console.log("Argument: " + arg + " Type: " + typeof arg));
  console.log("This: " + this);
  console.log("==============================")
}
var obj = [1,2,3];
var str = [1, '43', new Map()];
func(obj);
func("4314");
func(new Map());
func(...str);
func(...obj);
local(123);
func.apply(str);// This becomes the arguments
func.apply(); // This  [object Window]
func.bind(1);
func.bind();



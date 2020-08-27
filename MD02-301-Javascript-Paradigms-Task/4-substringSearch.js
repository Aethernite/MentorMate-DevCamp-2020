/*
4. Write a JavaScript function countSubstringOccur(value) that accepts as parameter an array of 2 elements arr [keyword, text]. 
The function finds how many times a substring is contained in a given text (perform case insensitive search). 
Write JS program substringSearch.js that invokes your function with the sample input data below and prints the output at the console. 
*/

let input = ["in", "We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days."];
let input2 = ['your', 'No one heard a single word you said. They should have seen it in your eyes. What was going around your head.']
let regex = new RegExp(input[0].toLowerCase(), "g");
let string = input[1].toLowerCase();
console.log(string.match(regex).length);
let regex2 = new RegExp(input2[0].toLowerCase(), "g");
let string2 = input2[1].toLowerCase();
console.log(string2.match(regex2).length);
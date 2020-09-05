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
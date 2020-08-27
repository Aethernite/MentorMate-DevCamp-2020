/*
2. Write a JavaScript function compareChars(value) that compares two arrays of chars lexicographically (letter by letter). 
Write a JavaScript program charComparer.js that invokes your function with the sample input data below and prints the output at the console.
*/

let arr1 = ['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'];
let arr2 = ['1', 'f', '1', 's', 'g', 'j', 'f', 'u', 's', 'q'];
console.log(arr1.length === arr2.length && arr1.every((value, index) => value === arr2[index]) ? 'Equal' : 'Not equal');
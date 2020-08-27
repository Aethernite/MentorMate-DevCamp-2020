/*
5. Write a JavaScript function findPalindromes(value) that extracts from a given text all palindromes, 
e.g. "ABBA", "lamal", "exe". 
Write JS program palindromesExtract.js that invokes your function with the sample input data below and prints the output at the console.
*/

function isPalindrome(inputString) {
return (inputString === inputString.split('').reverse().join(''));
}

function getPalindromes(string){
 return string.toLowerCase().replace(/\W/g, " ").split(/\s+/).filter(Boolean).filter(isPalindrome);
}

let input = 'There is a man, his name was Bob.';
getPalindromes(input);

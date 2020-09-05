/*
6. Write a JavaScript function findMostFreqWord(value) that finds the most frequent word in a text and prints it, as well as how many times it appears in format "word -> count". 
Consider any non-letter character as a word separator. 
Ignore the character casing. 
If several words have the same maximal frequency, print all of them in alphabetical order. 
Write a JavaScript program frequentWord.js that invokes your function with the sample input data below and prints the output at the console. 
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
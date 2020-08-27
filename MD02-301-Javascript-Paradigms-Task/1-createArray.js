/*
1. Write a JavaScript function createArray() that allocates array of 20 items and initializes each element by its index multiplied by 5. 
*Hint: arrays can be pre-allocated with the `new` keyword.
*/

function createArray(){
  let arr = [ ...Array(20).keys() ].map( e => e*5);
  return arr;
}
console.log(createArray());
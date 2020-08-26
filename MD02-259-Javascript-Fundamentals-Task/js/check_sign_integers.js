let first_integer = 42;
let second_integer = -4;

console.log("First integer is: " + getSign(Math.sign(first_integer)));
console.log("Second integer is: " + getSign(Math.sign(second_integer)));


function getSign(num){
  switch(num){
    case 1:
    return 'positive';
    case -1:
    return 'negative';
    case 0:
    return 'zero';
  }
}
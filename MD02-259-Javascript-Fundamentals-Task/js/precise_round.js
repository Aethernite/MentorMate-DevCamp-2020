let number = 12.432523423;
console.log(precise_round(number,3));

function precise_round(num,precision){
  return num.toFixed(precision);
}
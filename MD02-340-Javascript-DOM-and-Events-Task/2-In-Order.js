/*2. Write a function called inOrder that accepts two callbacks and invokes them in order. Implement inOrder using the callback pattern.
*/
function inOrder(callbackOne, callbackTwo) {
    callbackOne(callbackTwo);
}
 
var logOne = function(callback) {
    setTimeout(function () {
        console.log("one!");
        callback();
    }, Math.random() * 7000);
}
 
var logTwo = function (){
    setTimeout(function () {
        console.log("two!");
    }, Math.random() * 1000);
}
 
inOrder(logOne, logTwo)
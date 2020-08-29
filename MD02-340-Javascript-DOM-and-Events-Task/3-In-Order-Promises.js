/*2. Write a function called inOrder that accepts two callbacks and invokes them in order. Implement inOrder using the callback pattern.
*/
function inOrder(logOne, logTwo) {
	let logTwoCallback = logTwo._onTimeout;
	clearTimeout(logTwo);
	let logOneCallback = new Promise((resolve, reject) => {
		resolve(logOne._onTimeout());
		clearTimeout(logOne);
	});
	Promise.resolve(logOneCallback).then(logTwoCallback);
}

var logOne = setTimeout(function () {
        console.log("one!");
    }, Math.random() * 3000);
 
var logTwo = setTimeout(function () {
        console.log("two!");
    }, Math.random() * 1000);
 
inOrder(logOne, logTwo)
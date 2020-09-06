/*
5. Implement a simple version of Promise.all. 
This function should accept an array of promises and return an array of resolved values. 
If any of the promises are rejected, the function should catch them.
*/
//ITERATIVE SOLUTION
PromiseAllIterativeFunction = function promiseAllIterative(values) {
    return new Promise((resolve, reject) => {
       let results = [];
       let completed = 0;
       
       values.forEach((value, index) => {
            Promise.resolve(value).then(result => {
                results[index] = result;
                completed += 1;
                
                if (completed == values.length) {
                    resolve(results);
                }
            }).catch(err => reject(err));
       });
    });
}
//REDUCER SOLUTION
PromiseAllReducerFunction = function promiseAllReduce(values) {
    return values.reduce((accumulator, value) => {
        return accumulator.then(results => {
            return Promise.resolve(value).then(result => {
                return [...results, result];
            });
        });
    }, Promise.resolve([]));
}
//RECURSIVE SOLTUION
PromiseAllRecursiveFunction = function promiseAllRecursive(values) {
    if (values.length === 0) {
        return Promise.resolve([]);
    }
    const [first, ...rest] = values;
    return Promise.resolve(first).then(firstResult => {
        return promiseAllRecursive(rest).then(restResults => {
            return [firstResult, ...restResults];
        });
    });
}



//SAMPLE PROMISES
let promise1 = new Promise((resolve, reject) => {
	setTimeout(() => {
		resolve('Promise 1 fulfilled!');
	}, Math.random() * 1500);
});

let promise2 = new Promise((resolve, reject) => {
	let result = 0;
	let counter = Math.random() * 3000;
	for (let i = 0; i < counter; i++) {
		result += i;
		i = result;
	}
	resolve(`Promise 2 fulfilled with result: ${result}`);
});

let promise3 = new Promise((resolve, reject) => {
	setTimeout(() => {
		let randomNumber = Math.random();
		if (randomNumber > 0.25) {
			resolve(`Promise 3 fullfilled at ${randomNumber.toFixed(2)}!`);
		} else {
			reject('Promise 3 failed!');
		}
	}, Math.random() * 1500);
});


PromiseAllIterativeFunction([promise1,promise2,promise3]).then(console.log); //Sometimes Promise 3 will fail
//PromiseAllReducerFunction([promise1,promise2,promise3]).then(console.log); //Sometimes Promise 3 will fail
//PromiseAllRecursiveFunction([promise1,promise2,promise3]).then(console.log); //Sometimes Promise 3 will fail
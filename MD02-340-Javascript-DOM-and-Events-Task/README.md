# Homework assignment  
  
 ### :white_check_mark: 1. Create a TODO app using vanilla JS and the DOM api. It can be as simple as a single input to type the TODO content, a button to create the TODO and a list (\<ul>) to display them.  
  
If you style it and make it pretty that would be nice. Any additional functionality is also e plus. Here’s an example of such an application.  
 > [http://todomvc.com/examples/vanillajs/](http://todomvc.com/examples/vanillajs/)

  

  
### :white_check_mark: 2.  Write a function called inOrder that accepts two callbacks and invokes them in order. Implement inOrder  using the callback pattern.

```js
var logOne = setTimeout(function() {  
console.log("one!");  
}, Math.random() * 1000);

var logTwo = setTimeout(function() {  
console.log("two!");  
}, Math.random() * 1000);

inOrder(logOne, logTwo);

// one  
// two

// it should always log those two in order regardless of their timing
```

### :white_check_mark: 3. Refactor inOrder to use promises.

  

### :white_check_mark: 4. Make an AJAX (or Fetch) call to the [Star Wars API](https://swapi.dev/) and get the opening crawl for each film in the series. Once you have finished that, loop through the array of planets for each movie and make more AJAX calls to collect the name of each planet, organized by film. Then, console log an array of objects in which each object contains the opening crawl for a specific movie, along with the names of every planet featured in that movie.

  

### :white_check_mark: 5. Implement a simple version of Promise.all. This function should accept an array of promises and return an array of resolved values. If any of the promises are rejected, the function should catch them.


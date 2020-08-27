/*
10. Function Playground. Create a function with no parameters. Perform the following operations:
The function should print the number of its arguments and each of the arguments' type. 
Call the function with different number and type of arguments.
The function should print the this object. Compare the results when calling the function from:
Global scope
Function scope
Over the object
Use call and apply to call the function with parameters and without parameters

*/

function local(args){
  func(args);
}

function func(){
  console.log("Number of arguments:" + arguments.length);
  Array.from(arguments).forEach(arg => console.log("Argument: " + arg + " Type: " + typeof arg));
  console.log("This: " + this);
  console.log("==============================")
}
var obj = [1,2,3];
var str = [1, '43', new Map()];
func(obj);
func("4314");
func(new Map());
func(...str);
func(...obj);
local(123);
func.apply(str);// This becomes the arguments
func.apply(); // This  [object Window]
func.bind(1);
func.bind();
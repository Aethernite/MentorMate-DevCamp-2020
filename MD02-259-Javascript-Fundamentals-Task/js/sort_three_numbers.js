/*
4. Write a JavaScript conditional statement to sort three numbers. Display an alert box to show the result. Do NOT use arrays.
*/

var a= 0;
var b= 5;
var c= -1;

sort(a,b,c);


function sort(a,b,c){
var max = Math.max(a,Math.max(b,c));
var min = -Math.max(-a, Math.max(-b, -c));
var mid = (a + b + c)  - (max + min);
alert(min + " " + mid + " " + max);
}
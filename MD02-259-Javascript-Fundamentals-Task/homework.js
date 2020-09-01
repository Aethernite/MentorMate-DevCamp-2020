/*
3. Create sample expressions, using all possible JavaScript operators.
*/

//Assignment operators
var x=1,y=1;
x = y;    //Assignment                            same as             x = y
x += y;   //Addition assignment                   same as             x = x + y
x -= y;   //Subtraction assignment                same as             x = x - y
x *= y;   //Multiplication assignment             same as             x = x * y
x /= y;   //Division assignment                   same as             x = x / y
x %= y;   //Remainder assignment                  same as             x = x % y
x **= y;  //Exponentiation assignment             same as             x = x ** y
x <<= y;  //Left shift assignment                 same as             x = x << y
x >>= y;  //Right shift assignment                same as             x = x >> y
x >>>= y; //Unsigned right shift assignment       same as             x = x >>> y
x &= y;   //Bitwise AND assignment                same as             x = x & y
x ^= y;   //Bitwise XOR assignment                same as             x = x ^ y
x |= y;   //Bitwise OR assignment                 same as             x = x | y
//x &&= y;//Logical AND assignment                same as             x && (x = y)
//x ||= y;//Logical OR assignment                 same as             x || (x = y)
//x ??= y;//Logical nullish assignment	          same as             x ?? (x = y)

x=y=1;

//Comparison operators
x == y;   //Equal
x != y;   //Not equal
x === y;  //Strict equal
x !== y;  //Strict not equal
x > y;    //Greater than
x >= y;   //Greater than or equal
x < y;    //Less than
x <= y;   //Less than or equal

//Arithmetic operators
x + y;   //Addition
x - y;   //Substraction
x / y;   //Division
x * y;   //Multiplication
x--;     //Decrement after
x++;     //Increment after
--x;     //Decrement first
++x;     //Increment first
-x;      //Unary negation
+x;      //Unary plus
x%y;     //Remainder

//Bitwise operators
x & y;   //AND
x | y;   //OR
x ^ y;   //XOR
~ x;     //NOT
x << y;  //Left shift
x >> y;  //Sign-propagating right shift
x >>> y; //Zero-fill right shift

//Logical operators
x && y;  //AND
x || y;  //OR
!x;      //NOT

var str1 = 'Hello ';
var str2 = 'World!';
//String operators
str1+str2; //Concatenation

var z;
//Conditional (ternary) operator
z ? x : y;

//Comma operator
var j = [0,1,2,3,4,5,6,7,8,9];


var trees = ['redwood', 'bay', 'cedar', 'oak', 'maple'];
//Unary operators
delete j;  //Deletion
typeof x;  //Returns type
'length' in trees; //Returns boolean
null instanceof Object; //Returns boolean

//######################################################################################################################################

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

//######################################################################################################################################

/*
5.  Write a JavaScript program to display the current day and time in the following format.
Today is : Wednesday.
Current time is : 12 PM : 03 : 38
*/
var weekday = new Array(7);
weekday[0] = "Sunday";
weekday[1] = "Monday";
weekday[2] = "Tuesday";
weekday[3] = "Wednesday";
weekday[4] = "Thursday";
weekday[5] = "Friday";
weekday[6] = "Saturday";

var date = new Date();
var day = date.getDay();
console.log("Today is : " + weekday[day]);
console.log("Current time is : " + extractTime(date));

function extractTime(date) {
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var seconds = date.getSeconds();
  var ampm = hours >= 12 ? 'PM' : 'AM';
  hours = hours % 12;
  hours = hours ? hours : 12; // the hour '0' should be '12'
  minutes = minutes < 10 ? '0'+minutes : minutes;
  var time = hours + " " + ampm + ' : ' + minutes + ' : ' + seconds;
  return time;
}

//######################################################################################################################################

/*
6. Write a JavaScript program that counts the number of workdays and holidays to the end of the year. 
Bonus points for including Bulgarian national holidays.
*/

console.log(getBusinessDatesCount());
function getBusinessDatesCount() {
    var startDate = new Date();
    var count = 0;
    var curDate = startDate;
    var year = curDate.getFullYear();
    while (curDate.getFullYear() < year+1) {
        var dayOfWeek = curDate.getDay();
        if(!((dayOfWeek == 6) || (dayOfWeek == 0))){
           count++;
        }
        curDate.setDate(curDate.getDate() + 1);
    }
    count--;
    return count;
}

//######################################################################################################################################

/*
7. Write a JavaScript program to find when your birthday is on Friday between 2020 and 2050.
*/

let birthday = new Date('1998-12-18');
console.log(countBirthdaysOnFriday(birthday));

function countBirthdaysOnFriday(birthday){
    let count = 0;
    for(let year = 2020; year <= 2050; year++){
      let date = new Date(year,birthday.getMonth(),birthday.getDate());
      if(date.getDay()==5){
        console.log('Birthday on friday in year: ' + year);
        count++;
      }
    }
    return 'Result: ' + count;
}

//######################################################################################################################################

/*
8. FizzBuzz. Write a program that prints the numbers from 1 to 100. 
But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
For numbers which are multiples of both three and five print “FizzBuzz”. 
Try to do that with the least amount of code possible.
*/

for (let i = 1; i <= 100; i++) {
  console.log(i%3==0 && i%5 == 0? 'FizzBuzz': i%3 ==0 ? 'Fizz' : i%5 == 0 ? 'Buzz': i);
}

//######################################################################################################################################

/*
9. Write a JavaScript programs to convert the following metrics:
- Temperatures to and from Celsius, Fahrenheit
- mph to and from km/h
- Gallons to and from litres
*/

galonToLiter(1);
literToGalon(20);
celsiusToFahrenheit(30);
fahrenheitToCelsius(86);
kmhToMph(100);
mphToKmh(62);

function celsiusToFahrenheit(celsius) 
{
  var fahrenheit = celsius * 9 / 5 + 32;
  var message = celsius +'\xB0C is ' + fahrenheit + ' \xB0F.';
  console.log(message);
}

function fahrenheitToCelsius(fahrenheit) 
{
  var celsius = (fahrenheit - 32) * 5 / 9;
  var message = fahrenheit + '\xB0F is ' + celsius + '\xB0C.';
  console.log(message);
}

function galonToLiter(gallons){
  var liters = gallons * 3.7854;
  var message = gallons + ' gallons is ' + liters.toFixed(2) + ' liters.'
  console.log(message);
}

function literToGalon(liters){
  var gallons = liters / 3.7854;
  var message = liters + ' liters is ' + gallons.toFixed(2) + ' gallons.'
  console.log(message);
}

function mphToKmh(mph){
  var kmh = mph * 1.61;
  var message = mph + ' mph is ' + kmh.toFixed(0) + ' kmh.';
  console.log(message);
}

function kmhToMph(kmh){
  var mph = kmh / 1.61;
  var message = kmh + ' kmh is ' + mph.toFixed(0) + ' mph.';
  console.log(message);
}

//######################################################################################################################################

/*
10. Write a JavaScript program to check from two given integers, whether one is positive and another one is negative.
*/

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

//######################################################################################################################################

/*
11. Write a JavaScript function to calculate the tax (20%) of a given price.
*/

let tax = 3142.20;
console.log(get20Percent(tax));

function get20Percent(tax){
  return tax*0.2;
}

//######################################################################################################################################

/*
12. Write a JavaScript function to round a number to a given decimal places. Do NOT use string methods or arrays.
*/

let number = 12.432523423;
console.log(precise_round(number,3));

function precise_round(num,precision){
  return num.toFixed(precision);
}



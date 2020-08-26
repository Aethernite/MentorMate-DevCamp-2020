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
//x &&= y;  //Logical AND assignment              same as             x && (x = y)
//x ||= y;  //Logical OR assignment               same as             x || (x = y)
//x ??= y;  //Logical nullish assignment	  same as             x ?? (x = y)

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
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
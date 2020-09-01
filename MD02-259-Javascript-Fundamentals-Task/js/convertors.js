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
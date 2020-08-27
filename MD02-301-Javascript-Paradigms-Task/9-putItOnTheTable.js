/*
9.  Put it on the table! There is a magical function which turns JSON data into an HTML table. You will be given JSON strings holding data about food products, including their name, type and calories. You need to parse that data into objects, and create an HTML table which holds the data for each trainee on a different row, as columns.
The name and type of the products are strings, the calories is a number.
The input comes as an array of strings. Each element is a JSON string which represents the data for a certain food. The output is the HTML code of a table which holds the data exactly as explained above. 
Bonus Task: Visualize the generated HTML Table code in the browser.
*/

let jsonStrings = [
  '{"type":"Fruit","name":"Apple","calories":95}',
  '{"type":"Fruit","name":"Avocado","calories":270}',
  '{"type":"Fruit","name":"Coconut","calories":351}',
  '{"type":"Fruit","name":"Lemon","calories":6}',
  '{"type":"Vegetable","name":"Brussels Sprouts","calories":56}',
  '{"type":"Vegetable","name":"Rice (white)","calories":223}',
  '{"type":"Vegetable","name":"Zucchini","calories":22}',
  '{"type":"Vegetable","name":"Cabbage","calories":31}',
  '{"type":"Meat","name":"Beef (steak)","calories":229}',
  '{"type":"Poultry","name":"Chicken Breast (100g)","calories":75}'];

  function toHtmlElement(string){
      let parsed = JSON.parse(string);
      let html = "<tr>" + "<td>" + parsed.type + "</td>" + "<td>" + parsed.name + "</td>" + "<td>" + parsed.calories + "</td>" + "</tr>";
      return html;
  }
var table = "<table>";
jsonStrings.forEach(e => table+=toHtmlElement(e));
table += "</table>";
console.log(table);
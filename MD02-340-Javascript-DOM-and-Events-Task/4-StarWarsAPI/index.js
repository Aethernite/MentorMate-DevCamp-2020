/*
4. Make an AJAX (or Fetch) call to the Star Wars API (https://swapi.dev/) and get the opening crawl for each film in the series. 
Once you have finished that, loop through the array of planets for each movie and make more AJAX calls to collect the name of 
each planet, organized by film. Then, console log an array of objects in which each object contains the opening crawl for a 
specific movie, along with the names of every planet featured in that movie.
*/
const fetch = require('node-fetch');
async function showResults(data){
    let output = [];

    for (let film of data){
        let obj = {};
        let planets = [];

        for (let planet of film.planets){
            await fetch(planet).then(a => a.json()).then(a => planets.push(a.name));
        }

        obj.opening_crawl = film.opening_crawl;
        obj.planets = planets;

        output.push(obj);
    }
    console.log(output);
}

function fetchStarWarsAPI(url){
    return fetch(url)
          .then(a => a.json())
          .then(data => data.results)
          .then(showResults)
          .catch(console.error);
}

const url = "https://swapi.dev/api/films/"
fetchStarWarsAPI(url);

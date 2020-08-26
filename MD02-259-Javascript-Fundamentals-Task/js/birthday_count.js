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
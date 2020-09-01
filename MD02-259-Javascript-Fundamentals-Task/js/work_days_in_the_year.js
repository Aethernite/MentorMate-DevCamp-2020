console.log(getBusinessDatesCount());
function getBusinessDatesCount() {
    var currentDate = new Date();
    var startDate = new Date(currentDate.getUTCFullYear()+'');
    var endDate = new Date(currentDate.getFullYear()+1+'');
    var count = 0;
    var curDate = startDate;
    while (curDate <= endDate) {
        var dayOfWeek = curDate.getDay();
        if(!((dayOfWeek == 6) || (dayOfWeek == 0))){
           count++;
        }
        curDate.setDate(curDate.getDate() + 1);
    }
    return count-16; //There are 16 days of National Holidays in Bulgaria
}
const loadedTimeHtml = document.getElementById("loadedTime");
const realTimeHtml = document.getElementById("realTime");

const time = new Date().toISOString();
loadedTimeHtml.innerText = time;

function showRealTime() {
    realTimeHtml.innerText = new Date().toISOString();
}

const SECOND = 1000;
const MINUTE = 60 * SECOND;
const HOUR = 60 * MINUTE;
const DAY = 24 * HOUR;
const WEEK = 7 * DAY;

setInterval(showRealTime, SECOND);


function showAlertTime() {
    alert('Time is: ' + new Date().toISOString());
}

setTimeout(showAlertTime, 5 * SECOND)


setInterval(function () {
    console.log("EVERY 2 SECONDS")
}, 2 * SECOND)

setInterval(() => {
    console.log("Every 3 SECONDS")
}, 3 * SECOND)













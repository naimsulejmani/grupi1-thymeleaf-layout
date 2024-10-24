const loadedTimeHtml = document.getElementById("loadedTime");
const realTimeHtml = document.getElementById("realTime");

const time = new Date().toISOString();
loadedTimeHtml.innerText = time;


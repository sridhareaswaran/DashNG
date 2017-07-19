/*** author: Sridhar Easwaran ***/

/* json: https://gist.githubusercontent.com/sridhareaswaran/ef30b1560f14b081dfc25c846fa08ac0/raw/907872ac347b643d6d6b4af7947d9a269c3d63db/testng.json */
/* css: https://gist.githubusercontent.com/sridhareaswaran/4069a212a11653273b1f1a2cb2f02761/raw/ed9857d0538ebf3980ec01f68b0defebf0abfd0b/dashboard.css */

$(document).ready(function() {
    $('#modal1').modal();
});

var suiteName;
var startTime;
var endTime;
var totalTests;
var includedGroups;
var excludedGroups;
var passCount;
var skipCount;
var failedCount;

var InprogressGIF = "https://cdn.dribbble.com/users/236204/screenshots/2675071/dog_gif.gif";
var CompletedIMG = "https://cdn.dribbble.com/users/59947/screenshots/2853583/2_1x.jpg";

function readJSONfile() {
    $.getJSON("data/testng.json", function(json) {
        suiteName = json.info.suiteName;
        startTime = json.info.startTime;
        endTime=json.info.endTime;
        totalTests=json.info.totalTests;
        includedGroups=json.info.includedGroups;
        excludedGroups=json.info.excludedGroups;
        if (json.passed==null)
            passCount=0;
        else
            passCount=json.passed.length;

        if (json.skipped==null)
            skipCount=0;
        else
            skipCount=json.skipped.length;

        if (json.failed==null)
            failCount=0;
        else
            failCount=json.failed.length;
        
        updateDashboard();
    });
}

function updateGIF() {
    if (endTime == null) {
        //document.getElementById("funnyIMG").src = InprogressGIF;
        document.getElementById("funnyIMG").alt = "Test Execution Inprogress";
        document.getElementById('endTime').innerHTML = "  .    .    .".replace(/ /g, '&nbsp;');
    } else {
        document.getElementById("funnyIMG").src = CompletedIMG;
        document.getElementById("funnyIMG").alt = "Test Execution Completed";
        document.getElementById('endTime').textContent = endTime;
    }
}

function updateTestInfo() {
    document.getElementById('suiteName').textContent = suiteName;
    document.getElementById('startTime').textContent = startTime;
    document.getElementById('endTime').textContent = endTime;
    document.getElementById('totalTests').textContent = totalTests;
    document.getElementById('includedGroups').textContent = includedGroups;
    document.getElementById('excludedGroups').textContent = excludedGroups;
}

function updateTestCount() {
    document.getElementById('passCount').textContent = passCount;
    document.getElementById('skipCount').textContent = skipCount;
    document.getElementById('failCount').textContent = failCount;
}

function updateDashboard() {
    updateTestInfo();
    updateTestCount();
    updateGIF();
}

function main() {
    readJSONfile();
    setTimeout(main, 1000);
}

main();
/*
 index.js
 */


"use strict";

//var msg = "Hello JavaScript";
//console.log(msg);

//var resultsDiv = document.getElementById("results");
//resultsDiv.innerHTML = "<p>This is from java script</p>";

var resultList = $("#resultList");
resultList.text("this is now from jQuery");

var toggleButton = $("#toggleButton");
toggleButton.on("click", function () {
    resultList.toggle(500);
    if (toggleButton.text() === "Hide")
        toggleButton.text("Show");
    else
        toggleButton.text("Hide");
});
var listItems = $("header nav li")
listItems.css("font-weight", "bold");
listItems.filter(":first").css("font-size", "16px");

/*
 var result = {
 name: "jQuery",
 language: "JavaScript",
 score: 4.5
 showLog: function() {
 
 },
 owner: {
 login: "tsteger",
 id: 123456
 }
 };
 result.phoneNumber = "123-456-7890";
 console.log(result.phoneNumber);
 */
$("#librarySeekForm").on("submit", function () {

    var searchPhrase = $("#searchPhrase").val();
    var useStars = $("#useStars").val();
    var langChoice = $("#langChoice").val();

    if (searchPhrase) {
        resultList.text("Performing search...");
        var gitHubSearch = "Https://api.github.com/search/repositories?q=" +encodeURIComponent(searchPhrase);
        
        if(langChoice !="All"){
            gitHubSearch += "+language:" + encodeURIComponent(langChoice);
        }
        if(useStars){
            gitHubSearch += "&sort=stars";
        }
       // var gitHubSearch = "Https://api.github.com/search/repositories?q=jquery+language:javascript&sort=stars";

        $.get(gitHubSearch, function (r) {
            console.log(r.items.length);
            //console.log(r.items);
            displayResults(r.items);
        });
    }
    return false;
});

/*
 var results = [{
 name: "jQuery",
 language: "JavaScript",
 score: 4.5,
 owner: {
 login: "tsteger",
 id: 123456
 }
 }, {
 name: "jQuery ui",
 language: "JavaScript",
 score: 3.5,
 owner: {
 login: "tsteger",
 id: 123456
 }
 }];
 */
function displayResults(results) {


    resultList.empty();
    $.each(results, function (i, item) {

        var newResult = $("<div class ='result'>" +
                "<div class='title'>" + item.name + "</div>" +
                "<div>Lanugage: " + item.language + "</div>" +
                "<div>Owner: " + item.owner.login + "</div" +
                "</div>");

        newResult.hover(function () {
            $(this).css("background-color", "lightgray");
        }, function () {
            $(this).css("background-color", "transparent");
        });

        resultList.append(newResult);
    });
}
/*
 for (var x = 0; x < results.length ; x++) {
 var result = results[x];
 if (result.score < 4) break;
 console.log(result.name);
 }
 */
//console.log(results.length);
//console.log(results[0].name);
/*
 results.push(result);
 
 results.push({
 name: "dummy prodject"
 });
 */
/*
 console.log("msg is " + typeof(msg));
 console.log("rusultsDiv is " + typeof(resultsDiv));
 
 var none;
 console.log("none is " + typeof(none));
 
 var aNumber = 10;
 console.log("aNumber is " + typeof(aNumber));
 
 var trueFalse = true;
 console.log("trueFalse is " + typeof(trueFalse));
 
 if (none == undefined) {
 console.log("none is undefined");
 
 }
 if(aNumber === "10") {
 console.log("10 is 10");
 }
 //function showMsg(msg) {
 //	console.log("showMsg: " +msg);
 //}
 function showMsg(msg, more) {
 if(more){
 console.log("showMsg+ " +msg+more);
 }else {
 console.log("showMsg: " +msg);
 }
 
 }
 showMsg("Some info");
 showMsg("Some info","Ultra");
 
 var showIt = function (msg) {
 console.log(msg);
 }
 showIt("Some message");
 
 function showItThen(msg, callback) {
 showIt(msg);
 callback();
 }
 showItThen("showItThen called", function () {
 console.log("callback called");
 });
 
 var inGlobal = true;
 
 
 function testMe() {
 console.log("testMe(): " +inGlobal);
 
 var somMsg = "some Message";
 console.log("testMe(): " +somMsg);
 
 showItThen("with Closure", function () {
 showIt("testMe With Closure(): " + someMsg);
 });
 
 }
 //console.log("global(): " +somMsg);
 testMe();
 
 */
























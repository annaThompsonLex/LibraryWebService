/*
 index.js
 */


"use strict";
 $('.button2').on('mouseenter', function() {
    $(this).addClass('highlight');
     $(this).animate({'font-size': '32px'});
  });
  $('.button2').on('mouseleave', function() {
    $(this).removeClass('highlight');
    $(this).animate({'font-size': '16px'});
  });
  
 

var resultList = $("#resultList");
resultList.text("results");
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
//listItems.filter(":first").css("font-size", "16px");

$("#librarySeekForm").on("submit", function () {

    var searchPhrase = $("#seek").val();
    var LibSearch = "http://localhost:8080/LibraryWebService/rest/book";
    if (document.getElementById('title').checked)
    {
        LibSearch += "?title=" + encodeURIComponent(searchPhrase);
    } else if (document.getElementById('author').checked)
    {
        LibSearch += "?author=" + encodeURIComponent(searchPhrase);
    } else if (document.getElementById('genre').checked)
    {
        LibSearch += "?genre=" + encodeURIComponent(searchPhrase);
    } else if (document.getElementById('isbn').checked)
    {
        LibSearch += "?isbn=" + encodeURIComponent(searchPhrase);
    } else
    {
        console.log("Nada Go");
        searchPhrase=" ";
    }
    console.log(LibSearch);
    

    if (searchPhrase) {
        resultList.text("Performing search...");
        //var LibSearch = "http://localhost:8080/LibraryWebService/rest/book" + encodeURIComponent(searchPhrase);
       // var LibSearch = "http://localhost:8080/LibraryWebService/rest/book";


        $.get(LibSearch, function (r) {
            console.log(r.length);
            console.log(r);
            displayResults(r);
        });
    }
    return false;
});

function displayResults(results) {


    resultList.empty();
    $.each(results, function (i, item) {

        var newResult = $("<div class ='result'>" +
                "<div class='title'>" + item.title + "</div>" +
                "<div class='pic'><img src="+item.picUrl+" alt='bild' width='100' height='150'></div>" +
                "<div class='infotext'>Author: " + item.author + "</div>" +
                "<div class='infotext'>Gener: " + item.genre + "</div>" +
                "<div class='infotext'>Isbn: " + item.isbn + "</div>" +
                "</div>");
       
        newResult.hover(function () {
            $(this).css("background-color", "lightgray");
            
        }, function () {
            $(this).css("background-color", "transparent");
        });
        resultList.append(newResult);
    });
}


//<div><img src="img/logo2.png" alt="logo" class="bordered-image"></div>

/*
 * var newResult = $("<div class ='result'>" +
                "<div class='title'>" + item.title + "</div>" +
                "<div class='pic'><img src="+item.picUrl+" alt='bild' width='100' height='150'></div>" +
                "<div class='infotext'>Author: " + item.author + "</div>" +
                "<div class='infotext'>Gener: " + item.genre + "</div>" +
                "<div class='infotext'>Isbn: " + item.isbn + "</div>" +
                "</div>");
 */




















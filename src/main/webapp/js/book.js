var resultList = $("#resultList");
var listItems = $("header nav li")
listItems.css("font-weight", "bold");

$('form').on('submit', function () {
    event.preventDefault();
    var objKeysRegex = /({|,)(?:\s*)(?:')?([A-Za-z_$\.][A-Za-z0-9_ \-\.$]*)(?:')?(?:\s*):/g;
    var form = $(this);
    var data = {};
    $("form").serializeArray().map(function(x){data[x.name] = x.value;});
    var formData = JSON.stringify(data);
    var newQuotedKeysString = formData.replace(objKeysRegex, "$1\"$2\":");
    $.ajax('http://localhost:8080/LibraryWebService/rest/book', {
        type: 'POST',
         headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: newQuotedKeysString,
      
        success: function (result) {
             console.log(result);
             resultList.append("</br/><span class='blue'>A new book is added to the database</span>");
        },
        error: function(xhr,resp,text){
            console.log(newQuotedKeysString);
            console.log(xhr);
            console.log(resp);
            console.log(text);
            resultList.append("<br/><span class='red'>Somthing whent wrong when adding a new book!</span>");
        }
    });
});


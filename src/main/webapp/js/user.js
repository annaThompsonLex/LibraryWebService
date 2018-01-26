var resultList = $("#resultList");
var listItems = $("header nav li")
listItems.css("font-weight", "bold");

$('form').on('submit', function () {
    event.preventDefault();
    //var objKeysRegex = /({|,)(?:\s*)(?:')?([A-Za-z_$\.][A-Za-z0-9_ \-\.$]*)(?:')?(?:\s*):/g;
    var form = $(this);
    var data = {};
    $("form").serializeArray().map(function (x) {
        data[x.name] = x.value;
    });
    var formData = JSON.stringify(data);
    console.log(formData);
   // var newQuotedKeysString = formData.replace(objKeysRegex, "$1\"$2\":");
    $.ajax('http://localhost:8080/LibraryWebService/rest/user', {
        type: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        data: formData,

        success: function (result) {
            console.log(result);
            resultList.append("<br/><span class='blue'>A new User is addet to the database</span>");
        },
        error: function (xhr, resp, text) {
            console.log(formData);
            console.log(xhr);
            console.log(resp);
            console.log(text);
            resultList.append("<br/><span class='red'>Somthing whent wrong when adding a new user!</span>");
        }
    });
});

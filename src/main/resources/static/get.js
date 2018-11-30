$(document).ready(function () {

    // GET REQUEST
    $("#getAllCustomerId").click(function (event) {
        event.preventDefault();
        console.log(window.location + "/getAll");
        ajaxGet();
    });
    var obj = {
        name: "fausto",
        age: 24,
        city: "ny",
    };
    var myJSON = JSON.stringify(obj);

    // DO GET
    function ajaxGet() {
        $.ajax({
            type: "POST",
            data: myJSON,
            dataType: 'json',
            contentType: "application/json",
            url: window.location + "/getAll",
            success: function (data) {
                console.log(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    }

    $("#getStatus").click(function (event) {
        $.ajax({
            type: "GET",
            url: window.location + "/status",
            success: function (data) {
                console.log(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    });

    $("#loginAuth").click(function (event) {
        console.log("login!!!");
        var user = { name: "admin",
        email: "la@metra.com"}
        $.ajax({
            type: "POST",
            data: JSON.stringify(user),
            dataType: 'json',
            contentType: "application/json",
            url: window.location + "add",
            success: function (data) {
                console.log(data);

            },
            error: function (e) {
                console.log("ERROR: ", e);
            }
        });
    });

})
$(document).ready(function () {

    function theWorks(elm) {
        if (elm.val() == "works") {
            $('#mush').prop("checked", "checked");
            $('#peppers').prop("checked", "checked");
            $('#sausage').prop("checked", "checked");
        } else {
            $('#works').removeProp("checked");
        }
    }

    $(':input[name="toppings"]').on("click", function () {
        theWorks($(this));
    });

    $('#myForm').submit(function () {
        var formError = false;
        var emailRegex = /@/;
        var customerRegex = /[\w\s]+/;
        if (!customerRegex.test($('#customerName').val())) {
            formError = true;
        } else if (!emailRegex.test($('#emailAddress').val())) {
            formError = true;
        } else if ($(':input[name="orderType"]:checked').val() == undefined) {
            formError = true;
        } else if ($(':input[name="toppings"]:checked').val() == undefined) {
            formError = true;
        } else if ($(':input[name="crust"] :selected').val() == "") {
            formError = true;
        } else {
            // work with the filled data here...
        }

        if (formError) {
            alert("One or more required fields missing!");
            return false;
        } else {
            alert("Form valid, submitting to server.");
            return true;
        }
    });
});
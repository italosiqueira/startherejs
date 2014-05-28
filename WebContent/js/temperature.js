$(document).ready(function () {
    $('#myForm').on('submit', function () {
        var inputTemp = $('#temp').val();
        var inputTempType = $('#tempType').val();
        // CSS Styling via jQuery
        if (inputTemp == "") {
            $('#temp').addClass('formErrorClass');
            return false;
        } else {
            $('#temp').removeClass('formErrorClass');
        }
        $.getJSON('TemperatureConverter',
        { "temp": inputTemp, "tempType": inputTempType },
        function (resp) {
            $("#result").text(resp["Temp"] + " " + resp["TempType"]);
            // CSS Styling via jQuery
            $("#result").css("background-color", "#00FF00");
        }).error(function () {
            $("#result").text('An unknown error has occurred.');
            // CSS Styling via jQuery
            $("#result").css("background-color", "#FF0000");
        });
        return false;
    });
    $('#temp').on('click', function () {
        $('#result').text("");
        // CSS Styling via jQuery
        $('#result').css("background-color", "");
        $('#temp').removeClass('formErrorClass');
    });
});
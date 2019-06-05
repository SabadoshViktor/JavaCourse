var getInput = function(input){
    var currentInput = '#employee_form ' + input['element'] + '[name=' + input['name'] + ']';
    return $(currentInput);

};

inputs.forEach(function (input) {

    var $currentInput = $(getInput(input));
    $($currentInput).focus(function(){
        $currentInput.parent().next().hide();
    });
});

var isFormValid = true;

inputs.forEach(function(input) {

    var $currentInput = $(getInput(input));
    if ($currentInput.val() == input['restrictedValue']) {
        isFormValid = false;
        $currentInput.parent().next().show();
    }


if (!isFormValid)
    return isFormValid;

});

var createEmployeeTable = function (employees) {
    var html = '';

    var mapPosition = {
        "1":"Worker",
        "2":"Manager",
        "3":"Coworker"
    };



    employees.forEach(function (employee) {
        html += '<tr>';
        html += '<th scope="row">' + employee.id + '</th>';
        html += '<td>' + employee.firstName + '</td>';
        html += '<td>' + employee.lastName + '</td>';
        html += '<td>' + employee.birthDate+ '</td>';

        var position = mapPosition[employee.position];
        html += '<td>' + position + '</td></tr>';

        /*      var position = '';
              switch (employee.position) {
                  case "1":
                      position = "Worker";
                      break;
                  case "2":
                      position = "Manager";
                      break;
                  case "3":
                      position = "Coworker";
                      break;
              }*/

    });

    return html;
};
$(document).ready(function () {
    var $employeeForm = $('#employee_form');
    $employeeForm.submit(function(event) {
        event.preventDefault();



        var inputs = [
            {
                element: 'input',
                name: 'firstName',
                restrictedValue: ''
            },
            {
                element: 'input',
                name: 'lastName',
                restrictedValue: ''
            },
            {
                element: 'input',
                name: 'birthDate',
                restrictedValue: ''
            },
            {
                element: 'select',
                name: 'position',
                restrictedValue: 0
            }
        ];

        inputs.forEach(function (input) {
            var $currentInput = getInput(input);
            $($currentInput).focus(function(){
                $currentInput.parent().next().hide();
            });
        });



        if (!isFormValid(inputs))
            return;

        $.ajax({
            url: "/employee",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify($employeeForm.serializeToJSON()),
            success: function(data) {
                alert("New employee created!!! Id=" + data);
                $('#id').val(data);
            },
            error: function() {
                alert("Creating new employee failed");
            }
        });
    });



  /*  var employees = [
        {   "id": 1,
            "firstName": "balabol",
            "lastName": "picha",
            "birthDate": "2019-05-24",
            "position": "1"
        },
        {
            "id": 2,
            "firstName": "potz",
            "lastName": "chuchu",
            "birthDate": "2019-05-24",
            "position": "2"
        },
        {
            "id": 3,
            "firstName": "rob",
            "lastName": "carl",
            "birthDate": "2019-05-24",
            "position": "1"
        },
        {
            "id": 4,
            "firstName": "mrtka",
            "lastName": "pula",
            "birthDate": "2019-05-24",
            "position": "1"
        }
    ];*/

  /*  var mapPosition = {
        "1":"Worker",
        "2":"Manager",
        "3":"Co-worker"
    };
  */



  /*  var employeePositions = [
        {
            value: 1,
            display: "Worker"
        },
        {
            value: 2,
            display: "Manager"
        },
        {
            value: 3,
            display: "Co-worker"
        }
    ];*/

     var mapPosition = createPositionMapper(employeePositions);
    var peremennaya = 'select#position';
    $.ajax({
        url: "/employee",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            $('table#employees tbody').html(createEmployeeTable(data,mapPosition));
        },
        error: function() {
            alert("Creating new employee failed");
        }
    });

    $.ajax({
        url: "/position",
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        success: function(data) {
            console.log(data);
            $(peremennaya).html(createSelectOptions(data, 'Please select employee roll'));
        },
        error: function() {
            alert("Creating new position failed");
        }
    });






    $('table#employees button[name=edit]').each(function () {
        $(this).click(function (event) {
            console.log(event.target.id.split("_")[1]);
        })
    });

});
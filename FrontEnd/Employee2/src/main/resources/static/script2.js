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
            },
            {
                element: 'input',
                name: 'manager',
                restrictedValue: ''
            }
        ];



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

    var employees = [
        {   "id": 1,
            "firstName": "Sava",
            "lastName": "Sdds",
            "birthDate": "2019-05-02",
            "manager": "sdafsdf",
            "position": "1"
        },
        {   "id": 2,
            "firstName": "Sava",
            "lastName": "Sdds",
            "birthDate": "2019-05-02",
            "manager": "sdafsdf",
            "position": "2"
        },
        {   "id": 3,
            "firstName": "Sava",
            "lastName": "Sdds",
            "birthDate": "2019-05-02",
            "manager": "sdafsdf",
            "position": "1"
        }
    ];





/*<tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
         <td>Worker</td>
    </tr>*/


    console.log('kuku');
    $('table#employees tbody').html(createEmployeeTable(employees));


});
$(document).ready(function () {



    $("h1").dblclick(function () {
        $("img.card-img-top").toggle();
    });

    $("input.input-forMe").mouseenter(function () {
        $(this).toggle();
    });

    $("input.input-forMe").mouseleave(function () {
        $(this).show();
    });



    // $("h1").mouseleave(function () {
    //     $("img.card-img-top").show();
    // });
    //
    // $("h1").mouseenter(function () {
    //     $("img.card-img-top").toggle();
    // });



    /*$("h1").dblclick(function () {
        $("img.card-img-top").toggle();
    });*/

  /*  $("h1").click(function () {
        $("img.card-img-top").hide();
    });*/

 /*   $("h1").click(function () {
        $(this).css("color" , "red");
    });*/



    /*    const onClick = function () {
            $(this).hide();
        };

        const onClick2 = function () {
            $("img.card-img-top").hide();
        };

        const onClick3 = function () {
            $("h1").hide();
        };*/


    /*   function onClick(){
           $(this).hide();
       };*/

    /*   $("h1").click(function () {
           $(this).hide();
       });
   */

    /*   $("h1").click(onClick2);
        $("i*!/mg.card-img-top").click(onClick3);
    });*/


    /*
    $(selector).action(function () {

    })*/
});
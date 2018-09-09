$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });

    setTimeout(function() {
        $('#messages li.info').fadeOut();
    }, 3000);


    $scope.firstName = "hohol"




});
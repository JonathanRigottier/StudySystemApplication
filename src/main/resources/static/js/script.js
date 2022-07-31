$(document).ready(function(){
    $(".alert-success, .alert-danger").fadeTo(5000, 1000).slideUp(1000, function () {
        $(".alert-success, .alert-danger").slideUp(1000);
    });
});
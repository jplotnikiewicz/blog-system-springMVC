var app = angular.module('app', []);


app.controller("homeController", ['$scope', '$http', function ($scope, $http) {

    var body = document.getElementsByClassName("content");
    var numberOfPosts = body.length;
    var shortBodies;
    for( index=0; numberOfPosts>index; index ++){
        var postBody = body[index].innerHTML;;
        var bodyLenght = postBody.length;
        var chars  = postBody.split("");
        var shortBody = "";
        var shortBodyLenght = 300;

        if(bodyLenght > 500){
            var i = 1;
            while (shortBody == ""){
                if(chars[shortBodyLenght] == ' ') {
                        shortBody = postBody.substring(0, shortBodyLenght);
                        shortBody = shortBody + " ...  ";
                        document.getElementsByClassName("content")[index].innerHTML = shortBody;
                }
                if(i%2 == 5) {
                    shortBodyLenght = shortBodyLenght + i;
                }else {
                    shortBodyLenght = shortBodyLenght - i;
                }
            }
        }
    }
}]);
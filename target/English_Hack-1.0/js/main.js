var url = location.href
var username = new URL(url).searchParams.get('username');

var user;

$(document).ready(function () {
    getUser().then(function(){
        $("#my-profil-btn").attr("href","profile.html?username="+username);
    });
        }           
);

async function getUser(){
      $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletGetUser",
        data: $.param({
            username: username
        }),
        success: function (result) {
            console.log(username);
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
               user = parsedResult;
               console.log(username);
            } else {
                console.log("Something was wrong, We can't get user info");
                
            }
        }
    });
}
$(document).ready(function(){
    $("#form-login").submit(function(event){
        event.preventDefault();
        autenticarUsuario();
    });
    $("#form-signup").submit(function (event) {
        event.preventDefault();
        userSignup();
    });
});

function autenticarUsuario(){
    let username = $("#user").val();
    let password = $("#password").val();
    $.ajax({
        type:"GET",
        dataType:"html",
        url:"./ServletUserLogin",
        data: $.param({
            username: username,
            password: password
        }),
        success: function(result){
           let parsedResult = JSON.parse(result);
           console.log(parsedResult);
           if(parsedResult != false){
               $("#login-error").addClass("d-none");
               let username = parsedResult['username'];
               document.location.href="home.html?username="+username;
           }
           else{
              $("#login-error").removeClass("d-none"); 
           }
        }
    });
}

 function userSignup(){
    let username = $("#input-user").val();
    let password = $("#input-password").val();
    let passwordrepeat = $("#input-password-repeat").val();
    let name = $("#input-name").val();
    let lastname = $("#input-lastname").val();
    let email = $("#input-email").val();
    if (password === passwordrepeat) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUserSignUp",
            data: $.param({
                username: username,
                password: password,
                name: name,
                lastname: lastname,
                email: email
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult != false) {
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];

                    document.location.href = "home.html?username=" + username;
                } else {
                    console.log("ya casi")
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Mistake in signup");
                }
            }
        });
    } else {
        console.log(username)
        $("#register-error").removeClass("d-none");
        $("#register-error").html("The passwords are different");
    }
}

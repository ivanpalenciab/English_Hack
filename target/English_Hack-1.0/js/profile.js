var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {
    showUser().then(function () {

    });
    //Delete account
    $("#aceptar-eliminar-cuenta-btn").click(function () {
        deleteAccount().then(function () {
            location.href = "index.html";
        });
    });
    //update account
    $("#form-update").on("submit", function (event) {

        event.preventDefault();
        updateUser();
    });

});
//Function showUser
async function showUser() {
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

                let showusername = "<p>" + parsedResult.username + "</p>";
                $("#user-profile").html(showusername);
                console.log(parsedResult.username);

                let showname = "<p>" + parsedResult.name + "</p>";
                $("#name-profile").html(showname);
                console.log(parsedResult.name);

                let showemail = "<p>" + parsedResult.email + "</p>";
                $("#email-profile").html(showemail);
                console.log(parsedResult.email);

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.password);
                $("#input-nombre").val(parsedResult.name);
                $("#input-apellidos").val(parsedResult.lastname);
                $("#input-email").val(parsedResult.email);

            } else {
                console.log("Something was wrong, We can't get user info");

            }
        }
    });
}

//Delete account Function
async function deleteAccount() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUserDelete",
        data: $.param({
            username: username
        }),
        success: function (result) {
            console.log("estas aqui")

            if (result != false) {

                console.log("User Deleted")

            } else {
                console.log("Something was  wrong deleting account");
            }
        }
    });
}
//update function
function updateUser() {
    let username = $("#input-username").val();
    let password = $("#input-contrasena").val();
    let name = $("#input-nombre").val();
    let lastname = $("#input-apellidos").val();
    let email = $("#input-email").val();
     $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUserUpdate",
        data: $.param({
            username: username,
            password: password,
            name: name,
            lastname: lastname,
            email: email
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });
   
    }
var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {
    $("#form-lesson1").submit(function(event){
        event.preventDefault();
        calificationLesson1();
    });
    
        });


function calificationLesson1(){
    let question1_1 = $("#1-1").val();
    let question1_2 = $("#1-2").val();
    let question1_3 = $("#1-3").val();
    let question1_4 = $("#1-4").val();
    let question1_5 = $("#1-5").val();
    
    grade =0;
    finished = 0;
    if (question1_1==="your"){
        grade +=1;
    }
    if (question1_2==="yours"){
        grade +=1;
    }
    if (question1_3==="nice"){
        grade +=1;
    }
    if (question1_4==="meet"){
        grade +=1;
    }
    if (question1_5==="likewise"){
        grade +=1;
    }
    if (grade >=3){
        finished = 1;
    }
    
       $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletLessonGrade",
            data: $.param({
                username: username,
                lessonId: lessonId,
                finished: finished,
                grade: grade
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
}
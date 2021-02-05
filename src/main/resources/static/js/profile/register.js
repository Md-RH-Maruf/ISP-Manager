

function register() {
    let memberId = $("#memberId").val().trim();
    let memberType = $("#memberType").val().trim();
    let userName = $("#userName").val().trim();
    let password = $("#password").val().trim();
    let repeatPassword = $("#repeatPassword").val().trim();

    if (memberId != '') {
        if (memberType != 0) {
            if (userName != '') {
                if (password != '') {
                    if (password === repeatPassword) {
                       
                        $.ajax({
                            type: 'POST',
                            dataType: 'json',
                            url: './registerNewUser',
                            data: {
                                memberId : memberId,
                                username : userName,
                                password : password,
                                userType : memberType
                            },
                            success: function (data) {
                                console.log(data);
                                if(data.result == "success"){
                                    successAlert("User Create Successfully")
                                    var url = "login";
                                    window.open(url, '_self');
                                }else{
                                    dangerAlert(data.result);
                                }
                            }
                        });
                    } else {
                        dangerAlert("Confirm Password don't Match");
                        $("#repeatPassword").focus();
                    }
                } else {
                    warningAlert("Password is Empty... Please provide a password");
                    $("#password").focus();
                }

            } else {
                warningAlert("User Name is empty.. Please Enter User Name");
                $("#userName").focus();
            }
        } else {
            warningAlert("Member Type Not Selected... Please Select Member Type");
            $("#memberType").focus();
        }
    } else {
        warningAlert("Member Id is Empty... Please Fill Out Member Id");
        $("#memberId").focus();
    }

}
function submitRequest() {
    let customerName = $("#customerName").val();
    let area = $("#area").val();
    let contactPerson = $("#contactPerson").val();
    let contactNo = $("#contactNo").val();
    let address = $("#address").val();
    let package = $("#package").val();
    let otc = $("#otc").val();
    let mrc = $("#mrc").val();
    let promissDate = $("#promiseDate").val();
    let reference = $("#reference").val();
    let connectionType = $("#connectionType").val();
    let note = $("#note").val();
    if (customerName != '') {
        if (area != '') {
            if (contactPerson != '0') {
                if (contactNo != '0') {
                    if (package != '0') {
                        if (confirm("Are you sure to Submit Activation Request?")) {
                            $.ajax({
                                type: 'POST',
                                dataType: 'json',
                                url: '/submitActivationTMSRequest',
                                data: {
                                    
                                        name: customerName,
                                        area: area,
                                        keyPerson: contactPerson,
                                        contactNo: contactNo,
                                        address: address,
                                        packageId: package,
                                        otc: otc,
                                        mrc: mrc,
                                        reference: reference,
                                        connectionType: connectionType,
                                        note: note,
                                        promissDate: promissDate
                                     
                                },
                                success: function (data) {
                                    if (data.result == "something wrong") {
                                        dangerAlert("Something went wrong");
                                    } else if (data.result == "duplicate") {
                                        dangerAlert("Duplicate ConnectionPoint Name..This ConnectionPoint Name Allreary Exist")
                                    } else {
                    
                                        if (data.result == "successfull") {
                                            alert("Activation Request Submit Successfully");
                                            let url = "http://localhost:8080/support/activation-ticket-list";
                                            window.open(url, '_self');
                                        } else {
                                            dangerAlert("Something went wrong");
                                        }
                    
                                    }
                                }
                            });
                        }
                    } else {
                        warningAlert("Package is not selected...Please Select Package");
                        $("#package").val();
                    }
                } else {
                    warningAlert("Contact No is Empty...Please Enter Contact No");
                    $("#contactNo").val();
                }
            } else {
                warningAlert("Contact Person is Empty...Please Enter Contact Person");
                $("#contactPerson").val();
            }
        } else {
            warningAlert("Area Name is Empty...Please Enter Area Name");
            $("#area").val();
        }
    } else {
        warningAlert("Customer Name is Empty...Please Enter Customer Name");
        $("#customerName").val();
    }
    

}

let today = new Date();
document.getElementById("promiseDate").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
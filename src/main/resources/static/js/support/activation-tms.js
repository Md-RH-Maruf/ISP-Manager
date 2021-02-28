function submitRequest() {
    let customerName = $("#customerName").val();
    let area = $("#area").val();
    let contactPerson = $("#contactPerson").val();
    let contactNo = $("#contactNo").val();
    let address = $("#address").val();
    let package = $("#package").val();
    let otc = $("#otc").val();
    let mrc = $("#mrc").val();
    let promissDate = $("#promissDate").val();
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
                                    customerName: customerName,
                                    area: area,
                                    contactPerson: contactPerson,
                                    contactNo: contactNo,
                                    address: address,
                                    packageId: package,
                                    otc: otc,
                                    mrc: mrc,
                                    promissDate: promissDate
                                },
                                success: function (data) {
                                    if (data.result == "Something Wrong") {
                                        dangerAlert("Something went wrong");
                                    } else if (data.result == "duplicate") {
                                        dangerAlert("Duplicate ConnectionPoint Name..This ConnectionPoint Name Allreary Exist")
                                    } else {
                    
                                        if (data.result.id) {
                                            alert("Activation Request Submit Successfully");
                                            location.reload();
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
function submitComplain() {
    let customerId = $("#customerId").val()
    let problemType = $("#problemType").val()
    let customerName = $("#customerName").val();
    let area = $("#area").val();
    let complainDetails = $("#complainDetails").val();
    let priority = $("#contactNo").val();


    if (problemType != '') {
        if (customerName != '') {

            if (confirm("Are you sure to Submit Complain?")) {
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/submitComplainTMS',
                    data: {
                        customerId: customerId,
                        problemType: problemType,
                        customerName: customerName,
                        area: area,
                        complainDetails: complainDetails,
                        priority: priority
                    },
                    success: function (data) {
                        if (data.result == "Something Wrong") {
                            dangerAlert("Something went wrong");
                        } else if (data.result == "duplicate") {
                            dangerAlert("Duplicate ConnectionPoint Name..This ConnectionPoint Name Allreary Exist")
                        } else {

                            if (data.result.id) {
                                alert("Complain TMS Submit Successfully");
                                location.reload();
                            } else {
                                dangerAlert("Something went wrong");
                            }

                        }
                    }
                });
            }

        } else {
            warningAlert("Customer Name is Empty...Please Enter Customer Name");
            $("#customerName").val();
        }
    } else {
        warningAlert("Problem Type is Empty...Please Enter Problem Type");
        $("#problemType").val();
    }

}
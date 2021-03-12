
function searchAction(){
    let customerId = $("#customerId").val();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getCustomerComplainHistory',
        data: {
          customerId : customerId
        },
        success: function (data) {
         
          let customer = data.customer;
          $("#customerName").val(customer.name);
          $("#contactNumber").val(customer.popName);
          $("#area").val(customer.area);
          $("#address").val(customer.address);
            $("#accountStatus").val(customer.activeStatus==1?"Active":"Inactive");
            let currentDate  = new Date();
            let expireDate = new Date(customer.expireDate);
            if(expireDate<currentDate){
                $("#connectionStatus").val("Deactive");
            }else{
                $("#connectionStatus").val("Active");
            }
           
        }
      });
}

function submitComplain() {
    let customerId = $("#customerId").val()
    let problemType = $("#problemType").val()
    let customerName = $("#customerName").val();
    let area = $("#area").val();
    let complainDetails = $("#complainDetails").val();
    let priority = $("#priority").val();


    if (problemType != '') {
        if (customerName != '') {

            if (confirm("Are you sure to Submit Complain?")) {
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/submitComplainTMS',
                    data: {
                        customerId: customerId,
                        subject : customerId+"_"+customerName,
                        problemType: problemType,
                        complainDetails: complainDetails,
                        status: "OPEN",
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
                               
                                let url = "http://localhost:8080/support/complain-ticket-list";
                                window.open(url, '_self');
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
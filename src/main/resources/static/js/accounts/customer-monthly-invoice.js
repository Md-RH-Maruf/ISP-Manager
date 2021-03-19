window.onload = () => {
    document.title = "Monthly Invoice";
  
  }
function searchAction(){
    let customerId = $("#customerId").val();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getCustomerInfo',
        data: {
          customerId : customerId
        },
        success: function (data) {
            console.log(data.customerInfo);
            console.log(data.serviceInfo);
          let customer = data.customerInfo;
          let package = data.serviceInfo;
          $("#customerName").val(customer.name);
          $("#contactNumber").val(customer.popName);
          $("#area").val(customer.area);
          $("#package").val(package.serviceName);
          $("#price").val(package.servicePrice);
          $("#activeDate").val(customer.expireDate);
        let expireDate = new Date(customer.expireDate);
            if(expireDate<currentDate){
                $("#connectionStatus").val("Deactive");
            }else{
                $("#connectionStatus").val("Active");
            }
           
        }
      });
}


function submitInvoice(){
    let customerId = $("#customerId").val();
    let amount = $("#amount").val();
    let activeDate = $("#activeDate").val();
    if(customerId != ''){
        if (amount > 0 || amount != '') {
            if (activeDate) {
               
                if (confirm("Are you Sure to submit This Invoice?")) {
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: '/submitMonthlyInvoice',
                        data: {
                            customerId: customerId,
                            amount: amount,
                            activeDate: activeDate
                        },
                        success: function (data) {
                            if (data.result == 'successfull') {
                                alert("Monthly Invoice Submit Successfully");
                                let url = "http://localhost:8080/accounts/customer-bill-info";
                                window.open(url, '_self');
                            } else {
                                warningAlert(data.message);
                            }

                        }
                    });
                }

            } else {
                warningAlert("Please Activate Date");
            }
        
    } else {
        warningAlert("Please Enter Amount");
    }
    }else{
        warningAlert("Please Enter Customer Id ");
    }
    

}

let today = new Date();
let currentDate = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
document.getElementById("billDate").value = currentDate;
let activeDate = today.getFullYear() + '-' + ('0' + (today.getMonth() + 2)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
document.getElementById("activeDate").value = activeDate;
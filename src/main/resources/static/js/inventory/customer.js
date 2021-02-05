window.onload = () => {
    document.title = "Customer Create";
  
  }

  
function setCustomerData(id) {
  
    $.ajax({
      type: 'GET',
      dataType: 'json',
      url: '/getCustomer',
      data: {
        id : id
      },
      success: function (data) {
        console.log(data)
        let customer = data.customerInfo;
        $("#customerAutoId").val(customer.id);
        $("#customerId").val(customer.customerId);
        $("#customerName").val(customer.name);
        $("#companyName").val(customer.companyName);
        $("#keyPerson").val(customer.keyPerson);
        $("#address").val(customer.address);
        $("#email").val(customer.email);
        $("#contactNo").val(customer.contactNo);
        $("#customerType").val(customer.customerType);
        $("#serviceStartDate").val(customer.serviceStartDate);
        $("#activeStatus").val(customer.status);
        $("#reference").val(customer.reference);
        
      }
    });
  
    $("#btnSave").hide();
    $("#btnEdit").show();
  
  }

  function saveAction() {
    
    let customerName = $("#customerName").val();
    let companyName = $("#companyName").val();
    let keyPerson = $("#keyPerson").val();
    let address = $("#address").val();
    let email = $("#email").val();
    let contactNo = $("#contactNo").val();
    let customerType = $("#customerType").val();
    let serviceStartDate = $("#serviceStartDate").val();
    let activeStatus = $("#activeStatus").val();
    let reference = $("#reference").val();
  
    if (customerName != '') {
        if (serviceStartDate) {
            if(confirm("Are you sure to save Customer?")){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/saveCustomer',
                    data: {
                        name: customerName,
                        companyName : companyName,
                        keyPerson: keyPerson,
                        address: address,
                        email: email,
                        contactNo: contactNo,
                        customerType: customerType,
                        serviceStartDate: serviceStartDate,
                        status: activeStatus,
                        reference: reference
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Customer Name..This Customer Name Allreary Exist")
                      } else {
              
                        if (data.result.customerId) {
                          successAlert("Customer Save Successfully");
                          $("#customerList").empty();
                          $("#customerList").append(drawCustomerTable(data.customerList));
                        } else {
                          dangerAlert("Something went wrong");
                        }
              
                      }
                    }
                  });
            }
     
    } else {
        warningAlert("Service Start Date is empty... Please Select Service start date");
        $("#serviceStartDate").val();
      }
    } else {
      warningAlert("Empty Customer Name... Please Enter Customer Name Name");
      $("#customerName").val();
    }
  }

  function editAction() {
    
    let id = $("#customerAutoId").val();
    let customerId = $("#customerId").val();
    let customerName = $("#customerName").val();
    let companyName = $("#companyName").val();
    let keyPerson = $("#keyPerson").val();
    let address = $("#address").val();
    let email = $("#email").val();
    let contactNo = $("#contactNo").val();
    let customerType = $("#customerType").val();
    let serviceStartDate = $("#serviceStartDate").val();
    let activeStatus = $("#activeStatus").val();
    let reference = $("#reference").val();
  
    if (customerName != '') {
        if (serviceStartDate) {
            if(confirm("Are you sure to Edit Customer?")){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/editCustomer',
                    data: {
                        id : id,
                        customerId : customerId,
                        name: customerName,
                        companyName : companyName,
                        keyPerson: keyPerson,
                        address: address,
                        email: email,
                        contactNo: contactNo,
                        customerType: customerType,
                        serviceStartDate: serviceStartDate,
                        status: activeStatus,
                        reference: reference
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Customer Name..This Customer Name Allreary Exist")
                      } else {
              
                        if (data.result.customerId) {
                          successAlert("Customer Save Successfully");
                          $("#customerList").empty();
                          $("#customerList").append(drawCustomerTable(data.customerList));
                        } else {
                          dangerAlert("Something went wrong");
                        }
              
                      }
                    }
                  });
            }
     
    } else {
        warningAlert("Service Start Date is empty... Please Select Service start date");
        $("#serviceStartDate").focus();
      }
    } else {
      warningAlert("Empty Customer Name... Please Enter Customer Name Name");
      $("#customerName").focus();
    }
  }

  function refreshAction(){
      location.reload();
  }

  function drawCustomerTable(data) {
    let rows = "";
    let length = data.length;
  
    for (let i = 0; i < length; i++) {
        let customer = data[i];
      rows += `<tr style="cursor: pointer;"
      onclick="setCustomerData('${customer.id}')">
      <td>${customer.customerId}</td>
      <td>${customer.name}</td>
      <td>${customer.customerType }</td>
      <td>${customer.status }</td>
  </tr>`
    }
  
    return rows;
  }
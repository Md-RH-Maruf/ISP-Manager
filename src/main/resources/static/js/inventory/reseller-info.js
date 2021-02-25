window.onload = () => {
    document.title = "Reseller Create";
  
  }

  
function setResellerData(id) {
  
    $.ajax({
      type: 'GET',
      dataType: 'json',
      url: '/getReseller',
      data: {
        id : id
      },
      success: function (data) {
        console.log(data)
        let reseller = data.resellerInfo;
        $("#resellerAutoId").val(reseller.id);
        $("#resellerId").val(reseller.resellerId);
        $("#resellerName").val(reseller.name);
        $("#companyName").val(reseller.companyName);
        $("#keyPerson").val(reseller.keyPerson);
        $("#address").val(reseller.address);
        $("#email").val(reseller.email);
        $("#contactNo").val(reseller.contactNo);
        $("#resellerType").val(reseller.resellerType);
        $("#serviceStartDate").val(reseller.serviceStartDate);
        $("#activeStatus").val(reseller.status);
        $("#reference").val(reseller.reference);
        
      }
    });
  
    $("#btnSave").hide();
    $("#btnEdit").show();
  
  }

  function saveAction() {
    
    let resellerName = $("#resellerName").val();
    let companyName = $("#companyName").val();
    let keyPerson = $("#keyPerson").val();
    let address = $("#address").val();
    let email = $("#email").val();
    let contactNo = $("#contactNo").val();
    let resellerType = $("#resellerType").val();
    let serviceStartDate = $("#serviceStartDate").val();
    let activeStatus = $("#activeStatus").val();
    let reference = $("#reference").val();
  
    if (resellerName != '') {
        if (serviceStartDate) {
            if(confirm("Are you sure to save Reseller?")){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/saveReseller',
                    data: {
                        name: resellerName,
                        companyName : companyName,
                        keyPerson: keyPerson,
                        address: address,
                        email: email,
                        contactNo: contactNo,
                        resellerType: resellerType,
                        serviceStartDate: serviceStartDate,
                        status: activeStatus,
                        reference: reference
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Reseller Name..This Reseller Name Allreary Exist")
                      } else {
              
                        if (data.result.resellerId) {
                          successAlert("Reseller Save Successfully");
                          $("#resellerList").empty();
                          $("#resellerList").append(drawResellerTable(data.resellerList));
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
      warningAlert("Empty Reseller Name... Please Enter Reseller Name Name");
      $("#resellerName").val();
    }
  }

  function editAction() {
    
    let id = $("#resellerAutoId").val();
    let resellerId = $("#resellerId").val();
    let resellerName = $("#resellerName").val();
    let companyName = $("#companyName").val();
    let keyPerson = $("#keyPerson").val();
    let address = $("#address").val();
    let email = $("#email").val();
    let contactNo = $("#contactNo").val();
    let resellerType = $("#resellerType").val();
    let serviceStartDate = $("#serviceStartDate").val();
    let activeStatus = $("#activeStatus").val();
    let reference = $("#reference").val();
  
    if (resellerName != '') {
        if (serviceStartDate) {
            if(confirm("Are you sure to Edit Reseller?")){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/editReseller',
                    data: {
                        id : id,
                        resellerId : resellerId,
                        name: resellerName,
                        companyName : companyName,
                        keyPerson: keyPerson,
                        address: address,
                        email: email,
                        contactNo: contactNo,
                        resellerType: resellerType,
                        serviceStartDate: serviceStartDate,
                        status: activeStatus,
                        reference: reference
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Reseller Name..This Reseller Name Allreary Exist")
                      } else {
              
                        if (data.result.resellerId) {
                          successAlert("Reseller Edit Successfully");
                          $("#resellerList").empty();
                          $("#resellerList").append(drawResellerTable(data.resellerList));
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
      warningAlert("Empty Reseller Name... Please Enter Reseller Name Name");
      $("#resellerName").focus();
    }
  }

  function refreshAction(){
      location.reload();
  }

  function drawResellerTable(data) {
    let rows = "";
    let length = data.length;
  
    for (let i = 0; i < length; i++) {
        let reseller = data[i];
      rows += `<tr style="cursor: pointer;"
      onclick="setResellerData('${reseller.id}')">
      <td>${reseller.resellerId}</td>
      <td>${reseller.name}</td>
      <td>${reseller.resellerType }</td>
      <td>${reseller.status }</td>
  </tr>`
    }
  
    return rows;
  }
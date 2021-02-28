window.onload = () => {
    document.title = "Service Create";
  
  }

   
function setServiceData(id) {
  
    $.ajax({
      type: 'GET',
      dataType: 'json',
      url: '/getService',
      data: {
        id : id
      },
      success: function (data) {
        console.log(data)
        let service = data.serviceInfo;
        $("#serviceAutoId").val(service.id);
        $("#serviceName").val(service.serviceName);
        $("#servicePrice").val(service.servicePrice);
        $("#serviceVat").val(service.serviceVat);
        $("#activeStatus").val(service.activeStatus);
      }
    });
  
    $("#btnSave").hide();
    $("#btnEdit").show();
  
  }
  function saveAction() {
    
    let serviceName = $("#serviceName").val();
    let servicePrice = $("#servicePrice").val();
    let serviceVat = $("#serviceVat").val()==''?0:$("#serviceVat").val();
    let activeStatus = $("#activeStatus").val();
   
    if (serviceName != '') {
        if (servicePrice) {
            if(confirm("Are you sure to save Service?")){
             
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/saveService',
                    data: {
                        serviceName: serviceName,
                        servicePrice : servicePrice,
                        serviceVat: serviceVat,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Service Name..This Service Name Allreary Exist")
                      } else {
              
                        if (data.result.serviceName) {
                          successAlert("Service Save Successfully");
                          $("#serviceList").empty();
                          $("#serviceList").append(drawServiceTable(data.serviceList));
                        } else {
                          dangerAlert("Something went wrong");
                        }
              
                      }
                    }
                  });
            }
     
    } else {
        warningAlert("Service Price Date is empty... Please Select Service Price");
        $("#servicePrice").val();
      }
    } else {
      warningAlert("Empty Service Name... Please Enter Sevice Name");
      $("#serviceName").val();
    }
  }

  function editAction() {
    let id = $("#serviceAutoId").val();
    let serviceName = $("#serviceName").val();
    let servicePrice = $("#servicePrice").val();
    let serviceVat = $("#serviceVat").val();
    let activeStatus = $("#activeStatus").val();
   
    if (serviceName != '') {
        if (servicePrice) {
            if(confirm("Are you sure to edit Service?")){
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/editService',
                    data: {
                        id : id,
                        serviceName: serviceName,
                        servicePrice : servicePrice,
                        serviceVat: serviceVat,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                      if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                      } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Service Name..This Service Name Allreary Exist")
                      } else {
              
                        if (data.result.serviceName) {
                          successAlert("Service Edit Successfully");
                          $("#serviceList").empty();
                          $("#serviceList").append(drawServiceTable(data.serviceList));
                        } else {
                          dangerAlert("Something went wrong");
                        }
              
                      }
                    }
                  });
            }
     
    } else {
        warningAlert("Service Price Date is empty... Please Select Service Price");
        $("#servicePrice").val();
      }
    } else {
      warningAlert("Empty Service Name... Please Enter Sevice Name");
      $("#serviceName").val();
    }
  }

  function refreshAction(){
    location.reload();
}

function drawServiceTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
      let service = data[i];
    rows += `<tr style="cursor: pointer;"
    onclick="setServiceData('${service.id}')">
    <td>${service.id}</td>
    <td>${service.serviceName}</td>
    <td>${service.servicePrice }</td>
    <td>${service.activeStatus }</td>
</tr>`
  }

  return rows;
}
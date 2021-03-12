window.onload = () => {
  document.title = "Customer Details Create";
}

function setCustomerData(customerId) {
  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getCustomerDetails',
    data: {
      customerId: customerId
    },
    success: function (data) {
      
        let customer = data.customerDetails;
        $("#customerId").val(customer.customerId);
        $("#connectionPoint").val(customer.connectionPoint);
        $("#ipAddress").val(customer.ipAddress);
        $("#onuMac").val(customer.onuMac);
        $("#onuInterface").val(customer.onuInterface);
        $("#clientMac").val(customer.clientMac);
        $("#latLong").val(customer.latLong);
        $("#connectionStatus").val(customer.connectionStatus);

        $("#btnSave").hide();
        $("#btnEdit").show();

        $("#exampleModal").modal('show');
      
    }
  });


}


function editAction() {
  let customerId = $("#customerId").val();
  let connectionPoint = $("#connectionPoint").val();
  let ipAddress = $("#ipAddress").val();
  let onuMac =  $("#onuMac").val();
  let onuInterface = $("#onuInterface").val();
  let clientMac =  $("#clientMac").val();
  let latLong = $("#latLong").val();
  let connectionStatus = $("#connectionStatus").val();

  
      if (confirm("Are you sure to Edit Customer Details?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/editCustomerDetails',
          data: {
            customerId: customerId,
            connectionPoint: connectionPoint,
            ipAddress: ipAddress,
            onuMac: onuMac,
            onuInterface: onuInterface,
            clientMac: clientMac,
            latLong: latLong,
            connectionStatus: connectionStatus
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Customer Details Name..This Customer Details Name Allreary Exist")
            } else {

              if (data.result.id) {
                alert("Customer Details Edit Successfully");
                $('#customerDetailsTable').dataTable().fnDestroy();
                $("#customerDetailsList").empty();
                $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                $('#customerDetailsTable').DataTable(({
                  "destroy": true,
                }));
                $("#exampleModal").modal('hide');
              } else {
                alert("Something went wrong");
              }

            }
          }
        });
      }
   
}

function refreshAction() {
  location.reload();
}

$(document).ready(function () {
  $('#customerDetailsTable').DataTable();
});

function drawCustomerDetailsTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let customer = data[i];
    rows += `<tr>
    <td>${i+1}</td>
    <td id="customerId-${customer.id}">${customer.customerId}</td>
    <td id="customerName-${customer.id}">${customer.name }</td>
    <td>${customer.connectionPoint }</td>
    <td>${customer.ipAddress }</td>
    <td>${customer.onuMac }</td>
    <td>${customer.onuInterface }</td>
    <td>${customer.connectionStatus }</td>
    <td><i class="fa fa-edit" style="cursor: pointer;"
      onclick="setCustomerData('${customer.customerId}')"> </i></td>
  </tr>`
  }

  return rows;
}
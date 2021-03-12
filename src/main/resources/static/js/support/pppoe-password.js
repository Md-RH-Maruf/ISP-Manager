window.onload = () => {
  document.title = "Customer Details";

}


function setPPPoEData(id) {
  $("#pppoeAutoId").val(id);
  $("#customerId").val($("#customerId-"+id).text());
  $("#customerName").val($("#customerName-"+id).text());
  $("#pppoeId").val($("#pppoeId-"+id).text());
  $("#pppoePassword").val($("#pppoePassword-"+id).text());
 
  $("#btnSave").hide();
  $("#btnEdit").show();

  $("#exampleModal").modal('show');
}


function editAction() {
  let id = $("#pppoeAutoId").val();
  let customerId = $("#customerId").val();
  let pppoeId = $("#pppoeId").val().trim();
  let pppoePassword = $("#pppoePassword").val().trim();

  if (pppoeId != '') {
    if (pppoePassword != '') {
    if (confirm("Are you sure to Edit PPPoE And Password?")) {
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/editPPPoEAndPasswordInfo',
        data: {
          id: id,
          customerId: customerId,
          pppoeId: pppoeId,
          password: pppoePassword
        },
        success: function (data) {
          if (data.result == "Something Wrong") {
            alert("Something went wrong");
          } else if (data.result == "duplicate") {
            alert("Duplicate PPPoEAndPassword Name..This PPPoEAndPassword Name Allreary Exist")
          } else {

            if (data.result.id) {
              alert("PPPoEAndPassword Edit Successfully");
              $('#ppoePasswordInfoTable').dataTable().fnDestroy();
              $("#ppoeIdPasswordList").empty();
              $("#ppoeIdPasswordList").append(drawPPPoEAndPasswordTable(data.ppoePasswordInfoList));
              $('#ppoePasswordInfoTable').DataTable(({
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
  } else {
    alert("Empty PPPoE Password ... Please Select PPPoE Password");
    $("#pppoePassword").focus();
  }
  } else {
    alert("Empty PPPoE ID ... Please Select PPPoE Id");
    $("#pppoeId").focus();
  }
}

function refreshAction() {
  location.reload();
}

$(document).ready(function () {
  $('#ppoePasswordInfoTable').DataTable();
});

function drawPPPoEAndPasswordTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let ppoe = data[i];
    rows += `<tr >
    <td>${i+1}</td>
    <td id="customerId-${ppoe.id}">${ppoe.customerId}</td>
    <td id="customerName-${ppoe.id}">${ppoe.customerName }</td>
    <td id="pppoeId-${ppoe.id}">${ppoe.pppoeId }</td>
    <td id="pppoePassword-${ppoe.id}">${ppoe.pppoePassword }</td>
    <td><i class="fa fa-edit" style="cursor: pointer;"
    onclick="setPPPoEData('${ppoe.id}')"> </i></td>	
  </tr>`
  }

  return rows;
}
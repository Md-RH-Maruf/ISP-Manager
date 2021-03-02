window.onload = () => {
  document.title = "Mc Create";

}


function setMcData(id) {
  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getMcInfo',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let mc = data.mcInfo;
      $("#mcAutoId").val(mc.id);
      $("#popName").val(mc.popName);
      $("#rackNo").val(mc.rackNo);
      $("#chassiNo").val(mc.chassiNo);
      $("#clientName").val(mc.clientName);
      $("#switchPortNo").val(mc.switchPortNo);
      $("#switchNo").val(mc.switchNo);
      $("#exampleModal").modal('show');
    }
  });
  $("#btnSave").hide();
  $("#btnEdit").show();
}

function saveAction() {

  let popName = $("#popName").val();
  let rackNo = $("#rackNo").val();
  let chassiNo = $("#chassiNo").val();
  let clientName = $("#clientName").val();
  let switchPortNo = $("#switchPortNo").val();
  let switchNo = $("#switchNo").val();

  if ((popName + rackNo +chassiNo) != '') {
    
      if (confirm("Are you sure to save MC?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/saveMcInfo',
          data: {
            popName: popName,
            rackNo: rackNo,
            chassiNo: chassiNo,
            clientName: clientName,
            switchPortNo: switchPortNo,
            switchNo: switchNo
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Mc Name..This Mc Name Allreary Exist")
            } else {

              if (data.result.id) {
                alert("Mc Save Successfully");
                $('#mcInfoTable').dataTable().fnDestroy();
                $("#mcList").empty();
                $("#mcList").append(drawMcTable(data.mcInfoList));
                $('#mcInfoTable').DataTable(({ 
                  "destroy": true, 
                }));
              } else {
                alert("Something went wrong");
              }

            }
          }
        });
      }

    
  } else {
    alert("Empty Mc Name... Please Enter Mc Name Name");
    $("#mcName").val();
  }
}

function editAction() {

  let id = $("#mcAutoId").val();
  let popName = $("#popName").val();
  let rackNo = $("#rackNo").val();
  let chassiNo = $("#chassiNo").val();
  let clientName = $("#clientName").val();
  let switchPortNo = $("#switchPortNo").val();
  let switchNo = $("#switchNo").val();
 

  if ((popName + rackNo +chassiNo) != '') {
    
      if (confirm("Are you sure to Edit Mc?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/editMcInfo',
          data: {
            id: id,
            popName: popName,
            rackNo: rackNo,
            chassiNo: chassiNo,
            clientName: clientName,
            switchPortNo: switchPortNo,
            switchNo: switchNo
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Mc Name..This Mc Name Allreary Exist")
            } else {

              if (data.result.id) {
                alert("Mc Edit Successfully");
                $('#mcInfoTable').dataTable().fnDestroy();
                $("#mcList").empty();
                $("#mcList").append(drawMcTable(data.mcInfoList));
                $('#mcInfoTable').DataTable(({ 
                  "destroy": true, 
                }));
              } else {
                alert("Something went wrong");
              }

            }
          }
        });
      }
  } else {
    alert("Empty Mc Name... Please Enter Mc Name Name");
    $("#mcName").focus();
  }
}

function newClickAction() {
  $("#mcAutoId").val('');
      $("#popName").val('');
      $("#rackNo").val('');
      $("#chassiNo").val('');
      $("#clientName").val('');
      $("#switchPortNo").val('');
      $("#switchNo").val('');

  $("#btnSave").show();
  $("#btnEdit").hide();
}

function refreshAction() {
  location.reload();
}

$(document).ready(function () {
  $('#mcInfoTable').DataTable();
});

function drawMcTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let mc = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setMcData('${mc.id}')">
      <td>${mc.popName}</td>
      <td>${mc.rackNo }</td>
      <td>${mc.chassiNo }</td>
      <td>${mc.clientName }</td>
      <td>${mc.switchPortNo}</td>
      <td>${mc.switchNo}</td>
  </tr>`
  }

  return rows;
}
window.onload = () => {
  document.title = "PPPoEAndPassword Create";

}


function setBillData(id) {
  $("#exampleModal").modal('show');
  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getBillInfo',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let ppoePassword = data.ppoePasswordInfo;
      $("#ppoePasswordAutoId").val(ppoePassword.id);
      $("#popName").val(ppoePassword.popName);
      $("#rackNo").val(ppoePassword.rackNo);
      $("#chassiNo").val(ppoePassword.chassiNo);
      $("#clientName").val(ppoePassword.clientName);
      $("#switchPortNo").val(ppoePassword.switchPortNo);
      $("#switchNo").val(ppoePassword.switchNo);
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

  if ((popName + rackNo + chassiNo) != '') {

    if (confirm("Are you sure to save MC?")) {
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/savePPPoEAndPasswordInfo',
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
            alert("Duplicate PPPoEAndPassword Name..This PPPoEAndPassword Name Allreary Exist")
          } else {
            ///
            if (data.result.id) {
              alert("PPPoEAndPassword Save Successfully");
              $('#ppoePasswordInfoTable').dataTable().fnDestroy();
              $("#ppoePasswordList").empty();
              $("#ppoePasswordList").append(drawPPPoEAndPasswordTable(data.ppoePasswordInfoList));
              $('#ppoePasswordInfoTable').DataTable(({
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
    alert("Empty PPPoEAndPassword Name... Please Enter PPPoEAndPassword Name Name");
    $("#ppoePasswordName").val();
  }
}

function editAction() {

  let id = $("#ppoePasswordAutoId").val();
  let popName = $("#popName").val();
  let rackNo = $("#rackNo").val();
  let chassiNo = $("#chassiNo").val();
  let clientName = $("#clientName").val();
  let switchPortNo = $("#switchPortNo").val();
  let switchNo = $("#switchNo").val();


  if ((popName + rackNo + chassiNo) != '') {

    if (confirm("Are you sure to Edit PPPoEAndPassword?")) {
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '/editPPPoEAndPasswordInfo',
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
            alert("Duplicate PPPoEAndPassword Name..This PPPoEAndPassword Name Allreary Exist")
          } else {

            if (data.result.id) {
              alert("PPPoEAndPassword Edit Successfully");
              $('#ppoePasswordInfoTable').dataTable().fnDestroy();
              $("#ppoePasswordList").empty();
              $("#ppoePasswordList").append(drawPPPoEAndPasswordTable(data.ppoePasswordInfoList));
              $('#ppoePasswordInfoTable').DataTable(({
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
    alert("Empty PPPoEAndPassword Name... Please Enter PPPoEAndPassword Name Name");
    $("#ppoePasswordName").focus();
  }
}

function newClickAction() {
  $("#ppoePasswordAutoId").val('');
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
  $('#ppoePasswordInfoTable').DataTable();
});

function drawPPPoEAndPasswordTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let ppoePassword = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setPPPoEAndPasswordData('${ppoePassword.id}')">
      <td>${ppoePassword.popName}</td>
      <td>${ppoePassword.rackNo}</td>
      <td>${ppoePassword.chassiNo}</td>
      <td>${ppoePassword.clientName}</td>
      <td>${ppoePassword.switchPortNo}</td>
      <td>${ppoePassword.switchNo}</td>
  </tr>`
  }

  return rows;
}
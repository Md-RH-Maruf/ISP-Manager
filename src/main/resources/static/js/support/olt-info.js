window.onload = () => {
  document.title = "Olt Create";

}


function setOltData(id) {
  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getOltInfo',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let olt = data.oltInfo;
      $("#oltAutoId").val(olt.id);
      $("#oltName").val(olt.oltName);
      $("#oltPortNo").val(olt.oltPortNo);
      $("#connectionPointName").val(olt.connectionPointName);
      $("#spliterOdfNo").val(olt.spliterOdfNo);
      $("#spliterOdfPortNo").val(olt.spliterOdfPortNo);
      $("#fiberOdfNo").val(olt.fiberOdfNo);
      $("#fiberOdfPortNo").val(olt.fiberOdfPortNo);
      $("#exampleModal").modal('show');
    }
  });
  $("#btnSave").hide();
  $("#btnEdit").show();
}

function saveAction() {

  let oltName = $("#oltName").val();
  let oltPortNo = $("#oltPortNo").val();
  let connectionPointName = $("#connectionPointName").val();
  let spliterOdfNo = $("#spliterOdfNo").val();
  let spliterOdfPortNo = $("#spliterOdfPortNo").val();
  let fiberOdfNo = $("#fiberOdfNo").val();
  let fiberOdfPortNo = $("#fiberOdfPortNo").val();
 


  if (oltName != '') {
    
      if (confirm("Are you sure to save Olt?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/saveOltInfo',
          data: {
            oltName: oltName,
            oltPortNo: oltPortNo,
            connectionPointName: connectionPointName,
            spliterOdfNo: spliterOdfNo,
            spliterOdfPortNo: spliterOdfPortNo,
            fiberOdfNo: fiberOdfNo,
            fiberOdfPortNo: fiberOdfPortNo
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Olt Name..This Olt Name Allreary Exist")
            } else {

              if (data.result.oltId) {
                alert("Olt Save Successfully");
                $('#oltInfoTable').dataTable().fnDestroy();
                $("#oltList").empty();
                $("#oltList").append(drawOltTable(data.oltList));
                $('#oltInfoTable').DataTable(({ 
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
    alert("Empty Olt Name... Please Enter Olt Name Name");
    $("#oltName").val();
  }
}

function editAction() {

  let id = $("#oltAutoId").val();
  let oltName = $("#oltName").val();
  let oltPortNo = $("#oltPortNo").val();
  let connectionPointName = $("#connectionPointName").val();
  let spliterOdfNo = $("#spliterOdfNo").val();
  let spliterOdfPortNo = $("#spliterOdfPortNo").val();
  let fiberOdfNo = $("#fiberOdfNo").val();
  let fiberOdfPortNo = $("#fiberOdfPortNo").val();
 

  if (oltName != '') {
    
      if (confirm("Are you sure to Edit Olt?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/editOltInfo',
          data: {
            id: id,
            oltName: oltName,
            oltPortNo: oltPortNo,
            connectionPointName: connectionPointName,
            spliterOdfNo: spliterOdfNo,
            spliterOdfPortNo: spliterOdfPortNo,
            fiberOdfNo: fiberOdfNo,
            fiberOdfPortNo: fiberOdfPortNo
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Olt Name..This Olt Name Allreary Exist")
            } else {

              if (data.result.oltId) {
                alert("Olt Edit Successfully");
                $('#oltInfoTable').dataTable().fnDestroy();
                $("#oltList").empty();
                $("#oltList").append(drawOltTable(data.oltList));
                $('#oltInfoTable').DataTable(({ 
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
    alert("Empty Olt Name... Please Enter Olt Name Name");
    $("#oltName").focus();
  }
}

function newClickAction() {
  $("#oltAutoId").val('');
  $("#oltName").val('');
  $("#oltPortNo").val('');
  $("#connectionPointName").val('');
  $("#spliterOdfNo").val('');
  $("#spliterOdfPortNo").val('');
  $("#fiberOdfNo").val('');
  $("#fiberOdfPortNo").val('');

  $("#btnSave").show();
  $("#btnEdit").hide();
}

function refreshAction() {
  location.reload();
}

$(document).ready(function () {
  $('#oltInfoTable').DataTable();
});

function drawOltTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let olt = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setOltData('${olt.id}')">
      <td>${olt.oltName}</td>
      <td>${olt.oltPortNo }</td>
      <td>${olt.connectionPointName }</td>
      <td>${olt.spliterOdfNo }</td>
      <td>${olt.fiberOdfNo}</td>
  </tr>`
  }

  return rows;
}
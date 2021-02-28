window.onload = () => {
  document.title = "Connection Point Create";

}


function setConnectionPointData(id) {

  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getConnectionPoint',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let connection = data.connectionPointInfo;
      $("#connectionPointAutoId").val(connection.id);
      $("#connectionPointName").val(connection.connectionPointName);
      $("#connectionType").val(connection.connectionType);
      $("#activeStatus").val(connection.activeStatus);
      $("#clientName").val(connection.clientName);
      $("#server").val(connection.server);
      $("#ipAddress").val(connection.ipAddress);
      $("#eponInterface").val(connection.eponInterface);
      $("#onuMac").val(connection.onuMac);
      $("#clientMac").val(connection.clientMac);
      $("#graphId").val(connection.graphId);

    }
  });

  $("#btnSave").hide();
  $("#btnEdit").show();

}

function saveAction() {

  let connectionPointName = $("#connectionPointName").val();
  let connectionType = $("#connectionType").val();
  let activeStatus = $("#activeStatus").val();
  let clientName = $("#clientName").val();
  let server = $("#server").val();
  let ipAddress = $("#ipAddress").val();
  let eponInterface = $("#eponInterface").val();
  let onuMac = $("#onuMac").val();
  let clientMac = $("#clientMac").val();
  let graphId = $("#graphId").val();


  if (connectionPointName != '') {
    if (clientName != '') {
      if (server != '') {
        if (ipAddress != '') {
          if (confirm("Are you sure to save ConnectionPoint?")) {
            $.ajax({
              type: 'POST',
              dataType: 'json',
              url: '/saveConnectionPoint',
              data: {
                connectionPointName: connectionPointName,
                connectionType: connectionType,
                activeStatus: activeStatus,
                clientName: clientName,
                server: server,
                ipAddress: ipAddress,
                eponInterface: eponInterface,
                onuMac: onuMac,
                clientMac: clientMac,
                graphId: graphId
              },
              success: function (data) {
                if (data.result == "Something Wrong") {
                  dangerAlert("Something went wrong");
                } else if (data.result == "duplicate") {
                  dangerAlert("Duplicate ConnectionPoint Name..This ConnectionPoint Name Allreary Exist")
                } else {
    
                  if (data.result.id) {
                    successAlert("ConnectionPoint Save Successfully");
                    $("#connectionPointList").empty();
                    $("#connectionPointList").append(drawConnectionPointTable(data.connectionList));
                  } else {
                    dangerAlert("Something went wrong");
                  }
    
                }
              }
            });
          }
        } else {
          warningAlert("IP Address is empty... Please Enter IP Address");
          $("#ipAddress").val();
        }
      } else {
        warningAlert("Server is empty... Please Enter Server Name");
        $("#server").val();
      }
    } else {
      warningAlert("Client Name is empty... Please Enter Client Name");
      $("#clientName").val();
    }
  } else {
    warningAlert("Empty ConnectionPoint Name... Please Enter ConnectionPoint Name Name");
    $("#connectionPointName").val();
  }
}

function editAction() {

  let id = $("#connectionPointAutoId").val();
  let connectionPointName = $("#connectionPointName").val();
  let connectionType = $("#connectionType").val();
  let activeStatus = $("#activeStatus").val();
  let clientName = $("#clientName").val();
  let server = $("#server").val();
  let ipAddress = $("#ipAddress").val();
  let eponInterface = $("#eponInterface").val();
  let onuMac = $("#onuMac").val();
  let clientMac = $("#clientMac").val();
  let graphId = $("#graphId").val();


  if (connectionPointName != '') {
    if (clientName != '') {
      if (server != '') {
        if (ipAddress != '') {
          if (confirm("Are you sure to Edit ConnectionPoint?")) {
            $.ajax({
              type: 'POST',
              dataType: 'json',
              url: '/editConnectionPoint',
              data: {
                id:id,
                connectionPointName: connectionPointName,
                connectionType: connectionType,
                activeStatus: activeStatus,
                clientName: clientName,
                server: server,
                ipAddress: ipAddress,
                eponInterface: eponInterface,
                onuMac: onuMac,
                clientMac: clientMac,
                graphId: graphId
              },
              success: function (data) {
                if (data.result == "Something Wrong") {
                  dangerAlert("Something went wrong");
                } else if (data.result == "duplicate") {
                  dangerAlert("Duplicate ConnectionPoint Name..This ConnectionPoint Name Allreary Exist")
                } else {
    
                  if (data.result.id) {
                    successAlert("ConnectionPoint Edit Successfully");
                    $("#connectionPointList").empty();
                    $("#connectionPointList").append(drawConnectionPointTable(data.connectionList));
                  } else {
                    dangerAlert("Something went wrong");
                  }
    
                }
              }
            });
          }
        } else {
          warningAlert("IP Address is empty... Please Enter IP Address");
          $("#ipAddress").val();
        }
      } else {
        warningAlert("Server is empty... Please Enter Server Name");
        $("#server").val();
      }
    } else {
      warningAlert("Client Name is empty... Please Enter Client Name");
      $("#clientName").val();
    }
  } else {
    warningAlert("Empty ConnectionPoint Name... Please Enter ConnectionPoint Name Name");
    $("#connectionPointName").val();
  }
}

function refreshAction() {
  location.reload();
}

function drawConnectionPointTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let connectionPoint = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setConnectionPointData('${connectionPoint.id}')">
      <td>${connectionPoint.connectionPointName}</td>
      <td>${connectionPoint.clientName}</td>
      <td>${connectionPoint.server}</td>
      <td>${connectionPoint.activeStatus}</td>
  </tr>`
  }

  return rows;
}
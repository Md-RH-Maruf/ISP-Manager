window.onload = () => {
    document.title = "OLT/MC Position";
  
  }
  
  
  function setOltMcPositionData(id) {
  
    $.ajax({
      type: 'GET',
      dataType: 'json',
      url: '/getOltMcPosition',
      data: {
        id: id
      },
      success: function (data) {
        console.log(data)
        let connection = data.oltMcPositionInfo;
        $("#oltMcPositionAutoId").val(connection.id);
        $("#oltMcName").val(connection.oltMcName);
        $("#area").val(connection.area);
        $("#address").val(connection.address);
      }
    });
  
    $("#btnSave").hide();
    $("#btnEdit").show();
  
  }
  
  function saveAction() {
  
    let oltMcName = $("#oltMcName").val();
    let area = $("#area").val();
    let address = $("#address").val();
   
  
  
    if (oltMcName != '') {
      if (area != '') {
        if (address != '') {
         
            if (confirm("Are you sure to save OLT/MC Position?")) {
              $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/saveOltMcPosition',
                data: {
                    oltMcName: oltMcName,
                    area: area,
                    address: address
                },
                success: function (data) {
                  if (data.result == "Something Wrong") {
                    dangerAlert("Something went wrong");
                  } else if (data.result == "duplicate") {
                    dangerAlert("Duplicate OLT/MC Position Name..This OLT/MC Position Name Allreary Exist")
                  } else {
                    if (data.result.id) {
                      successAlert("OLT/MC Position Save Successfully");
                      $("#oltMcPositionList").empty();
                      $("#oltMcPositionList").append(drawOltMcPositionTable(data.oltMcList));
                    } else {
                      dangerAlert("Something went wrong");
                    }
      
                  }
                }
              });
            }
          
        } else {
          warningAlert("Address is empty... Please Enter Address");
          $("#address").val();
        }
      } else {
        warningAlert("Area is empty... Please Enter Area Name");
        $("#area").val();
      }
    } else {
      warningAlert("Empty OLT/MC Position Name... Please Enter OLT/MC Position Name Name");
      $("#oltMcName").val();
    }
  }
  
  function editAction() {
  
    let id = $("#oltMcPositionAutoId").val();
    let oltMcName = $("#oltMcName").val();
    let area = $("#area").val();
    let address = $("#address").val();
   
  
  
    if (oltMcName != '') {
      if (area != '') {
        if (address != '') {
         
            if (confirm("Are you sure to Edit OLT/MC Position?")) {
              $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/editOltMcPosition',
                data: {
                    id: id,
                    oltMcName: oltMcName,
                    area: area,
                    address: address
                },
                success: function (data) {
                  if (data.result == "Something Wrong") {
                    dangerAlert("Something went wrong");
                  } else if (data.result == "duplicate") {
                    dangerAlert("Duplicate OLT/MC Position Name..This OLT/MC Position Name Allreary Exist")
                  } else {
                    if (data.result.id) {
                      successAlert("OLT/MC Position Edit Successfully");
                      $("#oltMcPositionList").empty();
                      $("#oltMcPositionList").append(drawOltMcPositionTable(data.oltMcList));
                    } else {
                      dangerAlert("Something went wrong");
                    }
      
                  }
                }
              });
            }
          
        } else {
          warningAlert("Address is empty... Please Enter Address");
          $("#address").val();
        }
      } else {
        warningAlert("Area is empty... Please Enter Area Name");
        $("#area").val();
      }
    } else {
      warningAlert("Empty OLT/MC Position Name... Please Enter OLT/MC Position Name Name");
      $("#oltMcName").val();
    }
  }
  
  function refreshAction() {
    location.reload();
  }
  
  function drawOltMcPositionTable(data) {
    let rows = "";
    let length = data.length;
  
    for (let i = 0; i < length; i++) {
      let oltMcPosition = data[i];
      rows += `<tr style="cursor: pointer;"
        onclick="setOltMcPositionData('${oltMcPosition.id}')">
        <td>${oltMcPosition.oltMcName}</td>
        <td>${oltMcPosition.area}</td>
        <td>${oltMcPosition.address}</td>
    </tr>`
    }
  
    return rows;
  }
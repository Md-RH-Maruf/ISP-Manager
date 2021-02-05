window.onload = () => {
  document.title = "Role Management";

}

function saveAction() {
  let roleName = $("#roleName").val().trim();

  if (roleName != '') {
    $.ajax({
      type: 'POST',
      dataType: 'json',
      url: './saveRole',
      data: {
        roleName: roleName
      },
      success: function (data) {
        if (data.result == "Something Wrong") {
          dangerAlert("Something went wrong");
        } else if (data.result == "duplicate") {
          dangerAlert("Duplicate Role Name..This Role Name Allreary Exist")
        } else {

          if (data.result.roleName) {
            successAlert("Role Name Save Successfully");
            $("#roleList").empty();
            $("#roleList").append(drawRoleTable(data.roleList));
          } else {
            dangerAlert("Something went wrong");
          }

        }
      }
    });
  } else {
    warningAlert("Empty Role Name... Please Enter Role Name");
  }
}


function editAction() {
  let roleId = $("#roleId").val();
  let roleName = $("#roleName").val().trim();

  if (roleName != '') {
    $.ajax({
      type: 'POST',
      dataType: 'json',
      url: './editRole',
      data: {
        id: roleId,
        roleName: roleName
      },
      success: function (data) {
        if (data.result == "Something Wrong") {
          dangerAlert("Something went wrong");
        } else if (data.result == "duplicate") {
          dangerAlert("Duplicate Role Name..This Role Name Allreary Exist")
        } else {
          if (data.result.roleName) {
            successAlert("Role Name Save Successfully");
            $("#roleList").empty();
            $("#roleList").append(drawRoleTable(data.roleList));
          } else {
            dangerAlert("Something went wrong");
          }
        }
      }
    });
  } else {
    warningAlert("Empty Role Name... Please Enter Role Name");
  }
}


function refreshAction() {
  location.reload();
}


function setData(roleId) {
  document.getElementById("roleId").value = roleId;
  document.getElementById("roleName").value = document.getElementById("roleName" + roleId).innerHTML;

  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: './getResourceRoleDetails',
    data: {
      roleId : roleId
    },
    success: function (data) {
      console.log(data)
      $("#resourceRoleList").empty()
      data.resourceRoleDetails.forEach((row,index)=>{
        $("#resourceRoleList").append(`<tr>
            <td>${index+1}</td>
            <td>${row.resourceName}</td>
            <td><input id="canAddCheck-${row.id}" type="checkbox" ${row.canAdd==0?"":"checked"}/></td>
            <td><input id="canEditCheck-${row.id}" type="checkbox" ${row.canEdit==0?"":"checked"}/></td>
            <td><input id="canViewCheck-${row.id}" type="checkbox" ${row.canView==0?"":"checked"}/></td>
            <td><input id="canDeleteCheck-${row.id}" type="checkbox" ${row.canDelete==0?"":"checked"}/></td>
            <td><i class="fa fa-edit" onclick="editResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
            <td><i class="fa fa-trash" onclick="deleteResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
        </tr>`);
      })
      
    }
  });

  $("#btnSave").hide();
  $("#btnEdit").show();

}

function editResourceRole(id,resourceId,roleId){

  let canAdd = $("#canAddCheck-"+id).is(":checked")?1:0;
  let canEdit = $("#canEditCheck-"+id).is(":checked")?1:0;
  let canView = $("#canViewCheck-"+id).is(":checked")?1:0;
  let canDelete = $("#canDeleteCheck-"+id).is(":checked")?1:0;

  $.ajax({
    type: 'POST',
    dataType: 'json',
    url: './editResourceRole',
    data: {
      id : id,
      resourceId : resourceId,
      roleId : roleId,
      canAdd : canAdd,
      canEdit : canEdit,
      canView : canView,
      canDelete : canDelete
    },
    success: function (data) {
      successAlert("Edit Successfully...");
      $("#resourceRoleList").empty()
      data.resourceRoleDetails.forEach((row,index)=>{
        $("#resourceRoleList").append(`<tr>
            <td>${index+1}</td>
            <td>${row.resourceName}</td>
            <td><input id="canAddCheck-${row.id}" type="checkbox" ${row.canAdd==0?"":"checked"}/></td>
            <td><input id="canEditCheck-${row.id}" type="checkbox" ${row.canEdit==0?"":"checked"}/></td>
            <td><input id="canViewCheck-${row.id}" type="checkbox" ${row.canView==0?"":"checked"}/></td>
            <td><input id="canDeleteCheck-${row.id}" type="checkbox" ${row.canDelete==0?"":"checked"}/></td>
            <td><i class="fa fa-edit" onclick="editResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
            <td><i class="fa fa-trash" onclick="deleteResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
        </tr>`);
      })
      
    }
  });
}


function deleteResourceRole(id,resourceId,roleId){

  if(confirm("Are you sure to Delete this Resource?")){
    $.ajax({
      type: 'POST',
      dataType: 'json',
      url: './deleteResourceRole',
      data: {
        id : id,
        resourceId : resourceId,
        roleId : roleId
      },
      success: function (data) {
        successAlert("Delete Successfully..");
        $("#resourceRoleList").empty()
        data.resourceRoleDetails.forEach((row,index)=>{
          $("#resourceRoleList").append(`<tr>
              <td>${index+1}</td>
              <td>${row.resourceName}</td>
              <td><input id="canAddCheck-${row.id}" type="checkbox" ${row.canAdd==0?"":"checked"}/></td>
              <td><input id="canEditCheck-${row.id}" type="checkbox" ${row.canEdit==0?"":"checked"}/></td>
              <td><input id="canViewCheck-${row.id}" type="checkbox" ${row.canView==0?"":"checked"}/></td>
              <td><input id="canDeleteCheck-${row.id}" type="checkbox" ${row.canDelete==0?"":"checked"}/></td>
              <td><i class="fa fa-edit" onclick="editResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
              <td><i class="fa fa-trash" onclick="deleteResourceRole('${row.id}','${row.resourceId}','${row.roleId}')" style="cursor: pointer;"> </i></td>
          </tr>`);
        })
        
      }
    });
  }
  
}

function drawRoleTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    rows += `<tr>
              <td>${i}</td> 
              <td id='roleName${data[i].id}'>${data[i].roleName}</td>
              <td ><i class='fa fa-edit' style="cursor:pointer;" onclick="setData('${data[i].id}')"></i></td>
            </tr>`
  }

  return rows;
}

function resourceAddAction(){
  let resourceId = $("#resourceNameSelect").val();
  let roleId = $("#roleId").val();

  if(resourceId != 0){
    if(roleId != '0'){
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: './addResourceRole',
        data: {
          resourceId: resourceId,
          roleId: roleId
        },
        success: function (data) {
          console.log(data);
          if (data.result == "Something Wrong") {
            alert("Something went wrong");
          } else if (data.result == "duplicate") {
            alert("Duplicate Resource Name..... \nThis Resource Name Already Exist..");
          } else {
            if (data.result.roleId) {
              alert("Resource Name Save Successfully...");
              $("#resourceTableList").empty();
              $("#resourceTableList").append(drawResourceTable(data.resourceRoleDetails));
            } else {
              alert("Something went wrong");
            }
          }
        }
      });
    }else{
      warningAlert("Role Not Selectd... Please Select a role");
    }
  }else{
    warningAlert("Resource Name not selected");
    $("#resourceNameSelect").focus();
  }

}

function resourceSaveAction() {

  let resourceName = $("#resourceName").val().trim();
  let resourceLink = $("#resourceLink").val().trim();

  if (resourceName != '') {
    if (resourceLink != '') {
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: './saveResource',
        data: {
          resourceName: resourceName,
          resourceLink: resourceLink
        },
        success: function (data) {
          if (data.result == "Something Wrong") {
            alert("Something went wrong");
          } else if (data.result == "duplicate") {
            alert("Duplicate Resource Name..... \nThis Resource Name Already Exist..");
          } else {
            if (data.result.resourceName) {
              alert("Resource Name Save Successfully...");
              $("#resourceTableList").empty();
              $("#resourceTableList").append(drawResourceTable(data.resourceList));
            } else {
              alert("Something went wrong");
            }
          }
        }
      });
    } else {
      //warningAlert("Empty Resource Name... Please Enter a Resource Name");
      alert("Empty Resource Link ... please Enter any resource Link");
      $("#resouceLink").focus();
    }
  } else {
    //warningAlert("Empty Resource Name... Please Enter a Resource Name");
    alert("Empty Resource Name ... please Enter any resource name");
    $("#resourceName").focus();
  }
}


function resourceEditAction() {
  let resourceName = $("#resourceName").val().trim();
  let resourceLink = $("#resourceLink").val().trim();
  let resourceId = $("#resourceId").val();
  if (resourceName != '') {
    if (resourceLink != '') {
      $.ajax({
        type: 'POST',
        dataType: 'json',
        url: './editResource',
        data: {
          id: resourceId,
          resourceName: resourceName,
          resourceLink: resourceLink
        },
        success: function (data) {
          if (data.result == "Something Wrong") {
            alert("Something went wrong");
          } else if (data.result == "duplicate") {
            alert("Duplicate Resource Name..... \nThis Resource Name Already Exist..");
          } else {
            if (data.result.resourceName) {
              alert("Resource Name Edit Successfully...")
              $("#resourceTableList").empty();
              $("#resourceTableList").append(drawResourceTable(data.resourceList));
              $("#btnResourceSave").show();
              $("#btnResourceEdit").hide();
            } else {
              alert("Something went wrong");
            }
          }
        }
      });
    } else {
      alert("Empty Resource Link ... please Enter any resource Link");
      $("#resouceLink").focus();
    }
  } else {
    alert("Empty Resource Name ... please Enter any resource name");
    $("#resourceName").focus();
  }
}

function resourceModalCloseAction() {
  $("resourceId").val("");
  $("#btnResourceSave").show();
  $("#btnResourceEdit").hide();
  $("#resourceName").val("");
  $("#resourceLink").val("");
}

function setResourceData(id) {
  $("#resourceId").val(id);
  $("#resourceName").val($("#resourceName" + id).text());
  $("#resourceLink").val($("#resourceLink" + id).text());
  $("#btnResourceSave").hide();
  $("#btnResourceEdit").show();
}



function drawResourceTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    rows += `<tr>
              <td id='resourceName${data[i].id}'>${data[i].resourceName}</td>
              <td id='resourceLink${data[i].id}'>${data[i].resourceLink}</td>
              <td ><i class='fa fa-edit' style="cursor:pointer;" onclick="setResourceData('${data[i].id}')"></i></td>
            </tr>`
  }

  return rows;
}


$(document).ready(function () {
  $("input:text").focus(function () { $(this).select(); });
});

$(document).ready(function () {
  $("#search").on("keyup", function () {
    let value = $(this).val().toLowerCase();
    $("#roleList tr").filter(function () {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});


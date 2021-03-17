window.onload = () => {
    document.title = "User Auth Management";
  
  }


function setUserData(userId){
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: './getUserEmployeeInfo',
        data: {
          userId : userId
        },
        success: function (data) {
          //successAlert("Edit Successfully...");
          console.log(data);
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
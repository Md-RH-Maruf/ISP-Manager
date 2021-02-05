window.onload = () => {
  document.title = "Employee Create";
  $("#leaveDate").val("1900-01-01");
}


function setEmployeeData(id) {

  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getEmployee',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let employee = data.employeeInfo;
      $("#employeeAutoId").val(employee.id);
      $("#employeeId").val(employee.employeeId);
      $("#firstName").val(employee.firstName);
      $("#lastName").val(employee.lastName);
      $("#nickName").val(employee.nickName);
      $("#fatherName").val(employee.fatherName);
      $("#motherName").val(employee.motherName);
      $("#dateOfBirth").val(employee.dateOfBirth);
      $("#gender").val(employee.gender);
      $("#meritalStatus").val(employee.meritalStatus);
      $("#nationality").val(employee.nationality);
      $("#nationalId").val(employee.nationalId);
      $("#presentAddress").val(employee.presentAddress);
      $("#permanentAddress").val(employee.permanentAddress);
      $("#email").val(employee.email);
      $("#contactNo").val(employee.contactNo);
      $("#designation").val(employee.designation);
      $("#joiningDate").val(employee.joiningDate);
      $("#activeStatus").val(employee.status);
      $("#leaveDate").val(employee.leaveDate);

    }
  });

  $("#btnSave").hide();
  $("#btnEdit").show();

}

function saveAction() {

  let firstName = $("#firstName").val();
  let lastName = $("#lastName").val();
  let nickName = $("#nickName").val();
  let fatherName = $("#fatherName").val();
  let motherName = $("#motherName").val();
  let dateOfBirth = $("#dateOfBirth").val();
  let gender = $("#gender").val();
  let meritalStatus = $("#meritalStatus").val();
  let nationality = $("#nationality").val();
  let nationalId = $("#nationalId").val();
  let presentAddress = $("#presentAddress").val();
  let permanentAddress = $("#permanentAddress").val();
  let email = $("#email").val();
  let contactNo = $("#contactNo").val();
  let designation = $("#designation").val();
  let joiningDate = $("#joiningDate").val();
  let activeStatus = $("#activeStatus").val();

  let leaveDate = $("#leaveDate").val();

  if (firstName != '') {
    if (lastName != '') {

      if (dateOfBirth) {
        if (joiningDate) {
          if (confirm("Are you sure to save Employee?")) {
            $.ajax({
              type: 'POST',
              dataType: 'json',
              url: '/saveEmployee',
              data: {
                firstName: firstName,
                lastName: lastName,
                nickName: nickName,
                fatherName: fatherName,
                motherName: motherName,
                dateOfBirth: dateOfBirth,
                gender: gender,
                meritalStatus: meritalStatus,
                nationality: nationality,
                nationalId: nationalId,
                presentAddress: presentAddress,
                permanentAddress: permanentAddress,
                email: email,
                contactNo: contactNo,
                designation: designation,
                joiningDate: joiningDate,
                status: activeStatus,
                leaveDate: leaveDate
              },
              success: function (data) {
                if (data.result == "Something Wrong") {
                  dangerAlert("Something went wrong");
                } else if (data.result == "duplicate") {
                  dangerAlert("Duplicate Employee Name..This Employee Name Allreary Exist")
                } else {

                  if (data.result.employeeId) {
                    successAlert("Employee Save Successfully");
                    $("#employeeList").empty();
                    $("#employeeList").append(drawEmployeeTable(data.employeeList));
                  } else {
                    dangerAlert("Something went wrong");
                  }

                }
              }
            });
          }
        } else {
          warningAlert("Joining Date is empty... Please Select Joining date");
          $("#joiningDate").focus();
        }
      }
      else {
        warningAlert("Date Of Birth is empty... Please Select Date Of Birth");
        $("#dateOfBirth").focus();
      }
    } else {
      warningAlert("Empty Last Name... Please Select Last Name");
      $("#lastName").focus();
    }
  } else {
    warningAlert("Empty First Name... Please Select First Name");
    $("#firstName").focus();
  }
}



function editAction() {

  let id = $("#employeeAutoId").val();
  let employeeId = $("#employeeId").val();
  let firstName = $("#firstName").val();
  let lastName = $("#lastName").val();
  let nickName = $("#nickName").val();
  let fatherName = $("#fatherName").val();
  let motherName = $("#motherName").val();
  let dateOfBirth = $("#dateOfBirth").val();
  let gender = $("#gender").val();
  let meritalStatus = $("#meritalStatus").val();
  let nationality = $("#nationality").val();
  let nationalId = $("#nationalId").val();
  let presentAddress = $("#presentAddress").val();
  let permanentAddress = $("#permanentAddress").val();
  let email = $("#email").val();
  let contactNo = $("#contactNo").val();
  let designation = $("#designation").val();
  let joiningDate = $("#joiningDate").val();
  let activeStatus = $("#activeStatus").val();

  let leaveDate = $("#leaveDate").val();

  if (firstName != '') {
    if (lastName != '') {

      if (dateOfBirth) {
        if (joiningDate) {
          if (confirm("Are you sure to Edit Employee?")) {
            $.ajax({
              type: 'POST',
              dataType: 'json',
              url: '/editEmployee',
              data: {
                id: id,
                employeeId: employeeId,
                firstName: firstName,
                lastName: lastName,
                nickName: nickName,
                fatherName: fatherName,
                motherName: motherName,
                dateOfBirth: dateOfBirth,
                gender: gender,
                meritalStatus: meritalStatus,
                nationality: nationality,
                nationalId: nationalId,
                presentAddress: presentAddress,
                permanentAddress: permanentAddress,
                email: email,
                contactNo: contactNo,
                designation: designation,
                joiningDate: joiningDate,
                status: activeStatus,
                leaveDate: leaveDate
              },
              success: function (data) {
                if (data.result == "Something Wrong") {
                  dangerAlert("Something went wrong");
                } else if (data.result == "duplicate") {
                  dangerAlert("Duplicate Employee Name..This Employee Name Allreary Exist")
                } else {

                  if (data.result.employeeId) {
                    successAlert("Employee Save Successfully");
                    $("#employeeList").empty();
                    $("#employeeList").append(drawEmployeeTable(data.employeeList));
                  } else {
                    dangerAlert("Something went wrong");
                  }

                }
              }
            });
          }

        } else {
          warningAlert("Joining Date is empty... Please Select Joining date");
          $("#joiningDate").focus();
        }
      }
      else {
        warningAlert("Date Of Birth is empty... Please Select Date Of Birth");
        $("#dateOfBirth").focus();
      }
    } else {
      warningAlert("Empty Last Name... Please Select Last Name");
      $("#lastName").focus();
    }
  } else {
    warningAlert("Empty First Name... Please Select First Name");
    $("#firstName").focus();
  }
}

function refreshAction() {
  location.reload();
}

function drawEmployeeTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let employee = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setEmployeeData('${employee.id}')">
      <td>${employee.employeeId}</td>
      <td>${employee.firstName}</td>
      <td>${employee.designation}</td>
      <td>${employee.status}</td>
    </tr>`
  }

  return rows;
}
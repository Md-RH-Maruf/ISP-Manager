window.onload = () => {
  document.title = "Reseller Create";

}


function setResellerData(id) {

  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getReseller',
    data: {
      id: id
    },
    success: function (data) {
      console.log(data)
      let reseller = data.resellerInfo;
      $("#resellerAutoId").val(reseller.id);
      $("#resellerId").val(reseller.resellerId);
      $("#resellerName").val(reseller.name);
      $("#address").val(reseller.address);
      $("#scrNo").val(reseller.scrNo);
      $("#publicIp").val(reseller.publicIp);
      $("#email").val(reseller.email);
      $("#contactNo").val(reseller.contactNo);
      $("#mikrotikUserName").val(reseller.mikrotikUserName);
      $("#mikrotikPassword").val(reseller.mikrotikPassword);
      $("#internetBandwidth").val(reseller.internetBandwidth);
      $("#facebookBandwidth").val(reseller.facebookBandwidth);
      $("#youtubeBandwidth").val(reseller.youtubeBandwidth);
      $("#bdixBandwidth").val(reseller.bdixBandwidth);
      $("#monthlyPayment").val(reseller.monthlyPayment);
      $("#activeStatus").val(reseller.status);
      $("#serviceStartDate").val(reseller.serviceStartDate);
      $("#exampleModal").modal('show');

    }
  });

  $("#btnSave").hide();
  $("#btnEdit").show();

}

function saveAction() {

  let resellerName = $("#resellerName").val();
  let address = $("#address").val();
  let publicIp = $("#publicIp").val();
  let scrNo = $("#scrNo").val();
  let email = $("#email").val();
  let contactNo = $("#contactNo").val();
  let mikrotikUserName = $("#mikrotikUserName").val();
  let mikrotikPassword = $("#mikrotikPassword").val();
  let internetBandwidth = $("#internetBandwidth").val();
  let facebookBandwidth = $("#facebookBandwidth").val();
  let youtubeBandwidth = $("#youtubeBandwidth").val();
  let bdixBandwidth = $("#bdixBandwidth").val();
  let monthlyPayment = $("#monthlyPayment").val() == '' ? 0 : $("#monthlyPayment").val();
  let serviceStartDate = $("#serviceStartDate").val();
  let activeStatus = $("#activeStatus").val();


  if (resellerName != '') {
    if (serviceStartDate) {
      if (confirm("Are you sure to save Reseller?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/saveReseller',
          data: {
            name: resellerName,
            address: address,
            publicIp: publicIp,
            scrNo: scrNo,
            email: email,
            contactNo: contactNo,
            mikrotikUserName: mikrotikUserName,
            mikrotikPassword: mikrotikPassword,
            internetBandwidth: internetBandwidth,
            facebookBandwidth: facebookBandwidth,
            youtubeBandwidth: youtubeBandwidth,
            bdixBandwidth: bdixBandwidth,
            monthlyPayment: monthlyPayment,
            serviceStartDate: serviceStartDate,
            status: activeStatus
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Reseller Name..This Reseller Name Allreary Exist")
            } else {

              if (data.result.resellerId) {
                alert("Reseller Save Successfully");
                $('#resellerInfoTable').dataTable().fnDestroy();
                $("#resellerList").empty();
                $("#resellerList").append(drawResellerTable(data.resellerList));
                $('#resellerInfoTable').DataTable(({ 
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
      alert("Service Start Date is empty... Please Select Service start date");
      $("#serviceStartDate").val();
    }
  } else {
    alert("Empty Reseller Name... Please Enter Reseller Name Name");
    $("#resellerName").val();
  }
}

function editAction() {

  let id = $("#resellerAutoId").val();
  let resellerId = $("#resellerId").val();
  let resellerName = $("#resellerName").val();
  let address = $("#address").val();
  let publicIp = $("#publicIp").val();
  let scrNo = $("#scrNo").val();
  let email = $("#email").val();
  let contactNo = $("#contactNo").val();
  let mikrotikUserName = $("#mikrotikUserName").val();
  let mikrotikPassword = $("#mikrotikPassword").val();
  let internetBandwidth = $("#internetBandwidth").val();
  let facebookBandwidth = $("#facebookBandwidth").val();
  let youtubeBandwidth = $("#youtubeBandwidth").val();
  let bdixBandwidth = $("#bdixBandwidth").val();
  let monthlyPayment = $("#monthlyPayment").val() == '' ? 0 : $("#monthlyPayment").val();
  let serviceStartDate = $("#serviceStartDate").val();
  let activeStatus = $("#activeStatus").val();

  if (resellerName != '') {
    if (serviceStartDate) {
      if (confirm("Are you sure to Edit Reseller?")) {
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/editReseller',
          data: {
            id: id,
            resellerId: resellerId,
            name: resellerName,
            address: address,
            publicIp: publicIp,
            scrNo: scrNo,
            email: email,
            contactNo: contactNo,
            mikrotikUserName: mikrotikUserName,
            mikrotikPassword: mikrotikPassword,
            internetBandwidth: internetBandwidth,
            facebookBandwidth: facebookBandwidth,
            youtubeBandwidth: youtubeBandwidth,
            bdixBandwidth: bdixBandwidth,
            monthlyPayment: monthlyPayment,
            serviceStartDate: serviceStartDate,
            status: activeStatus
          },
          success: function (data) {
            if (data.result == "Something Wrong") {
              alert("Something went wrong");
            } else if (data.result == "duplicate") {
              alert("Duplicate Reseller Name..This Reseller Name Allreary Exist")
            } else {

              if (data.result.resellerId) {
                alert("Reseller Edit Successfully");
                $('#resellerInfoTable').dataTable().fnDestroy();
                $("#resellerList").empty();
                $("#resellerList").append(drawResellerTable(data.resellerList));
                $('#resellerInfoTable').DataTable(({ 
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
      alert("Service Start Date is empty... Please Select Service start date");
      $("#serviceStartDate").focus();
    }
  } else {
    alert("Empty Reseller Name... Please Enter Reseller Name Name");
    $("#resellerName").focus();
  }
}

function newClickAction() {
  $("#resellerAutoId").val('');
  $("#resellerName").val('');
  $("#address").val('');
  $("#scrNo").val('');
  $("#publicIp").val('');
  $("#email").val('');
  $("#contactNo").val('');
  $("#mikrotikUserName").val('');
  $("#mikrotikPassword").val('');
  $("#internetBandwidth").val('0');
  $("#facebookBandwidth").val('0');
  $("#youtubeBandwidth").val('0');
  $("#bdixBandwidth").val('0');
  $("#monthlyPayment").val('0');
  $("#activeStatus").val(1);

  let today = new Date();


  $("#serviceStartDate").val(today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2));
  //$("#exampleModal").modal('show');

  $("#btnSave").show();
  $("#btnEdit").hide();
}

function refreshAction() {
  location.reload();
}

$(document).ready(function () {
  $('#resellerInfoTable').DataTable();
});

function drawResellerTable(data) {
  let rows = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let reseller = data[i];
    rows += `<tr style="cursor: pointer;"
      onclick="setResellerData('${reseller.id}')">
      <td>${reseller.resellerId}</td>
      <td>${reseller.name}</td>
      <td>${reseller.address}</td>
      <td>${reseller.publicIp}</td>
      <td>${reseller.scrNo}</td>
      <td>${reseller.mikrotikUserName}</td>
      <td>${reseller.internetBandwidth}</td>
      <td>${reseller.monthlyPayment}</td>
  </tr>`
  }

  return rows;
}
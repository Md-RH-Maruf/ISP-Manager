window.onload = () => {
  document.title = "Activation Ticket Details";

  let tmsNo = $("#tmsNo").val();
  $("#loader").show();
  $.ajax({
    type: 'GET',
    dataType: 'json',
    url: '/getActivationTmsDetails',
    data: {
      tmsNo: tmsNo
    },
    success: function (data) {
      console.log(data.activationTms);
      console.log(data.customer);
      console.log(data.user);
     
      let tms = data.activationTms;
      let customer = data.customer;
      let user = data.user;
      $("#form").val(user.username);
      $("#subject").val(tms.subject);
      let tmsDate = new Date(tms.entryTime);
      $("#date").val(tmsDate.getFullYear() + '-' + ('0' + (tmsDate.getMonth() + 1)).slice(-2) + '-' + ('0' + tmsDate.getDate()).slice(-2));
      $("#status").val(tms.status);
      $("#priority").val(tms.priority);
      $("#owner").val(tms.owner).change();
      $("#customerId").val(customer.customerId);
      $("#contactName").val(customer.keyPerson);

      $("#contactNumber").val(customer.contactNo);
      $("#contactAddress").val(customer.address);
      $("#connectionType").val(customer.connectionType);
      $("#bandwidthPackage").val(customer.packageId);
      $("#olt").val(customer.olt);
      $("#mrc").val(customer.mrc);
      $("#reference").val(customer.reference);
      $("#promiseDate").val(tms.promissDate);

      $("#workTeamList").empty();
      drawWorkTeamList(data.workTeamList);

      $("#supportNameList").empty();
      drawSupportNameList(data.supportNameList);

      $("#commentList").empty();
      drawCommentList(data.commentList);

      $("#onuMac").val(customer.onuMac);
      $("#latLong").val(customer.latLong);
      $("#onuInterface").val(customer.onuInterface);
      $("#connectionPoint").val(customer.connectionPoint);
      $("#ipAddress").val(customer.ipAddress);
      $("#clientMac").val(customer.clientMac);
      $("#activationStatus").val(tms.activationStatus);
      $("#loader").hide();
    }
  });
}

function updateAction(){
     //let date = $("#date").val();
     let tmsNo = $("#tmsNo").val();
     let status = $("#status").val();
     let priority = $("#priority").val();
     let owner = $("#owner").val();
     let customerId = $("#customerId").val();
     let keyPerson = $("#contactName").val();
     let contactNo = $("#contactNumber").val();
     let address = $("#contactAddress").val();
     let connectionType = $("#connectionType").val();
     let packageId = $("#bandwidthPackage").val();
     let olt = $("#olt").val();
     let mrc = $("#mrc").val();
     let reference = $("#reference").val();
     let promissDate = $("#promiseDate").val();

     let onuMac = $("#onuMac").val();
     let latLong = $("#latLong").val();
     let onuInterface = $("#onuInterface").val();
     let connectionPoint = $("#connectionPoint").val();
     let ipAddress = $("#ipAddress").val();
     let clientMac = $("#clientMac").val();
     let activationStatus = $("#activationStatus").val();
    console.log("activation",{tmsNo: tmsNo,
      status: status,
      priority: priority,
      owner: owner,
      customerId: customerId,
      packageId: packageId,
      onuMac: onuMac,
      latLong: latLong,
      onuInterface: onuInterface,
      connectionPoint: connectionPoint,
      ipAddress: ipAddress,
      clientMac: clientMac,
      activationStatus: activationStatus});
     if(owner){
      if(activationStatus){
        if(confirm("Are you sure to Update TMS Details")){
          $("#loader").show();
          $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/updateActivationTMS',
            data: {
              tmsNo: tmsNo,
              status: status,
              priority: priority,
              owner: owner,
              customerId: customerId,
              packageId: packageId,
              onuMac: onuMac,
              latLong: latLong,
              onuInterface: onuInterface,
              connectionPoint: connectionPoint,
              ipAddress: ipAddress,
              clientMac: clientMac,
              activationStatus: activationStatus
            },
            success: function (data) {
              if(data.result == "successfull"){
                successAlert("TMS Update Successfully...")
              }else if(data.result == "deleted"){
                alert("Activation Deleted Successfully...");
                let url = "http://localhost:8080/support/activation-ticket-list";
                 window.open(url, '_self');
              }else{
                warningAlert("Something Wrong")
              }
              $("#loader").hide();
            }
          });
        }
      }else{
        warningAlert("Activation Status Not Selected.... Please Select Activation Status");
        $("#activationStatus").focus();
      }
     }else{
       warningAlert("Owner Not Selected.... Please Select Owner");
       $("#owner").focus();
     }
     
}

function workTeamAddAction() {
  let tmsNo = $("#tmsNo").val();
  let workTeam = $("#workTeam").val();

  if (tmsNo != '') {
    if (workTeam != '') {
      if (confirm("Are you sure to add this work team?")) {
        $("#loader").show();
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/addWorkTeam',
          data: {
            ticketId: tmsNo,
            teamName: workTeam
          },
          success: function (data) {
            $("#workTeamList").empty();
            drawWorkTeamList(data.workTeamList);
            $("#loader").hide();
          }
        });
      }

    } else {
      warningAlert("Empty Work Team Name... Please Enter Work Team Name");
      $("#workTeam").val();
    }
  }
}

function supportTeamAddAction() {
  let tmsNo = $("#tmsNo").val();
  let supportName = $("#supportName").val();

  if (tmsNo != '') {
    if (supportName != '') {
      if (confirm("Are you sure to add this Support Name?")) {
        $("#loader").show();
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/addSupportName',
          data: {
            ticketId: tmsNo,
            supportName: supportName
          },
          success: function (data) {
            $("#supportNameList").empty();
            drawSupportNameList(data.supportNameList);
            $("#loader").hide();
          }
        });
      }
    } else {
      warningAlert("Empty Support Name... Please Enter Support Name");
      $("#supportName").val();
    }
  }
}

function commentAddAction() {
  let tmsNo = $("#tmsNo").val();
  let comment = $("#comment").val();
  console.log(tmsNo,"test comment",comment);
  if (tmsNo != '') {
    if (comment != '') {
      if (confirm("Are you sure to Commenting?")) {
        $("#loader").show();
        $.ajax({
          type: 'POST',
          dataType: 'json',
          url: '/addComment',
          data: {
            ticketId: tmsNo,
            commentString: comment
          },
          success: function (data) {
            $("#commentList").empty();
            drawCommentList(data.commentList);
            $("#loader").hide();
          }
        });
      }
    } else {
      warningAlert("Empty Comment... Please Write Commetn");
      $("#comment").val();
    }
  }
}

function drawWorkTeamList(data) {
  let items = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let workTeam = data[i];
    items += `<li>${workTeam.teamName}</li>`
  }
  $("#workTeamList").append(items);
}

function drawSupportNameList(data) {
  let items = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let support = data[i];
    items += `<li>${support.supportName}</li>`
  }
  $("#supportNameList").append(items);
}

function drawCommentList(data) {
  let comments = "";
  let length = data.length;

  for (let i = 0; i < length; i++) {
    let comment = data[i];
    console.log(comment);
    let date = new Date(comment.entryTime);
    comments += `<div class="comment p-1 rounded border border-secondary">
    <div class="d-flex justify-content-between">
      <h6>${comment.commentBy}</h6>
      <small>${date.getDate()}-${date.getMonth()+1}-${date.getFullYear()}  ${date.getHours()}:${date.getMinutes()}</small>
    </div>
    <p class="mb-1">${comment.comment}</p>
  </div>`
  }
  $("#commentList").append(comments);
}
window.onload = () => {
    document.title = "Complain Ticket Details";
  
    let tmsNo = $("#tmsNo").val();
    $("#loader").show();
    $.ajax({
      type: 'GET',
      dataType: 'json',
      url: '/getComplainTmsDetails',
      data: {
        tmsNo: tmsNo
      },
      success: function (data) {
        console.log(data.complainTms);
        console.log(data.customer);
        console.log(data.user);
       
        let tms = data.complainTms;
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
        $("#problemType").val(tms.problemType);
        $("#complainDetails").val(tms.complainDetails);
        $("#workTeamList").empty();
        drawWorkTeamList(data.workTeamList);
  
        $("#supportNameList").empty();
        drawSupportNameList(data.supportNameList);
  
        $("#commentList").empty();
        drawCommentList(data.commentList);

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
    
   
    if(owner){
       if(confirm("Are you sure to Update TMS Details")){
         $("#loader").show();
         $.ajax({
           type: 'POST',
           dataType: 'json',
           url: '/updateComplainTMS',
           data: {
             tmsNo: tmsNo,
             status: status,
             priority: priority,
             owner: owner
           },
           success: function (data) {
             if(data.result == "successfull"){
               successAlert("Complain Update Successfully...");
               commentAddAction();
             }else{
               warningAlert("Something Wrong")
             }
             $("#loader").hide();
           }
         });
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
          commentAddAction();
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
   
    if (tmsNo != '') {
      if (comment != '') {
       
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
              $("#comment").val('');
              $("#loader").hide();
            }
          });
        
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
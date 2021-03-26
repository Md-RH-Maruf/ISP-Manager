function approveBill(){
    let billNo = $("#billNo").val();
    let approveAmount = $("#approveAmount").val();
    if(approveAmount != 0 || approveAmount!=''){
        if(confirm("Are you sure to approve this Bill?")){
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/approveBill',
                data: {
                    billNo: billNo,
                    approveAmount: approveAmount
                },
                success: function (data) {
                    if (data.result == 'successfull') {
                        successAlert("Bill Approve Successfully");
                        
                    } else {
                        warningAlert(data.message);
                    }
    
                }
            });
        }     
    }else{
        warningAlert("Please Enter Approve Amount");
    }
}

function rejectBill(){
    let billNo = $("#billNo").val();
    let rejectedCause = $("#rejectedCause").val();
    if(rejectedCause != ''){
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/rejectBill',
            data: {
                billNo: billNo,
                rejectedCause: rejectedCause
            },
            success: function (data) {
                if (data.result == 'successfull') {
                    successAlert("Bill Reject Successfully");
                    $("#example").modal('hide');
                } else {
                    warningAlert(data.message);
                }

            }
        });
    }else{
       alert("Please Enter Rejected Cause")
    }
}
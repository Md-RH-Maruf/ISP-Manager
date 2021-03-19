function approvedRequisition(){
    let requisitionNo = $("#requistionNo").val();

    if(confirm("Are you sure to Approved This Requisition?")){
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/updateProudctRequsition',
            data: {
                requisitionNo: requisitionNo,
                status: '2'
            },
            success: function (data) {
                if(data.result== 'successfull')
                    successAlert("Approved Successfully..");
                else
                dangerAlert("Something Wrong");
            }
        });
    }
    
}

function notApprovedRequisition(){
    let requisitionNo = $("#requistionNo").val();

    if(confirm("Are you sure to Reject This Requisition?")){
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/updateProudctRequsition',
            data: {
                requisitionNo: requisitionNo,
                status: '3'
            },
            success: function (data) {
                if(data.result== 'successfull')
                    warningAlert("Reject Successfully..");
                else
                    dangerAlert("Something Wrong");
            }
        });
    }
}

function issueRequisition(){
    let requisitionNo = $("#requistionNo").val();

    if(confirm("Are you sure to Issue This Product Requisition?")){
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/issueProudctRequsition',
            data: {
                requisitionNo: requisitionNo,
                status: '4'
            },
            success: function (data) {
                if(data.result== 'successfull')
                    successAlert("Issued Successfully..");
                else
                dangerAlert("Something Wrong");
            }
        });
    }
    
}
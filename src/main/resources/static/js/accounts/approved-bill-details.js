function issueBillAmount(){
    let billNo = $("#billNo").val();
  
        if(confirm("Are you sure to issue this Bill Amount?")){
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/issueBillAmount',
                data: {
                    billNo: billNo
                },
                success: function (data) {
                    if (data.result == 'successfull') {
                        successAlert("Bill Issue Successfully");    
                    } else {
                        warningAlert(data.message);
                    }
    
                }
            });
        }     
   
}
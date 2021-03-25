window.onload = () => {
    document.title = "Cash Transaction";
  
  }

function paymentBtnClickAction(){
    $("#ticketId").prop('disabled',false);
    $("#billLedger").prop('disabled',false);
    $("#billLedger").selectpicker('refresh');
    $("#billDate").prop('disabled',false);
    $("#billAmount").prop('disabled',false);
    $("#receiverTakenFrom").prop('disabled',false);
    $("#description").prop('disabled',false);
    $("#btnAdd").prop('disabled',false);
    $("#transactionType").val("payment");
    $("#receiveBtn").prop('disabled',true);
}

function receiveBtnClickAction(){
    $("#ticketId").prop('disabled',false);
    $("#billLedger").prop('disabled',false);
    $("#billLedger").selectpicker('refresh');
    $("#billDate").prop('disabled',false);
    $("#billAmount").prop('disabled',false);
    $("#receiverTakenFrom").prop('disabled',false);
    $("#description").prop('disabled',false);
    $("#btnAdd").prop('disabled',false);
    $("#transactionType").val("receive");
    $("#paymentBtn").prop('disabled',true);
}


function addAction() {
    let ledgerId = $("#billLedger").val();
    let ledgerName = $("#billLedger option:selected").text();
    let amount = $("#billAmount").val();
    let description = $("#description").val();

    if (ledgerId != 0) {
        if (amount != '') {
            let length = $("#ledgerList tr").length + 1;

            let row = `<tr id='row-${length}' data-id='${length}' data-ledger-id='${ledgerId}'>
                <td>${length}</td>
                <td id='ledgerName-${length}'>${ledgerName}</td>
                <td id='amount-${length}'>${amount}</td>
                <td id='description-${length}'>${description}</td>
                <td><i class="fa fa-edit" style="cursor:pointer;" onclick='setLedgerData("${length}")'> </i></td>
                <td><i class="fa fa-trash" style="cursor:pointer;" onclick='deleteRow("${length}")'> </i></td>
            </tr>`;

            $("#ledgerList").append(row);
        } else {
            warningAlert("Amount is empty... Please Enter Bill Amount");
            $("#billAmount").focus();
        }
    } else {
        warningAlert("Ledger is Not Selected");
        $("#billLedger").focus();
    }

}

function setLedgerData(id){
    let row = $("#row-"+id);
    $("#rowId").val(id);
    $("#billLedger").val(row.attr('data-ledger-id')).change();
    $("#billAmount").val($("#amount-"+id).text());
    $("#description").val($("#description-"+id).text());
    $("#btnAdd").hide();
    $("#btnEdit").show();
}

function editAction(){
    let rowId = $("#rowId").val();
    let row = $("row-"+rowId);

    let ledgerId = $("#billLedger").val();
    let ledgerName = $("#billLedger option:selected").text();
    let amount = $("#billAmount").val();
    let description = $("#description").val();

    if (ledgerId != 0) {
        if (amount != '') {
            row.attr('data-ledger-id',ledgerId);
            $("#ledgerName-"+rowId).text(ledgerName);
            $("#amount-"+rowId).text(amount);
            $("#description-"+rowId).text(description);

            $("#btnAdd").show();
            $("#btnEdit").hide();
        } else {
            warningAlert("Amount is empty... Please Enter Bill Amount");
            $("#billAmount").focus();
        }
    } else {
        warningAlert("Ledger is Not Selected");
        $("#billLedger").focus();
    }
}

function deleteRow(id) {
    $("#row-"+id).remove();
    
}


function refreshAction(){
    $("#ticketId").val("");
    $("#billLedger").val("0").change();
    $("#billAmount").val("");
    $("#receiverTakenFrom").val("");
    $("#description").val("");
    $("#btnAdd").show();
    $("#btnEdit").hide();
}



function completeTransaction() {
    let billNo = $("#billNo").val();
    let ticketId = $("#ticketId").val();
    let billDate = $("#billDate").val();
    let receiverTakenFrom = $("#receiverTakenFrom").val();

    let billLedgers = {};
    billLedgers['list'] = [];

    let rowList = $("#ledgerList tr");


    if (rowList.length > 0) {
        if (receiverTakenFrom != '') {
            if (billDate) {

                rowList.each((index, row) => {
                    let id = row.getAttribute('data-id');
                    let ledger = {
                        ledgerId: row.getAttribute('data-ledger-id'),
                        ledgerName: $("#ledgerName-" + id).text(),
                        amount: $("#amount-" + id).text(),
                        description: $("#description-" + id).text()
                    }

                    billLedgers.list.push(ledger);
                });
                console.log(billLedgers);
                if (confirm("Are you Sure to Complete This Transaction?")) {
                    if($("#transactionType").val() == "payment"){
                        console.log("paymentTransaction call")
                        $.ajax({
                            type: 'POST',
                            dataType: 'json',
                            url: '/submitPaymentTransaction',
                            data: {
                                billNo: billNo,
                                ticketId: ticketId,
                                billDate: billDate,
                                status: 1,
                                receiverTakenFrom: receiverTakenFrom,
                                billLedgers: JSON.stringify(billLedgers)
                            },
                            success: function (data) {
                                if (data.result == 'successfull') {
                                    successAlert("Transaction Complete Successfully");
                                    
                                } else {
                                    warningAlert(data.message);
                                }
    
                            }
                        });
                    }else{
                        console.log("Receive Transaction call")
                        $.ajax({
                            type: 'POST',
                            dataType: 'json',
                            url: '/submitReceiveTransaction',
                            data: {
                                billNo: billNo,
                                ticketId: ticketId,
                                billDate: billDate,
                                status: 1,
                                receiverTakenFrom: receiverTakenFrom,
                                billLedgers: JSON.stringify(billLedgers)
                            },
                            success: function (data) {
                                if (data.result == 'successfull') {
                                    successAlert("Transaction Complete Successfully");
                                } else {
                                    warningAlert(data.message);
                                }
    
                            }
                        });
                    }
                    
                }

            } else {
                warningAlert("Please Select Bill Date");
            }
        } else {
            warningAlert("Please Enter Receiver Or Taken From Name");
        }
    } else {
        warningAlert("Please Enter Any Product");
    }

}



let today = new Date();
document.getElementById("billDate").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);

window.onload = () => {
    document.title = "Bill Create";
  
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


function deleteRow(id) {
    $("#row-" + id).remove();
}



function submitBill() {
    let billNo = $("#billNo").val();
    let ticketId = $("#ticketId").val();
    let billDate = $("#billDate").val();

    let billLedgers = {};
    billLedgers['list'] = [];

    let rowList = $("#ledgerList tr");


    if (rowList.length > 0) {
        if (ticketId != '') {
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
                if (confirm("Are you Sure to submit?")) {
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: '/submitBill',
                        data: {
                            billNo: billNo,
                            ticketId: ticketId,
                            billDate: billDate,
                            status: 1,
                            billLedgers: JSON.stringify(billLedgers)
                        },
                        success: function (data) {
                            if (data.result == 'successfull') {
                                alert("Requisition Submit Successfully");
                                let url = "http://localhost:8080/accounts/pending-bill";
                                window.open(url, '_self');
                            } else {
                                warningAlert(data.message);
                            }

                        }
                    });
                }

            } else {
                warningAlert("Please Select Bill Date");
            }
        } else {
            warningAlert("Please Enter Ticket Id");
        }
    } else {
        warningAlert("Please Enter Any Product");
    }

}

let today = new Date();
document.getElementById("billDate").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
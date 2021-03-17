
function addAction(){
    let productId = $("#productName").val();
    let productName = $("#productName option:selected").text();
    let quantity = $("#quantity").val();
    let description = $("#description").val();

    let length = $("#requisitionProductList tr").length+1;

    let row = `<tr id='row-${length}' data-id='${length}' data-product-id='${productId}'>
                <td>${length}</td>
                <td id='productName-${length}'>${productName}</td>
                <td id='quantity-${length}'>${quantity}</td>
                <td id='description-${length}'>${description}</td>
                <td><i class="fa fa-trash" style="cursor:pointer;" onclick='deleteRow("${length}")'> </i></td>
            </tr>`;

    $("#requisitionProductList").append(row);
}


function deleteRow(id){
    $("#row-"+id).remove();
}


function submitProductRequisition(){
    let requisitionNo = $("#requisitionNo").val();
    let ticketId = $("#ticketId").val();
    let requisitionDate = $("#requisitionDate").val();

    let products = {};
    products['list'] = [];

    let rowList = $("#requisitionProductList tr");


    if(rowList.length>0){
        if(ticketId != ''){
            if(requisitionDate){

                rowList.each((index,row) => {
                    let id = row.getAttribute('data-id');
                    let product = {
                        productId : row.getAttribute('data-product-id'),
                        productName : $("#productName-"+id).text(),
                        quantity : $("#quantity-"+id).text(),
                        description : $("#description-"+id).text()
                    }

                    products.list.push(product);
                });
                console.log(products);
                if(confirm("Are you Sure to submit?")){
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: '/submitProductRequisition',
                        data: {
                            requisitionNo: requisitionNo,
                            ticketId: ticketId,
                            requisitionDate: requisitionDate,
                            status: 1,
                            productsString: JSON.stringify(products)
                        },
                        success: function (data) {
                            alert(data.result);
                        }
                      });
                }
                
            }else{
            warningAlert("Please Select Requisition Date");
        }
        }else{
            warningAlert("Please Enter Ticket Id");
        }   
    }else{
        warningAlert("Please Enter Any Product");
    }
    
}


let today = new Date();
document.getElementById("requisitionDate").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
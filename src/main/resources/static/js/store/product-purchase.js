
function addAction(){
    let productId = $("#productName").val();
    let productName = $("#productName option:selected").text();
    let quantity = $("#quantity").val();
    //let description = $("#description").val();

    if(productId != 0){
        if(quantity != ''){
            let length = $("#purchaseProductList tr").length+1;

            let row = `<tr id='row-${length}' data-id='${length}' data-product-id='${productId}'>
                        <td>${length}</td>
                        <td id='productName-${length}'>${productName}</td>
                        <td id='quantity-${length}'>${quantity}</td>
                        <td><i class="fa fa-trash" style="cursor:pointer;" onclick='deleteRow("${length}")'> </i></td>
                    </tr>`;
        
            $("#purchaseProductList").append(row);
        }else{
            warningAlert("Quantity is empty... Please Enter Quantity");
            $("#quantity").focus();
        }
    }else{
        warningAlert("Product Not Selected");
        $("#productName").focus();
    }
   
}


function deleteRow(id){
    $("#row-"+id).remove();
}


function submitPurchaseProduct(){
    let supplierName = $("#supplierName").val();
    //let ticketId = $("#ticketId").val();
    let purchaseDate = $("#purchaseDate").val();

    let products = {};
    products['list'] = [];

    let rowList = $("#purchaseProductList tr");


    if(rowList.length>0){
        if(supplierName != ''){
            if(purchaseDate){

                rowList.each((index,row) => {
                    let id = row.getAttribute('data-id');
                    let product = {
                        productId : row.getAttribute('data-product-id'),
                        productName : $("#productName-"+id).text(),
                        quantity : $("#quantity-"+id).text(),
                    }

                    products.list.push(product);
                });
                console.log(products);
                if(confirm("Are you Sure to submit?")){
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: '/submitPurchaseProduct',
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
            warningAlert("Please Select Purchase Date");
        }
        }else{
            warningAlert("Please Enter Supplier Name");
        }   
    }else{
        warningAlert("Please Enter Any Product");
    }
    
}


let today = new Date();
document.getElementById("purchaseDate").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
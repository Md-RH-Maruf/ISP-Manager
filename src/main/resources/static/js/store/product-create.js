window.onload = () => {
    document.title = "Product Create";
    $("#loader").show();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getCatgoryList',
        data: {},
        success: function (data) {
            $("#ul-0").empty();
            loadCategoryTree(data.categoryList);
            $("#loader").hide();

        }
    });
}


function categorySaveAction() {
    let parentsId = $("#parentName").val();
    let categoryName = $("#categoryName").val();
    console.log("category name", categoryName);
    if (categoryName != '') {
        if (confirm("Are you sure to Save this Category?")) {
            $("#loader").show();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/saveCategory',
                data: {
                    parentsId: parentsId,
                    categoryName: categoryName
                },
                success: function (data) {
                    if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                    } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Category Name..This Category Name Allreary Exist")
                    } else {

                        if (data.result.id) {
                            successAlert("Category Save Successfully");
                            // $('#customerDetailsTable').dataTable().fnDestroy();
                            // $("#customerDetailsList").empty();
                            // $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                            // $('#customerDetailsTable').DataTable(({
                            //     "destroy": true,
                            // }));
                            // $("#exampleModal").modal('hide');
                            $("#ul-0").empty();
                            console.log(data);
                            loadCategoryTree(data.categoryList);

                        } else {
                            successAlert("Something went wrong");
                        }

                    }
                    $("#loader").hide();
                }
            });
        }
    } else {
        warningAlert("Category Name Is Empty... Please Enter Category Name");
        $("#categoryName").focus();
    }
}


function categoryEditAction() {
    let categoryId = $("#categoryId").val();
    let parentsId = $("#parentName").val();
    let categoryName = $("#categoryName").val();

    if (categoryName != '') {
        if (confirm("Are you sure to Edit this Category?")) {
            $("#loader").show();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/editCategory',
                data: {
                    id: categoryId,
                    parentsId: parentsId,
                    categoryName: categoryName
                },
                success: function (data) {
                    if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                    } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Category Name..This Category Name Allreary Exist")
                    } else {

                        if (data.result.id) {
                            successAlert("Category Save Successfully");
                            // $('#customerDetailsTable').dataTable().fnDestroy();
                            // $("#customerDetailsList").empty();
                            // $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                            // $('#customerDetailsTable').DataTable(({
                            //     "destroy": true,
                            // }));
                            // $("#exampleModal").modal('hide');
                            $("#ul-0").empty();
                            //$("#cat-0").append(`<ul id="ul-0"></ul>`);
                            console.log(data);
                            loadCategoryTree(data.categoryList);

                        } else {
                            successAlert("Something went wrong");
                        }

                    }
                    $("#loader").hide();
                }
            });
        }
    } else {
        warningAlert("Category Name Is Empty... Please Enter Category Name");
        $("#categoryName").focus();
    }
}

function setCategoryData(categoryId, event) {
    $("#categoryId").val(categoryId);
    let parentsId = $("#cat-" + categoryId).attr('data-parent-id');
    $("#parentName").val(parentsId).change();
    $("#productCategoryName").val(categoryId).change();
    $("#categoryName").val($("#cat-" + categoryId).clone()	//clone the element
        .children()	//select all the children
        .remove()	//remove all the children
        .end()	//again go back to selected element
        .text());
    event.stopPropagation();
    $("#btnCategorySave").hide();
    $("#btnCategoryEdit").show();
}

function categoryRefreshAction() {
    $("#btnCategorySave").show();
    $("#btnCategoryEdit").hide();
}


function productSaveAction() {


    let categoryId = $("#productCategoryName").val();
    let productName = $("#productName").val();
    let brandName = $("#brandName").val();
    let activeStatus = $("#activeStatus").val();

    if (categoryId != 0) {
        if (productName != '') {
            if (confirm("Are you sure to Save this Product?")) {
                $("#loader").show();
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/saveProduct',
                    data: {
                        categoryId: categoryId,
                        productName: productName,
                        brandName: brandName,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                        if (data.result == "Something Wrong") {
                            warningAlert("Something went wrong");
                        } else if (data.result == "duplicate") {
                            warningAlert("Duplicate Product Name..This productTable Name Allreary Exist")
                        } else {

                            if (data.result.id) {
                                successAlert("Product Save Successfully");
                                // $('#productTable').dataTable().fnDestroy();
                                $("#productList").empty();
                                $("#productList").append(drawProductTable(data.productList));
                                // $('#productTable').DataTable(({
                                //     "destroy": true,
                                // }));
                                // $("#exampleModal").modal('hide');
                            } else {
                                warningAlert("Something went wrong");
                            }

                        }
                        $("#loader").hide();
                    }
                });
            }
        } else {
            warningAlert('Product Name is Empty....Please Enter Product Name');
            $("#productName").focus();
        }
    } else {
        warningAlert('Please Select Category Name');
        $("#productCategoryName").focus();
    }
}


function productEditAction() {

    let productId = $("#productId").val();
    let categoryId = $("#productCategoryName").val();
    let productName = $("#productName").val();
    let brandName = $("#brandName").val();
    let activeStatus = $("#activeStatus").val();

    if (categoryId != 0) {
        if (productName != '') {
            if (confirm("Are you sure to Save this Product?")) {
                $("#loader").show();
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/editProduct',
                    data: {
                        id: productId,
                        categoryId: categoryId,
                        productName: productName,
                        brandName: brandName,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                        if (data.result == "Something Wrong") {
                            warningAlert("Something went wrong");
                        } else if (data.result == "duplicate") {
                            warningAlert("Duplicate Product Name..This productTable Name Allreary Exist")
                        } else {

                            if (data.result.id) {
                                successAlert("Product Save Successfully");
                                // $('#productTable').dataTable().fnDestroy();
                                $("#productList").empty();
                                $("#productList").append(drawProductTable(data.productList));
                                // $('#productTable').DataTable(({
                                //     "destroy": true,
                                // }));
                                // $("#exampleModal").modal('hide');
                            } else {
                                warningAlert("Something went wrong");
                            }

                        }
                        $("#loader").hide();
                    }
                });
            }
        } else {
            warningAlert('Product Name is Empty....Please Enter Product Name');
            $("#productName").focus();
        }
    } else {
        warningAlert('Please Select Category Name');
        $("#productCategoryName").focus();
    }
}

function setProductData(productId) {
    $("#loader").show();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getProductInfo',
        data: {
            productId: productId
        },
        success: function (data) {
            let product = data.productInfo;
            $("#productId").val(product.id);
            $("#productCategoryName").val(product.categoryId);
            $("#productName").val(product.productName);
            $("#brandName").val(product.brandName);
            $("#activeStatus").val(product.activeStatus);
            $("#btnProductSave").hide();
            $("#btnProductEdit").show();
            $("#loader").hide();
        }
    });
}


function productRefreshAction() {
    $("#btnProductEdit").hide();
    $("#btnProductSave").show();
    $("#productId").val('');
}


function drawProductTable(data) {
    let rows = "";
    let length = data.length;

    for (let i = 0; i < length; i++) {
        let product = data[i];
        rows += `<tr style="cursor: pointer;"
      onclick="setProductData('${product.id}')">
      <td>${product.productName}</td>
      <td>${product.brandName}</td>
      <td>${product.activeStatus}</td>
  </tr>`;
    }

    return rows;
}

function loadCategoryTree(data) {
    let previousParentId = 0;
    let length = data.length;
    for (let i = 0; i < length; i++) {
        let category = data[i];
        let parentsId = category.parentsId;
        if (parentsId == previousParentId) {
            $(`#ul-${parentsId}`).append(`<li id='cat-${category.id}' data-parent-id='${parentsId}' onclick='setCategoryData("${category.id}",event)'>${category.categoryName}</li>`);
        } else {
            $(`#cat-${parentsId}`).append(`<ul id='ul-${parentsId}'><li id='cat-${category.id}' data-parent-id='${parentsId}' onclick='setCategoryData("${category.id}",event)'>${category.categoryName}</li></ul>`);
            previousParentId = parentsId;
        }

    }
    $('#tree1').treed();
}

$.fn.extend({
    treed: function (o) {

        var openedClass = 'fa fa-minus-circle';
        var closedClass = 'fa fa-plus-circle';

        if (typeof o != 'undefined') {
            if (typeof o.openedClass != 'undefined') {
                openedClass = o.openedClass;
            }
            if (typeof o.closedClass != 'undefined') {
                closedClass = o.closedClass;
            }
        };

        //initialize each of the top levels
        var tree = $(this);
        tree.addClass("tree");
        tree.find('li').has("ul").each(function () {
            var branch = $(this); //li with children ul
            branch.prepend("<i class='indicator glyphicon " + closedClass + "'></i>");
            branch.addClass('branch');
            branch.on('click', function (e) {
                if (this == e.target) {
                    var icon = $(this).children('i:first');
                    icon.toggleClass(openedClass + " " + closedClass);
                    $(this).children().children().toggle();
                }
            })
            branch.children().children().toggle();
        });
        //fire event from the dynamically added icon
        tree.find('.branch .indicator').each(function () {
            $(this).on('click', function () {
                $(this).closest('li').click();
            });
        });
        //fire event to open branch if the li contains an anchor instead of text
        tree.find('.branch>a').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
        //fire event to open branch if the li contains a button instead of text
        tree.find('.branch>button').each(function () {
            $(this).on('click', function (e) {
                $(this).closest('li').click();
                e.preventDefault();
            });
        });
    }
});




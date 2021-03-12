window.onload = () => {
    document.title = "Product Create";
    $("#loader").show();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getCatgoryList',
        data: {},
        success: function (data) {
            //$("#cat-0").empty();
            console.log(data);
           $("#loader").hide();
        }
    });
 }

function categorySaveAction() {
    let parentsId = $("#parentName").val();
    let categoryName = $("#categoryName").val();
    console.log("category name",categoryName);
    if(categoryName != ''){
        if (confirm("Are you sure to Save this Category?")) {
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
                        successAlert("Something went wrong");
                    } else if (data.result == "duplicate") {
                        successAlert("Duplicate Category Name..This Category Name Allreary Exist")
                    } else {
    
                        if (data.result.id) {
                            successAlert("Category Save Successfully");
                            $('#customerDetailsTable').dataTable().fnDestroy();
                            $("#customerDetailsList").empty();
                            $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                            $('#customerDetailsTable').DataTable(({
                                "destroy": true,
                            }));
                            $("#exampleModal").modal('hide');
                        } else {
                            successAlert("Something went wrong");
                        }
    
                    }
                }
            });
        }
    }else{
        warningAlert("Category Name Is Empty... Please Enter Category Name");
        $("#categoryName").focus();
    }
}



function productSaveAction() {


    let categoryId = $("#productCategoryName").val();
    let productName = $("#productName").val();
    let brandName = $("#brandName").val();
    let activeStatus = $("#activeStatus").val();

    if (confirm("Are you sure to Save this Product?")) {
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
                    alert("Something went wrong");
                } else if (data.result == "duplicate") {
                    alert("Duplicate Category Name..This Category Name Allreary Exist")
                } else {

                    if (data.result.id) {
                        alert("Category Save Successfully");
                        $('#customerDetailsTable').dataTable().fnDestroy();
                        $("#customerDetailsList").empty();
                        $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                        $('#customerDetailsTable').DataTable(({
                            "destroy": true,
                        }));
                        $("#exampleModal").modal('hide');
                    } else {
                        alert("Something went wrong");
                    }

                }
            }
        });
    }


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


$('#tree1').treed();

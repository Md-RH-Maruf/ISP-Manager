window.onload = () => {
    document.title = "Ledger Create";
    $("#loader").show();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getLedgerHeadList',
        data: {},
        success: function (data) {
            $("#ul-0").empty();
            loadHeadTree(data.ledgerHeadList);
            $("#loader").hide();

        }
    });
}


function headSaveAction() {
    let parentsId = $("#parentName").val();
    let headName = $("#headName").val();
    console.log("head name", headName);
    if (headName != '') {
        if (confirm("Are you sure to Save this Head?")) {
            $("#loader").show();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/saveLedgerHead',
                data: {
                    parentId: parentsId,
                    headName: headName
                },
                success: function (data) {
                    if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                    } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Head Name..This Head Name Allreary Exist")
                    } else {

                        if (data.result.id) {
                            successAlert("Head Save Successfully");
                            // $('#customerDetailsTable').dataTable().fnDestroy();
                            // $("#customerDetailsList").empty();
                            // $("#customerDetailsList").append(drawCustomerDetailsTable(data.customerList));
                            // $('#customerDetailsTable').DataTable(({
                            //     "destroy": true,
                            // }));
                            // $("#exampleModal").modal('hide');
                            $("#ul-0").empty();
                            console.log(data);
                            loadHeadTree(data.ledgerHeadList);

                        } else {
                            successAlert("Something went wrong");
                        }

                    }
                    $("#loader").hide();
                }
            });
        }
    } else {
        warningAlert("Head Name Is Empty... Please Enter Head Name");
        $("#headName").focus();
    }
}


function headEditAction() {
    let headId = $("#headId").val();
    let parentsId = $("#parentName").val();
    let headName = $("#headName").val();

    if (headName != '') {
        if (confirm("Are you sure to Edit this Head?")) {
            $("#loader").show();
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url: '/editLedgerHead',
                data: {
                    id: headId,
                    parentId: parentsId,
                    headName: headName
                },
                success: function (data) {
                    if (data.result == "Something Wrong") {
                        dangerAlert("Something went wrong");
                    } else if (data.result == "duplicate") {
                        dangerAlert("Duplicate Head Name..This Head Name Allreary Exist")
                    } else {

                        if (data.result.id) {
                            successAlert("Head Save Successfully");
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
                            loadHeadTree(data.ledgerHeadList);

                        } else {
                            successAlert("Something went wrong");
                        }

                    }
                    $("#loader").hide();
                }
            });
        }
    } else {
        warningAlert("Head Name Is Empty... Please Enter Head Name");
        $("#headName").focus();
    }
}

function setHeadData(headId, event) {
    $("#headId").val(headId);
    let parentsId = $("#cat-" + headId).attr('data-parent-id');
    $("#parentName").val(parentsId).change();
    $("#ledgerHeadName").val(headId).change();
    $("#headName").val($("#cat-" + headId).clone()	//clone the element
        .children()	//select all the children
        .remove()	//remove all the children
        .end()	//again go back to selected element
        .text());
    event.stopPropagation();
    $("#btnHeadSave").hide();
    $("#btnHeadEdit").show();
}

function headRefreshAction() {
    $("#btnHeadSave").show();
    $("#btnHeadEdit").hide();
}


function ledgerSaveAction() {


    let headId = $("#ledgerHeadName").val();
    let ledgerName = $("#ledgerName").val();
    let openingBalance = $("#openingBalance").val()==''?0:$("#openingBalance").val();
    let activeStatus = $("#activeStatus").val();

    if (headId != 0) {
        if (ledgerName != '') {
            if (confirm("Are you sure to Save this Ledger?")) {
                $("#loader").show();
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/saveLedger',
                    data: {
                        headId: headId,
                        ledgerName: ledgerName,
                        openingBalance: openingBalance,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                        if (data.result == "Something Wrong") {
                            warningAlert("Something went wrong");
                        } else if (data.result == "duplicate") {
                            warningAlert("Duplicate Ledger Name..This ledgerTable Name Allreary Exist")
                        } else {

                            if (data.result.id) {
                                successAlert("Ledger Save Successfully");
                                // $('#ledgerTable').dataTable().fnDestroy();
                                $("#ledgerList").empty();
                                $("#ledgerList").append(drawLedgerTable(data.ledgerList));
                                // $('#ledgerTable').DataTable(({
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
            warningAlert('Ledger Name is Empty....Please Enter Ledger Name');
            $("#ledgerName").focus();
        }
    } else {
        warningAlert('Please Select Head Name');
        $("#ledgerHeadName").focus();
    }
}


function ledgerEditAction() {

    let ledgerId = $("#ledgerId").val();
    let headId = $("#ledgerHeadName").val();
    let ledgerName = $("#ledgerName").val();
    let openingBalance = $("#openingBalance").val()==''?0:$("#openingBalance").val();
    let activeStatus = $("#activeStatus").val();

    if (headId != 0) {
        if (ledgerName != '') {
            if (confirm("Are you sure to Save this Ledger?")) {
                $("#loader").show();
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    url: '/editLedger',
                    data: {
                        id: ledgerId,
                        headId: headId,
                        ledgerName: ledgerName,
                        openingBalance: openingBalance,
                        activeStatus: activeStatus
                    },
                    success: function (data) {
                        if (data.result == "Something Wrong") {
                            warningAlert("Something went wrong");
                        } else if (data.result == "duplicate") {
                            warningAlert("Duplicate Ledger Name..This ledgerTable Name Allreary Exist")
                        } else {

                            if (data.result.id) {
                                successAlert("Ledger Save Successfully");
                                // $('#ledgerTable').dataTable().fnDestroy();
                                $("#ledgerList").empty();
                                $("#ledgerList").append(drawLedgerTable(data.ledgerList));
                                // $('#ledgerTable').DataTable(({
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
            warningAlert('Ledger Name is Empty....Please Enter Ledger Name');
            $("#ledgerName").focus();
        }
    } else {
        warningAlert('Please Select Head Name');
        $("#ledgerHeadName").focus();
    }
}

function setLedgerData(ledgerId) {
    $("#loader").show();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: '/getLedgerInfo',
        data: {
            ledgerId: ledgerId
        },
        success: function (data) {
            let ledger = data.ledgerInfo;
            $("#ledgerId").val(ledger.id);
            $("#ledgerHeadName").val(ledger.headId).change();
            $("#ledgerName").val(ledger.ledgerName);
            $("#openingBalance").val(ledger.openingBalance);
            $("#activeStatus").val(ledger.activeStatus);
            $("#btnLedgerSave").hide();
            $("#btnLedgerEdit").show();
            $("#loader").hide();
        }
    });
}


function ledgerRefreshAction() {
    $("#btnLedgerEdit").hide();
    $("#btnLedgerSave").show();
    $("#ledgerId").val('');
}


function drawLedgerTable(data) {
    let rows = "";
    let length = data.length;

    for (let i = 0; i < length; i++) {
        let ledger = data[i];
        rows += `<tr style="cursor: pointer;"
                    onclick="setLedgerData('${ledger.id}')">
                    <td>${ledger.id}</td>
                    <td>${ledger.ledgerName}</td>
                    <td>${ledger.openingBalance}</td>
                    <td>${ledger.activeStatus}</td>
                </tr>`;
    }

    return rows;
}

function loadHeadTree(data) {
    let previousParentId = 0;
    let length = data.length;
    for (let i = 0; i < length; i++) {
        let head = data[i];
        let parentId = head.parentId;
        if (parentId == previousParentId) {
            $(`#ul-${parentId}`).append(`<li id='cat-${head.id}' data-parent-id='${parentId}' onclick='setHeadData("${head.id}",event)'>${head.headName}</li>`);
        } else {
            $(`#cat-${parentId}`).append(`<ul id='ul-${parentId}'><li id='cat-${head.id}' data-parent-id='${parentId}' onclick='setHeadData("${head.id}",event)'>${head.headName}</li></ul>`);
            previousParentId = parentId;
        }

    }
    $('#tree1').treed();
}

$.fn.extend({
    treed: function (o) {
      
      var openedClass = 'fa fa-minus-circle';
      var closedClass = 'fa fa-plus-circle';
      
      if (typeof o != 'undefined'){
        if (typeof o.openedClass != 'undefined'){
        openedClass = o.openedClass;
        }
        if (typeof o.closedClass != 'undefined'){
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
      tree.find('.branch .indicator').each(function(){
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


//$('#tree1').treed();
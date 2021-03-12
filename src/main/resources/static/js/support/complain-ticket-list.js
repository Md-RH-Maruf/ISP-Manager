window.onload = () => {
  document.title = "Activation Ticket List";

//   $('#openDataTable').dataTable().fnDestroy();
// $('#openDataTable').DataTable(({ 
//   "destroy": true, 
// }));
}

$(document).ready(function() {
    $('#openDataTable').DataTable();
    $('#processingDataTable').DataTable();
    $('#closedDataTable').DataTable();
    $('#deletedDataTable').DataTable();

});


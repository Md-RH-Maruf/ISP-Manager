window.onload = () => {
  document.title = "Activation Ticket List";

  $('#openDataTable').dataTable().fnDestroy();
$("#openDataBody").append(`<tr>
    <td>tms-32</td>
    <td>New Connection</td>
    <td>3-jun-2021</td>
    <td>10:49</td>
    <td>Processing</td>
    <td>Low</td>
    <td>Kartiq</td>
    <td><a href="/activation-tms-details/242">Action</a></td>
</tr>`)
$('#openDataTable').DataTable(({ 
  "destroy": true, 
}));
}

$(document).ready(function() {
    $('#openDataTable').DataTable();
    $('#processingDataTable').DataTable();
    $('#closedDataTable').DataTable();
    $('#deletedDataTable').DataTable();

   
});


window.onload = () => {
  document.title = "Role Management";

  $("#dataBody").append(`<tr>
      <td>tms-32</td>
      <td>New Connection</td>
      <td>3-jun-2021</td>
      <td>10:49</td>
      <td>Processing</td>
      <td>Low</td>
      <td>Kartiq</td>
      <td><a href="/tms-details/242">Action</a></td>
  </tr>`)
}

$(document).ready(function() {
    $('#dataTable').DataTable();
  });
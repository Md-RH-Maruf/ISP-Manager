window.onload = () => {
    document.title = "Product Requisition List";
  
  }

  function viewTicket(ticketId,event){
    console.log("ticketId"+ticketId);
    event.preventDefault();
    let url = 'http://localhost:8080/activation-tms-details/'+ticketId;
    window.open(url, '_blank');
  }

  function viewRequisition(requisitionNo,event){
    event.preventDefault();
    let url = 'http://localhost:8080/store/product-requisition/'+requisitionNo;
    window.open(url, '_self');
  }

  function viewApprovedRequisition(requisitionNo,event){
    event.preventDefault();
    let url = 'http://localhost:8080/store/approved-product-requisition/'+requisitionNo;
    window.open(url, '_self');
  }
  
  $(document).ready(function() {
      $('#pendingDataTable').DataTable();
      $('#approvedDataTable').DataTable();
      $('#notApprovedDataTable').DataTable();
  });
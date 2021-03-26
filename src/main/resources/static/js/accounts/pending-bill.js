function viewBillDetails(billNo,event){
    
    event.preventDefault();
    let url = 'http://localhost:8080/accounts/pending-bill-details/'+billNo;
    window.open(url, '_blank');
}
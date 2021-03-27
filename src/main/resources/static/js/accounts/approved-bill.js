function issueBillAmount(billNo,event){
    
    event.preventDefault();
    let url = 'http://localhost:8080/accounts/approved-bill-details/'+billNo;
    window.open(url, '_blank');
}
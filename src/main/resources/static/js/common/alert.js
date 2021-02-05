
 function successAlert(message) {
    var element = $(".alert");
    element.hide();
    element = $(".alert-success");
    document.getElementById("successAlert").innerHTML = "<strong>Success!</strong> " + message + "...";
    element.show();
    setTimeout(() => {
      element.toggle('fade');
    }, 3000);
  }
  
   function warningAlert(message) {
    var element = $(".alert");
    element.hide();
    element = $(".alert-warning");
    document.getElementById("warningAlert").innerHTML = "<strong>Warning!</strong> " + message + "..";
    element.show();
    setTimeout(() => {
      element.toggle('fade');
    }, 3000);
  }
  
   function dangerAlert(message) {
    var element = $(".alert");
    element.hide();
    element = $(".alert-danger");
    document.getElementById("dangerAlert").innerHTML = "<strong>Wrong!</strong> " + message + "..";
    element.show();
    setTimeout(() => {
      element.toggle('fade');
    }, 3000);
  }
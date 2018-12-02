function updatedate() {
    var firstdate = document.getElementById("checkin").value;
    var seconddate = document.getElementById("checkout");
    //var newfirstdate = new Date(firstdate);
    //newfirstdate.setDate(newfirstdate.getDate() + 1);
   // var mm = newfirstdate.getMonth() + 1; // getMonth() is zero-based
    //var dd = newfirstdate.getDate();
    //var newday = newfirstdate.getFullYear() + '-' (mm>9 ? '' : '0') + mm + '-' (dd>9 ? '' : '0') + dd;
    seconddate.min=firstdate;
  }
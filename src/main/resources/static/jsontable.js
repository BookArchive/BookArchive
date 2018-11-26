

filterSelection('a');

    /* function displayBookData(input) {
          var text = input;

          obj = JSON.parse(text);
          document.getElementById("BookResults").innerHTML =
          obj.input[1].author + " " + obj.input[1].title;
    }
*/

    function displayBookData(input) {
    document.addEventListener("DOMContentLoaded", ()=>{
      let jsonstr= input;
      let jsonobj= JSON.parse(jsonstr)
      let form.document.querySelector("form")


      form.string.addEventListener("click", ()=>{
          let out=form.out
          if(!jsonobj.length)
            return
          let tblstr="<table>"
          tblstr+="<caption>Table Using HTML String</caption>"
          tblstr+="<tr>"
          for(let prop in jsonobj[0]) {
            tblstr+=`<th>${prop}`
          }
          tblstr+=jsonobj.reduce((s, x) => {
            s+="<tr>"
            for(let prop in x) {
              s+=`<td>${x[prop]}`
            }
            return s
          }, "")
          tblstr+="</table>"
          out.insertAdjacentHTML("beforeend", "<p>" + tblstr)
        })

    }

    function classBtnClick(theId){
         var str = $(theId).attr("id");
         var arr = theId.split("-");
         alert(arr);
         let int =0;
         int = arr[1];

         $.postJSON("api/booksbyclass",{
             subject: arr[0],
            classNum: int
         },(data)=>{
            console.log(data);
            displayBookData(data);

         });


    }


    $.postJSON = function(url, data, callback) {
        return jQuery.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'type': 'POST',
            'url': url,
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success': callback
            });
     }




 /*$(document).ready(function(){



     $(".classbtn").click(()=>{
         var idOfBtn = $(this).attr("id");
         alert(idOfBtn);
         var str = $(idOfBtn).text();
         var arr = str.split(" ");
         let int =0;
         int = arr[1];

         $.postJSON("api/booksbyclass",{
             subject: arr[0],
            classNum: int
         },(data)=>{
            console.log(data);
         });

     });





     function eventHandle(data){
        console.log(data);
     }
});*/

function filterSelection(c) {
  var x, i;
  x = document.getElementsByClassName("Mcolumn");
  if (c == "all") c = "";
  for (i = 0; i < x.length; i++) {
    w3RemoveClass(x[i], "show");
    if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
  }
}

function w3AddClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
  }
}

function w3RemoveClass(element, name) {
  var i, arr1, arr2;
  arr1 = element.className.split(" ");
  arr2 = name.split(" ");
  for (i = 0; i < arr2.length; i++) {
    while (arr1.indexOf(arr2[i]) > -1) {
      arr1.splice(arr1.indexOf(arr2[i]), 1);
    }
  }
  element.className = arr1.join(" ");
}



var btnContainer = document.getElementById("myBtnContainer");
var btns = btnContainer.getElementsByClassName("Mbtn");
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function(){
    var current = document.getElementsByClassName("active");
    current[0].className = current[0].className.replace(" active", "");
    this.className += " active";
  });
}

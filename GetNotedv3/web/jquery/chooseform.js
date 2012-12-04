/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function showForm() {
     var temp = $('select.selector').val();
     if (temp == "student") {
         $(".professor").hide();
         $(".student").show(1000);
     }
     else if (temp == "professor") {
         $(".student").hide();
         $(".professor").show(1000);
     }
     else {
         $(".student").hide();
         $(".professor").hide();
     }
}
     $(document).ready(function() {
         $(".student").hide();
         $(".professor").hide();
     });

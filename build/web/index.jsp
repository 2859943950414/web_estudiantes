<%-- 
    Document   : index
    Created on : 1/10/2022, 02:08:49
    Author     : lglui
--%>

<%@page import="javax.swing.table.DefaultTableModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Blood" %>
<%@page import="modelo.Estudent" %>
<%@page import="java.util.HashMap" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estudents</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    
     <body>
        <div class="container">
             
     <!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal_students">
  New
</button>

<!-- Modal -->
<div class="modal fade" id="modal_students" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Students</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
      <div class="container">
          
        <h1>Students Form</h1> 
      <form action="sr_student" method="post" class="form-group">
        
        <label for="lbl_id"> <b> ID </b> </label>
        <input type="text" name="txt_id" id="txt_id" value="0" class="form-control" readonly> 
        
        <label for="lbl_key1"> <b>Key </b> </label>
        <input type="text" name="txt_key" id="txt_key1" placeholder="Example: E001"class="form-control">
        
        <label for="lbl_names1"><b>Names</b> </label>
        <input type="text" name="txt_names1" id="txt_names1" placeholder="Example: Name 1 Name 2"class="form-control">
        
        <label for="lbl_lastname"><b>Last Names</b> </label>
        <input type="text" name="txt_lastnames" id="txt_lastnames" placeholder="Example: Last Name 1 Last Name 2"class="form-control">
        
        <label for="lbl_address"><b>Address</b> </label>
        <input type="text" name="txt_address" id="txt_address" placeholder="Example: 1956 Hery Ford Avenue Manhattan, NY 10016"class="form-control">
        
        
        <label for="lbl_phone"><b>Phone</b> </label>
        <input type="number" name="txt_phone" id="txt_phone" placeholder="Example: 45411378 "class="form-control">
        
        <label for="lbl_blood"><b>Blood</b> </label>
        <select name="drop_blood" id="drop_blood"class="form-select">
        
              <% 
                        Blood blood = new Blood();
                        HashMap<String,String> drop = blood.drop_sangre();
                        
                        for (String i: drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                    %>
        </select>
        <label for="lbl_dbo"><b>Birth</b> </label>
        <input type="date" name="txt_dbo" id="txt_dbo" placeholder="Example: dd-mm-yyyy "class="form-control">
        
         <br> 
         <button name="btn_add" id="btn_add" value="add" class="btn btn-primary">Add</button> 
         <button name="btn_modify" id="btn_modify" value="modify" class="btn btn-success">Modify</button> 
         <button name="btn_delete" id="btn_delete" value="delete" class="btn btn-danger">Delete</button> 
     </form>
         <br> 
        
        
        <table class="table table-dark table-striped">
        <thead> 
            <tr>
                <th>Key </th>
                <th>Names </th>
                <th> Last Names</th>
                <th>Address </th>
                <th> Phone</th>
                <th> Blood</th>
                <th> Birth </th>
            </tr>
        </thead>    
        <tbody id="tbl_students">
       
            <% 
            Estudent estudent = new Estudent();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla = estudent.read();
            for (int t=0; t<tabla.getRowCount();t++ ){
                
                out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_b=" + tabla.getValueAt(t,7) + ">");
                  out.println("<td>"+ tabla.getValueAt(t,1)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,2)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,3)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,4)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,5)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,6)  +"</td>");
                  out.println("<td>"+ tabla.getValueAt(t,7)  +"</td>");
                out.println("</tr>");
                
                }
            
            
            
            %>
    
        </table>
        
        
     </div>
        <script src="https://code.jquery.com/jquery-3.6.1.slim.js" integrity="sha256-tXm+sa1uzsbFnbXt8GJqsgi2Tw+m4BLGDof6eUPjbtk=" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>    
     
     <script>
         $('#tbl_students').on('click','tr td',function(evt){
             
            var target,id,id_b,key,name,lastname,address,phone,dbo; 
             target = $(event.target);
             id= target.parent().data('id');
             id_b= target.parent().data('id_b');
                key = target.parent("tr").find("td").eq(0).html();
                name= target.parent("tr").find("td").eq(1).html();
                lastname = target.parent("tr").find("td").eq(2).html();
                address= target.parent("tr").find("td").eq(3).html();
                phone = target.parent("tr").find("td").eq(4).html();
                dbo = target.parent("tr").find("td").eq(5).html();
             
                $('#txt_id').val(id);
                $('#drop_blood').val(id_b);
                
                $("#txt_key1").val(key);
                $("#txt_names1").val(name);
                $("#txt_lastnames").val(lastname);
                $("#txt_address").val(address);
                $("#txt_phone").val(phone);
                $("#drop_blood").val(id_b);
                $("#txt_dbo").val(dbo);
                $("#modal_student").modal('show');
         });
     </script>    
     
   </body> 
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
<title>Home Page</title>
body {margin:0;font-family:Arial}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.active {
  background-color: #04AA6D;
  color: white;
}

.topnav .icon {
  display: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 17px;    
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.topnav a:hover, .dropdown:hover .dropbtn {
  background-color: #555;
  color: white;
}

.dropdown-content a:hover {
  background-color: #ddd;
  color: black;
}

.dropdown:hover .dropdown-content {
  display: block;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child), .dropdown .dropbtn {
    display: none;
  }
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
    display: block;
    width: 100%;
    text-align: left;
  }
}

* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  background-size:cover;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
</style>
</head>
<body>

<div class="topnav" id="myTopnav">
  <a href="login" class="active">Log Out</a>
  
  <div class="dropdown">
    <button class="dropbtn">Raw Materials 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addRawPage">Add Raw Materials</a>
      <a href="viewRaw">View Raw Materials</a>
      <a href="updateRawPage">Update Raw Materials</a>
    </div>
  </div> 
  
  <div class="dropdown">
    <button class="dropbtn">Processed Items 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="addProcessPage">Add Processed Items</a>
      <a href="viewProcess">View Processed Items</a>
      <a href="updateProcessPage">Update Processed Items</a>
    </div>
  </div> 
  
  <a href="issueProcessPage">Issue Processed Items</a>
  <a href="viewIssueProcessLog">Processed Logs</a>
  <a href="issueRawPage">Issue Raw Materials</a>
  <a href="viewIssueRawLog">Raw Logs</a>
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>


<div class="container">
  <form action="addProcess" method="POST">
    <div class="row">
      <div class="col-25">
        <label for="fname">Product ID</label>
      </div>
      <div class="col-75">
        <input type="text" id="fname" name="id" placeholder="Product ID">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="lname">Product Name</label>
      </div>
      <div class="col-75">
        <input type="text" id="lname" name="name" placeholder="Product Name">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="fname">Product Quantity</label>
      </div>
      <div class="col-75">
        <input type="text" id="fname" name="quantity" placeholder="Product Quantity">
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="country">Unit</label>
      </div>
      <div class="col-75">
        <select id="country" name="unit">
          <option value="kg">KG</option>
          <option value="ltr">LTR</option>
          <option value="pcs">PCS</option>
        </select>
      </div>
    </div>
    
    <div class="row">
      <div class="col-25">
        <label for="fname">Cost Per Unit</label>
      </div>
      <div class="col-75">
        <input type="text" id="fname" name="cpu" placeholder="Cost Per Unit">
      </div>
    </div>
    
    
    <div class="row" align="left">
      <input type="submit" value="Add Processed Material">
    </div>
  </form>
  </div>


<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>

</body>
</html>
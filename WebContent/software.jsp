<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Softwares</title>
<script>
window.onload = loadDynamicContent;

function loadDynamicContent() {
	toggleWebServers();
	toggleDbServers();
}

function addRow(tableID) 
{
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var counts = rowCount - 1;

        var cell1 = row.insertCell(0);
        var appName = document.createElement("input");
        appName.type = "text";
        appName.name = "additionalSoftware[" + counts + "].name";
        cell1.appendChild(appName);

        var cell2 = row.insertCell(1);
        var gitURL = document.createElement("input");
        gitURL.type = "text";
        gitURL.name = "additionalSoftware[" + counts + "].githubURL";
        cell2.appendChild(gitURL);

}
	function toggleWebServers() {
		var val = document.getElementById("web_server").value;
		var div = document.getElementById("dynamic_web_server");
		if (val == "Yes") {
			var html = "<p>Choose your web server</p>\
				<select id=\"webServer\" name=\"webServer\">\
				<option value=\"null\">Choose One:</option>\
				<option value=\"Apache\">Apache</option>\
				<option value=\"GWS\">GWS</option>\
				<option value=\"nginx\">nginx</option>\
				</select>";
			div.innerHTML = html;
		} else {
			div.innerHTML = "";
		}
	}
	
	function toggleDbServers() {
		var val = document.getElementById("database_server").value;
		var div = document.getElementById("dynamic_database_server");
		if (val == "Yes") {
			var html = "<p>Choose your database server</p>\
				<select id=\"databaseServer\" name=\"databaseServer\">\
				<option value=\"null\">Choose One:</option>\
				<option value=\"MySql\">MySql</option>\
				<option value=\"PostgreSQL\">PostgreSQL</option>\
				<option value=\"MariaDB\">MariaDB</option>\
				</select>";
			div.innerHTML = html;
		} else {
			div.innerHTML = "";
		}
	}
	
</script>
<style>
label {
	color: red;
}
</style>
</head>

<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="js/collapse.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="UNITED COMMS Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
</head>
<body>
<!-- header-section-starts -->
<div class="header">
<div class="container">
<div class="logo"><a href="index.html"><img
	src="images/logo.png" class="img-responsive" alt="" /></a></div>
<div class="header-right">
<h4><i class="phone"></i>(573) 999 1234</h4>
<span class="menu"></span>
<div class="top-menu">
<ul>
	<li><a href="index.html">Home</a></li>
	<li><a href="404.html">Products</a></li>
	<li><a href="about.hmtl">About Us</a></li>
	<li><a href="services.html">Services</a></li>
	<li><a href="login.jsp">Account</a></li>
	<li><a class="active" href="softwares.jsp">Start</a></li>
</ul>
</div>
<!-- script for menu --> <script>
	$("span.menu").click(function() {
		$(".top-menu").slideToggle("slow", function() {
			// Animation complete.
		});
	});
</script> <!-- script for menu --></div>
<div class="clearfix"></div>
</div>
</div>
<!-- header-section-ends -->
<div class="content">
<div class="contact about-desc">
<h3>Step 5/5 : Softwares</h3>
<div class="container">
<div class="row">
<div class="col-md-8 contact_left">
<h4>Software Resources</h4>
   					<p class="m_6">In this step, we only focus on the Computation resources of the template. 
   					<br>
   					Software resources mainly include the types of the Server, such as Virtual Server or Dedicated Server, the sizes of the cores about CPU, the size of RAM and so on.
   					<h4>Questions Explanation</h4>
   			<br>
   			<div class="row">
   				<div class="col-md-8">
	   				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						 <!-- Q1 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingOne">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
						          <strong>What is web server?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
						      <div class="panel-body">
						        	Virtual Web servers are a very popular way of providing low-cost web hosting services. Instead of requiring a separate computer for each server, dozens of virtual servers can co-reside on the same computer. In most cases, performance is not affected and each web site behaves as if it is being served by a dedicated server. However, if too many virtual servers reside on the same computer, or if one virtual server starts hogging resources, Web pages will be delivered more slowly.
						         </div>
						    </div>
						  </div>
					  
				
						  <!-- Q2 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingTwo">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						          <strong>What is the database server?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						      <div class="panel-body">
						       		 A virtual CPU (vCPU) also known as a virtual processor, is a physical central processing unit (CPU) that is assigned to a virtual machine (VM).
By default, virtual machines are allocated one vCPU each. If the physical host has multiple CPU cores at its disposal, however, then a CPU scheduler assigns execution contexts and the vCPU essentially becomes a series of time slots on logical processors.
						        </div>
						    </div>
						  </div>
					
						  <!-- Q3 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingThree">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						          <strong>What is the additional softwares?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						      <div class="panel-body">
						        	Virtual memory combines your computer’s RAM with temporary space on your hard disk. When RAM runs low, virtual memory moves data from RAM to a space called a paging file. Moving data to and from the paging file frees up RAM so your computer can complete its work.

The more RAM your computer has, the faster your programs will generally run. If a lack of RAM is slowing your computer, you might be tempted to increase virtual memory to compensate. However, your computer can read data from RAM much more quickly than from a hard disk, so adding RAM is a better solution.
						      </div>
						    </div>
						  </div>
		 			</div>
		 		
	 			</div>
	 		</div>
	 			<p class="m_7">If you have any problem of this step or about the Network resources, please contact with us using the following contact information.</p>   
   			<!-- End Frequent Ques Part -->
					<div class="contact_grid contact_address">
						<h5>Contact Information:</h5>	
						<p>Telephone : 573-999-1234</p>
						<p>Fax : 573-999-1234</p>
						<p>Email : <a href="http://www.baidu.com">mizzou@mail.missouri.edu</a></p>
						<p>Address: EBW Room 237, MU, Columbia, MO, USA
					</div>
</div>
		<div class="col-md-4">
				<div class="contact_right">
					<div class="contact-form_grid">
						<s:form action="setSoftwareReq" method="post" namespace="/">
						
							<p><s:text name="webServerRequired"></s:text></p>
							<s:select name="webServerRequired" key="webServerRequired" headerKey="null" id="web_server"
								headerValue="Choose one" list="yesOrNoList" onchange="toggleWebServers()">
							</s:select>
							
							<div id="dynamic_web_server">
							</div>
							
							<p><s:text name="dbServerRequired"></s:text></p>
							<s:select name="dbServerRequired" key="dbServerRequired" headerKey="null" id="database_server"
								headerValue="Choose one" list="yesOrNoList" onchange="toggleDbServers()">
							</s:select>
							
							
							<div id="dynamic_database_server">
							
							</div>
							
							<p><s:text name="addSoftware"></s:text></p>
							<!-- <input type="text" name="sw_name" placeholder="app name">
							<input type="text" name="git_url" placeholder="git url"> -->
							
						<TABLE id="additionalSoftwareTable" align="center">
       						<TR>
               	 				<TD><p>Software Name</p></TD>
                				<TD><p>Git Hub Url</p></TD>
        					</TR>
        					<TR>
                				<TD><INPUT type="text" name="additionalSoftware[0].name" /></TD>
                				<TD><INPUT type="text" name="additionalSoftware[0].githubURL" /></TD>
        					</TR>
					</TABLE>
					<table align="center">
						<tr>
        					<td><INPUT type="button" value="Add More" onclick="addRow('additionalSoftwareTable')" /></td>
        				</tr>
					</table>
					<br/>
							<input type="submit" value="Submit">
						</s:form>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>
<!-- End of content -->


<div class="footer text-center">
<div class="social-icons"><a href="#"><i class="facebook"></i></a>
<a href="#"><i class="twitter"></i></a> <a href="#"><i
	class="googlepluse"></i></a> <a href="#"><i class="youtube"></i></a> <a
	href="#"><i class="linkedin"></i></a></div>
<div class="copyright">
<p>Copyright &copy; 2015 All rights reserved | Template by <a
	href="http://www.baidu.com"> CustomTemplateTeam</a></p>
</div>
</div>
</body>
</html>
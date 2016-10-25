<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Storage</title>
<script>
function toggleRemoteStorage() {
	var rStorage = document.getElementById("remoteStorage").value;
	alert(rStorage);
	var p_val1 = document.getElementById("p_remote_storage_size");
	var s_val1 = document.getElementById("s_remote_storage_size");
	if (rStorage == "Yes") {
		var p_html = "<p>Your remote storage capacity requirement</p> \
			<s\:fielderror fieldName=\"remoteStorageSize\"></s\:fielderror>";
		var s_html = "<s\:select list=\"\" name=\"remoteStorageSize\" id="" key=\"remoteStorageSize\"></s\:select>";
		p_val1.innerHTML = p_html;
		s_val1.innerHTML = s_html;
	} else {
		p_val1.innerHTML = "";
		s_val1.innerHTML = "";
	}
}
</script>

<style>

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
	<li><a class="active" href="storage.jsp">Start</a></li>
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
<h3>Step 3/5 : Storage</h3>
<div class="container">
<div class="row">
<div class="col-md-8 contact_left">
		<h4>Storage Resources Identifier</h4>
   					<p class="m_6">In this step, we only focus on the Storage resources of the template. 
   					<br>
   					Storage resources mainly include Local Storage, Remote Storage, the size of the Storage, Magnetic storage, Solid Storage and so on.
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
						          <strong>How to calculate your storage requirement?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
						      <div class="panel-body">
						        	In order to figure out your requirement of storage capacity, you need to find out what is the maximum size of your total documents that need to be stored in the disk. As long as you know that, you can know your requirement about the storage based on that data size.
						         </div>
						    </div>
						  </div>
					  
				
						  <!-- Q2 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingTwo">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						          <strong>What is the difference between Local Storage and Remote Storage?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						      <div class="panel-body">
						       		You can use Remote Storage to extend disk space on your server without adding more hard disks. Remote Storage automatically copies eligible files on your local volumes to a library of magnetic tapes or magneto-optical disks. Remote Storage then monitors the amount of space that is available on your local volumes.
						        </div>
						    </div>
						  </div>
					
						  <!-- Q3 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingThree">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						          <strong>Which kind of storage is suitable for you?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						      <div class="panel-body">
						        	<Strong>Data Transfer</Strong>:In an HDD, data transfer is sequential.In an SSD, data transfer is not sequential; it is random access so it is faster.<br>
						        	<Strong>Reliability</Strong>: Unlike HDD drives, SSD disks do not have moving parts. So SSD reliability is higher. <br>
						        	<Strong>Price</Strong>: As of May 2014, SSDs are still more expensive per gigabyte than hard drives but prices for SSDs have fallen substantially in recent years.<br>
						      </div>
						    </div>
						  </div>
						  
						  <!-- Q4 -->
						  <div class="panel panel-default">
						    <div class="panel-heading" role="tab" id="headingFour">
						      <h5 class="panel-title">
						        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
						          <strong>Why do we need to backup our storage?</strong>
						        </a>
						      </h5>
						    </div>
						    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
						      <div class="panel-body">
						       Data backup involves the storing of files from your computer in another location. In this way, if there is ever any loss of data on your primary machine, you still have your data in backup in order to restore those files. In the world of computers loss of data can be devastating, and while there are possibilities for recovery of data after a disaster it is far easier to restore your files from backup than to attempt to find your data on a crashed hard drive.
						      </div>
						    </div>
						  </div>
						  
						 
		 			
		 			</div>
		 		
	 			</div>
	 		</div>
	 			<p class="m_7">If you have any problem of this step or about the Network resources, please contact with us using the following contact information.</p>   
   			<!-- End Frequent Ques Part --><div class="contact_grid contact_address">
						
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
				<s:form action="setStorageReq" method="post" namespace="/">
				
					<p><s:text name="localStorageSize"></s:text></p>
					<s:fielderror fieldName="localStorageSize"></s:fielderror>
					<s:select name="localStorageSize" key="localStorageSize" headerKey="null"
						headerValue="Choose one" list="storageSizeList">
					</s:select>
					
					<p><s:text name="localStorageDisk"></s:text></p>
					<s:fielderror fieldName="localStorageDisk"></s:fielderror>
					<s:select name="localStorageDisk" key="localStorageDisk" headerKey="null"
						headerValue="Choose one" list="storageDiskList">
					</s:select>
				
					<p><s:text name="remoteStorage"></s:text></p>
					<s:fielderror fieldName="remoteStorage"></s:fielderror>
					<s:select name="remoteStorage" key="remoteStorage" id="remoteStorage" onchange="toggleRemoteStorage()"
						headerKey="null" headerValue="Choose one" list="yesOrNoList">
					</s:select>
					
					<!-- Content of the following division is dynamiclly added by javascript based on the remote storage requirement -->
					<div id="p_remote_storage_size">
						
					</div>
					<div id="s_remote_storage_size">
						
					</div>
				
					<input type="submit" value="Next">
				</s:form>
			</div>
		</div>
	</div>
</div>
</div>
</div>

</div>

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
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="zh_CN"/>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title><fmt:message key="index_title" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- 网站图标 -->
	<link href="${ctx}images/icons/favicon.ico" rel="shortcut icon" />
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="${ctx}pages/index/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="${ctx}pages/index/css/icomoon.css">
	<!-- Bootstrap  -->
	<link href="${ctx}cs/bootstrap/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="${ctx}pages/index/css/magnific-popup.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="${ctx}pages/index/css/style.css">
	<link rel="stylesheet" href="${ctx}cs/font-style.css">

	<!-- Modernizr JS -->
	<script src="${ctx}pages/index/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="${ctx}pages/index/js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="container">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo"><a href="${ctx}index.jsp"><img alt="logo" src="${ctx}pages/index/images/logo.gif"></a></div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li class="active"><a href="${ctx}index.jsp"><fmt:message key="index_index" /></a></li>
						<li><a href="about.html"><fmt:message key="index_about_us" /></a></li>
						<li class="has-dropdown">
							<a href="services.html"><fmt:message key="index_services" /></a>
							<ul class="dropdown">
								<li><a href="#">Web Design</a></li>
								<li><a href="#">eCommerce</a></li>
								<li><a href="#">Branding</a></li>
								<li><a href="#">API</a></li>
							</ul>
						</li>
						<li><a href="contact.html"><fmt:message key="index_contract" /></a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/img_bg_1.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1><fmt:message key="index_index_header_title" /></h1>
							<h2><fmt:message key="index_index_header_content" /> </h2>
							<p><a href="#" class="btn btn-default"><fmt:message key="index_index_header_mark" /></a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
    <div class="copyrights">Collect from <a href="###" ><fmt:message key="index_index_header_title" /></a></div>
	
	<div class="container">
		<div class="row">
			<div id="fh5co-section">
				<div class="col-nineth">
					<div class="row">
						<div class="col-third">
							<div class="col-md-12">
								<span class="icon">
									<i class="icon-second-house"></i>
								</span>
								<div class="desc">
									<h3><fmt:message key="index_index_content_second_house_title" /></h3>
									<p><fmt:message key="index_index_content_second_house_content" /></p>
									<p><a href="#" class="btn btn-primary"><fmt:message key="index_index_content_link" /></a></p>
								</div>
							</div>
						</div>
						<div class="col-third">
							<div class="col-md-12">
								<span class="icon">
									<i class="icon-new-house"></i>
								</span>
								<div class="desc">
									<h3><fmt:message key="index_index_content_new_house_title" /></h3>
									<p><fmt:message key="index_index_content_new_house_content" /></p>
									<p><a href="#" class="btn btn-primary"><fmt:message key="index_index_content_link" /></a></p>
								</div>
							</div>
						</div>
						<div class="col-third">
							<div class="col-md-12">
								<span class="icon">
									<i class="icon-evaluate-house"></i>
								</span>
								<div class="desc">
									<h3><fmt:message key="index_index_content_evaluate_house_title" /></h3>
									<p><fmt:message key="index_index_content_evaluate_house_content" /></p>
									<p><a href="#" class="btn btn-primary"><fmt:message key="index_index_content_link" /></a></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-forth fh5co-video fh5co-bg" style="background-image: url(images/image_1.jpg)">
					<a href="${ctx}pages/index/images/image_1_copy.jpg" class="popup-vimeo"><i class="icon-video2"></i></a>
						<div class="overlay"></div>
				</div>
			</div>
		</div>
	</div>
    

	
	<div class="fh5co-bg-section">
		<div class="container">
			<div class="row">
				<div id="fh5co-features-2">
					<div class="col-feature-9">
						<div class="row">
							<div class="col-md-12 fh5co-heading animate-box">
								<h2><fmt:message key="index_index_content_core_feature_title" /></h2>
								<p><fmt:message key="index_index_content_core_feature_content" /></p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-7 col-sm-7 col-md-pull-2 col-sm-pull-2 animate-box" data-animate-effect="fadeInRight">
								<div class="feature-image">
									<img src="images/work_1.png" alt="work">
								</div>
							</div>
							<div class="col-md-5 col-sm-5">
								<div class="feature-left animate-box" data-animate-effect="fadeInLeft">
									<span class="icon">
										<i class="icon-check"></i>
									</span>
									<div class="feature-copy">
										<h3><fmt:message key="index_index_content_core_feature_copy_1_title" /></h3>
										<p><fmt:message key="index_index_content_core_feature_copy_1_content" /></p>
									</div>
								</div>

								<div class="feature-left animate-box" data-animate-effect="fadeInLeft">
									<span class="icon">
										<i class="icon-check"></i>
									</span>
									<div class="feature-copy">
										<h3><fmt:message key="index_index_content_core_feature_copy_2_title" /></h3>
										<p><fmt:message key="index_index_content_core_feature_copy_2_content" /></p>
									</div>
								</div>

								<div class="feature-left animate-box" data-animate-effect="fadeInLeft">
									<span class="icon">
										<i class="icon-check"></i>
									</span>
									<div class="feature-copy">
										<h3><fmt:message key="index_index_content_core_feature_copy_3_title" /></h3>
										<p><fmt:message key="index_index_content_core_feature_copy_3_content" /></p>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="col-feature-3">
						<div id="fh5co-counter" class="fh5co-bg fh5co-counter">
							<div class="row">
								<div class="display-t">
									<div class="display-tc">
										<div class="col-md-12 animate-box">
											<div class="feature-center">
												<span class="counter js-counter" data-from="0" data-to="2200" data-speed="5000" data-refresh-interval="50">1</span>
												<span class="counter-label"><fmt:message key="index_index_content_core_feature_center_1_title" /></span>

											</div>
										</div>
										<div class="col-md-12 animate-box">
											<div class="feature-center">
												<span class="counter js-counter" data-from="0" data-to="97" data-speed="5000" data-refresh-interval="50">1</span>
												<span class="counter-label"><fmt:message key="index_index_content_core_feature_center_2_title" /></span>
											</div>
										</div>
										<div class="col-md-12 animate-box">
											<div class="feature-center">
												<span class="counter js-counter" data-from="0" data-to="402" data-speed="5000" data-refresh-interval="50">1</span>
												<span class="counter-label"><fmt:message key="index_index_content_core_feature_center_3_title" /></span>
											</div>
										</div>
										<div class="col-md-12 animate-box">
											<div class="feature-center">
												<span class="counter js-counter" data-from="0" data-to="4523" data-speed="5000" data-refresh-interval="50">1</span>
												<span class="counter-label"><fmt:message key="index_index_content_core_feature_center_4_title" /></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div id="fh5co-portfolio">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Finished Project</h2>
					<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
				</div>
			</div>
			<div class="row">
				<div class="project">
					<div class="col-md-8 col-md-push-5 animate-box" data-animate-effect="fadeInLeft">
						<img class="img-responsive" src="images/work_1.png" alt="work">
					</div>
					<div class="col-md-4 col-md-pull-8 animate-box" data-animate-effect="fadeInRight">
						<div class="mt">
							<h3>Real Project For Real Solutions</h3>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. </p>
							<ul class="list-nav">
								<li><i class="icon-check"></i>Far far away, behind the word</li>
								<li><i class="icon-check"></i>There live the blind texts</li>
								<li><i class="icon-check"></i>Separated they live in bookmarksgrove</li>
								<li><i class="icon-check"></i>Semantics a large language ocean</li>
								<li><i class="icon-check"></i>A small river named Duden</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="project">
					<div class="col-md-8 col-md-pull-1 animate-box" data-animate-effect="fadeInLeft">
						<img class="img-responsive" src="images/work_1.png" alt="work">
					</div>
					<div class="col-md-4 animate-box" data-animate-effect="fadeInRight">
						<div class="mt">
							<div>
								<h4><i class="icon-user"></i>Real Project For Real Solutions</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
							</div>
							<div>
								<h4><i class="icon-video2"></i>Real Project For Real Solutions</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
							</div>
							<div>
								<h4><i class="icon-shield"></i>Real Project For Real Solutions</h4>
								<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</div>

	<div id="fh5co-testimonial">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Testimonial</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 animate-box">
					<div class="testimony">
						<blockquote>
							&ldquo;Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius&rdquo;
						</blockquote>
						<p class="author"><cite>John Doe</cite></p>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div class="testimony">
						<blockquote>
							&ldquo;Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius&rdquo;
						</blockquote>
						<p class="author"><cite>Rob Smith</cite></p>
					</div>
				</div>
				<div class="col-md-4 animate-box">
					<div class="testimony">
						<blockquote>
							&ldquo;Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius&rdquo;
						</blockquote>
						<p class="author"><cite>Jane Doe</cite></p>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="fh5co-started">
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Newsletter</h2>
					<p>Dignissimos asperiores vitae velit veniam totam fuga molestias accusamus alias autem provident. Odit ab aliquam dolor eius.</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2">
					<form class="form-inline">
						<div class="col-md-6 col-sm-6">
							<div class="form-group">
								<label for="email" class="sr-only">Email</label>
								<input type="email" class="form-control" id="email" placeholder="Email">
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<button type="submit" class="btn btn-default btn-block">Subscribe</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<footer id="fh5co-footer" role="contentinfo">
		<div class="container">
			<div class="row row-pb-md">
				<div class="col-md-4 fh5co-widget">
					<h3><fmt:message key="index_index_footer_title" /></h3>
					<p><fmt:message key="index_index_footer_content" /></p>
					<p><a href="#"><fmt:message key="index_index_footer_link" /></a></p>
				</div>
				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">About</a></li>
						<li><a href="#">Help</a></li>
					</ul>
				</div>
				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">Services</a></li>
						<li><a href="#">API</a></li>
					</ul>
				</div>				
				<div class="col-md-2 col-sm-4 col-xs-6 col-md-push-1">
					<ul class="fh5co-footer-links">
						<li><a href="#">Contact</a></li>
					</ul>
				</div>
			</div>

			<div class="row copyright">
				<div class="col-md-12 text-center">
					<p>
						<small class="block"><fmt:message key="index_index_footer_rights" /></small> 
					</p>
					<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
					</p>
				</div>
			</div>

		</div>
	</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
	<script type="text/javascript" src="${ctx}js/jquery/jquery-3.0.0/jquery-3.0.0.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${ctx}pages/index/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="${ctx}js/bootstrap/bootstrap-3.3.7/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${ctx}pages/index/js/jquery.waypoints.min.js"></script>
	<!-- countTo -->
	<script src="${ctx}pages/index/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="${ctx}pages/index/js/jquery.magnific-popup.min.js"></script>
	<script src="${ctx}pages/index/js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="${ctx}pages/index/js/main.js"></script>

	</body>
</html>


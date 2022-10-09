<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>

<body>

	<jsp:include page="theme-loader.jsp"></jsp:include>

	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">

						<jsp:include page="page-header.jsp"></jsp:include>

						<div class="pcoded-inner-content">
							<div class="main-body">
								<div class="page-wrapper">
									<div class="page-body">
										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">
													<div class="card-block">
														<h4 class="sub-title">Cadastro de Usuario</h4>
														<form class="form-material">
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required="" disabled> <span
																	class="form-bar"></span> <label class="float-label">ID:</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Nome:</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Email:</label>
															</div>
															<div class="form-group form-default">
																<input type="password" name="footer-email"
																	class="form-control" required=""> <span
																	class="form-bar"></span> <label class="float-label">Password:</label>
															</div>
															<button class="btn btn-primary waves-effect waves-light">Salvar</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="javascriptfile.jsp"></jsp:include>

</body>

</html>

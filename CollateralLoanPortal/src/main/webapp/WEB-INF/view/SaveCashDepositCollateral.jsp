<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
	fill="white" class="bi bi-box-arrow-right float-right"
	viewBox="0 0 16 16">
            <path fill-rule="evenodd"
		d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z" />
            <path fill-rule="evenodd"
		d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z" />
          </svg>

<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
	fill="white" class="bi bi-house float-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd"
		d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
            <path fill-rule="evenodd"
		d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" />
          </svg>

<script src="https://kit.fontawesome.com/a076d05399.js"
	crossorigin="anonymous"></script>
<link href='https://css.gg/arrow-left-r.css' rel='stylesheet'>
<title>Save Collateral</title>
<style>
body {
	background-color: black;
}

.fix {
	position: fixed;
	bottom: 0px;
	left: 0px;
}

a {
	color: white;
}


a:hover {
	color: white;
	text-decoration: none;
}
/* <h1 class="display-1" style="color: white;">Fetch Loan Details</h1> */
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
	%>
	<div class="row">
		<div class="col-2">
			<a href="/home" class="float-left" style="font-size: larger;"> <i
				class="bi bi-house"></i>Home
			</a>
		</div>
		<div class="col-8">
			<h1 class="display-1" style="color: white; text-align: center;">Save
				Collateral Details</h1>
		</div>
		<div class="col-2">
			<a href="/logout" class="float-right" style="font-size: larger;">
				<span><i class="bi bi-box-arrow-right"></i></span>Log Out
			</a>
		</div>
	</div>
	<div class="container">
		<form class="form form-horizontal"
			action="/saveCollateral/cashdeposit/" method="POST">
			<div class="form-group">
				<div class="row" style="margin-top: 15%;">
					<div class="col-6">
						<div class="row">
							<div class="col">
								<div class="input-group input-group-lg mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">Name</span>
									</div>
									<input type="text" name="ownerName" class="form-control"
										placeholder="Enter Account Holder Name" pattern= "^[a-zA-Z]+(\s[a-zA-Z]+)?$" required>
								</div>
							</div>
						</div>
					</div>
					<div class="col-6">
						<div class="row">
							<div class="input-group input-group-lg mb-3">
									<div class="input-group-prepend">
										<label class="input-group-text" for="bankName">Bank</label>
									</div>
									<select class="custom-select" name="bankName" id="bankName">
										<option value="SBI">SBI</option>
										<option value="PNB">PNB</option>
									</select>
								</div>
							</div>	
						</div>
					</div>
				<div class="row">
					<div class="col-6">
						<div class="row">
							<div class="col">
								<div class="input-group input-group-lg mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">Tenure</span>
									</div>
									<input type="number" name="lockperiod" class="form-control"
										placeholder="Enter Lock In Period in Years" required>
								</div>
							</div>
						</div>
					</div>
					<div class="col-6">
						<div class="row">
							<div class="col">
								<div class="input-group input-group-lg mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">Deposit</span>
									</div>
									<input type="number" name="depositAmount" class="form-control"
										placeholder="Enter Deposit Amount" required>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="row">
							<div class="col">
								<div class="input-group input-group-lg mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">Account
											Number</span>
									</div>
									<input type="number" name="accountNumber" class="form-control"
										placeholder="Enter Account Number" pattern=".{5,10}" required>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 3%;">
					<div class="col">
						<button type="submit" class="btn btn-dark "
							style="margin-left: 25%; width: 50%;">Save Collateral</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="container-fluid">
		<div class="row" style="">
			<div class="col float-left">
				<div class="fix">
					<a href="/saveCollateral" style="font-size: larger;"> <i
						class="gg-arrow-left-r"></i> Back
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
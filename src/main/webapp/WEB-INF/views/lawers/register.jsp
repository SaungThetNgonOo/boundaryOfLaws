<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lawyer Registration</title>
    <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
	integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/js/all.min.js"
	integrity="sha512-u3fPA7V8qQmhBPNT5quvaXVa1mnnLSXUep5PS1qo5NRzHwG19aHmNJnj1Q8hpA/nBWZtZD4r4AX6YOt5ynLN2g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script>
        function validateForm() {
            // Clear previous error messages
            var errorMessages = document.querySelectorAll('.error-message');
            errorMessages.forEach(function (msg) {
                msg.innerHTML = "";
            });

            var isValid = true;

            var name = document.getElementById('name').value.trim();
            var email = document.getElementById('email').value.trim();
            var nrc = document.getElementById('NRC').value.trim();
            var phone = document.getElementById('phone').value.trim();
            var gender = document.querySelector('input[name="gender"]:checked');
            var currentState = document.getElementById('current_state').value;
            var price = document.getElementById('price').value.trim();
            var photo = document.getElementById('photo').value;
            var caseTypeId = document.getElementById('case_type_id').value;
            var password = document.getElementById('password').value.trim();

            if (!name) {
                document.getElementById('nameError').innerHTML = "Name is required";
                isValid = false;
            }

            if (!email) {
                document.getElementById('emailError').innerHTML = "Email is required";
                isValid = false;
            }

            if (!nrc) {
                document.getElementById('nrcError').innerHTML = "NRC is required";
                isValid = false;
            }

            if (!phone) {
                document.getElementById('phoneError').innerHTML = "Phone is required";
                isValid = false;
            }

            if (!gender) {
                document.getElementById('genderError').innerHTML = "Gender is required";
                isValid = false;
            }

            if (!currentState) {
                document.getElementById('stateError').innerHTML = "State/Region is required";
                isValid = false;
            }

            if (!price) {
                document.getElementById('priceError').innerHTML = "Price is required";
                isValid = false;
            }

            if (!photo) {
                document.getElementById('photoError').innerHTML = "Photo is required";
                isValid = false;
            }

            if (!caseTypeId) {
                document.getElementById('caseTypeError').innerHTML = "Case Type is required";
                isValid = false;
            }

            if (!password) {
                document.getElementById('passwordError').innerHTML = "Password is required";
                isValid = false;
            }

            return isValid;
        }
    </script>
</head>
<body>

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h4 class="text-center">Lawyer Registration</h4>
                <div class="text-danger text-center">${error_msg}</div>
                <form action="/boundaryOfLaws/" method="post" enctype="multipart/form-data" onsubmit="return validateForm();">

                    <div class="mb-4">
                        <label for="name" class="form-label">Name</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="name" name="name">
                            <p id="nameError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="email" class="form-label">Email</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="email" name="email">
                            <p id="emailError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="NRC" class="form-label">NRC</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="NRC" name="NRC">
                            <p id="nrcError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="phone" class="form-label">Phone</label>
                        <div class="col-sm-12">
                            <input type="text" placeholder="+95" class="form-control" id="phone" name="phone">
                            <p id="phoneError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="col-form-label col-md-12 pt-0">Gender</div>
                    <div class="col-md-12">
                        <div class="form-check-inline">
                            <input type="radio" class="form-check-input" value="Male" id="male" name="gender" ${lawer.gender == 'Male' ? 'checked' : ''}> 
                            <label class="form-check-label" for="male"> Male </label>
                        </div>
                        <div class="form-check-inline">
                            <input type="radio" class="form-check-input" value="Female" id="female" name="gender" ${lawer.gender == 'Female' ? 'checked' : ''}> 
                            <label class="form-check-label" for="female"> Female </label>
                        </div>
                        <div class="form-check-inline">
                            <input type="radio" class="form-check-input" value="Other" id="other" name="gender" ${lawer.gender == 'Other' ? 'checked' : ''}> 
                            <label class="form-check-label" for="other"> Other </label>
                        </div>
                        <p id="genderError" class="text-danger error-message"></p>
                    </div>

                    <div class="row mb-4 mt-4">
                        <label for="current_state" class="col-md-3 col-form-label">State/Region</label>
                        <div class="col-md-4">
                            <select name="current_state" class="form-select" aria-label="current_state" id="current_state">
                                <option disabled ${lawer.current_state==null ? 'selected' : ''}>Choose...</option>
                                <option value="Ayeyarwady Region" ${lawer.current_state == 'Ayeyarwady Region' ? 'selected' : ''}>Ayeyarwady Region</option>
                                <option value="Bago Region" ${lawer.current_state == 'Bago Region' ? 'selected' : ''}>Bago Region</option>
                                <option value="Magway Region" ${lawer.current_state == 'Magway Region' ? 'selected' : ''}>Magway Region</option>
                                <option value="Mandalay Region" ${lawer.current_state == 'Mandalay Region' ? 'selected' : ''}>Mandalay Region</option>
                                <option value="Sagaing Region" ${lawer.current_state == 'Sagaing Region' ? 'selected' : ''}>Sagaing Region</option>
                                <option value="Tanintharyi Region" ${lawer.current_state == 'Tanintharyi Region' ? 'selected' : ''}>Tanintharyi Region</option>
                                <option value="Yangon Region" ${lawer.current_state == 'Yangon Region' ? 'selected' : ''}>Yangon Region</option>
                                <option value="Naypyidaw Region" ${lawer.current_state == 'Naypyidaw Region' ? 'selected' : ''}>Naypyidaw Region</option>
                                <option value="Kachin State" ${lawer.current_state == 'Kachin State' ? 'selected' : ''}>Kachin State</option>
                                <option value="Kayah State" ${lawer.current_state == 'Kayah State' ? 'selected' : ''}>Kayah State</option>
                                <option value="Kayin State" ${lawer.current_state == 'Kayin State' ? 'selected' : ''}>Kayin State</option>
                                <option value="Mon State" ${lawer.current_state == 'Mon State' ? 'selected' : ''}>Mon State</option>
                                <option value="Rakhine State" ${lawer.current_state == 'Rakhine State' ? 'selected' : ''}>Rakhine State</option>
                                <option value="Shan State" ${lawer.current_state == 'Shan State' ? 'selected' : ''}>Shan State</option>
                                <option value="Chin State" ${lawer.current_state == 'Chin State' ? 'selected' : ''}>Chin State</option>
                            </select>
                            <p id="stateError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="price" class="form-label">Price</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="price" name="price">
                            <p id="priceError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="photo" class="form-label">Photo</label>
                        <div class="col-sm-12">
                            <input type="file" class="form-control" accept="image/*" id="photo" name="photo">
                            <p id="photoError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="row mb-4 mt-4">
                        <label for="case_type_id" class="col-md-3 col-form-label">Case Type</label>
                        <div class="col-sm-4">
                            <select id="case_type_id" name="case_type_id" class="form-select">
                                <option disabled ${lawer.case_type_id==null ? 'selected' : ''}>Choose...</option>
                                <c:forEach var='caseType' items='${case_types}'>
                                    <option value='${caseType.id}'>${caseType.name}</option>
                                </c:forEach>
                            </select>
                            <p id="caseTypeError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="password" class="form-label">Password</label>
                        <div class="col-sm-12">
                            <input type="password" class="form-control" id="password" name="password">
                            <p id="passwordError" class="text-danger error-message"></p>
                        </div>
                    </div>

                    <input type="hidden" class="form-control" value="pending" id="status" name="status">

                    <div class="mb-4 text-center">
                        <input type="submit" value="Submit form" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <c:if test="${not empty success_msg}">
        <script>
            swal({
                title: "Success!",
                text: "${success_msg}",
                icon: "success",
                button: "OK",
            });
        </script>
    </c:if>
</body>
</html>

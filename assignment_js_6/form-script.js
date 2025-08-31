const form = document.getElementById('registrationForm');

form.addEventListener('submit', function (e) {
  e.preventDefault(); // Prevent form from submitting

  // Get input values
  const name = document.getElementById('name');
  const email = document.getElementById('email');
  const password = document.getElementById('password');
  const confirmPassword = document.getElementById('confirmPassword');

  // Validate all fields
  let isValid = true;

  clearErrors();

  // Name validation
  if (name.value.trim() === '') {
    showError(name, 'Name is required');
    isValid = false;
  }

  // Email validation
  if (email.value.trim() === '') {
    showError(email, 'Email is required');
    isValid = false;
  } else if (!isValidEmail(email.value)) {
    showError(email, 'Enter a valid email');
    isValid = false;
  }

  // Password validation
  if (password.value.length < 6) {
    showError(password, 'Password must be at least 6 characters');
    isValid = false;
  }

  // Confirm password validation
  if (confirmPassword.value !== password.value) {
    showError(confirmPassword, 'Passwords do not match');
    isValid = false;
  }

  if (isValid) {
    alert('Registration successful!');
    form.reset();
  }
});

function showError(input, message) {
  const formGroup = input.parentElement;
  const error = formGroup.querySelector('small');
  error.innerText = message;
  error.style.display = 'block';
  input.style.borderColor = 'red';
}

function clearErrors() {
  const errors = document.querySelectorAll('small.error');
  const inputs = form.querySelectorAll('input');
  errors.forEach((e) => {
    e.style.display = 'none';
    e.innerText = '';
  });
  inputs.forEach((input) => {
    input.style.borderColor = '#ccc';
  });
}

function isValidEmail(email) {
  // Simple regex for email validation
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

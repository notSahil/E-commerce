import React, { useState, useEffect } from 'react';
import { Grid, TextField, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { register } from '../../../Redux/Auth/Action';
import './RegisterUserForm.css'; // Import your CSS file

export default function RegisterUserForm({ handleNext }) {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const { auth } = useSelector((store) => store);
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    password: ''
  });
  const [passwordError, setPasswordError] = useState('');
  const [nameError, setNameError] = useState('');
  const [showAlert, setShowAlert] = useState(false);

  const handleSubmit = (event) => {
    event.preventDefault();
    const isValid = validateForm();
    if (isValid) {
      dispatch(register(formData));
    }
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
    if (name === 'password') {
      validatePassword(value);
    } else if (name === 'firstName' || name === 'lastName') {
      validateName(value);
    }
  };

  const validatePassword = (value) => {
    const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{7,}$/;
    if (!passwordRegex.test(value)) {
      setPasswordError('Password should be at least 7 characters long and contain at least one digit, one uppercase letter, one lowercase letter, and one special character.');
    } else {
      setPasswordError('');
    }
  };

  const validateName = (value) => {
    const nameRegex = /^[A-Za-z]+$/;
    if (!nameRegex.test(value) || value.length < 2) {
      setNameError('Name should not contain digits and should be at least 2 characters long.');
    } else {
      setNameError('');
    }
  };

  const validateForm = () => {
    return !passwordError && !nameError && formData.firstName && formData.lastName && formData.email && formData.password;
  };

  useEffect(() => {
    if (auth.error) {
      setShowAlert(true);
    }
  }, [auth.error]);

  return (
    <div className="">
      <form onSubmit={handleSubmit}>
        <Grid container spacing={3}>
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="firstName"
              name="firstName"
              label="First Name"
              fullWidth
              autoComplete="given-name"
              error={!!nameError}
              helperText={nameError}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12} sm={6}>
            <TextField
              required
              id="lastName"
              name="lastName"
              label="Last Name"
              fullWidth
              autoComplete="given-name"
              error={!!nameError}
              helperText={nameError}
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              required
              id="email"
              name="email"
              label="Email"
              fullWidth
              autoComplete="given-name"
              onChange={handleInputChange}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              required
              id="password"
              name="password"
              label="Password"
              fullWidth
              autoComplete="given-name"
              type="password"
              error={!!passwordError}
              helperText={passwordError}
              onChange={handleInputChange}
            />
          </Grid>

          <Grid item xs={12}>
            <Button
              className="bg-[#9155FD] w-full"
              type="submit"
              variant="contained"
              size="large"
              sx={{ padding:".8rem 0" }}
            >
              Register
            </Button>
          </Grid>
        </Grid>
      </form>

      <div className="flex justify-center flex-col items-center">
        <div className="py-3 flex items-center ">
          <p className="m-0 p-0">if you have already account ?</p>
          <Button onClick={() => navigate('/login')} className="ml-5" size="small">
            Login
          </Button>
        </div>
      </div>

      {showAlert && (
        <div className="custom-alert">
          <p>This email is already registered. Please change your email or reset your password.</p>
        </div>
      )}
    </div>
  );
}

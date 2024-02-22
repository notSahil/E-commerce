import React, { useState } from "react";
import { Grid, TextField, Button, Snackbar, Alert } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login } from "../../../Redux/Auth/Action";
import axios from 'axios';
import "./LoginUserForm.css";

export default function LoginUserForm({ handleNext }) {
  const navigate = useNavigate();
  const dispatch = useDispatch();
  const [openSnackBar, setOpenSnackBar] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleCloseSnackbar = () => setOpenSnackBar(false);

  const handleForgotPassword = async () => {
    try {
      const response = await axios.post(`http://localhost:5454/api/users/forgotPassword?userEmail=${email}`, {
        headers: {
          'Content-Type': 'application/json'
        }
      });
      setOpenSnackBar(true);
      setErrorMessage(`New password has been sent to ${email} successfully.`);
    } catch (error) {
      setOpenSnackBar(true);
      setErrorMessage("Failed to send reset password email as this email is not registered.");
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const userData = {
      email: email,
      password: password,
    };

    try {
      const response = await dispatch(login(userData));
      if (response.error) {
        setOpenSnackBar(true);
        setErrorMessage(response.error);
      } else {
        navigate(handleNext);
      }
    } catch (error) {
      setErrorMessage('Email or Password is incorrect.');
      setOpenSnackBar(true);
    }
  };

  return (
    <React.Fragment>
      <form className="w-full" onSubmit={handleSubmit}>
        <Grid container spacing={3}>
          <Grid item xs={12}>
            <TextField
              required
              id="email"
              name="email"
              label="Email"
              fullWidth
              autoComplete="given-name"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
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
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </Grid>
          <Grid item xs={12}>
            <Button
              className="bg-[#9155FD] w-full"
              type="submit"
              variant="contained"
              size="large"
              sx={{ padding: ".8rem 0" }}
            >
              Login
            </Button>
          </Grid>
        </Grid>
      </form>
      <div className="flex justify-center flex-col items-center">
        <div className="py-3 flex items-center">
          <Button onClick={handleForgotPassword} size="small">
            Forgot Password
          </Button>
          <p className="m-0 p-0 ml-2">Forgot your password?</p>
        </div>
      </div>
      <Snackbar
        open={openSnackBar}
        autoHideDuration={6000}
        onClose={handleCloseSnackbar}
      >
        <Alert onClose={handleCloseSnackbar} severity="error">
          {errorMessage}
        </Alert>
      </Snackbar>
    </React.Fragment>
  );
}

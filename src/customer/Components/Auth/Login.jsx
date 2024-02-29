import React, { useState } from "react";
import { Grid, TextField, Button, Snackbar, Alert } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login } from "../../../Redux/Auth/Action";
import axios from 'axios';
import "./LoginUserForm.css";
import { API_BASE_URL } from "../../../config/api";

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
      const response = await axios.post(`${API_BASE_URL}/api/users/forgotPassword?userEmail=${email}`, {
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
      console.log("userdata:--",userData);
      // Fetch user data from the API endpoint
      const response = await axios.get(`${API_BASE_URL}/api/admin/Customer/users`);
      const users = response.data;

      // Match email with the provided data
      const matchedUser = users.find((user) => user.email === email);
      console.log("matched user---",matchedUser.role);
      

      

      if (matchedUser && matchedUser.role === "ROLE_USER") {
        // Redirect to user page if the role is "ROLE_USER"
        navigate("/admin"); // or navigate to the user panel if there's one
      } else {
        // Redirect to admin page if the role is not "ROLE_USER" or no user is found
        navigate("/");
      }
      

      // Dispatch login action after handling redirection
      dispatch(login(userData));
    } catch (error) {
      console.error("Error fetching user data:", error);
      // Handle error fetching user data
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
          <p className="m-0 p-0 ml-2">Forgot your password?</p>
          <Button onClick={handleForgotPassword} size="small">
            Forgot Password
          </Button>
        </div>
      </div>
      <div className="flex justify-center flex-col items-center">
        <div className="py-3 flex items-center ">
          <p className="m-0 p-0">Want to Register?</p>
          <Button onClick={() => navigate('/register')} className="ml-5" size="small">
           Register
          </Button>
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

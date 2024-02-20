import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import Axios
import {
  Box,
} from '@mui/material';
import { useNavigate } from 'react-router-dom';

const ProductsTable = () => {
  const [isAdmin, setIsAdmin] = useState(false);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch profile data when the component mounts
    fetchProfileData();
  }, []);

  const fetchProfileData = async () => {
    try {
      // Retrieve JWT token from local storage
      const jwt = localStorage.getItem('jwt');

      // Check if JWT token is available
      if (!jwt) {
        throw new Error('JWT token is missing.');
      }

      // Make a GET request to fetch profile data
      const response = await axios.get('http://localhost:5454/api/users/profile', {
        headers: {
          'Authorization': `Bearer ${jwt}`, // Include JWT token in the Authorization header
          'Content-Type': 'application/json'
        }
      });

      // Check if the request was successful
      if (!response.data) {
        throw new Error('Error fetching profile data');
      }

      // Check if the role is admin
      const role = response.data.role;
      if (role === 'ROLE_ADMIN' || role === '1' || role === 'ROLE_USER') {
        setIsAdmin(true);
      } else {
        setIsAdmin(false);
      }
    } catch (error) {
      console.error('Error fetching profile data:', error.message);
      setError(error.message);
    }
  };

  return (
    <Box width={'100%'}>
      {isAdmin ? (
        <div>
          <h1>Welcome Admin</h1>
          
          {/* Render admin components here */}
        </div>
      ) : (
        <div>
          <h1>Welcome User</h1>
          {/* Render user components here */}
        </div>
      )}
    </Box>
  );
};

export default ProductsTable;

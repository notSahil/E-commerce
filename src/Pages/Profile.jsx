import React, { useEffect, useState } from 'react';
import { Email, Person, Home } from '@mui/icons-material';
import { Avatar, Container, Grid, Typography, Paper } from '@mui/material'; // Import MUI components
import { API_BASE_URL } from '../config/api';

const ProfilePage = () => {
  const [profileData, setProfileData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchProfileData();
  }, []);

  const fetchProfileData = async () => {
    try {
      const jwt = localStorage.getItem('jwt');
      if (!jwt) {
        throw new Error('JWT token is missing.');
      }
      const response = await fetch(`${API_BASE_URL}/api/users/profile`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${jwt}`,
          'Content-Type': 'application/json'
        }
      });
      if (!response.ok) {
        throw new Error(`Error fetching profile data: ${response.statusText}`);
      }
      const data = await response.json();
      setProfileData(data);
    } catch (error) {
      console.error('Error fetching profile data:', error.message);
      setError(error.message);
    }
  };

  const getInitials = (name) => {
    return name.split(' ').map(part => part[0]).join('').toUpperCase();
  };

  return (
    <div style={styles.pageContainer}>
      <Container maxWidth="lg">
        <Paper elevation={3} style={styles.profileContainer}>
          <Typography variant="h3" style={styles.userProfileTitle}>User Profile</Typography>
          {error ? (
            <Typography variant="body1" style={styles.errorMessage}>Error: {error}</Typography>
          ) : (
            profileData ? (
              <div style={styles.profileDetails}>
                <Avatar sx={styles.avatar}>
                  {getInitials(`${profileData.firstName} ${profileData.lastName}`)}
                </Avatar>
                <Typography variant="h5" style={styles.profileText}><Person style={{ color: '#E91E63' }} /> {profileData.firstName} {profileData.lastName}</Typography>
                <Typography variant="body1" style={styles.profileText}><Email style={{ color: '#4CAF50' }} /> {profileData.email}</Typography>
                <Typography variant="h4" style={styles.addressTitle}><Home style={{ color: '#FFC107' }} /> Saved Addresses</Typography>
                {profileData.addresses.map((address, index) => (
                  <Paper key={address.id} style={styles.addressBox} elevation={2}>
                    <Typography variant="h5" style={styles.addressLabel}><Home style={{ color: '#FF5722' }} /> Address {index + 1}</Typography>
                    <Grid container spacing={2} style={styles.addressDetails}>
                      <Grid item xs={12} sm={6}>
                        <Typography variant="body1"><strong>Street Address:</strong> {address.streetAddress}</Typography>
                        <Typography variant="body1"><strong>City:</strong> {address.city}</Typography>
                      </Grid>
                      <Grid item xs={12} sm={6}>
                        <Typography variant="body1"><strong>State:</strong> {address.state}</Typography>
                        <Typography variant="body1"><strong>Zip Code:</strong> {address.zipCode}</Typography>
                        <Typography variant="body1"><strong>Mobile:</strong> {address.mobile}</Typography>
                      </Grid>
                    </Grid>
                  </Paper>
                ))}
              </div>
            ) : (
              <Typography variant="body1" style={styles.loadingMessage}>Loading profile data...</Typography>
            )
          )}
        </Paper>
      </Container>
    </div>
  );
};

export default ProfilePage;

const styles = {
  pageContainer: {
    backgroundColor: 'white',
    minHeight: '100vh',
    padding: '20px',
  },
  profileContainer: {
    backgroundColor: 'gray', // Yellow background for profile container
    padding: '20px',
    borderRadius: '8px',
    boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
    textAlign: 'center',
  },
  userProfileTitle: {
    color: '#fff', // White text color
    fontSize: '36px',
    fontWeight: 'bold',
    marginBottom: '20px',
  },
  errorMessage: {
    color: 'red',
    fontWeight: 'bold',
  },
  loadingMessage: {
    fontStyle: 'italic',
  },
  profileDetails: {
    marginBottom: '20px',
  },
  profileText: {
    fontSize: '20px',
    marginBottom: '10px',
  },
  addressTitle: {
    color: '#fff', // White text color
    fontSize: '24px',
    fontWeight: 'bold',
    marginBottom: '20px',
  },
  addressBox: {
    backgroundColor: '#f9f9f9',
    padding: '20px',
    marginBottom: '20px',
  },
  addressLabel: {
    fontSize: '18px',
    fontWeight: 'bold',
    marginBottom: '10px',
  },
  addressDetails: {
    marginLeft: '-8px', // Adjust grid container margin
  },
  avatar: {
    bgcolor: 'pink',
    width: 120,
    height: 120,
    fontSize: 48,
    margin: '0 auto',
    marginBottom: '20px',
  },
};

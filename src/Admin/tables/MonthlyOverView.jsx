import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Card from '@mui/material/Card';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import CardContent from '@mui/material/CardContent';

const MonthlyOverview = () => {
  const [productCount, setProductCount] = useState(null);
  const [userCount, setUserCount] = useState(null);
  const [orderCount, setOrderCount] = useState(null);
  const [deliveredCount, setDeliveredCount] = useState(0);
  const [cancelledCount, setCancelledCount] = useState(0);
  const [shippedCount, setShippedCount] = useState(0);
  const [pendingCount, setPendingCount] = useState(0);

  useEffect(() => {
    const fetchProductCount = async () => {
      try {
        const response = await fetch('http://localhost:5454/api/products/all');
        if (!response.ok) {
          throw new Error('Failed to fetch product data');
        }
        const data = await response.json();
        setProductCount(data.length);
      } catch (error) {
        console.error('Error fetching product data:', error.message);
      }
    };

    const fetchUserCount = async () => {
      try {
        const response = await fetch('http://localhost:5454/api/admin/Customer/users');
        if (!response.ok) {
          throw new Error('Failed to fetch user data');
        }
        const data = await response.json();
        setUserCount(data.length);
      } catch (error) {
        console.error('Error fetching user data:', error.message);
      }
    };

    const fetchOrderData = async () => {
      try {
        const response = await fetch('http://localhost:5454/api/admin/orders/');
        if (!response.ok) {
          throw new Error('Failed to fetch order data');
        }
        const data = await response.json();
        setOrderCount(data.length);

        // Calculate the counts for different order statuses
        let delivered = 0;
        let cancelled = 0;
        let shipped = 0;
        let pending = 0;
        data.forEach(order => {
          switch (order.orderStatus) {
            case 'DELIVERED':
              delivered++;
              break;
            case 'CANCELLED':
              cancelled++;
              break;
            case 'SHIPPED':
              shipped++;
              break;
            case 'PENDING':
              pending++;
              break;
            default:
              break;
          }
        });
        setDeliveredCount(delivered);
        setCancelledCount(cancelled);
        setShippedCount(shipped);
        setPendingCount(pending);
      } catch (error) {
        console.error('Error fetching order data:', error.message);
      }
    };

    fetchProductCount();
    fetchUserCount();
    fetchOrderData();
  }, []);

  return (
    <Card>
      <CardContent>
        <Grid container spacing={3}>
          <Grid item xs={3}>
            <Typography variant="h6" gutterBottom>
              Total Products: {productCount || 'Loading...'}
            </Typography>
          </Grid>
          <Grid item xs={3}>
            <Typography variant="h6" gutterBottom>
              Total Users: {userCount || 'Loading...'}
            </Typography>
          </Grid>
          <Grid item xs={6}>
            <Typography variant="h6" gutterBottom>
              Total Orders: {orderCount || 'Loading...'}
            </Typography>
            <Typography variant="body1" gutterBottom>
              Delivered: {deliveredCount}
            </Typography>
            <Typography variant="body1" gutterBottom>
              Cancelled: {cancelledCount}
            </Typography>
            <Typography variant="body1" gutterBottom>
              Shipped: {shippedCount}
            </Typography>
            <Typography variant="body1" gutterBottom>
              Pending: {pendingCount}
            </Typography>
          </Grid>
        </Grid>
      </CardContent>
    </Card>
  );
};

export default MonthlyOverview;

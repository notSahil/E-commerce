import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Box,
  Drawer,
  Toolbar,
  List,
  Divider,
  ListItem,
  ListItemText,
  ListItemButton,
  ListItemIcon,
  CssBaseline,
} from '@mui/material';
// Import icons
import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';

import { useNavigate, Routes, Route } from 'react-router-dom';
import AdminNavbar from './Navigation/AdminNavbar';
import Dashboard from './Views/Admin';
import DemoAdmin from './Views/DemoAdmin';
import CreateProductForm from './componets/createProduct/CreateProductFrom';
import ProductsTable from './componets/Products/ProductsTable';
import OrdersTable from './componets/Orders/OrdersTable';
import Customers from './componets/customers/customers';
import UpdateProductForm from './componets/updateProduct/UpdateProduct';

const drawerWidth = 240;

const menu = [
  { name: 'Dashboard', path: '/admin' },
  { name: 'Products', path: '/admin/products' },
  { name: 'Customers', path: '/admin/customers' },
  { name: 'Orders', path: '/admin/orders' },
  { name: 'Add Product', path: '/admin/product/create' },
];

const AdminPannel = () => {
  const [isAdmin, setIsAdmin] = useState(false);
  const [error, setError] = useState(null);
  const navigate = useNavigate();
  const [sideBarVisible, setSideBarVisible] = useState(false);

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
          Authorization: `Bearer ${jwt}`, // Include JWT token in the Authorization header
          'Content-Type': 'application/json',
        },
      });

      // Check if the request was successful
      if (!response.data) {
        throw new Error('Error fetching profile data');
      }

      // Check if the role is admin
      const role = response.data.role;
      if (role === 'ROLE_USER') {
        setIsAdmin(true);
        navigate('/admin'); // Redirect to admin page if user is admin
      } else {
        setIsAdmin(false);
        navigate('/'); // Redirect to home page if not admin
      }
    } catch (error) {
      console.error('Error fetching profile data:', error.message);
      setError(error.message);
    }
  };

  const handleSideBarViewInMobile = () => {
    setSideBarVisible(true);
  };

  const handleCloseSideBar = () => {
    setSideBarVisible(false);
  };

  const drawer = (
    <Box
      sx={{
        overflow: 'auto',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
      }}
    >
      <Toolbar />
      <List>
        {menu.map((item, index) => (
          <ListItem key={item.name} disablePadding onClick={() => navigate(item.path)}>
            <ListItemButton>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={item.name} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>

      <List sx={{ position: 'absolute', bottom: 0, width: '100%' }}>
        <Divider />
        {['Account', 'Request'].map((text, index) => (
          <ListItem key={text} disablePadding>
            <ListItemButton>
              <ListItemIcon>{index % 2 === 0 ? <InboxIcon /> : <MailIcon />}</ListItemIcon>
              <ListItemText primary={text} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
    </Box>
  );

  //const drawerVariant = isLargeScreen ? 'permanent' : 'temporary';
  const drawerVariant = 'permanent' ;

  return (
   // <Box sx={{ display: `${isLargeScreen ? 'flex' : 'block'}` }}>
      <Box >
      <CssBaseline />
      <AdminNavbar handleSideBarViewInMobile={handleSideBarViewInMobile} />

      <Drawer
        variant={drawerVariant}
        sx={{
          width: drawerWidth,
          flexShrink: 0,
          [`& .MuiDrawer-paper`]: {
            width: drawerWidth,
            boxSizing: 'border-box',
            ...(drawerVariant === 'temporary' && {
              top: 0,
              [`& .MuiPaper-root.MuiDrawer-paperAnchorTop.MuiDrawer-paperTemporary`]: {
                position: 'fixed',
                left: 0,
                right: 0,
                height: '100%',
                zIndex: (theme) => theme.zIndex.drawer + 2,
              },
            }),
          },
        }}
        // open={isLargeScreen || sideBarVisible}
        onClose={handleCloseSideBar}
      >
        {drawer}
      </Drawer>
      <Box className="adminContainer" component="main" sx={{ flexGrow: 1 }}>
        <Toolbar />
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/product/create" element={<CreateProductForm />} />
          <Route path="/product/update/:productId" element={<UpdateProductForm />} />
          <Route path="/products" element={<ProductsTable />} />
          <Route path="/orders" element={<OrdersTable />} />
          <Route path="/customers" element={<Customers />} />
          <Route path="/demo" element={<DemoAdmin />} />
        </Routes>
      </Box>
    </Box>
  );
};

export default AdminPannel;


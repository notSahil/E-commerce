import * as React from 'react';
import { useState } from 'react';
import { styled } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';
import InputBase from '@mui/material/InputBase';
import axios from 'axios';
import { Link } from 'react-router-dom';

const StyledAppBar = styled(AppBar)(({ theme }) => ({
  backgroundColor: '#fff', // Set background color to white
  color: '#000', // Set text color to black
  boxShadow: 'none', // Remove box shadow
  borderBottom: '1px solid #dadce0', // Add bottom border
}));

const SearchContainer = styled('div')({
  justifyContent: 'center',
  width:"200px" // Adjusted padding for smaller area
});

const SearchInput = styled(InputBase)(({ theme }) => ({
  width: '150px', // Adjusted width for smaller area
  backgroundColor: '#6A1B9A', // Set background color to purple
  color: '#FFFFFF', // Set text color to white
  borderRadius: '30px', // Add border radius
  padding: '6px 5px', // Adjusted padding for smaller area
}));

export default function ProminentAppBar() {
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [isSearchOpen, setIsSearchOpen] = useState(false);
  const [searchPerformed, setSearchPerformed] = useState(false);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:5454/api/products/search?q=${encodeURIComponent(searchQuery)}`);
      setSearchResults(response.data);
      setSearchPerformed(true);
    } catch (error) {
      console.error('Error searching products:', error);
    }
  };

  const toggleSearch = () => {
    setIsSearchOpen(!isSearchOpen);
    if (!isSearchOpen) {
      setSearchQuery(''); // Clear search query when closing the search bar
    }
  };

  const handleItemClick = () => {
    setIsSearchOpen(false);
    setSearchResults([]); // Clear search results when an item is clicked
  };

  return (
    <div style={{width:"250px"}}>
      <StyledAppBar position="static">
        <SearchContainer>
          <IconButton
            edge="end"
            color="inherit"
            aria-label="open search"
            onClick={toggleSearch}
          >
            <SearchIcon />
          </IconButton>
          {isSearchOpen && (
            <SearchInput
              placeholder="Search the Product"
              value={searchQuery}
              onChange={(e) => setSearchQuery(e.target.value)}
              onKeyDown={(e) => {
                if (e.key === 'Enter') {
                  handleSearch();
                }
              }}
            />
          )}
        </SearchContainer>
        {isSearchOpen && searchPerformed && (
          <div>
            {searchResults.length === 0 ? (
              <div>No products found</div>
            ) : (
              searchResults.map((product) => (
                <div key={product.id}>
                  <Link
                    to={`/product/${product.id}`}
                    style={{ textDecoration: 'none', color: 'inherit' }}
                    onClick={handleItemClick} // Add onClick event handler
                  >
                    {/* Display the product title */}
                    <div>{product.title}</div>
                  </Link>
                </div>
              ))
            )}
          </div>
        )}
      </StyledAppBar>
    </div>
  );
}
